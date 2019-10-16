package graphic;

import database.dao.ProfessorDAO;
import database.model.Professor;
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

public class ProfessorWindow extends JFrame implements Observer {

    private static final long serialVersionUID = 1L;
    private Connection connection;
    private JLabel lblSexo;
    private JLabel lblMatricula;
    private JTextField txfMat;
    private JLabel lblProfessor;
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
    private ProfessorDAO io_professor_dao;
    private Object selectedObject = null;
    private final ImageIcon alertIcon = new ImageIcon("icons/alerta.png");

    public ProfessorWindow(Connection conn) throws SQLException {
        this.connection = conn;
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(" Cadastro de Professor");
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblimagemcurso = new JLabel(new ImageIcon("icons/cadastro.png"));
        lblimagemcurso.setBounds(515, 90, 200, 200);
        getContentPane().add(lblimagemcurso);

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

        lblProfessor = new JLabel("Nome");
        lblProfessor.setBounds(135, 35, 300, 25);
        getContentPane().add(lblProfessor);

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
            private ProfessorDAO professorIO = new ProfessorDAO(connection);
            private List<Object> professores = new ArrayList<Object>();
            private Boolean isUpdate = false;
            private Boolean alreadyExists = false;

            @Override
            public void actionPerformed(ActionEvent e) {

                if (!txfMat.getText().matches("^[0-9]*$")) {
                    JOptionPane.showMessageDialog(null, "Campo matrícula deve conter apenas números",
                            "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    txfMat.setText("");
                } else if (txfNome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo nome requerido", "Aviso",
                            JOptionPane.WARNING_MESSAGE, alertIcon);
                } else if (txfMat.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Campo matrícula requerido",
                            "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                } else {
                    try {

                        Professor professor = new Professor();

                        professor.setNm_professor(txfNome.getText());
                        if (!txfNasc.getText().contains("  /  /    ")) {
                            professor.setNasc_professor(txfNasc.getText().replace("/", " "));
                        }

                        if (rdbSexoF.isSelected()) {
                            professor.setSexo_professor("F");
                        } else {
                            professor.setSexo_professor("M");
                        }

                        professor.setMat_professor(Integer.parseInt(txfMat.getText()));
                        professor.setCpf_professor(txfCpf.getText());
                        professor.setRg_professor(txfRg.getText());
                        professor.setCep_professor(txfCep.getText());
                        professor.setEnd_professor(txfEndereco.getText());
                        professor.setBairo_professor(txfBairro.getText());
                        professor.setCidade_professor(txfCidade.getText());
                        professor.setUf_professor(cbxEstado.getSelectedItem().toString());
                        professor.setTelefone_professor(txfTelefone.getText());
                        professor.setCelular_professor(txfCelular.getText());
                        professor.setEmail_professor(txfEmail.getText());

                        professores = professorIO.Select(null);

                        for (Object o : professores) {
                            Professor teste = (Professor) o;
                            if (selectedObject != null) {
                                if (teste.getMat_professor() == ((Professor) selectedObject).getMat_professor()) {
                                    professor.setcd_professor(teste.getcd_professor());
                                    isUpdate = true;
                                }
                            }

                        }

                        if (!isUpdate) {
                            try {
                                professorIO.Insert(professor);
                                JOptionPane.showMessageDialog(null, "Professor salvo com sucesso",
                                        "Aviso",
                                        JOptionPane.WARNING_MESSAGE, alertIcon);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Um professor com esse " +
                                                "CPF já foi cadastrado",
                                        "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                            }

                            setTitle(" Editando aluno: " + professor.getNm_professor());

                        } else {
                            try {
                                professorIO.Update(professor);
                                JOptionPane.showMessageDialog(null, "Professor atualizado com " +
                                                "sucesso", "Aviso",
                                        JOptionPane.WARNING_MESSAGE, alertIcon);
                                isUpdate = false;
                            } catch (Exception e1) {
                                JOptionPane.showMessageDialog(null, "Um professor com esse " +
                                                "CPF já foi cadastrado",
                                        "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                            }

                            setTitle(" Editando aluno: " + professor.getNm_professor());
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
                setTitle(" Cadastro de Professor");
            }
        });
        btnNovo.setBounds(500, 310, 115, 25);
        getContentPane().add(btnNovo);

        btnPesquisar = new JButton(new AbstractAction("Pesquisar") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                Pesquisar(conn);

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
                        JOptionPane.showMessageDialog(null, "Nenhum professor selecionado",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else {
                        ProfessorDAO professorIO = new ProfessorDAO(connection);
                        int opc = JOptionPane.showConfirmDialog(null, "Você tem certeza que" +
                                        " deseja exluir", "Apagar professor",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, alertIcon);
                        if (opc == 0) {
                            professorIO.Delete(selectedObject);
                            LimpaTela();
                            selectedObject = null;
                            setTitle(" Cadastro de Professor");
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
        String[] la_colunas = {"Matrícula", "Professor"};

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
        PesquisaWindow lo_pesquisa = new PesquisaWindow(io_professor_dao, la_colunas, la_classes, la_larguras,
                this, conn);
        lo_pesquisa.setVisible(true);
        try {
            selectedObject = lo_pesquisa.getObjetoSelecionado();
            setTitle(" Editando professor: " + ((Professor) selectedObject).getNm_professor());
        } catch (Exception ignored) {
            selectedObject = null;
        }
    }

    @Override
    public void update(Object arg) {

        try {
            Professor professor = (Professor) arg;
            txfMat.setText(Integer.toString(professor.getMat_professor()));
            txfNome.setText(professor.getNm_professor());
            txfBairro.setText(professor.getBairo_professor());
            txfCelular.setText(professor.getCelular_professor());
            txfCep.setText(professor.getCep_professor());
            txfCidade.setText(professor.getCidade_professor());
            txfCpf.setText(professor.getCpf_professor());
            txfEmail.setText(professor.getEmail_professor());
            txfEndereco.setText(professor.getEnd_professor());

            String ano = professor.getNasc_professor().replace("-", "/").substring(0, 4);
            String dia = professor.getNasc_professor().replace("-", "/").substring(8);
            String mes = professor.getNasc_professor().replace("-", "/").substring(5, 7);

            txfNasc.setText(dia + "/" + mes + "/" + ano);
            txfRg.setText(professor.getRg_professor());
            txfTelefone.setText(professor.getTelefone_professor());
            cbxEstado.setSelectedItem(professor.getUf_professor());
            if (professor.getSexo_professor().toUpperCase().equals("M")) {
                rdbSexoM.setSelected(true);
            } else {
                rdbSexoF.setSelected(true);
            }

        } catch (Exception e) {
        }

    }

}
