import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import graphic.PrincipalWindow;
import database.ConnectionFactory;
import database.model.*;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnEntrar;
	private JTextField txfUsuario;
	private JLabel lblUsuario, lblSenha;
	private JPasswordField pwfPassword;
	HashMap<String, Usuario> Usuario;

	public Login() {
		setLayout(null);
		setSize(320, 220);
		setTitle("Login");
		setResizable(false);
		setLocationRelativeTo(null);
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
				if (txfUsuario.getText().isEmpty() && pwfPassword.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Insira o Usuário e a Senha");
				} else if (pwfPassword.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Insira a Senha");
				} else if (txfUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira o Usuário");
				} else {
					// String teste2 = pwfPassword.getText().toString();
					// System.out.println("A senha digitada foi: " + teste2);
					dispose();

					try {
						Connection conn = ConnectionFactory.getConnection("localhost", "5432", "SistemaDBA", "postgres", "manager");

						conn.setAutoCommit(false);

						new PrincipalWindow(conn).setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			}
		});
		btnEntrar.setBounds(90, 140, 120, 25);
		btnEntrar.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btnEntrar);

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel((UIManager.getSystemLookAndFeelClassName()));
					new Login().setVisible(true);
				} catch (ClassNotFoundException ex) {
				} catch (InstantiationException ex) {
				} catch (IllegalAccessException ex) {
				} catch (UnsupportedLookAndFeelException ex) {
				}
			}
		});

	}

}