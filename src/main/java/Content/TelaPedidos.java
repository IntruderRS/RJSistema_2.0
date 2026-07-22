package Content;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class TelaPedidos extends javax.swing.JPanel {

    private final Service.PedidoService pedidoService = new Service.PedidoService();
    private Classes.Pedido pedidoAtual = new Classes.Pedido();
    private Classes.Cliente clienteSelecionado;
    private Classes.Produto produtoSelecionado;

    private boolean selecionandoDaLista = false;

    public TelaPedidos() {
        initComponents();
        limparCampos();
        configurarModeloTabela(); // Define as colunas da tabela de itens
        gerarProximoNumeroPedido(); // Busca automaticamente o próximo ID do banco
        carregarOpcoesFrete();
        carregarOpcoesPagamento();
        configurarGatilhosCalculoAutomatico();

    }

    private void carregarOpcoesFrete() {
        cbTipoFrete.removeAllItems();
        cbTipoFrete.addItem("FOB");
        cbTipoFrete.addItem("CIF");
        cbTipoFrete.addItem("SEDEX");
        cbTipoFrete.addItem("PAC");
        cbTipoFrete.addItem("RETIRADO NO LOCAL");
        cbTipoFrete.addItem("RODOVIÁRIA");
        cbTipoFrete.addItem("OUTROS");
        cbTipoFrete.setSelectedIndex(-1); // Inicia vazio
    }

    private void carregarOpcoesPagamento() {
        try {
            jakarta.persistence.EntityManager em = br.com.sistemarj.rjsistema.persistencia.JPAUtil.getEntityManager();
            // Assume que você possui a classe/entidade "Pagamento" mapeada
            List<String> formas = em.createQuery("SELECT p.nomeForma FROM Pagamento p", String.class).getResultList();
            em.close();

            cbFormaPagamento.removeAllItems();
            for (String forma : formas) {
                cbFormaPagamento.addItem(forma);
            }
        } catch (Exception e) {
            // Fallback preventivo caso a tabela no banco ainda não tenha registros
            cbFormaPagamento.removeAllItems();
            cbFormaPagamento.addItem("DINHEIRO");
            cbFormaPagamento.addItem("CARTÃO CRÉDITO");
            cbFormaPagamento.addItem("CARTÃO DÉBITO");
            cbFormaPagamento.addItem("PIX");
        }
        cbFormaPagamento.setSelectedIndex(-1);
    }

    private void configurarGatilhosCalculoAutomatico() {
        java.awt.event.FocusAdapter ouvinteCalculo = new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                // Executa a sincronização matemática sempre que o campo perder o foco
                atualizarTotaisFinais();
            }
        };

        // Vincula o ouvinte nos três campos monetários adicionais
        txtValorFrete.addFocusListener(ouvinteCalculo);
        txtDesconto.addFocusListener(ouvinteCalculo);
        txtImposto.addFocusListener(ouvinteCalculo);
    }

    // Configura a JTable para aceitar a estrutura de itens do pedido
    private void configurarModeloTabela() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Item", "Código", "Produto", "Quantidade", "Valor Unit.", "Subtotal"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            } // Trava edição direta
        };
        tblProdutos.setModel(modelo);
    }

