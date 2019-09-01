import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import graphic.PrincipalWindow;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblUsuario, lblSenha;
	private JTextField txfSenha, txfUsuario;
	private JButton btnEntrar;

	public Login() {
		setLayout(null);
		setSize(320, 220);
		setTitle("Login");
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

		lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(40, 20, 50, 25);
		getContentPane().add(lblUsuario);

		txfUsuario = new JTextField();
		txfUsuario.setBounds(40, 40, 227, 25);
		getContentPane().add(txfUsuario);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(40, 80, 50, 25);
		getContentPane().add(lblSenha);

		txfSenha = new JTextField();
		txfSenha.setBounds(40, 100, 227, 25);
		getContentPane().add(txfSenha);

		btnEntrar = new JButton(new AbstractAction("Entrar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txfUsuario.getText().isEmpty() && txfSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira o Usuário e a Senha");
				} else if (txfSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira a Senha");
				} else if (txfUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira o Usuário");
				} else {
					dispose();
					new PrincipalWindow().setVisible(true);
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
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException ex) {
				} catch (InstantiationException ex) {
				} catch (IllegalAccessException ex) {
				} catch (UnsupportedLookAndFeelException ex) {
				}
			}
		});

		new Login().setVisible(true);

	}
}
