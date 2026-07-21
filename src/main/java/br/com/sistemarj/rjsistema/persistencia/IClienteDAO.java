package br.com.sistemarj.rjsistema.persistencia;

import Classes.Cliente;
import java.util.List;

public interface IClienteDAO {
    void salvar(Cliente cliente);
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
    void atualizar(Cliente cliente);
}
