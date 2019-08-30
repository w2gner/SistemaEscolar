package Graphic;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlunoWindow extends JFrame {

	
	private JLabel lblSexo;
	private JTextField txtLegendaSexo;
	private JLabel lblMatricula;
	private JTextField txtLegendaMat;
	private JPanel pnltest;
	private JLabel lblAluno;
	private JLabel lblNasc;
	private JTextField txtLegendaNasc;
	private JTextField txtLegenda;
	private JLabel lblCpf;
	private JTextField txtLegendaCpf;
	private JLabel lblRg;
	private JTextField txtLegendaRg;
	private JLabel lblCep;
	private JTextField txtLegendaCep;
	private JLabel lblEndereco;
	private JTextField txtLegendaEndereco;
	private JLabel lblBairro;
	private JTextField txtLegendaBairro;
	private JLabel lblCidade;
	private JTextField txtLegendaCidade;
	private JLabel lblEstado;
	private JTextField txtLegendaEstado;
	private JLabel lblTelefone;
	private JTextField txtLegendaTelefone;
	private JLabel lblCelular;
	private JTextField txtLegendaCelular;
	private JLabel lblEmail;
	private JTextField txtLegendaEmail;
	private JButton btnSalvar;
	private JButton btnLimpar;

	private JLabel lblBotaoUsuario;

	public AlunoWindow() {
		setSize(750, 400);
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle(" Cadastro de Aluno");
		setResizable(false);

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				JOptionPane.showMessageDialog(null, "Você apertou uma tecla!");
			}
		});
		
		lblNasc = new JLabel("Nascimento");
		lblNasc.setBounds(405, 15, 80, 25);
		getContentPane().add(lblNasc);
		
		txtLegendaNasc = new JTextField();
		txtLegendaNasc.setBounds(405, 35, 130, 25);
		getContentPane().add(txtLegendaNasc);
		
		lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(20, 15, 60, 25);
		getContentPane().add(lblMatricula);
		
		txtLegendaMat = new JTextField();
		txtLegendaMat.setBounds(20, 35, 75, 25);
		getContentPane().add(txtLegendaMat);

		lblAluno = new JLabel("Nome");
		lblAluno.setBounds(100, 15, 40, 25);
		getContentPane().add(lblAluno);

		txtLegenda = new JTextField();
		txtLegenda.setBounds(100, 35, 300, 25);
		getContentPane().add(txtLegenda);

		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(540, 15, 80, 25);
		getContentPane().add(lblSexo);
		
		txtLegendaSexo = new JTextField();
		txtLegendaSexo.setBounds(540, 35, 115, 25);
		getContentPane().add(txtLegendaSexo);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(20, 60, 30, 25);
		getContentPane().add(lblCpf);
		
		txtLegendaCpf = new JTextField();
		txtLegendaCpf.setBounds(20, 80, 170, 25);
		getContentPane().add(txtLegendaCpf);
		
		lblRg = new JLabel("RG");
		lblRg.setBounds(195, 60, 30, 25);
		getContentPane().add(lblRg);
		
		txtLegendaRg = new JTextField();
		txtLegendaRg.setBounds(195, 80, 170, 25);
		getContentPane().add(txtLegendaRg);
		                           
		lblCep = new JLabel("CEP");
		lblCep.setBounds(20, 105, 30, 25);
		getContentPane().add(lblCep);
		
		txtLegendaCep = new JTextField();
		txtLegendaCep.setBounds(20, 125, 130, 25);
		getContentPane().add(txtLegendaCep);
		
		lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(155, 105, 80, 25);
		getContentPane().add(lblEndereco);
		
		txtLegendaEndereco = new JTextField();
		txtLegendaEndereco.setBounds(155, 125, 300, 25);
		getContentPane().add(txtLegendaEndereco);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(20, 150, 80, 25);
		getContentPane().add(lblBairro);
		
		txtLegendaBairro = new JTextField();
		txtLegendaBairro.setBounds(20, 170, 160, 25);
		getContentPane().add(txtLegendaBairro);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(185, 150, 80, 25);
		getContentPane().add(lblCidade);
		
		txtLegendaCidade = new JTextField();
		txtLegendaCidade.setBounds(185, 170, 160, 25);
		getContentPane().add(txtLegendaCidade);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(350, 150, 80, 25);
		getContentPane().add(lblEstado);
		
		txtLegendaEstado = new JTextField();
		txtLegendaEstado.setBounds(350, 170, 80, 25);
		getContentPane().add(txtLegendaEstado);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(20, 195, 80, 25);
		getContentPane().add(lblTelefone);
		
		txtLegendaTelefone = new JTextField();
		txtLegendaTelefone.setBounds(20, 215, 130, 25);
		getContentPane().add(txtLegendaTelefone);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(155, 195, 80, 25);
		getContentPane().add(lblCelular);
		
		txtLegendaCelular = new JTextField();
		txtLegendaCelular.setBounds(155, 215, 130, 25);
		getContentPane().add(txtLegendaCelular);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 240, 80, 25);
		getContentPane().add(lblEmail);
		
		txtLegendaEmail = new JTextField();
		txtLegendaEmail.setBounds(20, 260, 400, 25);
		getContentPane().add(txtLegendaEmail);
		
		
		//Botões
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(220, 320, 150, 25);
		getContentPane().add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(390, 320, 150, 25);
		getContentPane().add(btnLimpar);
		

		/*
		 * lblBotaoUsuario = new JLabel(new ImageIcon("usuarioButton.png"));
		 * lblBotaoUsuario.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) {
		 * System.out.println("AAAAA"); } }); lblBotaoUsuario.setBounds(50, 50, 300,
		 * 300); getContentPane().add(lblBotaoUsuario);
		 */

	}
	

	public static void main(String[] args) {
		new AlunoWindow().setVisible(true);
	}
}
