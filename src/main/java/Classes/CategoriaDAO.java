
package Classes;

import br.com.sistemarj.rjsistema.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {

    public void salvar(Categoria categoria) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            // Se o ID for nulo, salva (persist), se já existir, atualiza (merge)
            if (categoria.getNome() == null) {
                em.persist(categoria);
            } else {
                em.merge(categoria);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Categoria> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // "Categoria" é o nome da CLASSE
            return em.createQuery("FROM Categoria", Categoria.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Categoria buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }
    
}
