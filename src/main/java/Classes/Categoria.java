package Classes;

import jakarta.persistence.*;


@Entity
@Table(name = "categoria") // Nome da tabela no MySQL
public class Categoria {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Categoria")
    private Long id;

    @Column(name = "NomeCategoria", nullable = false, length = 100)
    private String nome;

    public Categoria() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // ESSENCIAL: Faz o nome da categoria aparecer no ComboBox
    @Override
    public String toString() {
        return nome;
    }
}

    
