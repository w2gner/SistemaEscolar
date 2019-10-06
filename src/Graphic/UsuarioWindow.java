package graphic;

import database.dao.UsuarioDAO;
import database.model.Usuario;
import lib.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioWindow extends JFrame implements Observer {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> cbxPerfil;
    private JTextField txfUsuario, txfSenha;
    private JLabel lblUsuario, lblSenha, lblPerfil, lblimagemcurso;
    private JButton btnNovo, btnRemover, btnSalvar, btnPesquisar;
    private UsuarioDAO io_usuario_dao;
    private final ImageIcon alertIcon = new ImageIcon("icons/alerta.png");
    private Object selectedObject = null;

    UsuarioWindow(final Connection connection) {
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(" Cadastro de Usuário");
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblimagemcurso = new JLabel(new ImageIcon("icons/usuários.png"));
        lblimagemcurso.setBounds(450, 20, 256, 256);
        getContentPane().add(lblimagemcurso);

        lblUsuario = new JLabel("Usuário");
        lblUsuario.setBounds(50, 70, 50, 25);
        getContentPane().add(lblUsuario);

        lblSenha = new JLabel("Senha");
        lblSenha.setBounds(50, 135, 50, 25);
        getContentPane().add(lblSenha);

        lblPerfil = new JLabel("Perfil");
        lblPerfil.setBounds(50, 200, 30, 25);
        getContentPane().add(lblPerfil);

        txfUsuario = new JTextField();
        txfUsuario.setBounds(110, 70, 300, 25);
        getContentPane().add(txfUsuario);

        txfSenha = new JPasswordField();
        txfSenha.setBounds(110, 135, 300, 25);
        getContentPane().add(txfSenha);

        cbxPerfil = new JComboBox<String>();
        cbxPerfil.setBounds(110, 200, 300, 25);
        getContentPane().add(cbxPerfil);
        cbxPerfil.addItem("Administrador");
        cbxPerfil.addItem("Convidado");

        btnNovo = new JButton(new AbstractAction("Novo") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                LimpaTela();
                selectedObject = null;
                setTitle(" Cadastro de Usuário");
            }
        });
        btnNovo.setBounds(500, 310, 115, 25);
        getContentPane().add(btnNovo);

        btnRemover = new JButton(new AbstractAction("Excluir") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    if (selectedObject == null) {
                        JOptionPane.showMessageDialog(null, "Nenhum usuário selecionado",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else {
                        UsuarioDAO usuarioIO = new UsuarioDAO(connection);
                        int opc = JOptionPane.showConfirmDialog(null, "Você tem certeza que " +
                                        "deseja exluir", "Apagar aluno", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE, alertIcon);
                        if (opc == 0) {
                            LimpaTela();
                            usuarioIO.Delete(selectedObject);
                            setTitle(" Cadastro de Usuário");
                            selectedObject = null;
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        btnRemover.setBounds(250, 310, 115, 25);
        getContentPane().add(btnRemover);

        try {
            btnSalvar = new JButton(new AbstractAction("Salvar") {

                private static final long serialVersionUID = 1L;
                private UsuarioDAO usuarioIO = new UsuarioDAO(connection);
                private List<Object> usuarios = new ArrayList<Object>();
                private Boolean isUpdate = false;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (txfUsuario.getText().isEmpty() && txfSenha.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Insira as informações do usuário",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else if (txfUsuario.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nome do usuário requerido",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else if (txfSenha.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Senha do usuário requerida",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else {
                        try {
                            Usuario usuario = new Usuario();
                            usuario.setNome(txfUsuario.getText());
                            usuario.setSenha(txfSenha.getText());
                            if (cbxPerfil.getSelectedItem().equals("Administrador")) {
                                usuario.setIs_Admin(true);
                            } else {
                                usuario.setIs_Admin(false);
                            }

                            io_usuario_dao = new UsuarioDAO(connection);
                            usuarios = io_usuario_dao.Select(null);
                            Usuario usuarioSelecionado = (Usuario) selectedObject;

                            for (Object o : usuarios) {
                                Usuario teste = (Usuario) o;
                                if (selectedObject != null) {
                                    if (teste.getID() == usuarioSelecionado.getID()) {
                                        usuario.setID(teste.getID());
                                        usuarioIO.Update(usuario);
                                        isUpdate = true;
                                    }
                                }
                            }

                            if (!isUpdate) {
                                usuarioIO.Insert(usuario);
                                JOptionPane.showMessageDialog(null, "Usuário salvo com " +
                                        "sucesso", "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuário atualizado com " +
                                        "sucesso", "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                                isUpdate = false;
                            }

                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                    }

                }
            });
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        btnSalvar.setBounds(125, 310, 115, 25);
        getContentPane().add(btnSalvar);

        btnPesquisar = new JButton(new AbstractAction("Pesquisar") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisar(connection);

            }
        });
        btnPesquisar.setBounds(375, 310, 115, 25);
        getContentPane().add(btnPesquisar);

    }

    public void pesquisar(Connection connection) {
        //
        // Define as colunas da tabela de pesquisa
        //
        String[] la_colunas = {"Admin", "Aluno"};

        //
        // Define as classes das colunas
        //
        Class<?>[] la_classes = {Integer.class, String.class};

        //
        // Define as larguras das colunas da tabela de pesquisa
        //
        int[] la_larguras = {55, 400};

        //
        // Cria a janela de busca
        //
        PesquisaWindow lo_pesquisa = new PesquisaWindow(io_usuario_dao, la_colunas, la_classes, la_larguras,
                this, connection);
        lo_pesquisa.setVisible(true);

        try {
            selectedObject = lo_pesquisa.getObjetoSelecionado();
            setTitle(" Editando usuário: " + ((Usuario) selectedObject).getNome());
        } catch (Exception ignored) {
            selectedObject = null;
        }

    }

    public void LimpaTela() {
        txfSenha.setText("");
        txfUsuario.setText("");
        cbxPerfil.setSelectedIndex(0);
    }

    @Override
    public void update(Object arg) {

        try {
            Usuario usuario = (Usuario) arg;

            txfSenha.setText(usuario.getSenha());
            txfUsuario.setText(usuario.getNome());

            if (usuario.getIs_Admin()) {
                cbxPerfil.setSelectedItem(0);
            } else {
                cbxPerfil.setSelectedItem(1);
            }
        } catch (Exception e) {
        }

    }

}
