package graphic;

import database.dao.DisciplinaDAO;
import database.dao.ProfessorDAO;
import database.model.Disciplina;
import database.model.Professor;
import lib.Observer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaWindow extends JFrame implements Observer {
    private static final long serialVersionUID = 1L;
    private JLabel lblDisciplina, lblcargahoraria, lblprofessor, lblinvestimento, lblimagemcurso;
    private JTextField txfDisciplina, txtcargahoraria, txfinvestimento;
    private JComboBox<String> cbxprofessor;
    private JButton btnSalvar, btnNovo, btnExcluir, btnPesquisar;
    private DisciplinaDAO io_disciplina_dao;
    private Object selectedObject = null;
    private final ImageIcon alertIcon = new ImageIcon("icons/alerta.png");

    public DisciplinaWindow(final Connection connection) throws SQLException {
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setTitle(" Cadastro de Disciplina");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblimagemcurso = new JLabel(new ImageIcon("icons/disciplina.png"));
        lblimagemcurso.setBounds(450, 20, 256, 256);
        getContentPane().add(lblimagemcurso);

        lblDisciplina = new JLabel("Disciplina");
        lblDisciplina.setBounds(50, 35, 90, 25);
        getContentPane().add(lblDisciplina);

        lblprofessor = new JLabel("Professor");
        lblprofessor.setBounds(50, 100, 90, 25);
        getContentPane().add(lblprofessor);

        lblcargahoraria = new JLabel("Carga Horária");
        lblcargahoraria.setBounds(50, 165, 90, 25);
        getContentPane().add(lblcargahoraria);

        lblinvestimento = new JLabel("Investimento");
        lblinvestimento.setBounds(50, 230, 90, 25);
        getContentPane().add(lblinvestimento);

        txfDisciplina = new JTextField();
        txfDisciplina.setBounds(145, 35, 275, 25);
        getContentPane().add(txfDisciplina);

        cbxprofessor = new JComboBox<String>();
        cbxprofessor.setBounds(145, 100, 275, 25);
        getContentPane().add(cbxprofessor);

        txtcargahoraria = new JTextField();
        txtcargahoraria.setBounds(145, 165, 275, 25);
        getContentPane().add(txtcargahoraria);

        txfinvestimento = new JTextField();
        txfinvestimento.setBounds(145, 230, 275, 25);
        getContentPane().add(txfinvestimento);

        try {
            ProfessorDAO professorIO = new ProfessorDAO(connection);
            List<Object> lista = new ArrayList<>();
            Professor professor = new Professor();
            lista = professorIO.Select(null);

            for (int i = 0; i < lista.size(); i++) {
                professor = (Professor) lista.get(i);
                cbxprofessor.addItem(professor.getNm_professor());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        btnSalvar = new JButton(new AbstractAction("Salvar") {

            private Boolean isUpdate = false;
            private Disciplina disciplina = new Disciplina();
            private List<Object> disciplinas = new ArrayList<Object>();
            private DisciplinaDAO disciplinaIO = new DisciplinaDAO(connection);

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (txfDisciplina.getText().isEmpty() || txfinvestimento.getText().isEmpty() ||
                            txtcargahoraria.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else {

                        if (txfinvestimento.getText().contains(",")) {
                            disciplina.setInvestimento(Double.parseDouble(txfinvestimento.getText().replace(",",
                                    ".")));
                            System.out.println(disciplina.getInvestimento());
                        } else {
                            disciplina.setInvestimento(Double.parseDouble(txfinvestimento.getText()));
                        }

                        disciplina.setDisciplina(txfDisciplina.getText());
                        disciplina.setCargaHoraria(txtcargahoraria.getText());
                        disciplina.setProfessor_disciplina(cbxprofessor.getSelectedItem().toString());

                        disciplinas = disciplinaIO.Select(null);
                        Disciplina disciplinaSelecionado = (Disciplina) selectedObject;

                        for (Object o : disciplinas) {
                            Disciplina teste = (Disciplina) o;
                            if (selectedObject != null) {
                                if (teste.getCod_disciplina() == disciplinaSelecionado.getCod_disciplina()) {
                                    disciplina.setCod_disciplina(teste.getCod_disciplina());
                                    disciplinaIO.Update(disciplina);
                                    isUpdate = true;
                                }
                            }
                        }

                        if (!isUpdate) {
                            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso",
                                    "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                            disciplinaIO.Insert(disciplina);
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuário atualizado com" +
                                    " sucesso", "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                        }

                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
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
                setTitle(" Cadastro de Disciplina");
            }
        });
        btnNovo.setBounds(500, 310, 115, 25);
        getContentPane().add(btnNovo);

        btnPesquisar = new JButton(new AbstractAction("Pesquisar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pesquisar(connection);
            }
        });
        btnPesquisar.setBounds(375, 310, 115, 25);
        getContentPane().add(btnPesquisar);

        btnExcluir = new JButton(new AbstractAction("Excluir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DisciplinaDAO disciplinaIO = new DisciplinaDAO(connection);

                    if (selectedObject == null) {
                        JOptionPane.showMessageDialog(null, "Nenhuma disciplina selecionada",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else {
                        int opc = JOptionPane.showConfirmDialog(null, "Você tem certeza que " +
                                "deseja exluir", "Apagar disciplina", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE, alertIcon);
                        if (opc == 0) {
                            disciplinaIO.Delete(selectedObject);
                            LimpaTela();
                            selectedObject = null;
                            setTitle(" Cadastro de Disciplina");
                        }
                    }
                } catch (SQLException ignored) {

                }
            }
        });
        btnExcluir.setBounds(250, 310, 115, 25);
        getContentPane().add(btnExcluir);

    }

    public void LimpaTela() {
        txfinvestimento.setText("");
        txfDisciplina.setText("");
        txtcargahoraria.setText("");
        cbxprofessor.setSelectedIndex(0);
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
        PesquisaWindow lo_pesquisa = new PesquisaWindow(io_disciplina_dao, la_colunas, la_classes, la_larguras,
                this, conn);
        lo_pesquisa.setVisible(true);

        try {
            selectedObject = lo_pesquisa.getObjetoSelecionado();
            setTitle(" Editando disciplina: " + ((Disciplina) selectedObject).getDisciplina());
        } catch (Exception ignored) {
            selectedObject = null;
        }
    }

    @Override
    public void update(Object arg) {
        Disciplina disciplina = (Disciplina) arg;
        txfDisciplina.setText(disciplina.getDisciplina());
        txfinvestimento.setText(String.valueOf(disciplina.getInvestimento()));
        cbxprofessor.setSelectedItem(disciplina.getProfessor_disciplina());
        txtcargahoraria.setText(disciplina.getCargaHoraria());
    }
}
