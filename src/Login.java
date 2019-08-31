import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Graphic.PrincipalWindow;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblUsuario, lblSenha;
	private JTextField txfSenha, txfUsuario;
	private JButton btnEntrar;

	public Login() {
		setSize(320, 250);
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Login");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));

		lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(20, 30, 50, 25);
		getContentPane().add(lblUsuario);

		txfUsuario = new JTextField();
		txfUsuario.setBounds(20, 50, 250, 25);
		getContentPane().add(txfUsuario);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(20, 100, 50, 25);
		getContentPane().add(lblSenha);

		txfSenha = new JTextField();
		txfSenha.setBounds(20, 120, 250, 25);
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
		btnEntrar.setBounds(70, 170, 160, 25);
		getContentPane().add(btnEntrar);

	}

	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}
