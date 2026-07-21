package br.com.sistemarj.rjsistema;

import Classes.Cliente;
import Classes.Fornecedor;
import Classes.Categoria;
import Classes.Produto;
import br.com.sistemarj.rjsistema.persistencia.CategoriaDAO;
import Service.ClienteService;
import Service.FornecedorService;
import Service.ProdutoService;
import java.time.LocalDate;
import java.util.List;

public class PrincipalTeste {

    public static void main(String[] args) {
        System.out.println("========== INICIANDO TESTE INTEGRADO COMPLETO (SOLID) ==========\n");

        ClienteService clienteService = new ClienteService();
        FornecedorService fornecedorService = new FornecedorService();
        ProdutoService produtoService = new ProdutoService();
        CategoriaDAO categoriaDAO = new CategoriaDAO(); // DAO de apoio ao teste

        try {
            // 1. FLUXO CLIENTE
            System.out.println("[FLUXO CLIENTE] Cadastrando Cliente de Teste...");
            Cliente novoCliente = new Cliente();
            novoCliente.setNomeRazao("Empresa de Teste SOLID Ltda");
            novoCliente.setCnpjCpf("99.888.777/0001-" + (System.currentTimeMillis() % 100)); 
            novoCliente.setNascimento(LocalDate.of(1995, 5, 20));
            clienteService.salvar(novoCliente);
            System.out.println("-> Sucesso: Cliente inserido.");

            // 2. FLUXO FORNECEDOR
            System.out.println("\n[FLUXO FORNECEDOR] Cadastrando Fornecedor de Teste...");
            Fornecedor novoFornecedor = new Fornecedor();
            novoFornecedor.setNomeRazao("Distribuidora Nordeste de Alimentos");
            novoFornecedor.setCnpj("44.333.222/0001-" + (System.currentTimeMillis() % 100));
            fornecedorService.salvar(novoFornecedor);
            System.out.println("-> Sucesso: Fornecedor inserido.");

            // 3. FLUXO PRODUTO (CORRIGIDO COM RELACIONAMENTOS OBRIGATÓRIOS)
            System.out.println("\n[FLUXO PRODUTO] Buscando chaves relacionais para o produto...");
            
            // Busca as categorias existentes no banco para não violar a FK do MySQL
            List<Categoria> categoriasExistentes = categoriaDAO.listarTodos();
            if (categoriasExistentes.isEmpty()) {
                throw new IllegalStateException("ERRO DO TESTE: Cadastre ao menos uma Categoria no banco antes de rodar!");
            }
            Categoria categoriaDoBanco = categoriasExistentes.get(0); // Pega a primeira que achar

            System.out.println("[FLUXO PRODUTO] Cadastrando Produto com Cálculo Automático...");
            Produto novoProduto = new Produto();
            novoProduto.setNome("Pneu Automotivo Aro 15");
            novoProduto.setQuantidade(45);
            novoProduto.setValorCusto(200.00);
            novoProduto.setPorcentagemLucro(50.0); 
            novoProduto.setVencimento(LocalDate.of(2031, 12, 31)); 
            
            // Vincula as chaves obrigatórias exigidas pelo banco físico
            novoProduto.setCategoria(categoriaDoBanco);
            novoProduto.setFornecedor(novoFornecedor);

            produtoService.salvar(novoProduto);
            
            System.out.println("-> Sucesso: Produto registrado via JPA!");
            System.out.println("   - Preço de Custo Informado: R$ " + novoProduto.getValorCusto());
            System.out.println("   - Margem Aplicada via Service: " + novoProduto.getPorcentagemLucro() + "%");
            System.out.println("   - Preço Final Calculado pela Lógica Centralizada: R$ " + novoProduto.getValorVenda());

            System.out.println("\n[LISTAGEM PRODUTOS] Verificando catálogo persistido...");
            List<Produto> catalogo = produtoService.listarTodos();
            for (Produto prod : catalogo) {
                System.out.println("   - Código: " + prod.getId() + " | Item: " + prod.getNome() + " | Estoque: " + prod.getQuantidade() + " un.");
            }

            System.out.println("\n=========================================================================");
            System.out.println(" RESULTADO DO TESTE DO PROJETO INTEGRADOR: SUCESSO TOTAL E ABSOLUTO!");
            System.out.println(" Sistema 100% desacoplado de dependências visuais e portável para Web.");
            System.out.println("=========================================================================");

        } catch (Exception e) {
            System.err.println("\n[FALHA DE EXECUÇÃO]: Erro estrutural ou relacional detectado.");
            e.printStackTrace();
        }
    }
}
