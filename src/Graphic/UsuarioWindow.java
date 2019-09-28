package graphic;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UsuarioWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> cbxPerfil;
    private JTextField txfUsuario;
    private JPasswordField pwfSenha;
    private JLabel lblUsuario, lblSenha, lblPerfil;
    private JButton btnAdicionar, btnRemover, btnSalvar;

    public UsuarioWindow() {
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(" Cadastro de Usuário");
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblUsuario = new JLabel("Usuário");
        lblUsuario.setBounds(50, 35, 50, 25);
        getContentPane().add(lblUsuario);

        lblSenha = new JLabel("Senha");
        lblSenha.setBounds(50, 70, 50, 25);
        getContentPane().add(lblSenha);

        lblPerfil = new JLabel("Perfil");
        lblPerfil.setBounds(50, 105, 30, 25);
        getContentPane().add(lblPerfil);

        txfUsuario = new JTextField();
        txfUsuario.setBounds(110, 35, 300, 25);
        getContentPane().add(txfUsuario);

        pwfSenha = new JPasswordField();
        pwfSenha.setBounds(110, 70, 300, 25);
        getContentPane().add(pwfSenha);

        cbxPerfil = new JComboBox<String>();
        cbxPerfil.setBounds(110, 105, 300, 25);
        getContentPane().add(cbxPerfil);
        cbxPerfil.addItem("Administrador");
        cbxPerfil.addItem("Convidado");

        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(200, 310, 100, 25);
        getContentPane().add(btnAdicionar);

        btnRemover = new JButton("Remover");
        btnRemover.setBounds(320, 310, 100, 25);
        getContentPane().add(btnRemover);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(440, 310, 100, 25);
        getContentPane().add(btnSalvar);

    }

}
