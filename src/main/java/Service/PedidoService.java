package Service;

import Classes.Pedido;
import Classes.ItemPedido;
import Classes.Produto;
import br.com.sistemarj.rjsistema.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import java.util.List;

public class PedidoService {

    public void finalizarPedido(Pedido pedido) {
        // Validações básicas de consistência de dados (SRP)
        if (pedido.getCliente() == null) {
            throw new IllegalArgumentException("Não é possível fechar um pedido sem um cliente vinculado.");
        }
        if (pedido.getItens().isEmpty()) {
            throw new IllegalArgumentException("O pedido deve conter pelo menos um item.");
        }

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            // Deduz a quantidade vendida do estoque físico dos produtos
            for (ItemPedido item : pedido.getItens()) {
                Produto produtoBanco = em.find(Produto.class, item.getProduto().getId());

                if (produtoBanco.getQuantidade() < item.getQuantidade()) {
                    System.out.println("[ALERTA DE NEGÓCIO]: Produto '" + produtoBanco.getNome()
                            + "' faturado sob encomenda.");
                }

                produtoBanco.setQuantidade(produtoBanco.getQuantidade() - item.getQuantidade());
                em.merge(produtoBanco);
            }

            pedido.setStatus("FINALIZADO");
            pedido.recalcularTotal();

            if (pedido.getId() == null) {
                // Se o ID for nulo, é um pedido novo no PDV -> Executa INSERT
                em.persist(pedido);
                System.out.println("-> Sucesso: Novo pedido inserido via persist().");
            } else {
                // Se o ID já existir, o pedido veio da Lista -> Executa UPDATE
                em.merge(pedido);
                System.out.println("-> Sucesso: Pedido atualizado via merge().");
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException("Falha operacional ao processar fechamento do pedido: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    public List<Pedido> listarTodos() {
        jakarta.persistence.EntityManager em = br.com.sistemarj.rjsistema.persistencia.JPAUtil.getEntityManager();
        try {
            // Carrega os pedidos trazendo os itens associados em memória
            return em.createQuery("FROM Pedido", Pedido.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void excluir(Long id) {
        jakarta.persistence.EntityManager em = br.com.sistemarj.rjsistema.persistencia.JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Pedido pedido = em.find(Pedido.class, id);
            if (pedido != null) {
                // Como mapeamos CascadeType.ALL, os itens vinculados serão deletados automaticamente
                em.remove(pedido);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new jakarta.persistence.PersistenceException("Erro operacional ao deletar o pedido: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
