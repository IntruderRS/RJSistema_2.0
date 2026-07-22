package Classes;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuario")
    private Long id;

    @Column(name = "Nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "Login", nullable = false, unique = true, length = 50)
    private String login;

    @Column(name = "Senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "Tipo", length = 50)
    private String tipo;

    @Column(name = "Ativo", nullable = false)
    private boolean ativo = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuarios_permissoes", // Nome padrão profissional e sem erros de digitação
        joinColumns = @JoinColumn(name = "fk_Usuario"),
        inverseJoinColumns = @JoinColumn(name = "fk_Permissao")
    )
    private Set<Permissao> permissoes = new HashSet<>();

    public Usuario() {}

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public Set<Permissao> getPermissoes() { return permissoes; }
    public void setPermissoes(Set<Permissao> permissoes) { this.permissoes = permissoes; }
}