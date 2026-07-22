package Classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    public void testCalcularTotalPedidoSemDescontoETaxas() {
        System.out.println("Executando: testCalcularTotalPedidoSemDescontoETaxas");
        
        // Arrange (Preparação do cenário)
        Pedido pedido = new Pedido();
        Produto p1 = new Produto(1L, "Filtro de Óleo", 25.0, 10);
        Produto p2 = new Produto(2L, "Óleo Motor 1L", 40.0, 20);
        
        ItemPedido item1 = new ItemPedido(p1, 2, 25.0); // Subtotal: 50.0
        ItemPedido item2 = new ItemPedido(p2, 1, 40.0); // Subtotal: 40.0

        // Act (Execução da ação)
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        // Assert (Verificação do resultado esperado)
        // 50.0 + 40.0 = 90.0
        assertEquals(90.0, pedido.getValorTotal(), 0.001, "O valor total do pedido simples está incorreto.");
    }

    @Test
    public void testCalcularTotalPedidoComFreteEComDesconto() {
        System.out.println("Executando: testCalcularTotalPedidoComFreteEComDesconto");
        
        // Arrange (Preparação)
        Pedido pedido = new Pedido();
        Produto p1 = new Produto(1L, "Pastilha Freio", 100.0, 5);
        ItemPedido item = new ItemPedido(p1, 2, 100.0); // Subtotal: 200.0
        
        pedido.adicionarItem(item);
        pedido.setValorFrete(50.0); // Total provisório: 250.0
        pedido.setImposto(10.0);    // Total provisório com taxas: 260.0
        pedido.setDescontoPorcentagem(10.0); // 10% de desconto sobre 260.0 (Abatimento de 26.0)

        // Act (Execução)
        pedido.recalcularTotal();

        // Assert
        // (200 + 50 + 10) - 10% = 260 - 26 = 234.0
        assertEquals(234.0, pedido.getValorTotal(), 0.001, "O cálculo de desconto composto com frete falhou.");
    }
}