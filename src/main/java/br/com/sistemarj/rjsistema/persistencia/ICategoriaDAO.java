package br.com.sistemarj.rjsistema.persistencia;

import Classes.Categoria;
import java.util.List;

public interface ICategoriaDAO {
    void salvar(Categoria categoria);
    Categoria buscarPorId(Long id);
    List<Categoria> listarTodos();
    void atualizar(Categoria categoria);
}

