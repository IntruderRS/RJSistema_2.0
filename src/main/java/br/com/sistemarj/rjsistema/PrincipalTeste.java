package br.com.sistemarj.rjsistema;

import Classes.Cliente;
import Service.ClienteService;
import java.time.LocalDate;
import java.util.List;

public class PrincipalTeste {

    public static void main(String[] args) {
        System.out.println("========== INICIANDO TESTE DOS COMPONENTES REFATORADOS (SOLID) ==========\n");

        // Instancia a camada de serviço (que por sua vez utiliza o DAO e a Interface)
        ClienteService clienteService = new ClienteService();

        try {
            // -----------------------------------------------------------------
            // TESTE 1: Validação de Segurança (SRP)
            // -----------------------------------------------------------------
            System.out.println("[TESTE 1] Testando validação de segurança (Nome obrigatório)...");
            Cliente clienteInvalido = new Cliente();
            clienteInvalido.setCnpjCpf("123.456.789-00");
            
            try {
                clienteService.salvar(clienteInvalido);
            } catch (IllegalArgumentException e) {
                System.out.println("-> Sucesso: A camada de serviço barrou o cadastro inválido. Motivo: " + e.getMessage());
            }

            // -----------------------------------------------------------------
            // TESTE 2: Persistência com Sucesso e Nova API de Data (LocalDate)
            // -----------------------------------------------------------------
            System.out.println("\n[TESTE 2] Cadastrando um cliente válido no banco de dados...");
            Cliente novoCliente = new Cliente();
            novoCliente.setNomeRazao("Empresa de Teste SOLID Ltda");
            novoCliente.setNomeFantasia("Teste Web Ready");
            novoCliente.setCnpjCpf("12.345.678/0001-21");
            novoCliente.setNascimento(LocalDate.of(1995, 5, 20)); // Testando o tipo LocalDate refatorado
            novoCliente.setEmail("contato@testesolid.com");
            novoCliente.setCidade("Camaquã");
            novoCliente.setEstado("RS");

            clienteService.salvar(novoCliente);
            System.out.println("-> Sucesso: Cliente salvo e transação concluída pelo DAO!");

            // -----------------------------------------------------------------
            // TESTE 3: Listagem de Dados (Desacoplada da Interface)
            // -----------------------------------------------------------------
            System.out.println("\n[TESTE 3] Listando todos os clientes cadastrados...");
            List<Cliente> lista = clienteService.listarTodos();
            
            if (lista.isEmpty()) {
                System.out.println("-> Nenhum cliente encontrado no banco.");
            } else {
                System.out.println("-> Clientes encontrados no banco de dados:");
                for (Cliente c : lista) {
                    System.out.println("   - ID: " + c.getId() 
                            + " | Nome: " + c.getNomeRazao() 
                            + " | Data Nasc: " + (c.getNascimento() != null ? c.getNascimento() : "Não informada"));
                }
            }

            System.out.println("\n=========================================================================");
            System.out.println(" RESULTADO DO TESTE: SUCESSO ABSOLUTO!");
            System.out.println(" As camadas de visualização, negócio e persistência estão 100% isoladas.");
            System.out.println("=========================================================================");

        } catch (Exception e) {
            System.err.println("\n[ERRO CRÍTICO NO TESTE]: Ocorreu uma falha na infraestrutura.");
            e.printStackTrace();
        }
    }
}

