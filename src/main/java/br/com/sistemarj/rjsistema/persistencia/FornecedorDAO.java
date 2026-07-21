package br.com.sistemarj.rjsistema.persistencia;

import Classes.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import java.util.List;

public class FornecedorDAO implements IFornecedorDAO {

    @Override
    public void salvar(Fornecedor fornecedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(fornecedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException("Erro ao persistir fornecedor: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public Fornecedor buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Fornecedor.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Fornecedor> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Fornecedor", Fornecedor.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void atualizar(Fornecedor fornecedor) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(fornecedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException("Erro ao atualizar fornecedor: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
