package Service;

import Classes.Usuario;
import br.com.sistemarj.rjsistema.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class UsuarioService {

    public void registrarUsuario(Usuario usuario, String senhaRepetida) {
        // Validações de segurança corporativa (SRP)
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

        // Simula uma Criptografia Básica (Para conformidade de segurança exigida na Web)
        // No projeto final Web você usará BCrypt. Aqui usaremos um Hash simples para o PI.
        if (usuario.getId() == null) { 
            String senhaMascarada = Integer.toHexString(usuario.getSenha().hashCode());
            usuario.setSenha(senhaMascarada);
        }

        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            if (usuario.getId() == null) {
                em.persist(usuario);
            } else {
                em.merge(usuario);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Usuario> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Usuario", Usuario.class).getResultList();
        } finally {
            em.close();
        }
    }
}
