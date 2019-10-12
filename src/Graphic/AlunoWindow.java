package graphic;

import database.dao.AlunoDAO;
import database.model.Aluno;
import lib.MLFDataTextField;
import lib.Observer;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class AlunoWindow extends JFrame implements Observer {

    private static final long serialVersionUID = 1L;
    private Connection connection;
    private JLabel lblSexo;
    private JLabel lblMatricula;
    private JFormattedTextField txfMat;
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
    private JLabel lblimagemcurso;
    private JTextField txfEmail;
    private JButton btnSalvar;
    private JButton btnNovo;
    private JButton btnPesquisar;
    private JButton btnExcluir;
    private JRadioButton rdbSexoM, rdbSexoF;
    private JComboBox<String> cbxEstado;
    private ButtonGroup btnGroup;
    private AlunoDAO io_aluno_dao;
    private Object selectedObject = null;
    private final ImageIcon alertIcon = new ImageIcon("icons/alerta.png");

    public AlunoWindow(final Connection connection) throws SQLException {
        this.connection = connection;
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(" Cadastro de Aluno");
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblimagemcurso = new JLabel(new ImageIcon("icons/cadastro.png"));
        lblimagemcurso.setBounds(515, 90, 200, 200);
        getContentPane().add(lblimagemcurso);

        NumberFormat longFormat = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(longFormat);
        numberFormatter.setValueClass(Long.class);

        lblNasc = new JLabel("Nascimento");
        lblNasc.setBounds(445, 35, 80, 25);
        getContentPane().add(lblNasc);

        txfNasc = new MLFDataTextField();
        txfNasc.setBounds(445, 55, 130, 25);
        getContentPane().add(txfNasc);

        lblMatricula = new JLabel("Matrícula");
        lblMatricula.setBounds(50, 35, 60, 25);
        getContentPane().add(lblMatricula);

        txfMat = new JFormattedTextField(numberFormatter);
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

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(230, 80, 30, 25);
        getContentPane().add(lblEmail);

        txfEmail = new JTextField();
        txfEmail.setBounds(230, 100, 260, 25);
        getContentPane().add(txfEmail);

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

        lblRg = new JLabel("RG");
        lblRg.setBounds(330, 220, 80, 25);
        getContentPane().add(lblRg);

        txfRg = new JTextField();
        txfRg.setBounds(330, 240, 160, 25);
        getContentPane().add(txfRg);

        btnSalvar = new JButton(new AbstractAction("Salvar") {

            private static final long serialVersionUID = 1L;
            private AlunoDAO alunoIO = new AlunoDAO(connection);
            private List<Object> alunos = new ArrayList<Object>();
            private Boolean isUpdate = false;

            @Override
            public void actionPerformed(ActionEvent e) {

                Aluno aluno = new Aluno();

                if (txfNome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo nome requerido", "Aviso",
                            JOptionPane.WARNING_MESSAGE, alertIcon);
                } else if (txfMat.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo matrícula requerido",
                            "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                } else {
                    try {


                        aluno.setNm_aluno(txfNome.getText());
                        if (!txfNasc.getText().contains("  /  /    ")) {
                            aluno.setNasc_aluno(txfNasc.getText().replace("/", " "));
                        }

                        if (rdbSexoF.isSelected()) {
                            aluno.setSexo_aluno("F");
                        } else {
                            aluno.setSexo_aluno("M");
                        }

                        aluno.setMat_aluno(Integer.parseInt(txfMat.getText()));
                        aluno.setCpf_aluno(txfCpf.getText());
                        aluno.setRg_aluno(txfRg.getText());
                        aluno.setCep_aluno(txfCep.getText());
                        aluno.setEnd_aluno(txfEndereco.getText());
                        aluno.setBairo_aluno(txfBairro.getText());
                        aluno.setCidade_aluno(txfCidade.getText());
                        aluno.setUf_aluno(cbxEstado.getSelectedItem().toString());
                        aluno.setTelefone_aluno(txfTelefone.getText());
                        aluno.setCelular_aluno(txfCelular.getText());
                        aluno.setEmail_aluno(txfEmail.getText());

                        alunos = alunoIO.Select(null);

                        for (Object o : alunos) {
                            Aluno teste = (Aluno) o;
                            if (selectedObject != null) {
                                if (teste.getMat_aluno() == Integer.parseInt(txfMat.getText())) {
                                    aluno.setCd_aluno(teste.getCd_aluno());
                                    isUpdate = true;
                                }
                            }
                        }

                        if (!isUpdate) {
                            try {
                                alunoIO.Insert(aluno);
                                JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso",
                                        "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "Um aluno com esse CPF" +
                                                " já foi cadastrado",
                                        "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                            }

                            setTitle(" Editando aluno: " + aluno.getNm_aluno());

                        } else {
                            try {
                                alunoIO.Update(aluno);
                                JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso",
                                        "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                                isUpdate = false;
                            } catch (Exception e1) {
                                JOptionPane.showMessageDialog(null, "Um aluno com esse CPF" +
                                                " já foi cadastrado",
                                        "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                            }

                            setTitle(" Editando aluno: " + aluno.getNm_aluno());
                        }

                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        btnSalvar.setBounds(125, 310, 115, 25);
        getContentPane().add(btnSalvar);

        btnNovo = new JButton(new AbstractAction("Novo") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                LimpaTela();
                selectedObject = null;
                setTitle(" Cadastro de Aluno");
            }
        });
        btnNovo.setBounds(500, 310, 115, 25);
        getContentPane().add(btnNovo);

        btnPesquisar = new JButton(new AbstractAction("Pesquisar") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                Pesquisar(connection);

            }
        });
        btnPesquisar.setBounds(375, 310, 115, 25);
        getContentPane().add(btnPesquisar);

        btnExcluir = new JButton(new AbstractAction("Excluir") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (selectedObject == null) {
                        JOptionPane.showMessageDialog(null, "Nenhum aluno selecionado",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else {
                        AlunoDAO aluno = new AlunoDAO(connection);
                        int opc = JOptionPane.showConfirmDialog(null, "Você tem certeza que" +
                                        " deseja exluir", "Apagar aluno",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, alertIcon);
                        if (opc == 0) {
                            aluno.Delete(selectedObject);
                            LimpaTela();
                            selectedObject = null;
                            setTitle(" Cadastro de Aluno");
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
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
        btnGroup.clearSelection();
    }

    public void Pesquisar(Connection conn) {
        //
        // Define as colunas da tabela de pesquisa
        //
        String[] la_colunas = {"Matrícula", "Aluno"};

        //
        // Define as classes das colunas
        //
        Class<?>[] la_classes = {Integer.class, String.class};

        //
        // Define as larguras das colunas da tabela de pesquisa
        //
        int[] la_larguras = {55, 400};

        //
        // Cria a janela de busca
        //
        PesquisaWindow lo_pesquisa = new PesquisaWindow(io_aluno_dao, la_colunas, la_classes, la_larguras,
                this, conn);
        lo_pesquisa.setVisible(true);
        try {
            selectedObject = lo_pesquisa.getObjetoSelecionado();
            if (selectedObject != null)
                setTitle(" Editando aluno: " + ((Aluno) selectedObject).getNm_aluno());
        } catch (Exception ignored) {
            selectedObject = null;
        }

    }

    @Override
    public void update(Object arg) {

        try {
            Aluno aluno = (Aluno) arg;
            txfMat.setText(Integer.toString(aluno.getMat_aluno()));
            txfNome.setText(aluno.getNm_aluno());
            txfBairro.setText(aluno.getBairo_aluno());
            txfCelular.setText(aluno.getCelular_aluno());
            txfCep.setText(aluno.getCep_aluno());
            txfCidade.setText(aluno.getCidade_aluno());
            txfCpf.setText(aluno.getCpf_aluno());
            txfEmail.setText(aluno.getEmail_aluno());
            txfEndereco.setText(aluno.getEnd_aluno());

            String ano = aluno.getNasc_aluno().replace("-", "/").substring(0, 4);
            String dia = aluno.getNasc_aluno().replace("-", "/").substring(8);
            String mes = aluno.getNasc_aluno().replace("-", "/").substring(5, 7);

            txfNasc.setText(dia + "/" + mes + "/" + ano);
            txfRg.setText(aluno.getRg_aluno());
            txfTelefone.setText(aluno.getTelefone_aluno());
            cbxEstado.setSelectedItem(aluno.getUf_aluno());
            if (aluno.getSexo_aluno().toUpperCase().equals("M")) {
                rdbSexoM.setSelected(true);
            } else {
                rdbSexoF.setSelected(true);
            }

        } catch (Exception ignored) {

        }

    }

}
