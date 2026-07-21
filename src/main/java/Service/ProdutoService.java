package Service;

import Classes.Produto;
import br.com.sistemarj.rjsistema.persistencia.IProdutoDAO;
import br.com.sistemarj.rjsistema.persistencia.ProdutoDAO;
import java.util.List;

public class ProdutoService {

    private final IProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void salvar(Produto produto) {
        // Validações de Regra de Negócio (SRP)
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome descritivo do produto é obrigatório.");
        }
        if (produto.getQuantidade() == null || produto.getQuantidade() < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }

        // Cálculo automatizado corporativo (Independente de tela Desktop ou Web)
        if (produto.getValorCusto() != null && produto.getPorcentagemLucro() != null) {
            double margem = produto.getValorCusto() * (produto.getPorcentagemLucro() / 100.0);
            produto.setValorVenda(produto.getValorCusto() + margem);
        }

        produtoDAO.salvar(produto);
    }

    public Produto buscarPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca de produto.");
        }
        return produtoDAO.buscarPorId(id);
    }

    public List<Produto> listarTodos() {
        return produtoDAO.listarTodos();
    }
}

