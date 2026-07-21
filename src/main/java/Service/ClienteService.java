package Service;

import Classes.Cliente;
import br.com.sistemarj.rjsistema.persistencia.IClienteDAO;
import br.com.sistemarj.rjsistema.persistencia.ClienteDAO;
import java.util.List;

public class ClienteService {

    // Dependemos da Abstração (Interface) e não da implementação rígida
    private final IClienteDAO clienteDAO;

    // Construtor padrão que inicializa a implementação atual
    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public void salvar(Cliente cliente) {
        // Regras de negócio e validações de segurança antes de mandar pro DAO
        if (cliente.getNomeRazao() == null || cliente.getNomeRazao().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome ou razão social é obrigatório.");
        }
        if (cliente.getCnpjCpf() == null || cliente.getCnpjCpf().trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF ou CNPJ é obrigatório.");
        }
        
        // Delega a persistência de forma limpa
        clienteDAO.salvar(cliente);
    }

    public Cliente buscarPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca.");
        }
        return clienteDAO.buscarPorId(id);
    }

    public List<Cliente> listarTodos() {
        return clienteDAO.listarTodos();
    }
}
