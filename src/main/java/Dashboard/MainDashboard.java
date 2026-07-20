package Dashboard;

//import Classes.*;
import Content.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainDashboard extends javax.swing.JFrame {
    
    public static Content.ListaClientes telaListaClientes;

    TelaHome a = new TelaHome();
    TelaPedidos b = new TelaPedidos();
    CadastrosFornecedores c = new CadastrosFornecedores();
    CadastroProdutos d = new CadastroProdutos();
    CadastroClientes e = new CadastroClientes();
    ListaFornecedores f = new ListaFornecedores();
    ListaProdutos g = new ListaProdutos();
    ListaClientes h = new ListaClientes();
    CadastroCategoria i = new CadastroCategoria();
    ListaPedidos j = new ListaPedidos();
    Usuarios k = new Usuarios();
    Permissoes l = new Permissoes();

    public class MyForm extends javax.swing.JFrame {

        // Lista para armazenar os botões
        private List<javax.swing.JButton> botoes = new ArrayList<>();
        private int yPos = 50; // Posição Y inicial

        public MyForm() {
            initComponents();
            inicializarBotoes();
        }

        private void inicializarBotoes() {
            botoes.add(btnFornecedores);
            botoes.add(btnProdutos);
            botoes.add(btnClientes);

            // Esconde ou joga para fora da tela inicialmente
            for (javax.swing.JButton btn : botoes) {
                btn.setLocation(-100, btn.getY());
            }
        }

        // Ação do botão que inicia a cascata
        private void iniciarCascata() {
            final int delay = 100; // milissegundos entre cada botão
            final int finalX = 50; // posição final X

            for (int i = 0; i < botoes.size(); i++) {
                final javax.swing.JButton btn = botoes.get(i);
                final int index = i;

                // Timer para cada botão com atraso acumulado
                Timer timer = new Timer(delay * index, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Simples animação de deslizar
                        new Thread(() -> {
                            for (int pos = -100; pos <= finalX; pos += 10) {
                                btn.setLocation(pos, btn.getY());
                                try {
                                    Thread.sleep(10);
                                } catch (Exception ex) {
                                }
                            }
                        }).start();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    public MainDashboard() {
        initComponents();
        this.pack();
        telaListaClientes = h; 
        telaCadastro = e; //puxa a tela CadastroClientes a partir da tela ListaClientes
        telaCadFornecedor = c;
        telaListaFornecedor = f;//puxa a tela CadastroFornecedor a partir da tela ListaFornecedor
        telaCadProduto = d;
        telaListaProduto = g;
        

        java.awt.Color corHover = new java.awt.Color(51, 51, 51); // Cinza Escuro
        java.awt.Color corPadrao = new java.awt.Color(30, 101, 165); // Volta cor normal

        //Lista dos botões:
        configurarEfeitoBotao(btnPedidos, corHover, corPadrao);
        configurarEfeitoBotao(btnCategoria, corHover, corPadrao);
        configurarEfeitoBotao(btnClientes, corHover, corPadrao);
        configurarEfeitoBotao(btnFornecedores, corHover, corPadrao);
        //configurarEfeitoBotao(btnHome, corHover, corPadrao);
        configurarEfeitoBotao(btnPermissoes, corHover, corPadrao);
        configurarEfeitoBotao(btnProdutos, corHover, corPadrao);
        configurarEfeitoBotao(btnUsuarios, corHover, corPadrao);
        configurarEfeitoBotao(btnListaClientes, corHover, corPadrao);
        configurarEfeitoBotao(btnListaFornecedores, corHover, corPadrao);
        configurarEfeitoBotao(btnListaPedidos, corHover, corPadrao);
        configurarEfeitoBotao(btnListaProdutos, corHover, corPadrao);

        main.add(a);
        main.add(b);
        main.add(c);
        main.add(d);
        main.add(e);
        main.add(f);
        main.add(g);
        main.add(h);
        main.add(i);
        main.add(j);
        main.add(k);
        main.add(l);

        a.setVisible(true);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        btnFornecedores = new javax.swing.JButton();
        btnProdutos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CADASTROS = new javax.swing.JLabel();
        CADASTROS1 = new javax.swing.JLabel();
        btnListaFornecedores = new javax.swing.JButton();
        btnListaProdutos = new javax.swing.JButton();
        btnListaClientes = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();
        btnListaPedidos = new javax.swing.JButton();
        CADASTROS2 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnPermissoes = new javax.swing.JButton();
        main = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RJSistemas");
        setName("RJSistemas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 800));

        jPanel2.setBackground(new java.awt.Color(30, 101, 165));
        jPanel2.setForeground(new java.awt.Color(35, 43, 49));
        jPanel2.setPreferredSize(new java.awt.Dimension(180, 551));

        btnHome.setBackground(new java.awt.Color(21, 44, 95));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("HOME");
        btnHome.setBorderPainted(false);
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnPedidos.setBackground(new java.awt.Color(30, 101, 165));
        btnPedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPedidos.setForeground(new java.awt.Color(255, 255, 255));
        btnPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PedidosPEQ.png"))); // NOI18N
        btnPedidos.setText("Pedidos");
        btnPedidos.setBorderPainted(false);
        btnPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        btnFornecedores.setBackground(new java.awt.Color(30, 101, 165));
        btnFornecedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFornecedores.setForeground(new java.awt.Color(255, 255, 255));
        btnFornecedores.setText("Fornecedores");
        btnFornecedores.setBorderPainted(false);
        btnFornecedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedoresActionPerformed(evt);
            }
        });

        btnProdutos.setBackground(new java.awt.Color(30, 101, 165));
        btnProdutos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProdutos.setForeground(new java.awt.Color(255, 255, 255));
        btnProdutos.setText("Produtos");
        btnProdutos.setBorderPainted(false);
        btnProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(30, 101, 165));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setText("Clientes");
        btnClientes.setBorderPainted(false);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU DE NAVEGAÇÃO");

        CADASTROS.setBackground(new java.awt.Color(153, 153, 153));
        CADASTROS.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CADASTROS.setForeground(new java.awt.Color(0, 0, 0));
        CADASTROS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CADASTROS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadastroPEQ.png"))); // NOI18N
        CADASTROS.setText("Cadastros");

        CADASTROS1.setBackground(new java.awt.Color(153, 153, 153));
        CADASTROS1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CADASTROS1.setForeground(new java.awt.Color(0, 0, 0));
        CADASTROS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CADASTROS1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RelatorioPEQ2.png"))); // NOI18N
        CADASTROS1.setText("Relatórios");

        btnListaFornecedores.setBackground(new java.awt.Color(30, 101, 165));
        btnListaFornecedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnListaFornecedores.setForeground(new java.awt.Color(255, 255, 255));
        btnListaFornecedores.setText("Lista Fornecedores");
        btnListaFornecedores.setBorderPainted(false);
        btnListaFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaFornecedoresActionPerformed(evt);
            }
        });

        btnListaProdutos.setBackground(new java.awt.Color(30, 101, 165));
        btnListaProdutos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnListaProdutos.setForeground(new java.awt.Color(255, 255, 255));
        btnListaProdutos.setText("Lista Produtos");
        btnListaProdutos.setBorderPainted(false);
        btnListaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaProdutosActionPerformed(evt);
            }
        });

        btnListaClientes.setBackground(new java.awt.Color(30, 101, 165));
        btnListaClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnListaClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnListaClientes.setText("Lista Clientes");
        btnListaClientes.setBorderPainted(false);
        btnListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaClientesActionPerformed(evt);
            }
        });

        btnCategoria.setBackground(new java.awt.Color(30, 101, 165));
        btnCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria.setText("Categoria");
        btnCategoria.setBorderPainted(false);
        btnCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnListaPedidos.setBackground(new java.awt.Color(30, 101, 165));
        btnListaPedidos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnListaPedidos.setForeground(new java.awt.Color(255, 255, 255));
        btnListaPedidos.setText("Lista Pedidos");
        btnListaPedidos.setBorderPainted(false);
        btnListaPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaPedidosActionPerformed(evt);
            }
        });

        CADASTROS2.setBackground(new java.awt.Color(153, 153, 153));
        CADASTROS2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CADASTROS2.setForeground(new java.awt.Color(0, 0, 0));
        CADASTROS2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CADASTROS2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/AdminPEQ.png"))); // NOI18N
        CADASTROS2.setText("Administração");

        btnUsuarios.setBackground(new java.awt.Color(30, 101, 165));
        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setText("Usuários");
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnPermissoes.setBackground(new java.awt.Color(30, 101, 165));
        btnPermissoes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPermissoes.setForeground(new java.awt.Color(255, 255, 255));
        btnPermissoes.setText("Permissões");
        btnPermissoes.setBorderPainted(false);
        btnPermissoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermissoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CADASTROS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CADASTROS1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnListaFornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnListaProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnListaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnListaPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CADASTROS2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPermissoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CADASTROS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFornecedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CADASTROS1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaFornecedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CADASTROS2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPermissoes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPedidos.getAccessibleContext().setAccessibleDescription("Lançar Pedido");

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        main.setForeground(new java.awt.Color(205, 205, 205));
        main.setLayout(new java.awt.CardLayout());
        getContentPane().add(main, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Transforme a variável 'e' em static para acessá-la de fora
    public static Content.CadastroClientes telaCadastro;
    public static Content.ListaClientes telaLista;
    public static Content.CadastrosFornecedores telaCadFornecedor;
    public static Content.ListaFornecedores telaListaFornecedor;
    public static Content.CadastroProdutos telaCadProduto;
    public static Content.ListaProdutos telaListaProduto;

    public static void mostrarListaProdutos() {
        telaCadProduto.setVisible(false);
        telaListaProduto.setVisible(true);
        telaListaProduto.atualizarTabela();
    }

    public static void exibirEdicaoProduto(Classes.Produto produto) {
         //1. Esconde a lista (letra g)
        telaListaProduto.setVisible(false);

        // 2. Prepara os dados na tela de cadastro (letra d)
        telaCadProduto.prepararEdicao(produto);

        // 3. Mostra o cadastro
        telaCadProduto.setVisible(true);
    }

    //trecho pra esconder a tela CadastroClientes e mostrar a tela ListaClientes 
    public static void mostrarLista() {
        // Esconde a tela de cadastro
        telaCadastro.setVisible(false);

        // Mostra a tela de lista
        telaLista.setVisible(true);

        // Opcional: Força a atualização da tabela ao abrir
        telaLista.atualizarTabela();
    }

// Crie este método para ser chamado pela Lista
    public static void exibirEdicao(Classes.Cliente cliente) {
        // 1. Esconde todas as outras (ou chama seu método de limpar tela)
        // Ex: esconderTodas(); 

        // 2. Preenche os dados na tela que já existe
        telaCadastro.prepararEdicao(cliente);

        // 3. Mostra apenas ela
        telaCadastro.setVisible(true);

    }

    public static void mostrarListaFornecedores() {
        // 1. Esconde o cadastro de fornecedores (letra c)
        telaCadFornecedor.setVisible(false);

        // 2. Mostra a lista de fornecedores (letra f)
        telaListaFornecedor.setVisible(true);

        // 3. Força a atualização dos dados na tabela
        telaListaFornecedor.atualizarTabela();
    }

    public static void exibirEdicaoFornecedor(Classes.Fornecedor fornecedor) {
        // 1. Esconde todas as outras (ou chama seu método de limpar tela)
        // Ex: esconderTodas(); 

        // 2. Preenche os dados na tela que já existe
        telaCadFornecedor.prepararEdicao(fornecedor);

        // 3. Mostra apenas ela
        telaCadFornecedor.setVisible(true);
    }

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        a.setVisible(true);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        a.setVisible(false);
        b.setVisible(true);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedoresActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(true);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnFornecedoresActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(true);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnProdutosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(true);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnListaFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaFornecedoresActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(true);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnListaFornecedoresActionPerformed

    private void btnListaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaProdutosActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(true);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnListaProdutosActionPerformed

    private void btnListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaClientesActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(true);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnListaClientesActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(true);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnListaPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaPedidosActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(true);
        k.setVisible(false);
        l.setVisible(false);
    }//GEN-LAST:event_btnListaPedidosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(true);
        l.setVisible(false);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnPermissoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermissoesActionPerformed
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        d.setVisible(false);
        e.setVisible(false);
        f.setVisible(false);
        g.setVisible(false);
        h.setVisible(false);
        i.setVisible(false);
        j.setVisible(false);
        k.setVisible(false);
        l.setVisible(true);
    }//GEN-LAST:event_btnPermissoesActionPerformed

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        btnHome.setBackground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        btnHome.setBackground(new java.awt.Color(30, 101, 165));
    }//GEN-LAST:event_btnHomeMouseExited

    public static void mostrarListaClientes() {
    // 1. Esconde a tela de cadastro (que é a letra e)
    telaCadastro.setVisible(false); 
    
    // 2. Mostra a lista de clientes (letra h)
    if (telaListaClientes != null) {
        telaListaClientes.setVisible(true);
        telaListaClientes.atualizarTabela(); // Garante que os dados apareçam
    } else {
        System.out.println("Erro: telaListaClientes não foi inicializada!");
    }
}
    
    private void configurarEfeitoBotao(javax.swing.JComponent componente, java.awt.Color corEntrada, java.awt.Color corSaida) {
        componente.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                componente.setBackground(corEntrada);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                componente.setBackground(corSaida);
            }
        });
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            MainDashboard frame = new MainDashboard();
            frame.setVisible(true); // Garante que o JFrame principal apareça
            frame.setLocationRelativeTo(null); // Centraliza na tela
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CADASTROS;
    private javax.swing.JLabel CADASTROS1;
    private javax.swing.JLabel CADASTROS2;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnFornecedores;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnListaClientes;
    private javax.swing.JButton btnListaFornecedores;
    private javax.swing.JButton btnListaPedidos;
    private javax.swing.JButton btnListaProdutos;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnPermissoes;
    private javax.swing.JButton btnProdutos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLayeredPane main;
    // End of variables declaration//GEN-END:variables
}
