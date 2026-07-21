package br.com.sistemarj.rjsistema.persistencia;

import Classes.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import java.util.List;

public class CategoriaDAO implements ICategoriaDAO {

    @Override
    public void salvar(Categoria categoria) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException("Erro ao salvar categoria: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public Categoria buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } catch (Exception e) {
            throw new PersistenceException("Erro ao buscar categoria pelo ID: " + id, e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Categoria> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Categoria", Categoria.class).getResultList();
        } catch (Exception e) {
            throw new PersistenceException("Erro ao listar categorias.", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void atualizar(Categoria categoria) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException("Erro ao atualizar categoria: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
