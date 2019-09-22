package graphic;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import database.dao.AlunoDAO;
import database.model.Aluno;
import lib.MLFDataTextField;

public class AlunoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private Connection connection;
	private JLabel lblSexo;
	private JLabel lblMatricula;
	private JTextField txfMat;
	private JLabel lblAluno;
	private JLabel lblNasc;
	private MLFDataTextField txfNasc;
	private JTextField txfNome;
	private JLabel lblCpf;
	private JTextField txfCpf;
	private JLabel lblRg;
	private JTextField txfRg;
	private JLabel lblCep;
	private JTextField txfCep;
	private JLabel lblEndereco;
	private JTextField txfEndereco;
	private JLabel lblBairro;
	private JTextField txfBairro;
	private JLabel lblCidade;
	private JTextField txfCidade;
	private JLabel lblEstado;
	private JLabel lblTelefone;
	private JTextField txfTelefone;
	private JLabel lblCelular;
	private JTextField txfCelular;
	private JLabel lblEmail;
	private JTextField txfEmail;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnPesquisar;
	private JButton btnExcluir;
	private JRadioButton rdbSexoM, rdbSexoF;
	private JComboBox<String> cbxEstado;
	private ButtonGroup btnGroup;
	AlunoDAO io_aluno_dao;

	public AlunoWindow(Connection conn) {
		this.connection = conn;
		setLayout(null);
		setSize(750, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(" Cadastro de Aluno");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

		lblNasc = new JLabel("Nascimento");
		lblNasc.setBounds(445, 35, 80, 25);
		getContentPane().add(lblNasc);

		txfNasc = new MLFDataTextField();
		txfNasc.setBounds(445, 55, 130, 25);
		getContentPane().add(txfNasc);

		lblMatricula = new JLabel("Matrícula");
		lblMatricula.setBounds(50, 35, 60, 25);
		getContentPane().add(lblMatricula);

		txfMat = new JTextField();
		txfMat.setBounds(50, 55, 75, 25);
		getContentPane().add(txfMat);

		lblAluno = new JLabel("Nome");
		lblAluno.setBounds(135, 35, 300, 25);
		getContentPane().add(lblAluno);

		txfNome = new JTextField();
		txfNome.setBounds(135, 55, 300, 25);
		getContentPane().add(txfNome);

		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(585, 35, 80, 25);
		getContentPane().add(lblSexo);

		rdbSexoM = new JRadioButton("M");
		rdbSexoM.setBounds(585, 55, 35, 25);
		getContentPane().add(rdbSexoM);

		rdbSexoF = new JRadioButton("F");
		rdbSexoF.setBounds(620, 55, 35, 25);
		getContentPane().add(rdbSexoF);

		btnGroup = new ButtonGroup();
		btnGroup.add(rdbSexoM);
		btnGroup.add(rdbSexoF);

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(50, 80, 30, 25);
		getContentPane().add(lblCpf);

		txfCpf = new JTextField();
		txfCpf.setBounds(50, 100, 170, 25);
		getContentPane().add(txfCpf);

		lblRg = new JLabel("RG");
		lblRg.setBounds(230, 80, 30, 25);
		getContentPane().add(lblRg);

		txfRg = new JTextField();
		txfRg.setBounds(230, 100, 170, 25);
		getContentPane().add(txfRg);

		lblCep = new JLabel("CEP");
		lblCep.setBounds(50, 130, 30, 25);
		getContentPane().add(lblCep);

		txfCep = new JTextField();
		txfCep.setBounds(50, 150, 130, 25);
		getContentPane().add(txfCep);

		lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(190, 130, 80, 25);
		getContentPane().add(lblEndereco);

		txfEndereco = new JTextField();
		txfEndereco.setBounds(190, 150, 300, 25);
		getContentPane().add(txfEndereco);

		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(50, 175, 80, 25);
		getContentPane().add(lblBairro);

		txfBairro = new JTextField();
		txfBairro.setBounds(50, 195, 160, 25);
		getContentPane().add(txfBairro);

		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(220, 175, 80, 25);
		getContentPane().add(lblCidade);

		txfCidade = new JTextField();
		txfCidade.setBounds(220, 195, 160, 25);
		getContentPane().add(txfCidade);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(390, 175, 80, 25);
		getContentPane().add(lblEstado);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(50, 220, 80, 25);
		getContentPane().add(lblTelefone);

		txfTelefone = new JTextField();
		txfTelefone.setBounds(50, 240, 130, 25);
		getContentPane().add(txfTelefone);

		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(190, 220, 80, 25);
		getContentPane().add(lblCelular);

		txfCelular = new JTextField();
		txfCelular.setBounds(190, 240, 130, 25);
		getContentPane().add(txfCelular);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(330, 220, 80, 25);
		getContentPane().add(lblEmail);

		txfEmail = new JTextField();
		txfEmail.setBounds(330, 240, 250, 25);
		getContentPane().add(txfEmail);

		btnSalvar = new JButton(new AbstractAction("Salvar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (txfNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo nome requerido!");
				} else {
					try {
						AlunoDAO alunoIO = new AlunoDAO(connection);
						Aluno aluno = new Aluno();

						aluno.setNm_aluno(txfNome.getText().toString());
						if (!txfNasc.getText().toString().contains("  /  /    ")) {
							aluno.setNasc_aluno(txfNasc.getText().toString().replace("/", " "));
						}

						if (!txfMat.getText().isEmpty()) {
							aluno.setMat_aluno(Integer.parseInt(txfMat.getText()));
						}

						if (rdbSexoF.isSelected()) {
							aluno.setSexo_aluno('F');
						} else {
							aluno.setSexo_aluno('M');
						}

						aluno.setCpf_aluno(txfCpf.getText().toString());
						aluno.setRg_aluno(txfRg.getText().toString());
						aluno.setCep_aluno(txfCep.getText().toString());
						aluno.setEnd_aluno(txfEndereco.getText().toString());
						aluno.setBairo_aluno(txfBairro.getText().toString());
						aluno.setCidade_aluno(txfCidade.getText().toString());
						aluno.setUf_aluno(cbxEstado.getSelectedItem().toString());
						aluno.setTelefone_aluno(txfTelefone.getText().toString());
						aluno.setCelular_aluno(txfCelular.getText().toString());
						aluno.setEmail_aluno(txfEmail.getText().toString());

						alunoIO.Insert(aluno);

						JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!");
						LimpaTela();

					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnSalvar.setBounds(125, 310, 115, 25);
		getContentPane().add(btnSalvar);

		btnCancelar = new JButton(new AbstractAction("Cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(500, 310, 115, 25);
		getContentPane().add(btnCancelar);

		btnPesquisar = new JButton(new AbstractAction("Pesquisar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Pesquisar(conn);

			}
		});
		btnPesquisar.setBounds(375, 310, 115, 25);
		getContentPane().add(btnPesquisar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(250, 310, 115, 25);
		getContentPane().add(btnExcluir);

		cbxEstado = new JComboBox<String>();
		cbxEstado.addItem("AC");
		cbxEstado.addItem("AL");
		cbxEstado.addItem("AP");
		cbxEstado.addItem("AM");
		cbxEstado.addItem("BA");
		cbxEstado.addItem("CE");
		cbxEstado.addItem("DF");
		cbxEstado.addItem("ES");
		cbxEstado.addItem("GO");
		cbxEstado.addItem("MA");
		cbxEstado.addItem("MT");
		cbxEstado.addItem("MS");
		cbxEstado.addItem("MG");
		cbxEstado.addItem("PA");
		cbxEstado.addItem("PB");
		cbxEstado.addItem("PR");
		cbxEstado.addItem("PE");
		cbxEstado.addItem("PI");
		cbxEstado.addItem("RJ");
		cbxEstado.addItem("RN");
		cbxEstado.addItem("RS");
		cbxEstado.addItem("RO");
		cbxEstado.addItem("RR");
		cbxEstado.addItem("SC");
		cbxEstado.addItem("SP");
		cbxEstado.addItem("SE");
		cbxEstado.addItem("TO");
		cbxEstado.setBounds(390, 195, 80, 25);
		getContentPane().add(cbxEstado);

	}

	public void LimpaTela() {
		txfBairro.setText("");
		txfCelular.setText("");
		txfCep.setText("");
		txfCidade.setText("");
		txfCpf.setText("");
		txfEmail.setText("");
		txfEndereco.setText("");
		txfMat.setText("");
		txfNasc.setText("");
		txfNome.setText("");
		txfRg.setText("");
		txfTelefone.setText("");
		cbxEstado.setSelectedIndex(0);
		rdbSexoF.setSelected(false);
		rdbSexoM.setSelected(false);
	}

	public void Pesquisar(Connection conn) {
		//
		// Define as colunas da tabela de pesquisa
		//
		String[] la_colunas = { "Código", "Aluno" };

		//
		// Define as classes das colunas
		//
		Class<?>[] la_classes = { Integer.class, String.class };

		//
		// Define as larguras das colunas da tabela de pesquisa
		//
		int[] la_larguras = { 50, 400 };

		//
		// Cria a janela de busca
		//
		PesquisaWindow lo_pesquisa = new PesquisaWindow(io_aluno_dao, la_colunas, la_classes, la_larguras, this, conn);
		lo_pesquisa.setVisible(true);
	}

}
