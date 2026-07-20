
package br.com.sistemarj.rjsistema.classes;

import Classes.Cliente;
import Classes.Produto;
import java.util.ArrayList;


public class Pedido {
    public int id;
    public Cliente cliente;
    public ArrayList<Produto> itens = new ArrayList<>();
    public String formaPagamento;

    public Pedido(int id, Cliente cliente, String formaPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
    } 
}
   