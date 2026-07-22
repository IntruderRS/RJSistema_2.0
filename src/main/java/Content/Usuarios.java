package Content;

import Classes.Usuario;
import Classes.Permissao;
import Service.UsuarioService;
import javax.swing.JOptionPane;

public class Usuarios extends javax.swing.JPanel {

    private final UsuarioService usuarioService = new UsuarioService();
    private Usuario usuarioAtual;

    public Usuarios() {
        initComponents();
        configurarLimpezaAutomaticaAoClicar();
    }

    private void configurarLimpezaAutomaticaAoClicar() {
        java.awt.event.FocusAdapter ouvinteSenha = new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                javax.swing.JPasswordField campo = (javax.swing.JPasswordField) evt.getSource();
                // Limpa o campo automaticamente ao ganhar o foco para o usuário não ter que apagar os asteriscos
                campo.setText("");
            }
        };

        // Vincula o comportamento nos dois campos de senha do formulário
        txtSenha.addFocusListener(ouvinteSenha);
        txtSenhaRepetida.addFocusListener(ouvinteSenha);
    }

    private void limparCampos() {
        txtID.setText("");
        txtCategoria.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtSenhaRepetida.setText("");

        txtSenha.setEchoChar('*');
        txtSenhaRepetida.setEchoChar('*');
        if (chkMostrarSenha != null) {
            chkMostrarSenha.setSelected(false);
        }

        if (jComboBox1 != null) {
            jComboBox1.setSelectedIndex(-1);
        }

        chkCadastros.setSelected(false);
        chkRelatorios.setSelected(false);
        chkPedidos.setSelected(false);
        chkUsuarios.setSelected(false);

        this.usuarioAtual = new Classes.Usuario();
        txtCategoria.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        chkCadastros = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        chkRelatorios = new javax.swing.JCheckBox();
        chkPedidos = new javax.swing.JCheckBox();
        chkUsuarios = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        txtSenhaRepetida = new javax.swing.JPasswordField();
        chkMostrarSenha = new javax.swing.JCheckBox();

        setForeground(new java.awt.Color(205, 205, 205));

        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO USUÁRIOS");

        jLabel4.setText("Nome:");

        jLabel3.setText("Tipo:");

        jLabel5.setText("Login:");

        jLabel6.setText("Senha:");

        jLabel7.setText("Senha Novamente:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor", "Escritório", "Almoxarifado" }));

        chkCadastros.setText("Cadastros");

        jLabel8.setText("Permissão:");

        chkRelatorios.setText("Relatórios");

        chkPedidos.setText("Pedidos");

        chkUsuarios.setText("Usuarios");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
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
                .addGap(78, 78, 78)
                .addComponent(btnPesquisar)
                .addGap(125, 125, 125)
                .addComponent(btnLimpar)
                .addGap(117, 117, 117)
                .addComponent(btnSalvar)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(btnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSenha.setText("jPasswordField1");

        txtSenhaRepetida.setText("jPasswordField1");

        chkMostrarSenha.setText("Mostrar Senha");
        chkMostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(chkCadastros)
                        .addGap(31, 31, 31)
                        .addComponent(chkRelatorios)
                        .addGap(26, 26, 26)
                        .addComponent(chkPedidos)
                        .addGap(36, 36, 36)
                        .addComponent(chkUsuarios))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSenhaRepetida)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(chkMostrarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 50, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(chkCadastros)
                    .addComponent(chkRelatorios)
                    .addComponent(chkPedidos)
                    .addComponent(chkUsuarios))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenhaRepetida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMostrarSenha))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(421, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            // Garante que se for um cadastro novo, o objeto não carregue chaves primárias nulas
            if (this.usuarioAtual == null || this.usuarioAtual.getId() != null) {
                this.usuarioAtual = new Classes.Usuario();
            }

            // Coleta o texto digitado exatamente do campo txtCategoria da sua tela Swing
            String nomeDigitado = txtCategoria.getText().trim();
            this.usuarioAtual.setNome(nomeDigitado);
            this.usuarioAtual.setLogin(txtLogin.getText().trim());
            this.usuarioAtual.setSenha(txtSenha.getText());
            this.usuarioAtual.setAtivo(true);

            if (jComboBox1.getSelectedItem() != null) {
                this.usuarioAtual.setTipo(jComboBox1.getSelectedItem().toString());
            }

            this.usuarioAtual.getPermissoes().clear();

            if (chkCadastros.isSelected()) {
                this.usuarioAtual.adicionarPermissao(new Classes.Permissao("ROLE_CADASTROS", "Acesso Cadastros"));
            }
            if (chkRelatorios.isSelected()) {
                this.usuarioAtual.adicionarPermissao(new Classes.Permissao("ROLE_RELATORIOS", "Acesso Relatórios"));
            }
            if (chkPedidos.isSelected()) {
                this.usuarioAtual.adicionarPermissao(new Classes.Permissao("ROLE_PEDIDOS", "Acesso Pedidos"));
            }
            if (chkUsuarios.isSelected()) {
                this.usuarioAtual.adicionarPermissao(new Classes.Permissao("ROLE_ADMIN", "Acesso Usuários"));
            }

            String confSenha = txtSenhaRepetida.getText();

            // Envia para o Service processar a persistência ORM (SOLID)
            usuarioService.registrarUsuario(this.usuarioAtual, confSenha);

            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso no ecossistema seguro!");
            limparCampos();

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Validação", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro operacional ao persistir usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        java.awt.Window janelaPai = javax.swing.SwingUtilities.getWindowAncestor(this);

        // 2. Instancia a janela flutuante nativa do Swing travando o fundo (Modal)
        javax.swing.JDialog janelaModal = new javax.swing.JDialog(janelaPai, "Pesquisa de Usuários do Sistema", java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        // 3. CORREÇÃO DO CONSTRUTOR: Instancia a sua classe de Design sem argumentos, cumprindo o requisito
        Content.JanelaPesquisaRapida painelBusca = new Content.JanelaPesquisaRapida();

        // Inicializa a lógica de negócio do grid de dados informando o escopo
        painelBusca.inicializarPesquisa("USUARIO");

        // 4. Acopla o painel dentro da janela e define a geometria gráfica
        janelaModal.add(painelBusca);
        janelaModal.pack();
        janelaModal.setLocationRelativeTo(janelaPai);

        // CORREÇÃO DO SYMBOL: Aplica a prioridade de foco na janelaModal e NÃO no painel
        janelaModal.setAlwaysOnTop(true);

        // Monitora o fechamento: quando o usuário clica em Confirmar, o painel roda setVisible(false) e fecha a modal
        painelBusca.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentHidden(java.awt.event.ComponentEvent e) {
                janelaModal.dispose();
            }
        });

        // Exibe o pop-up na tela travando o faturamento do formulário até a escolha
        janelaModal.setVisible(true);

        // 5. Coleta o usuário selecionado no grid de forma limpa e segura (SOLID)
        Classes.Usuario usuarioEscolhido = (Classes.Usuario) painelBusca.getObjetoSelecionado();
        if (usuarioEscolhido != null) {
            this.usuarioAtual = usuarioEscolhido;

            txtID.setText(String.valueOf(usuarioEscolhido.getId()));
            txtCategoria.setText(usuarioEscolhido.getNome());
            txtLogin.setText(usuarioEscolhido.getLogin());
            txtSenha.setText(usuarioEscolhido.getSenha());
            txtSenhaRepetida.setText(usuarioEscolhido.getSenha());

            if (usuarioEscolhido.getTipo() != null && jComboBox1 != null) {
                jComboBox1.setSelectedItem(usuarioEscolhido.getTipo());
            }

            chkCadastros.setSelected(false);
            chkRelatorios.setSelected(false);
            chkPedidos.setSelected(false);
            chkUsuarios.setSelected(false);

            for (Classes.Permissao perm : usuarioEscolhido.getPermissoes()) {
                if ("ROLE_CADASTROS".equals(perm.getNome())) {
                    chkCadastros.setSelected(true);
                }
                if ("ROLE_RELATORIOS".equals(perm.getNome())) {
                    chkRelatorios.setSelected(true);
                }
                if ("ROLE_PEDIDOS".equals(perm.getNome())) {
                    chkPedidos.setSelected(true);
                }
                if ("ROLE_ADMIN".equals(perm.getNome())) {
                    chkUsuarios.setSelected(true);
                }
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void chkMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarSenhaActionPerformed
        if (chkMostrarSenha.isSelected()) {
            // Remove os asteriscos e exibe o texto puro
            txtSenha.setEchoChar((char) 0);
            txtSenhaRepetida.setEchoChar((char) 0);
        } else {
            // Restaura a máscara padrão de asteriscos/pontos do Swing
            txtSenha.setEchoChar('*');
            txtSenhaRepetida.setEchoChar('*');
        }
    }//GEN-LAST:event_chkMostrarSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkCadastros;
    private javax.swing.JCheckBox chkMostrarSenha;
    private javax.swing.JCheckBox chkPedidos;
    private javax.swing.JCheckBox chkRelatorios;
    private javax.swing.JCheckBox chkUsuarios;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaRepetida;
    // End of variables declaration//GEN-END:variables
}
