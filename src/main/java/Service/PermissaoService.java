package Service;

import Classes.Permissao;
import br.com.sistemarj.rjsistema.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PermissaoService {

    public void salvar(Permissao permissao) {
        if (permissao.getNome() == null || permissao.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O identificador da permissão é obrigatório.");
        }
        
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            if (permissao.getId() == null) {
                em.persist(permissao);
            } else {
                em.merge(permissao);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Permissao> listarTodas() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("FROM Permissao", Permissao.class).getResultList();
        } finally {
            em.close();
        }
    }
}
