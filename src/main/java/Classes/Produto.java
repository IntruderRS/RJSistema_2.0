package Classes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Produto")
    private Long id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "ValorCusto")
    private Double valorCusto;

    @Column(name = "PorcentagemLucro") // Mantém o nome correto da tabela MySQL
    private Double porcentagemLucro; // Corrigido erro de grafia ("n")

    @Column(name = "ValorVenda")
    private Double valorVenda;

    @Column(name = "Quantidade")
    private Integer quantidade;

    @Column(name = "Peso")
    private Double peso;

    @Column(name = "Dimensoes")
    private String dimensoes;

    @Column(name = "CodigoBarras")
    private String codigoBarras;

    @Column(name = "NCM")
    private String ncm;

    @Column(name = "Lote")
    private String lote;

    @Column(name = "Vencimento")
    private LocalDate vencimento; // Refatorado para LocalDate

    @Column(name = "observacao", columnDefinition = "TEXT")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "fk_Categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fk_Fornecedor")
    private Fornecedor fornecedor;

    // --- CONSTRUTORES ---
    public Produto() {
    }

    public Produto(Long id, String nome, Double valorVenda, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.valorVenda = valorVenda;
        this.quantidade = quantidade;
    }

    // --- GETTERS E SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getValorCusto() { return valorCusto; }
    public void setValorCusto(Double valorCusto) { this.valorCusto = valorCusto; }

    public Double getPorcentagemLucro() { return porcentagemLucro; }
    public void setPorcentagemLucro(Double porcentagemLucro) { this.porcentagemLucro = porcentagemLucro; }

    public Double getValorVenda() { return valorVenda; }
    public void setValorVenda(Double valorVenda) { this.valorVenda = valorVenda; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public String getDimensoes() { return dimensoes; }
    public void setDimensoes(String dimensoes) { this.dimensoes = dimensoes; }

    public String getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(String codigoBarras) { this.codigoBarras = codigoBarras; }

    public String getNCM() { return ncm; }
    public void setNCM(String ncm) { this.ncm = ncm; }

    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }

    public LocalDate getVencimento() { return vencimento; }
    public void setVencimento(LocalDate vencimento) { this.vencimento = vencimento; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Fornecedor getFornecedor() { return fornecedor; }
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }
}
