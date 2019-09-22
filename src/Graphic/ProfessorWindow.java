package graphic;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ProfessorWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lblSexo;
    private JLabel lblMatricula;
    private JTextField txfMat;
    private JLabel lblAluno;
    private JLabel lblNasc;
    private JTextField txfNasc;
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
    private JRadioButton rdbSexoM, rdbSexoF;
    private JComboBox<String> cbxEstado;
    private ButtonGroup btnGroup;

    public ProfessorWindow() {
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(" Cadastro de Professor");
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblNasc = new JLabel("Nascimento");
        lblNasc.setBounds(445, 35, 80, 25);
        getContentPane().add(lblNasc);

        txfNasc = new JTextField();
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

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(220, 310, 115, 25);
        getContentPane().add(btnSalvar);

        btnCancelar = new JButton(new AbstractAction("Cancelar") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setBounds(390, 310, 115, 25);
        getContentPane().add(btnCancelar);

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

    public static void main(String[] args) {
        new ProfessorWindow().setVisible(true);
	}
}
