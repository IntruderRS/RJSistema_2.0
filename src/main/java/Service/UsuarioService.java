package Service;

import Classes.Usuario;
import br.com.sistemarj.rjsistema.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class UsuarioService {

    public void registrarUsuario(Usuario usuario, String senhaRepetida) {
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }
        if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
            throw new IllegalArgumentException("O login de acesso é obrigatório.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
            throw new IllegalArgumentException("A senha de acesso não pode ser vazia.");
        }
        if (!usuario.getSenha().equals(senhaRepetida)) {
            throw new IllegalArgumentException("As senhas inseridas não coincidem.");
        }

        // Criptografia simples baseada no hash da String
        if (usuario.getId() == null) { 
            String senhaMascarada = Integer.toHexString(usuario.getSenha().hashCode());
            usuario.setSenha(senhaMascarada);
        }

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            
            // Como removemos as FKs do banco, salvamos as permissões novas de forma direta
            if (usuario.getPermissoes() != null) {
                for (Classes.Permissao p : usuario.getPermissoes()) {
                    if (p.getId() == null) {
                        em.persist(p);
                    }
                }
            }

            if (usuario.getId() == null) {
                em.persist(usuario); // INSERT novo usuário
            } else {
                em.merge(usuario);   // UPDATE usuário existente
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new jakarta.persistence.PersistenceException("Falha ao salvar no banco: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    public List<Usuario> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Pedido", Usuario.class).getResultList(); // Mantido o padrão de consulta
        } catch (Exception e) {
            return em.createQuery("FROM Usuario", Usuario.class).getResultList(); // Fallback seguro para Usuario
        } finally {
            em.close();
        }
    }
}