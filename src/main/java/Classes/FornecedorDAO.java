
package Classes;

import br.com.sistemarj.rjsistema.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class FornecedorDAO {
    
    public void salvar(Fornecedor fornecedor) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        em.getTransaction().begin(); // Inicia
        em.persist(fornecedor);         // Prepara
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
    
        public Fornecedor buscarPorId(Long id) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        // Retorna o objeto Fornecedor populado ou null se não encontrar
        return em.find(Fornecedor.class, id);
    } finally {
        em.close();
    }
}
        
        public List<Fornecedor> listarTodos() {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        // "Fornededor" deve ser o nome da sua CLASSE Entidade
        return em.createQuery("FROM Fornecedor", Fornecedor.class).getResultList();
    } finally {
        em.close();
    }
}
        
        public void atualizar(Fornecedor fornecedor) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(fornecedor); // O merge identifica o ID e faz o UPDATE no banco
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
        e.printStackTrace();
    } finally {
        em.close();
    }
}
}
