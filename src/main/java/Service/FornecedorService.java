package Service;

import Classes.Fornecedor;
import br.com.sistemarj.rjsistema.persistencia.IFornecedorDAO;
import br.com.sistemarj.rjsistema.persistencia.FornecedorDAO;
import java.time.LocalDate;
import java.util.List;

public class FornecedorService {

    private final IFornecedorDAO fornecedorDAO;

    public FornecedorService() {
        this.fornecedorDAO = new FornecedorDAO();
    }

    public void salvar(Fornecedor fornecedor) {
        // Validações de Segurança Corporativa (SRP)
        if (fornecedor.getNomeRazao() == null || fornecedor.getNomeRazao().trim().isEmpty()) {
            throw new IllegalArgumentException("A Razão Social do fornecedor é obrigatória.");
        }
        if (fornecedor.getCnpj() == null || fornecedor.getCnpj().trim().isEmpty()) {
            throw new IllegalArgumentException("O CNPJ do fornecedor é obrigatório.");
        }

        // Garante a data de cadastro caso seja um registro novo
        if (fornecedor.getId() == null && fornecedor.getDataCadastro() == null) {
            fornecedor.setDataCadastro(LocalDate.now());
        }

        fornecedorDAO.salvar(fornecedor);
    }

    public Fornecedor buscarPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca de fornecedor.");
        }
        return fornecedorDAO.buscarPorId(id);
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorDAO.listarTodos();
    }
}
