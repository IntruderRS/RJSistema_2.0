package Content;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CadastroCategoria extends javax.swing.JPanel {

    private Classes.Categoria categoriaAtual;
    
    private TableRowSorter<TableModel> sorter;

    public CadastroCategoria() {
        initComponents();
        atualizarTabela();

        TableModel modelo = tblCategorias.getModel();
        sorter = new TableRowSorter<>(modelo);
        tblCategorias.setRowSorter(sorter);
    }

    private void limparCampos() {
         txtID.setText("");
    txtCategoria.setText("");
    
    // ESTA LINHA TIRA O FILTRO E MOSTRA TUDO DE NOVO
    if (sorter != null) {
        sorter.setRowFilter(null);
    }

    categoriaAtual = null;
    txtCategoria.requestFocus();
    }

    public void prepararEdicao(Classes.Categoria c) {
        this.categoriaAtual = c;
        txtID.setText(String.valueOf(c.getId()));
        txtCategoria.setText(c.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();

        setForeground(new java.awt.Color(205, 205, 205));

        jLabel1.setText("ID:");

        txtID.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO DE CATEGORIA");

        jLabel4.setText("Categoria:");

        txtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoriaKeyReleased(evt);
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
                .addGap(194, 194, 194)
                .addComponent(btnLimpar)
                .addGap(117, 117, 117)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tblCategorias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(559, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            // 1. Verifica se é novo ou edição
            if (categoriaAtual == null) {
                categoriaAtual = new Classes.Categoria();
            }

            // 2. Validação simples: não deixa salvar vazio
            if (txtCategoria.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe o nome da categoria!");
                return;
            }

            // 3. Pega o nome do campo
            categoriaAtual.setNome(txtCategoria.getText());

            // 4. Chama o DAO para salvar
            Classes.CategoriaDAO dao = new Classes.CategoriaDAO();
            dao.salvar(categoriaAtual);

            JOptionPane.showMessageDialog(this, "Categoria salva com sucesso!");

            // 5. Limpa e reseta
            limparCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar categoria: " + e.getMessage());
            e.printStackTrace();
        }
        limparCampos();
        atualizarTabela();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoriaKeyReleased
        String texto = txtCategoria.getText();
    
    if (texto.trim().length() == 0) {
        sorter.setRowFilter(null); // Mostra tudo se estiver vazio
    } else {
        // O "(?i)" faz a busca ignorar maiúsculas e minúsculas
        // O índice 1 refere-se à coluna "Nome" (0=ID, 1=Nome)
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1));
    }
    }//GEN-LAST:event_txtCategoriaKeyReleased

    private void tblCategoriasMouseClicked(java.awt.event.MouseEvent evt) {
        // 1. Descobrir qual linha foi clicada
        int linha = tblCategorias.getSelectedRow();

        if (linha != -1) {
            // 2. Pegar o ID da primeira coluna (índice 0)
            Long id = Long.valueOf(tblCategorias.getValueAt(linha, 0).toString());

            // 3. Buscar a categoria completa no banco para garantir os dados
            Classes.CategoriaDAO dao = new Classes.CategoriaDAO();
            Classes.Categoria selecionada = dao.buscarPorId(id);

            if (selecionada != null) {
                // 4. Preencher os campos da tela (txtID e txtCategoria)
                prepararEdicao(selecionada);
            }
        }
    }

    public void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblCategorias.getModel();
        modelo.setNumRows(0); // Limpa para não duplicar

        Classes.CategoriaDAO dao = new Classes.CategoriaDAO();
        List<Classes.Categoria> lista = dao.listarTodos();

        for (Classes.Categoria c : lista) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
