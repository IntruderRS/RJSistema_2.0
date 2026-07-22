package Content;

import Classes.Pedido;
import Service.PedidoService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaPedidos extends javax.swing.JPanel {

    private final PedidoService pedidoService = new PedidoService();

    public ListaPedidos() {
        initComponents();
        atualizarTabela();
        
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentShown(java.awt.event.ComponentEvent evt) {
            atualizarTabela(); // Recarrega o banco de dados em tempo real
        }
    });
    }

    public void atualizarTabela() {
        // AJUSTADO: Coletando o modelo da tabela com o nome correto
        DefaultTableModel modelo = (DefaultTableModel) tblListaPedidos.getModel();
        modelo.setNumRows(0);

        try {
            List<Pedido> lista = pedidoService.listarTodos();

            for (Pedido p : lista) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getCliente() != null ? p.getCliente().getNomeRazao() : "Não informado",
                    p.getCliente() != null ? p.getCliente().getNomeFantasia() : "",
                    p.getCliente() != null ? p.getCliente().getCnpjCpf() : "",
                    p.getCliente() != null ? p.getCliente().getCidade() : "",
                    p.getCliente() != null ? p.getCliente().getEstado() : "",
                    String.format("R$ %.2f", p.getValorTotal())
                });
            }
        } catch (Exception e) {
            System.err.println("Aviso: Banco ou tabelas de pedidos ainda não inicializados.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaPedidos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setForeground(new java.awt.Color(205, 205, 205));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTA PEDIDOS");

        tblListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°Pedido", "Nome/Razão", "Nome Fantasia", "CNPJ/CPF", "Cidade", "Estado", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(tblListaPedidos);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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
                .addComponent(btnExcluir)
                .addGap(45, 45, 45)
                .addComponent(btnEditar)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int linha = tblListaPedidos.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um pedido na tabela para editar.");
        return;
    }

    Long id = Long.valueOf(tblListaPedidos.getValueAt(linha, 0).toString());

    jakarta.persistence.EntityManager em = br.com.sistemarj.rjsistema.persistencia.JPAUtil.getEntityManager();
    Pedido pedidoCompleto = em.find(Pedido.class, id);
    em.close();

    if (pedidoCompleto != null) {
        // CORREÇÃO SOLID: Em vez de chamar o Dashboard que não tem o botão,
        // nós buscamos a instância da TelaPedidos que está ativa no mesmo container
        for (java.awt.Component comp : this.getParent().getComponents()) {
            if (comp instanceof Content.TelaPedidos) {
                Content.TelaPedidos telaFormPedido = (Content.TelaPedidos) comp;
                
                // Passa o pedido do banco direto para preencher os campos do formulário
                telaFormPedido.prepararEdicaoPedidoCompleto(pedidoCompleto);
                
                // Altera a visibilidade: mostra o formulário e esconde a lista
                telaFormPedido.setVisible(true);
                this.setVisible(false);
                break;
            }
        }
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblListaPedidos.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o pedido que deseja excluir.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(this,
                "Deseja realmente excluir este pedido? Esta operação é irreversível.",
                "Confirmar Deleção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                Long id = Long.valueOf(tblListaPedidos.getValueAt(linha, 0).toString());
                pedidoService.excluir(id);

                JOptionPane.showMessageDialog(this, "Pedido excluído com sucesso!");
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro técnico ao excluir: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    private void formComponentShown(java.awt.event.ComponentEvent evt) {
        atualizarTabela();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaPedidos;
    // End of variables declaration//GEN-END:variables
}
