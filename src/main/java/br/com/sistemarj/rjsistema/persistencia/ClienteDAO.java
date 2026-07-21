package br.com.sistemarj.rjsistema.persistencia;

import Classes.Cliente;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class ClienteDAO implements IClienteDAO {
    
    @Override
    public void salvar(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            
            throw new PersistenceException("Erro ao salvar o cliente: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    
    @Override
    public Cliente buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } catch (Exception e) {
            throw new PersistenceException("Erro ao buscar cliente pelo ID: " + id, e);
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Cliente> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Cliente", Cliente.class).getResultList();
        } catch (Exception e) {
            throw new PersistenceException("Erro ao listar todos os clientes.", e);
        } finally {
            em.close();
        }
    }
    
    @Override
    public void atualizar(Cliente cliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException("Erro ao atualizar o cliente: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}

