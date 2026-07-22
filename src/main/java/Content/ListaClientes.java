package Content;

import Classes.Cliente;
import Service.ClienteService;
import br.com.sistemarj.rjsistema.persistencia.ClienteDAO;
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

        ClienteService service = new ClienteService();
        List<Cliente> lista = service.listarTodos();

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
                c.getObservacao(),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaClientes = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSelecionar)
                .addGap(49, 49, 49)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnSelecionar))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblListaClientes.getSelectedRow();

        if (linha != -1) {
            Long id = Long.valueOf(tblListaClientes.getValueAt(linha, 0).toString());

            ClienteService service = new ClienteService();
            Classes.Cliente selecionado = service.buscarPorId(id);

            if (selecionado != null) {
                Dashboard.MainDashboard.exibirEdicao(selecionado);
                this.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.");
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        atualizarTabela();
    }//GEN-LAST:event_formComponentShown

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        int linha = tblListaClientes.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um cliente na tabela primeiro.");
            return;
        }

        Long id = Long.valueOf(tblListaClientes.getValueAt(linha, 0).toString());

        ClienteService service = new ClienteService();
        this.clienteSelecionado = service.buscarPorId(id);

        this.setVisible(false);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private Classes.Cliente clienteSelecionado;

// Getter para a tela de pedidos conseguir coletar o resultado
    public Classes.Cliente getClienteSelecionado() {
        return this.clienteSelecionado;
    }

// No evento de clique duplo da sua Tabela ou no botão "Selecionar" da lista, coloque:
    private void tblListaClientesMouseClicked(java.awt.event.MouseEvent evt) {
         if (evt.getClickCount() == 2) { 
            int linha = tblListaClientes.getSelectedRow();
            if (linha != -1) {
                Long id = Long.valueOf(tblListaClientes.getValueAt(linha, 0).toString()); 
                
                ClienteService service = new ClienteService();
                
                // CORREÇÃO: Altere de getClienteSelecionado() para buscarPorId(id)
                this.clienteSelecionado = service.buscarPorId(id);
                
                this.setVisible(false); 
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaClientes;
    // End of variables declaration//GEN-END:variables
}
