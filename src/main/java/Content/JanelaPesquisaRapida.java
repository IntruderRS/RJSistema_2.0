package Content;

import Classes.Usuario;
import Classes.Permissao;
import Service.UsuarioService;
import Service.PermissaoService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class JanelaPesquisaRapida extends javax.swing.JPanel {

    private Object objetoSelecionado;
    private String tipoPesquisa;

    public JanelaPesquisaRapida() {
        initComponents();
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });
    }

    public void inicializarPesquisa(String tipoPesquisa) {
        this.tipoPesquisa = tipoPesquisa;
        configurarECarregarTabela();
    }

    public Object getObjetoSelecionado() {
        return this.objetoSelecionado;
    }

    private void configurarECarregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblResultados.getModel();
        modelo.setNumRows(0);

        if ("USUARIO".equalsIgnoreCase(tipoPesquisa)) {
            modelo.setColumnIdentifiers(new String[]{"ID", "Nome", "Login", "Status"});

            UsuarioService uService = new UsuarioService();
            List<Usuario> lista = uService.listarTodos();
            for (Usuario u : lista) {
                modelo.addRow(new Object[]{u.getId(), u.getNome(), u.getLogin(), u.isAtivo() ? "ATIVO" : "INATIVO"});
            }

        } else if ("PERMISSAO".equalsIgnoreCase(tipoPesquisa)) {
            modelo.setColumnIdentifiers(new String[]{"ID", "Identificador Nível", "Descrição"});

            PermissaoService pService = new PermissaoService();
            List<Permissao> lista = pService.listarTodas();
            for (Permissao p : lista) {
                modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getDescricao()});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblResultados);

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelecionar)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelecionar)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        int linha = tblResultados.getSelectedRow();
        if (linha == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha da tabela primeiro.");
            return;
        }

        Long id = Long.valueOf(tblResultados.getValueAt(linha, 0).toString());
        jakarta.persistence.EntityManager em = br.com.sistemarj.rjsistema.persistencia.JPAUtil.getEntityManager();

        if ("USUARIO".equalsIgnoreCase(tipoPesquisa)) {
            this.objetoSelecionado = em.find(Usuario.class, id);
        } else {
            this.objetoSelecionado = em.find(Permissao.class, id);
        }

        em.close();

        // CORREÇÃO DE PAINEL: Oculta o painel disparando o encerramento da JDialog modal
        this.setVisible(false);
    }//GEN-LAST:event_btnSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    // End of variables declaration//GEN-END:variables
}
