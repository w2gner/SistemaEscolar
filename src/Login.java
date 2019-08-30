import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Graphic.AlunoWindow;

public class Login extends JFrame{
	
	private JLabel lblUsuario;
	private JTextField txtLegendaUsuario;
	private JLabel lblSenha;
	private JTextField txtLegendaSenha;
	private JButton btnEntrar;
	
	public Login() {
		setSize(400, 500);
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Login");
		setResizable(false);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(70,200,50,25);
		getContentPane().add(lblUsuario);
		
		txtLegendaUsuario = new JTextField();
		txtLegendaUsuario.setBounds(70, 220,250, 25);
		getContentPane().add(txtLegendaUsuario);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(70,250,50,25);
		getContentPane().add(lblSenha);
		
		txtLegendaSenha = new JTextField();
		txtLegendaSenha.setBounds(70, 270,250, 25);
		getContentPane().add(txtLegendaSenha);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(220, 320, 150, 25);
		getContentPane().add(btnEntrar);
	}

	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}
