package Service;

import Classes.Categoria;
import br.com.sistemarj.rjsistema.persistencia.ICategoriaDAO;
import br.com.sistemarj.rjsistema.persistencia.CategoriaDAO;
import java.util.List;

public class CategoriaService {

    private final ICategoriaDAO categoriaDAO;

    public CategoriaService() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public void salvar(Categoria categoria) {
        // Validação de Segurança e Integridade (SRP)
        if (categoria.getNome() == null || categoria.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome descritivo da categoria é obrigatório.");
        }
        
        if (categoria.getNome().trim().length() > 100) {
            throw new IllegalArgumentException("O nome da categoria não pode exceder 100 caracteres.");
        }

        categoriaDAO.salvar(categoria);
    }

    public Categoria buscarPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca de categoria.");
        }
        return categoriaDAO.buscarPorId(id);
    }

    public List<Categoria> listarTodos() {
        return categoriaDAO.listarTodos();
    }
}
