package br.com.sistemarj.rjsistema;

import Classes.Cliente;
import Classes.Fornecedor;
import Service.ClienteService;
import Service.FornecedorService;
import java.time.LocalDate;
import java.util.List;

public class PrincipalTeste {

    public static void main(String[] args) {
        System.out.println("========== INICIANDO TESTE DOS COMPONENTES REFATORADOS (SOLID) ==========\n");

        ClienteService clienteService = new ClienteService();
        FornecedorService fornecedorService = new FornecedorService();

        try {
            // =================================================================
            // MÓDULO 1: CLIENTES (Validações e Persistência)
            // =================================================================
            System.out.println("[TESTE CLIENTE 1] Testando validação de segurança (Nome obrigatório)...");
            Cliente clienteInvalido = new Cliente();
            clienteInvalido.setCnpjCpf("123.456.789-00");
            try {
                clienteService.salvar(clienteInvalido);
            } catch (IllegalArgumentException e) {
                System.out.println("-> Sucesso: A camada de serviço barrou o cadastro inválido. Motivo: " + e.getMessage());
            }

            System.out.println("\n[TESTE CLIENTE 2] Cadastrando um cliente válido no banco de dados...");
            Cliente novoCliente = new Cliente();
            novoCliente.setNomeRazao("Empresa de Teste SOLID Ltda");
            novoCliente.setNomeFantasia("Teste Web Ready");
            novoCliente.setCnpjCpf("99.888.777/0001-11"); // Alterado para evitar erro de duplicidade
            novoCliente.setNascimento(LocalDate.of(1995, 5, 20));
            novoCliente.setEmail("contato@testesolid.com");
            novoCliente.setCidade("Camaquã");
            novoCliente.setEstado("RS");
            clienteService.salvar(novoCliente);
            System.out.println("-> Sucesso: Cliente salvo e transação concluída pelo DAO!");

            // =================================================================
            // MÓDULO 2: FORNECEDORES (Validações e Persistência)
            // =================================================================
            System.out.println("\n-------------------------------------------------------------------------");
            System.out.println("[TESTE FORNECEDOR 1] Testando validação de segurança (Razão obrigatória)...");
            Fornecedor fornecedorInvalido = new Fornecedor();
            fornecedorInvalido.setCnpj("00.000.000/0001-00");
            try {
                fornecedorService.salvar(fornecedorInvalido);
            } catch (IllegalArgumentException e) {
                System.out.println("-> Sucesso: FornecedorService barrou o cadastro incompleto. Motivo: " + e.getMessage());
            }

            System.out.println("\n[TESTE FORNECEDOR 2] Cadastrando um fornecedor válido...");
            Fornecedor novoFornecedor = new Fornecedor();
            novoFornecedor.setNomeRazao("Distribuidora Nordeste de Alimentos");
            novoFornecedor.setNomeFantasia("Nordeste Atacado");
            novoFornecedor.setCnpj("44.333.222/0001-55"); // Documento único fictício
            novoFornecedor.setEmail("vendas@nordeste.com");
            novoFornecedor.setDataCadastro(LocalDate.now()); // Nova API de tempo mapeada pelo Converter
            fornecedorService.salvar(novoFornecedor);
            System.out.println("-> Sucesso: Fornecedor salvo com controle de transação e auditoria automatizada de data!");

            // =================================================================
            // MÓDULO 3: LISTAGEM UNIFICADA (Desacoplada da Interface)
            // =================================================================
            System.out.println("\n-------------------------------------------------------------------------");
            System.out.println("[TESTE INTEGRADO 3] Listando todos os fornecedores cadastrados...");
            List<Fornecedor> listaFornecedores = fornecedorService.listarTodos();
            
            if (listaFornecedores.isEmpty()) {
                System.out.println("-> Nenhum fornecedor encontrado no banco.");
            } else {
                System.out.println("-> Fornecedores encontrados no banco de dados:");
                for (Fornecedor f : listaFornecedores) {
                    System.out.println("   - ID: " + f.getId() 
                            + " | Razão Social: " + f.getNomeRazao() 
                            + " | Cadastro: " + (f.getDataCadastro() != null ? f.getDataCadastro() : "Não informada"));
                }
            }

            System.out.println("\n=========================================================================");
            System.out.println(" RESULTADO DO TESTE: SUCESSO ABSOLUTO PARA CLIENTES E FORNECEDORES!");
            System.out.println("=========================================================================");

        } catch (Exception e) {
            System.err.println("\n[ERRO CRÍTICO NO TESTE]: Falha de infraestrutura ou violação de constraints.");
            e.printStackTrace();
        }
    }
}
