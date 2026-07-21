package br.com.sistemarj.rjsistema.persistencia;

import Classes.Fornecedor;
import java.util.List;

public interface IFornecedorDAO {
    void salvar(Fornecedor fornecedor);
    Fornecedor buscarPorId(Long id);
    List<Fornecedor> listarTodos();
    void atualizar(Fornecedor fornecedor);
}

