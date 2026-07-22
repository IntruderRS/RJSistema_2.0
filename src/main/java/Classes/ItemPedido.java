package Classes;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_ItemPedido")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_Pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "fk_Produto", nullable = false)
    private Produto produto;

    @Column(name = "Quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "PrecoUnitario", nullable = false)
    private Double precoUnitario;

    public ItemPedido() {}

    public ItemPedido(Produto produto, Integer quantidade, Double precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public Double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(Double precoUnitario) { this.precoUnitario = precoUnitario; }

    // Lógica de domínio: calcula o subtotal do item
    public Double getSubtotal() {
        return (this.quantidade != null && this.precoUnitario != null) ? this.quantidade * this.precoUnitario : 0.0;
    }
}
