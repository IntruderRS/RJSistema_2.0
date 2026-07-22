package Classes;

import jakarta.persistence.*;

@Entity
@Table(name = "permissoes")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Permissao")
    private Long id;

    @Column(name = "Nome", nullable = false, unique = true, length = 50)
    private String nome; // Ex: ROLE_ADMIN, ROLE_VENDEDOR

    @Column(name = "Descricao")
    private String descricao;

    public Permissao() {}

    public Permissao(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() { return this.nome; }
}