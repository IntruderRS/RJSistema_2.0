package Content;

import Classes.*;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroProdutos extends javax.swing.JPanel {

    private Produto produtoAtual;

    public CadastroProdutos() {
        initComponents();
        carregarCombos();
    }

    private void limparCampos() {
        txtID.setText("");
        txtNome.setText("");
        txtValorCusto.setText("");
        cbCategoria.setSelectedIndex(-1);
        cbFornecedor.setSelectedIndex(-1);
        txtCodigoBarras.setText("");
        txtDimensoes.setText("");
        txtValorCusto.setText("");
        txtLote.setText("");
        txtNCM.setText("");
        txtPeso.setText("");
        txtPorcentagemLucro.setText("");
        txtQuantidade.setText("");
        txtValorVenda.setText("");
        txtVencimento.setText("");
        txtObservacao.setText("");

        txtNome.requestFocus(); // Coloca o cursor de volta no primeiro campo
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        txtNome = new javax.swing.JTextField();
        txtValorCusto = new javax.swing.JTextField();
        txtPorcentagemLucro = new javax.swing.JTextField();
        txtValorVenda = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtDimensoes = new javax.swing.JTextField();
        txtCodigoBarras = new javax.swing.JTextField();
        txtNCM = new javax.swing.JTextField();
        txtLote = new javax.swing.JTextField();
        txtVencimento = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        cbFornecedor = new javax.swing.JComboBox<>();
        cbCategoria = new javax.swing.JComboBox<>();

        setForeground(new java.awt.Color(205, 205, 205));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO PRODUTOS");

        jLabel2.setText("ID:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Valor Custo:");

        jLabel5.setText("Porcentagem Lucro:");

        jLabel6.setText("Valor Venda:");

        jLabel7.setText("Quantidade:");

        jLabel8.setText("Peso:");

        jLabel9.setText("Dimensões:");

        jLabel10.setText("Código de Barras:");

        jLabel11.setText("NCM:");

        jLabel12.setText("Lote:");

        jLabel13.setText("Vencimento:");

        jLabel14.setText("Observação:");

        jLabel15.setText("Fornecedor:");

        jLabel16.setText("Categoria:");

        txtID.setEditable(false);

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane1.setViewportView(txtObservacao);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnBuscar)
                .addGap(185, 185, 185)
                .addComponent(btnLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpar)
                    .addComponent(btnSalvar))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDimensoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(txtPeso, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtValorVenda, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPorcentagemLucro, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtValorCusto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtVencimento, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodigoBarras, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNCM, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, 320, Short.MAX_VALUE)
                        .addComponent(cbFornecedor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtValorCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtPorcentagemLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDimensoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            if (produtoAtual == null) {
                produtoAtual = new Produto();
            }

            // 1. Conversões (Preparamos os números para o objeto)
            Double valorCustoLimpo = Double.valueOf(txtValorCusto.getText().replace(",", "."));
            Double valorVendaLimpo = Double.valueOf(txtValorVenda.getText().replace(",", "."));
            Double pesoLimpo = Double.valueOf(txtPeso.getText().replace(",", "."));
            Double lucroLimpo = Double.valueOf(txtPorcentagemLucro.getText().replace(",", "."));
            Integer qtdLimpa = Integer.valueOf(txtQuantidade.getText());

            //Passa os dados dos campos para o objeto (MUITO IMPORTANTE)
            produtoAtual.setNome(txtNome.getText());
            produtoAtual.setCodigoBarras(txtCodigoBarras.getText());
            produtoAtual.setDimensoes(txtDimensoes.getText());
            produtoAtual.setValorCusto(valorCustoLimpo);
            produtoAtual.setLote(txtLote.getText());
            produtoAtual.setNCM(txtNCM.getText());
            produtoAtual.setPeso(pesoLimpo);
            produtoAtual.setPorcetagemLucro(lucroLimpo);
            produtoAtual.setQuantidade(qtdLimpa);
            produtoAtual.setValorVenda(valorVendaLimpo);
            produtoAtual.setVencimento(txtVencimento.getText());
            produtoAtual.setObservacao(txtObservacao.getText());
            produtoAtual.setFornecedor((Classes.Fornecedor) cbFornecedor.getSelectedItem());
            produtoAtual.setCategoria((Classes.Categoria) cbCategoria.getSelectedItem());

            // 5. Salva no Banco de Dados
            new Classes.ProdutoDAO().salvar(produtoAtual);

            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
            limparCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // 1. Chama o método que limpa os textos dos campos
        limparCampos();

        // 2. MUITO IMPORTANTE: Reseta a variável de controle
        // Isso evita que o sistema tente atualizar o ID do cliente anterior
        this.produtoAtual = null;

        // 3. Opcional: Coloca o foco no primeiro campo
        txtNome.requestFocus();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Dashboard.MainDashboard.mostrarListaProdutos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        carregarCombos();
    }//GEN-LAST:event_formComponentShown

    private void carregarCombos() {
        // 1. Limpa os combos para não duplicar se o método for chamado de novo
        cbCategoria.removeAllItems();
        cbFornecedor.removeAllItems();

        // Busca categorias atualizadas
        List<Categoria> listaCat = new CategoriaDAO().listarTodos();
        for (Categoria c : listaCat) {
            cbCategoria.addItem(c);
        }

        // Busca fornecedores atualizados
        List<Fornecedor> listaForn = new FornecedorDAO().listarTodos();
        for (Fornecedor f : listaForn) {
            cbFornecedor.addItem(f);
        }

        // Deixa os campos em branco por padrão (opcional)
        cbCategoria.setSelectedIndex(-1);
        cbFornecedor.setSelectedIndex(-1);
    }

    public void prepararEdicao(Classes.Produto p) {
        this.produtoAtual = p; // Variável da classe
        txtID.setText(String.valueOf(p.getId()));
        txtNome.setText(p.getNome());
        cbCategoria.setSelectedItem(p.getCategoria());
        txtCodigoBarras.setText(p.getCodigoBarras());
        txtDimensoes.setText(p.getDimensoes());
        cbFornecedor.setSelectedItem(p.getFornecedor());
        txtLote.setText(p.getLote());
        txtNCM.setText(p.getNCM());
        txtPeso.setText(String.valueOf(p.getPeso()));
        txtPorcentagemLucro.setText(String.valueOf(p.getPorcetagemLucro()));
        txtQuantidade.setText(String.valueOf(p.getQuantidade()));
        txtValorCusto.setText(String.valueOf(p.getValorCusto()).replace(".", ","));
        txtValorVenda.setText(String.valueOf(p.getValorVenda()).replace(".", ","));
        txtVencimento.setText(p.getVencimento());
        txtObservacao.setText(p.getObservacao());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Classes.Categoria> cbCategoria;
    private javax.swing.JComboBox<Classes.Fornecedor> cbFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtDimensoes;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtNCM;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPorcentagemLucro;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorCusto;
    private javax.swing.JTextField txtValorVenda;
    private javax.swing.JTextField txtVencimento;
    // End of variables declaration//GEN-END:variables
}