// Busca o maior ID da tabela para sugerir o número do novo pedido (Pre-faturamento)
    private void gerarProximoNumeroPedido() {
        try {
            jakarta.persistence.EntityManager em = br.com.sistemarj.rjsistema.persistencia.JPAUtil.getEntityManager();
            // JPQL para pegar o maior ID atual de pedidos
            Long maxId = em.createQuery("SELECT MAX(p.id) FROM Pedido p", Long.class).getSingleResult();
            em.close();

            long proximoId = (maxId == null) ? 1L : maxId + 1L;
            txtNumeroPedido.setText(String.valueOf(proximoId));
        } catch (Exception e) {
            txtNumeroPedido.setText("1"); // Fallback caso o banco esteja vazio ou não criado
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        btnBuscarProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtValorItem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValorFrete = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtImposto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        btnLimparPedido = new javax.swing.JButton();
        btnSalvarPedido = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtNumeroPedido = new javax.swing.JTextField();
        txtValorTotal = new javax.swing.JTextField();
        txtNomeCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnDeletarItem = new javax.swing.JButton();
        cbTipoFrete = new javax.swing.JComboBox<>();
        cbFormaPagamento = new javax.swing.JComboBox<>();

        setForeground(new java.awt.Color(205, 205, 205));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PEDIDOS");

        jLabel1.setText("Nome Cliente:");

        jLabel3.setText("Produto:");

        btnBuscarProduto.setText("Buscar");
        btnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdutoActionPerformed(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item", "Produto", "Quantidade", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        jLabel4.setText("Tipo Frete:");

        jLabel5.setText("Forma Pagamento:");

        jLabel6.setText("Valor Item:");

        jLabel7.setText("Valor Frete:");

        jLabel8.setText("Desconto (%):");

        jLabel9.setText("Imposto:");

        jLabel11.setText("Quantidade:");

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Valor Total");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("R$");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimparPedido.setText("Limpar");
        btnLimparPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparPedidoActionPerformed(evt);
            }
        });

        btnSalvarPedido.setText("Salvar");
        btnSalvarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnPesquisar)
                .addGap(240, 240, 240)
                .addComponent(btnLimparPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(btnSalvarPedido)
                .addGap(127, 127, 127))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarPedido)
                    .addComponent(btnLimparPedido)
                    .addComponent(btnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Número Pedido");

        txtNumeroPedido.setBackground(new java.awt.Color(204, 204, 204));
        txtNumeroPedido.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNumeroPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroPedido.setToolTipText("");

        txtValorTotal.setBackground(new java.awt.Color(204, 204, 204));
        txtValorTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        txtNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeClienteKeyReleased(evt);
            }
        });

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        btnDeletarItem.setText("Deletar Item");
        btnDeletarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarItemActionPerformed(evt);
            }
        });

        cbTipoFrete.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel6)
                                .addGap(25, 25, 25)
                                .addComponent(txtValorItem, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnOk))
                            .addComponent(txtProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                            .addComponent(txtNomeCliente))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarProduto)
                            .addComponent(btnBuscarCliente))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumeroPedido))
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4))
                            .addComponent(jLabel7))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtValorFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbTipoFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtImposto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorTotal)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDeletarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15))))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProduto)
                    .addComponent(txtNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(txtValorItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnDeletarItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtValorFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtImposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            if (produtoSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Selecione um produto utilizando o botão Buscar primeiro.");
                return;
            }
            if (txtQuantidade.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Insira a quantidade desejada.");
                return;
            }

            int qtd = Integer.parseInt(txtQuantidade.getText().trim());
            if (qtd <= 0) {
                JOptionPane.showMessageDialog(this, "A quantidade inserida deve ser maior que zero.");
                return;
            }

            // Pega o valor que veio automático do banco (ou permite digitação se o campo for aberto)
            double valorUnitario = Double.parseDouble(txtValorItem.getText().trim().replace(",", "."));

            // SRP/Regra de Negócio: Instancia o item (A classe ItemPedido calcula o subtotal sozinha)
            Classes.ItemPedido item = new Classes.ItemPedido(produtoSelecionado, qtd, valorUnitario);

            // Adiciona o item ao pedido da memória
            pedidoAtual.adicionarItem(item);

            // Atualiza a interface gráfica
            atualizarTabelaItens();

            // Reseta os campos de digitação de itens para o próximo produto
            txtProduto.setText("");
            txtQuantidade.setText("");
            txtValorItem.setText("");
            produtoSelecionado = null;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato numérico inválido na quantidade ou valor do item.");
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtNomeClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeClienteKeyReleased

    }//GEN-LAST:event_txtNomeClienteKeyReleased

    private void btnSalvarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPedidoActionPerformed
        try {
            if (clienteSelecionado == null) {
                JOptionPane.showMessageDialog(this, "É obrigatório associar um cliente ao pedido.");
                return;
            }
            if (cbFormaPagamento.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Selecione a forma de pagamento.");
                return;
            }

            pedidoAtual.setCliente(clienteSelecionado);

            // Coleta o texto selecionado nos ComboBoxes de forma limpa
            pedidoAtual.setTipoFrete((String) cbTipoFrete.getSelectedItem());
            pedidoAtual.setFormaPagamento((String) cbFormaPagamento.getSelectedItem());

            // Sincroniza os valores monetários finais de frete/desconto/imposto
            atualizarTotaisFinais();

            // Envia para o Service (onde valida o estoque e faz o commit via JPA)
            pedidoService.finalizarPedido(pedidoAtual);

            JOptionPane.showMessageDialog(this, "Pedido finalizado e registrado com sucesso!");
            limparTelaCompleta();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarPedidoActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // 1. Cria uma janela modal genérica (JDialog) em tempo de execução
        javax.swing.JDialog janelaModal = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), "Selecionar Cliente", true);

        // 2. Instancia o painel da ListaClientes (que agora estende JPanel de forma limpa)
        Content.ListaClientes painelLista = new Content.ListaClientes();

        // 3. Embutimos o painel dentro da janela modal flutuante
        janelaModal.add(painelLista);
        janelaModal.pack(); // Ajusta o tamanho da janela automaticamente ao tamanho do painel
        janelaModal.setLocationRelativeTo(this); // Centraliza a janelinha na tela

        // 4. Cria uma escuta: se o usuário clicar em "Selecionar" ou der clique duplo, a janela fecha
        painelLista.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentHidden(java.awt.event.ComponentEvent e) {
                janelaModal.dispose(); // Fecha a janela flutuante quando o painel se ocultar
            }
        });

        // 5. Exibe a janela flutuante por cima de tudo (bloqueia o fundo até fechar)
        janelaModal.setVisible(true);

        // 6. O código abaixo SÓ EXECUTA após a janela fechar
        Classes.Cliente clienteEscolhido = painelLista.getClienteSelecionado();

        if (clienteEscolhido != null) {
            this.clienteSelecionado = clienteEscolhido;
            txtNomeCliente.setText(clienteEscolhido.getNomeRazao());
            txtNomeCliente.setEditable(false);
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoActionPerformed
        // 1. Cria uma janela modal em tempo de execução para flutuar por cima de tudo
        javax.swing.JDialog janelaModal = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), "Selecionar Produto", true);

        // 2. Instancia o painel da sua lista de produtos (assumindo o nome padrão Content.ListaProdutos)
        Content.ListaProdutos painelLista = new Content.ListaProdutos();

        // 3. Insere e centraliza o painel dentro da janela flutuante
        janelaModal.add(painelLista);
        janelaModal.pack();
        janelaModal.setLocationRelativeTo(this);

        // 4. Fecha a janela flutuante de forma automatizada assim que o painel se ocultar
        painelLista.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentHidden(java.awt.event.ComponentEvent e) {
                janelaModal.dispose();
            }
        });

        // 5. Exibe a janela modal e pausa o fluxo da TelaPedidos
        janelaModal.setVisible(true);

        // 6. Coleta o produto que foi selecionado pelo usuário
        Classes.Produto produtoEscolhido = painelLista.getProdutoSelecionado();

        if (produtoEscolhido != null) {
            // Vincula a referência do objeto ao escopo da TelaPedidos
            this.produtoSelecionado = produtoEscolhido;

            // Alimenta as caixas de texto com as informações reais do banco de dados
            txtProduto.setText(produtoEscolhido.getNome());
            txtValorItem.setText(String.format("%.2f", produtoEscolhido.getValorVenda()));

            // Trava os campos textuais automáticos para garantir a consistência
            txtProduto.setEditable(false);
            txtValorItem.setEditable(false);

            // Coloca o foco direto na quantidade para agilizar a digitação do operador
            txtQuantidade.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarProdutoActionPerformed

    private void btnDeletarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarItemActionPerformed
        int linhaSelecionada = tblProdutos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela de itens para remover.");
            return;
        }

        // Remove o item da lista do objeto de negócio pelo mesmo índice do grid
        pedidoAtual.getItens().remove(linhaSelecionada);

        // Sincroniza e redesenha o grid e os preços totais na tela na hora
        atualizarTabelaItens();

        JOptionPane.showMessageDialog(this, "Item removido do faturamento atual.");
    }//GEN-LAST:event_btnDeletarItemActionPerformed

    private void btnLimparPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparPedidoActionPerformed
        limparTelaCompleta();
        JOptionPane.showMessageDialog(this, "Formulário de faturamento redefinido.");
    }//GEN-LAST:event_btnLimparPedidoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (this.getParent() != null) {
            for (java.awt.Component comp : this.getParent().getComponents()) {
                if (comp instanceof Content.ListaPedidos) {
                    Content.ListaPedidos telaLista = (Content.ListaPedidos) comp;

                    // Força a lista a ler os novos lançamentos ou atualizações do banco na hora
                    telaLista.atualizarTabela();

                    // Inverte as visibilidades locais
                    telaLista.setVisible(true);
                    this.setVisible(false);
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed
    private void atualizarTabelaItens() {
        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setNumRows(0);

        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formatadorMoeda = new DecimalFormat("R$ #,##0.00", simbolos);

        int contador = 1;
        List<Classes.ItemPedido> listaItens = pedidoAtual.getItens();

        for (Classes.ItemPedido item : listaItens) {
            modelo.addRow(new Object[]{
                contador++,
                item.getProduto().getId(),
                item.getProduto().getNome(),
                item.getQuantidade(),
                String.format("R$ %.2f", item.getPrecoUnitario()),
                String.format("R$ %.2f", item.getSubtotal())
            });
        }

        atualizarTotaisFinais();
    }

    private void atualizarTotaisFinais() {
        try {
            String freteTexto = txtValorFrete.getText().trim().replace(",", ".");
            pedidoAtual.setValorFrete(freteTexto.isEmpty() ? 0.0 : Double.parseDouble(freteTexto));

            String descontoTexto = txtDesconto.getText().trim().replace(",", ".");
            pedidoAtual.setDescontoPorcentagem(descontoTexto.isEmpty() ? 0.0 : Double.parseDouble(descontoTexto));

            String impostoTexto = txtImposto.getText().trim().replace(",", ".");
            pedidoAtual.setImposto(impostoTexto.isEmpty() ? 0.0 : Double.parseDouble(impostoTexto));
        } catch (NumberFormatException e) {
            // Ignora erros de digitação incompleta enquanto o usuário alterna os campos
        }

        // Executa a lógica centralizada no Modelo (SOLID - SRP)
        pedidoAtual.recalcularTotal();

        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formatadorTotal = new DecimalFormat("#,##0.00", simbolos); // Sem o R$ pois o seu jLabel12 já deve ter o texto "R$"

        // Atualiza a tela com o valor faturado final
        txtValorTotal.setText(formatadorTotal.format(pedidoAtual.getValorTotal()));
    }

    public void prepararEdicaoPedidoCompleto(Classes.Pedido p) {
        if (p == null) {
            return;
        }

        // 1. Vincula o objeto carregado do banco ao escopo da tela
        this.pedidoAtual = p;
        this.clienteSelecionado = p.getCliente();

        // 2. Alimenta os cabeçalhos visuais e numéricos
        txtNumeroPedido.setText(String.valueOf(p.getId()));
        txtNomeCliente.setText(p.getCliente() != null ? p.getCliente().getNomeRazao() : "");
        txtNomeCliente.setEditable(false);

        // 3. Seleciona os itens correspondentes nos ComboBoxes que criamos
        if (p.getTipoFrete() != null) {
            cbTipoFrete.setSelectedItem(p.getTipoFrete());
        }
        if (p.getFormaPagamento() != null) {
            cbFormaPagamento.setSelectedItem(p.getFormaPagamento());
        }

        // 4. Preenche os campos textuais de taxas adicionais
        txtValorFrete.setText(p.getValorFrete() != null ? String.valueOf(p.getValorFrete()) : "");
        txtDesconto.setText(p.getDescontoPorcentagem() != null ? String.valueOf(p.getDescontoPorcentagem()) : "");
        txtImposto.setText(p.getImposto() != null ? String.valueOf(p.getImposto()) : "");

        // 5. Força o redesenho do grid visual (tblProdutos) com a multiplicação dos itens do pedido faturado
        atualizarTabelaItens();
    }

    private void limparCampos() {
        // Limpa as linhas visuais da tabela tblProdutos na tela
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblProdutos.getModel();
        modelo.setNumRows(0);
        txtProduto.setText("");
        txtNomeCliente.setText("");
        txtValorItem.setText("");
        txtValorFrete.setText("");
        txtDesconto.setText("");
        txtImposto.setText("");
        txtQuantidade.setText("");
        txtValorTotal.setText("");

        // Reseta as caixas de seleção para o estado inicial neutro
        cbTipoFrete.setSelectedIndex(-1);
        cbFormaPagamento.setSelectedIndex(-1);
        clienteSelecionado = null;
        produtoSelecionado = null;
        txtNomeCliente.requestFocus(); // Devolve o cursor para o início do fluxo
    }

    private void limparTelaCompleta() {
        limparCampos();
        pedidoAtual = new Classes.Pedido();
        clienteSelecionado = null;
        txtValorTotal.setText("");
        gerarProximoNumeroPedido();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProduto;
    private javax.swing.JButton btnDeletarItem;
    private javax.swing.JButton btnLimparPedido;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvarPedido;
    private javax.swing.JComboBox<String> cbFormaPagamento;
    private javax.swing.JComboBox<String> cbTipoFrete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtImposto;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNumeroPedido;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorFrete;
    private javax.swing.JTextField txtValorItem;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
