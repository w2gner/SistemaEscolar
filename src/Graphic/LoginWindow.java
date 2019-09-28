package graphic;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import graphic.PrincipalWindow;
import database.dao.UsuarioDAO;
import database.model.*;

public class LoginWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnEntrar;
	private JTextField txfUsuario;
	private JLabel lblUsuario, lblSenha;
	private JPasswordField pwfPassword;
	HashMap<String, Usuario> Usuario;

	public LoginWindow(final Connection connection) {
		setLayout(null);
		setSize(320, 220);
		setTitle("Login");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

		Action enterClick = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				btnEntrar.doClick();
			}
		};

		lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(40, 20, 50, 25);
		getContentPane().add(lblUsuario);

		txfUsuario = new JTextField();
		txfUsuario.setBounds(40, 40, 227, 25);
		txfUsuario.addActionListener(enterClick);
		getContentPane().add(txfUsuario);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(40, 80, 50, 25);
		getContentPane().add(lblSenha);

		pwfPassword = new JPasswordField();
		pwfPassword.setBounds(40, 100, 227, 25);
		pwfPassword.addActionListener(enterClick);
		getContentPane().add(pwfPassword);

		btnEntrar = new JButton(new AbstractAction("Entrar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				String senha = pwfPassword.getText().toString();
				String usuario = txfUsuario.getText().toString();
				List<Object> Usuarios = new ArrayList<Object>();
				Boolean LoginSuccessfull = false;

				try {
					UsuarioDAO user = new UsuarioDAO(connection);
					Usuarios = user.Select(null);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				if (txfUsuario.getText().isEmpty() && pwfPassword.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Insira o Usuário e a Senha");
				} else if (pwfPassword.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Insira a Senha");
				} else if (txfUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira o Usuário");
				} else {
					for (int i = 0; i < Usuarios.size(); i++) {
						Usuario teste = (Usuario) Usuarios.get(i);
						if (teste.getNome().equals(usuario) && teste.getSenha().equals(senha)) {
							dispose();
							new PrincipalWindow(connection).setVisible(true);
							LoginSuccessfull = true;
							break;
						}
					}
					if (!LoginSuccessfull) {
						JOptionPane.showMessageDialog(null, "Verifique se o Usuário ou senha estão corretos");
					}
				}
			}
		});
		btnEntrar.setBounds(90, 140, 120, 25);
		btnEntrar.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnEntrar);

	}

}
