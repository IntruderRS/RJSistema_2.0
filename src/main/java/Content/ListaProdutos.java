package Content;

import Classes.Produto;
import Service.ProdutoService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaProdutos extends javax.swing.JPanel {

    private Classes.Produto produtoSelecionado;

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

    // Getter público exigido pela TelaPedidos para coletar o resultado da busca
    public Classes.Produto getProdutoSelected() { // Renomeado ou mantido conforme assinatura
        return this.produtoSelecionado;
    }
     // Getter alternativo para bater com a chamada da TelaPedidos
    public Classes.Produto getProdutoSelecionado() {
        return this.produtoSelecionado;
    }

    public void atualizarTabela() {

         DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setNumRows(0); // Limpa a tabela antes de repreeencher

        // CORREÇÃO SOLID: Utilizando a camada de serviço desacoplada do banco
        ProdutoService service = new ProdutoService();
        List<Produto> lista = service.listarTodos();

        // Adiciona cada produto na linha da tabela
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
                p.getPorcentagemLucro(), // Nomenclatura nominal corrigida com "n"
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
        btnSelecionar = new javax.swing.JButton();

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

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
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
                .addComponent(btnSelecionar)
                .addGap(43, 43, 43)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnSelecionar))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        atualizarTabela();
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int linha = tblProdutos.getSelectedRow();

        if (linha != -1) {
            try {
                Long id = Long.valueOf(tblProdutos.getValueAt(linha, 0).toString());

                // SOLID: Chamando o service em vez do DAO bruto
                ProdutoService service = new ProdutoService();
                Classes.Produto selecionado = service.buscarPorId(id);

                if (selecionado != null) {
                    Dashboard.MainDashboard.exibirEdicaoProduto(selecionado);
                    this.setVisible(false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro operacional ao descarregar produto: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um produto na tabela.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        // BOTÃO SELECIONAR CONFIGURADO
        int linha = tblProdutos.getSelectedRow();
        
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um produto na tabela primeiro.");
            return;
        }
        
        Long id = Long.valueOf(tblProdutos.getValueAt(linha, 0).toString());
        
        ProdutoService service = new ProdutoService();
        this.produtoSelecionado = service.buscarPorId(id);
        
        // Oculta o painel para fechar a modal automática na TelaPedidos
        this.setVisible(false);
    }//GEN-LAST:event_btnSelecionarActionPerformed

     private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {
        // Atalho de Clique Duplo na linha da tabela
        if (evt.getClickCount() == 2) { 
            int linha = tblProdutos.getSelectedRow();
            if (linha != -1) {
                Long id = Long.valueOf(tblProdutos.getValueAt(linha, 0).toString()); 
                
                ProdutoService service = new ProdutoService();
                this.produtoSelecionado = service.buscarPorId(id);
                
                this.setVisible(false); 
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    // End of variables declaration//GEN-END:variables
}
