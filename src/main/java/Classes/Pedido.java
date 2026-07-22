package Classes;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Pedido")
    private Long id;

    @Column(name = "DataHora", nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "fk_Cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "TipoFrete")
    private String tipoFrete;

    @Column(name = "ValorFrete")
    private Double valorFrete;

    @Column(name = "FormaPagamento")
    private String formaPagamento;

    @Column(name = "DescontoPorcentagem")
    private Double descontoPorcentagem;

    @Column(name = "Imposto")
    private Double imposto;

    @Column(name = "ValorTotal", nullable = false)
    private Double valorTotal;

    @Column(name = "Status", nullable = false, length = 30)
    private String status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
        this.dataHora = LocalDateTime.now();
        this.valorTotal = 0.0;
        this.valorFrete = 0.0;
        this.descontoPorcentagem = 0.0;
        this.imposto = 0.0;
        this.status = "PENDENTE";
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        item.setPedido(this);
        recalcularTotal();
    }

    // REGRA DE NEGÓCIO UNIFICADA: Calcula itens, soma frete/imposto e aplica o desconto
    public void recalcularTotal() {
        double subtotalItens = itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
        
        double totalComTaxas = subtotalItens + (valorFrete != null ? valorFrete : 0.0) + (imposto != null ? imposto : 0.0);
        
        if (descontoPorcentagem != null && descontoPorcentagem > 0) {
            double abatimento = totalComTaxas * (descontoPorcentagem / 100.0);
            this.valorTotal = totalComTaxas - abatimento;
        } else {
            this.valorTotal = totalComTaxas;
        }
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getTipoFrete() { return tipoFrete; }
    public void setTipoFrete(String tipoFrete) { this.tipoFrete = tipoFrete; }

    public Double getValorFrete() { return valorFrete; }
    public void setValorFrete(Double valorFrete) { this.valorFrete = valorFrete; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public Double getDescontoPorcentagem() { return descontoPorcentagem; }
    public void setDescontoPorcentagem(Double descontoPorcentagem) { this.descontoPorcentagem = descontoPorcentagem; }

    public Double getImposto() { return imposto; }
    public void setImposto(Double imposto) { this.imposto = imposto; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<ItemPedido> getItens() { return itens; }
    public void setItens(List<ItemPedido> itens) { this.itens = itens; }
}
