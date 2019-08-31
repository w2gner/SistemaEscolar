package Graphic;

import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AlunoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblSexo;
	private JLabel lblMatricula;
	private JTextField txtLegendaMat;
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
	private JLabel lblTelefone;
	private JTextField txtLegendaTelefone;
	private JLabel lblCelular;
	private JTextField txtLegendaCelular;
	private JLabel lblEmail;
	private JTextField txtLegendaEmail;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JRadioButton rdbSexoM, rdbSexoF;

	public AlunoWindow() {
		setSize(750, 400);
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle(" Cadastro de Aluno");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));

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

		rdbSexoM = new JRadioButton("M");
		rdbSexoM.setBounds(540, 35, 45, 25);
		getContentPane().add(rdbSexoM);

		rdbSexoF = new JRadioButton("F");
		rdbSexoF.setBounds(585, 35, 45, 25);
		getContentPane().add(rdbSexoF);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbSexoM);
		btnGroup.add(rdbSexoF);

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

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(220, 320, 150, 25);
		getContentPane().add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(390, 320, 150, 25);
		getContentPane().add(btnLimpar);

		JComboBox<String> combobox = new JComboBox<String>();

		combobox.addItem("AC");
		combobox.addItem("AL");
		combobox.addItem("AP");
		combobox.addItem("AM");
		combobox.addItem("BA");
		combobox.addItem("CE");
		combobox.addItem("DF");
		combobox.addItem("ES");
		combobox.addItem("GO");
		combobox.addItem("MA");
		combobox.addItem("MT");
		combobox.addItem("MS");
		combobox.addItem("MG");
		combobox.addItem("PA");
		combobox.addItem("PB");
		combobox.addItem("PR");
		combobox.addItem("PE");
		combobox.addItem("PI");
		combobox.addItem("RJ");
		combobox.addItem("RN");
		combobox.addItem("RS");
		combobox.addItem("RO");
		combobox.addItem("RR");
		combobox.addItem("SC");
		combobox.addItem("SP");
		combobox.addItem("SE");
		combobox.addItem("TO");
		combobox.setBounds(350, 170, 80, 25);
		getContentPane().add(combobox);

	}

	public static void main(String[] args) {
		new AlunoWindow().setVisible(true);
	}
}
