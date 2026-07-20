
package Classes;

import br.com.sistemarj.rjsistema.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {
    
    public void salvar(Cliente cliente) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        em.getTransaction().begin(); // Inicia
        em.persist(cliente);         // Prepara
        em.getTransaction().commit(); // Manda pro disco (CRUCIAL)
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback(); // Volta atrás se der erro
        }
        e.printStackTrace();
    } finally {
        em.close(); // Libera a conexão
    }
}
    
    public Cliente buscarPorId(Long id) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        // Retorna o objeto Cliente populado ou null se não encontrar
        return em.find(Cliente.class, id);
    } finally {
        em.close();
    }
}
    
    public List<Cliente> listarTodos() {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        // "Cliente" deve ser o nome da sua CLASSE Entidade
        return em.createQuery("FROM Cliente", Cliente.class).getResultList();
    } finally {
        em.close();
    }
}
    
    public void atualizar(Cliente cliente) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(cliente); // O merge identifica o ID e faz o UPDATE no banco
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
        e.printStackTrace();
    } finally {
        em.close();
    }
}
    
}
