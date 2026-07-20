package Content;

import Classes.Produto;
import Classes.ProdutoDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaProdutos extends javax.swing.JPanel {

    public ListaProdutos() {
        initComponents();
        atualizarTabela();

        for (int column = 0; column < tblProdutos.getColumnCount(); column++) {
            int width = 100; // Tamanho mínimo
            for (int row = 0; row < tblProdutos.getRowCount(); row++) {
                javax.swing.table.TableCellRenderer renderer = tblProdutos.getCellRenderer(row, column);
                java.awt.Component comp = tblProdutos.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            tblProdutos.getColumnModel().getColumn(column).setPreferredWidth(width);
        }

    }

    public void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setNumRows(0); // LIMPA A TABELA ANTES DE REPREENCHER

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listarTodos();

        // Limpa a tabela antes de preencher para não duplicar dados
        modelo.setNumRows(0);

        // Adiciona cada cliente na linha da tabela
        for (Produto p : lista) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getCategoria(),
                p.getFornecedor(),
                p.getQuantidade(),
                p.getValorVenda(),
                p.getVencimento(),
                p.getCodigoBarras(),
                p.getDimensoes(),
                p.getLote(),
                p.getNCM(),
                p.getPeso(),
                p.getPorcetagemLucro(),
                p.getValorCusto(),
                p.getObservacao(),
                });                            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA PRODUTOS");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Categoria", "Fornecedor", "Quantidade", "Valor Venda", "Vencimento", "Código de Barras", "Dimensoes", "Lote", "NCM", "Peso", "Porcentagem Lucro", "Valor Custo", "Observação"
            }
        ));
        tblProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblProdutos);

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        atualizarTabela();
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int linha = tblProdutos.getSelectedRow(); // Verifique o nome da sua tabela

    if (linha != -1) {
        try {
            // 1. Pega o ID da primeira coluna (índice 0)
            Long id = Long.valueOf(tblProdutos.getValueAt(linha, 0).toString());

            // 2. Busca o produto completo no banco
            ProdutoDAO dao = new ProdutoDAO();
            Classes.Produto selecionado = dao.buscarPorId(id);

            if (selecionado != null) {
                // 3. CHAMA O DASHBOARD PARA TROCAR A TELA
                // Aqui usamos o método que criamos para o Cadastro de Produtos
                Dashboard.MainDashboard.exibirEdicaoProduto(selecionado);
                
                // Esconde a lista atual
                this.setVisible(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produto: " + e.getMessage());
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecione um produto na tabela.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    // End of variables declaration//GEN-END:variables
}
