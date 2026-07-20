
package Classes;


public class Usuario {
    public String nome;
    public String tipo;

    public Usuario(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public void exibirPermissao() {
        System.out.println("Usuário: " + nome + " | Permissão: " + tipo);
    }

}
