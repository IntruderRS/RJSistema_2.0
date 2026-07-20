package Classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity  // <-- ESSA ANOTAÇÃO É OBRIGATÓRIA
@Table(name = "produtos")

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Produto")
    private Long id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "ValorCusto")
    private Double valorCusto;

    @Column(name = "PorcentagemLucro")
    private Double porcetagemLucro;

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
    private String NCM;

    @Column(name = "Lote")
    private String lote;

    @Column(name = "Vencimento")
    private String vencimento;

    @Column(name = "observacao", columnDefinition = "TEXT")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "fk_Categoria") // Nome exato da coluna no MySQL
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fk_Fornecedor") // Nome exato da coluna no MySQL
    private Fornecedor fornecedor;

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

    public Double getValorCusto() { 
        return valorCusto; 
    }
    
    public void setValorCusto(Double valorCusto) { 
        this.valorCusto = valorCusto; 
    }

    public Double getPorcetagemLucro() { 
        return porcetagemLucro; 
    }
    
    public void setPorcetagemLucro(Double porcetagemLucro) { 
        this.porcetagemLucro = porcetagemLucro; 
    }

    public Double getValorVenda() { 
        return valorVenda; }
    
    public void setValorVenda(Double valorVenda) { 
        this.valorVenda = valorVenda; }

    public Integer getQuantidade() { 
        return quantidade; 
    }
    
    public void setQuantidade(Integer quantidade) { 
        this.quantidade = quantidade; 
    }

    public Double getPeso() { 
        return peso; }
    
    public void setPeso(Double peso) { 
        this.peso = peso; 
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNCM() {
        return NCM;
    }

    public void setNCM(String NCM) {
        this.NCM = NCM;
    }

    
    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
