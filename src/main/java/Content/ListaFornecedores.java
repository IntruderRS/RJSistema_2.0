package Content;

import Classes.Fornecedor;
import Classes.FornecedorDAO;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

public class ListaFornecedores extends javax.swing.JPanel {

    public ListaFornecedores() {
        initComponents();
        atualizarTabela();

        for (int column = 0; column < tblFornecedor.getColumnCount(); column++) {
            int width = 100; // Tamanho mínimo
            for (int row = 0; row < tblFornecedor.getRowCount(); row++) {
                javax.swing.table.TableCellRenderer renderer = tblFornecedor.getCellRenderer(row, column);
                java.awt.Component comp = tblFornecedor.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            tblFornecedor.getColumnModel().getColumn(column).setPreferredWidth(width);
        }

    }

    public void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tblFornecedor.getModel();
        modelo.setNumRows(0); // LIMPA A TABELA ANTES DE REPREENCHER

        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> lista = dao.listarTodos();

        // Limpa a tabela antes de preencher para não duplicar dados
        modelo.setNumRows(0);

        // Adiciona cada Fornecedor na linha da tabela
        for (Fornecedor f : lista) {
            modelo.addRow(new Object[]{
                f.getId(),
                f.getNomeRazao(),
                f.getNomeFantasia(),
                f.getCnpj(),
                f.getInscricao(),
                f.getRua(),
                f.getBairro(),
                f.getCidade(),
                f.getEstado(),
                f.getCep(),
                f.getAtividade(),
                f.getVendedor(),
                f.getContato(),
                f.getEmail(),
                f.getDadosBanco(),
                f.getObservacoes(),
                f.getDataCadastro(),
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFornecedor = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA FORNECEDORES");

        tblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Razão Social", "Nome Fantasia", "CNPJ", "Inscrição Estadual", "Rua", "Bairro", "Cidade", "Estado", "CEP", "Ramo Atividade", "Vendedor", "Contato", "Email", "Dados Bancários", "Observação", "Data Cadastro"
            }
        ));
        tblFornecedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblFornecedor);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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
                .addComponent(btnEditar)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblFornecedor.getSelectedRow();

        if (linha != -1) {
            // Pega o ID da tabela
            Long id = Long.valueOf(tblFornecedor.getValueAt(linha, 0).toString());

            // Busca o Fornecedor no banco
            FornecedorDAO dao = new FornecedorDAO();
            Classes.Fornecedor selecionado = dao.buscarPorId(id);

            if (selecionado != null) {
                // CHAMA O DASHBOARD PARA TROCAR A TELA
                Dashboard.MainDashboard.exibirEdicaoFornecedor(selecionado);

                // Opcional: Esconde a lista atual se ela for um painel separado
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um fornecedor para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        atualizarTabela();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFornecedor;
    // End of variables declaration//GEN-END:variables
}
