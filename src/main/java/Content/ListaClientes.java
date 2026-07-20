package Content;

import Classes.Cliente;
import Classes.ClienteDAO;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;

public class ListaClientes extends javax.swing.JPanel {

    public ListaClientes() {
        initComponents();
        atualizarTabela();

        for (int column = 0; column < tblListaClientes.getColumnCount(); column++) {
            int width = 100; // Tamanho mínimo
            for (int row = 0; row < tblListaClientes.getRowCount(); row++) {
                javax.swing.table.TableCellRenderer renderer = tblListaClientes.getCellRenderer(row, column);
                java.awt.Component comp = tblListaClientes.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            tblListaClientes.getColumnModel().getColumn(column).setPreferredWidth(width);
        }

    }

    public void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tblListaClientes.getModel();
        modelo.setNumRows(0); // LIMPA A TABELA ANTES DE REPREENCHER

        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.listarTodos();

        // Limpa a tabela antes de preencher para não duplicar dados
        modelo.setNumRows(0);

        // Adiciona cada cliente na linha da tabela
        for (Cliente c : lista) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNomeRazao(),
                c.getNomeFantasia(),
                c.getCnpjCpf(),
                c.getNascimento(),
                c.getProfissao(),
                c.getRua(),
                c.getBairro(),
                c.getCidade(),
                c.getEstado(),
                c.getCep(),
                c.getTelefone(),
                c.getWhatsapp(),
                c.getEmail(),
                c.getObservacao(),
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaClientes = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA CLIENTES");

        tblListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome/Razão", "Nome Fantasia", "CNPJ/CPF", "Nascimento", "Atividade/Profissão", "Rua", "Bairro", "Cidade", "Estado", "CEP", "Telefone", "Whatsapp", "Email", "Observação"
            }
        ));
        tblListaClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblListaClientes);

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblListaClientes.getSelectedRow();

        if (linha != -1) {
            // Pega o ID da tabela
            Long id = Long.valueOf(tblListaClientes.getValueAt(linha, 0).toString());

            // Busca o cliente no banco
            ClienteDAO dao = new ClienteDAO();
            Classes.Cliente selecionado = dao.buscarPorId(id);

            if (selecionado != null) {
                // CHAMA O DASHBOARD PARA TROCAR A TELA
                Dashboard.MainDashboard.exibirEdicao(selecionado);

                // Opcional: Esconde a lista atual se ela for um painel separado
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        atualizarTabela();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaClientes;
    // End of variables declaration//GEN-END:variables
}
