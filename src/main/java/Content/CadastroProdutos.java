package Content;

import br.com.sistemarj.rjsistema.persistencia.CategoriaDAO;
import br.com.sistemarj.rjsistema.persistencia.FornecedorDAO;
import Classes.*;
import Service.ProdutoService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastroProdutos extends javax.swing.JPanel {

    // APLICANDO SOLID: Acionando as regras de negócio de forma isolada
    private final ProdutoService produtoService = new ProdutoService();
    private Produto produtoAtual;

    public CadastroProdutos() {
        initComponents();
        carregarCombos();
    }

    private void carregarCombos() {
        try {
            // Carrega os ComboBoxes através das classes de infraestrutura existentes
            FornecedorDAO fDAO = new FornecedorDAO();
            List<Fornecedor> fornecedores = fDAO.listarTodos();
            cbFornecedor.removeAllItems();
            for (Fornecedor f : fornecedores) {
                cbFornecedor.addItem(f);
            }

            CategoriaDAO cDAO = new CategoriaDAO();
            List<Categoria> categorias = cDAO.listarTodos();
            cbCategoria.removeAllItems();
            for (Categoria c : categorias) {
                cbCategoria.addItem(c);
            }

            cbFornecedor.setSelectedIndex(-1);
            cbCategoria.setSelectedIndex(-1);
        } catch (Exception e) {
            System.err.println("Aviso: Falha ao carregar listas de apoio visual na inicialização.");
        }
    }

    private void limparCampos() {
        txtID.setText("");
        txtNome.setText("");
        txtValorCusto.setText("");
        cbCategoria.setSelectedIndex(-1);
        cbFornecedor.setSelectedIndex(-1);
        txtCodigoBarras.setText("");
        txtDimensoes.setText("");
        txtLote.setText("");
        txtNCM.setText("");
        txtPeso.setText("");
        txtPorcentagemLucro.setText("");
        txtQuantidade.setText("");
        txtValorVenda.setText("");
        txtVencimento.setText("");
        txtObservacao.setText("");
        produtoAtual = null;

        txtNome.requestFocus();
    }

    // Traduz os textos da tela para o objeto de domínio (SRP)
    private Produto obterProdutoDaTela() {
        Produto produto = (produtoAtual != null) ? produtoAtual : new Produto();

        if (!txtID.getText().isEmpty()) {
            produto.setId(Long.parseLong(txtID.getText()));
        }

        produto.setNome(txtNome.getText());

        if (!txtValorCusto.getText().isEmpty()) {
            produto.setValorCusto(Double.parseDouble(txtValorCusto.getText().replace(",", ".")));
        }
        if (!txtPorcentagemLucro.getText().isEmpty()) {
            // CORREÇÃO: Utilizando a nomenclatura correta definida no modelo
            produto.setPorcentagemLucro(Double.parseDouble(txtPorcentagemLucro.getText().replace(",", ".")));
        }
        if (!txtValorVenda.getText().isEmpty()) {
            produto.setValorVenda(Double.parseDouble(txtValorVenda.getText().replace(",", ".")));
        }
        if (!txtQuantidade.getText().isEmpty()) {
            produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        }
        if (!txtPeso.getText().isEmpty()) {
            produto.setPeso(Double.parseDouble(txtPeso.getText().replace(",", ".")));
        }

        produto.setDimensoes(txtDimensoes.getText());
        produto.setCodigoBarras(txtCodigoBarras.getText());
        produto.setLote(txtLote.getText());
        produto.setNCM(txtNCM.getText());
        produto.setObservacao(txtObservacao.getText());

        produto.setCategoria((Categoria) cbCategoria.getSelectedItem());
        produto.setFornecedor((Fornecedor) cbFornecedor.getSelectedItem());

        // REFATORAÇÃO: Tratamento e parsing seguro de String para LocalDate
        String dataTexto = txtVencimento.getText().trim();
        if (!dataTexto.isEmpty()) {
            try {
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                produto.setVencimento(LocalDate.parse(dataTexto, formatador));
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Formato da data de vencimento incorreto! Utilize o padrão dd/MM/yyyy.");
            }
        } else {
            produto.setVencimento(null);
        }

        return produto;
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
            Produto produto = obterProdutoDaTela();

            // Lógica de cálculo de margem e gravação delegada para a Camada de Serviço
            produtoService.salvar(produto);

            JOptionPane.showMessageDialog(this, "Produto processado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Alerta de Negócio", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro técnico interno ao tentar gravar o registro.", "Erro Crítico", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
         limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idStr = JOptionPane.showInputDialog(this, "Insira o código identificador (ID) do Produto:");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                Long id = Long.parseLong(idStr.trim());
                Produto produto = produtoService.buscarPorId(id);
                prepararEdicao(produto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "A chave inserida deve possuir apenas caracteres numéricos.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro de Consulta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        carregarCombos();
    }//GEN-LAST:event_formComponentShown

    
    public void prepararEdicao(Classes.Produto p) {
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Produto inválido.");
            limparCampos();
            return;
        }

        this.produtoAtual = p;

        txtID.setText(String.valueOf(p.getId()));
        txtNome.setText(p.getNome());
        txtValorCusto.setText(p.getValorCusto() != null ? String.valueOf(p.getValorCusto()) : "");

        // CORREÇÃO NOMINAL: getPorcentagemLucro() corrigido
        txtPorcentagemLucro.setText(p.getPorcentagemLucro() != null ? String.valueOf(p.getPorcentagemLucro()) : "");
        txtValorVenda.setText(p.getValorVenda() != null ? String.valueOf(p.getValorVenda()) : "");
        txtQuantidade.setText(p.getQuantidade() != null ? String.valueOf(p.getQuantidade()) : "");
        txtPeso.setText(p.getPeso() != null ? String.valueOf(p.getPeso()) : "");

        txtDimensoes.setText(p.getDimensoes());
        txtCodigoBarras.setText(p.getCodigoBarras());
        txtLote.setText(p.getLote());
        txtNCM.setText(p.getNCM());
        txtObservacao.setText(p.getObservacao());

        // Vincula as seleções de chaves estrangeiras
        cbCategoria.setSelectedItem(p.getCategoria());
        cbFornecedor.setSelectedItem(p.getFornecedor());

        // REFATORAÇÃO: Converte LocalDate vindo do banco em String formatada para a UI Swing
        if (p.getVencimento() != null) {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            txtVencimento.setText(p.getVencimento().format(formatador));
        } else {
            txtVencimento.setText("");
        }
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
