package graphic;

import database.dao.*;
import database.model.*;
import lib.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatriculaWindow extends JFrame implements Observer {
    private static final long serialVersionUID = 1L;
    private JLabel lblCurso, lblProfessor, lblAluno, lblDisciplina, lblimagemcurso;
    private JComboBox<String> cmbCurso, cmbProfessor, cmbAluno, cmbDisciplina;
    private JButton btnSalvar, btnNovo, btnPesquisar, btnExcluir;
    private MatriculaDAO io_matricula_dao;
    private Object selectedObject = null;
    private Connection connection;
    private final ImageIcon alertIcon = new ImageIcon("icons/alerta.png");

    public MatriculaWindow(final Connection connection) throws SQLException {
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setTitle(" Matrícula de aluno");
        setLocationRelativeTo(null);
        this.connection = connection;
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        AlunoDAO alunoIO = new AlunoDAO(connection);
        CursoDAO cursoIO = new CursoDAO(connection);
        ProfessorDAO professorIO = new ProfessorDAO(connection);
        MatriculaDAO matriculaIO = new MatriculaDAO(connection);
        DisciplinaDAO disciplinaIO = new DisciplinaDAO(connection);

        List<Object> alunos = alunoIO.Select(null);
        List<Object> cursos = cursoIO.Select(null);
        List<Object> professores = professorIO.Select(null);
        List<Object> disciplinas = disciplinaIO.Select(null);

        lblimagemcurso = new JLabel(new ImageIcon("icons/matrícula.png"));
        lblimagemcurso.setBounds(450, 20, 256, 256);
        getContentPane().add(lblimagemcurso);

        lblCurso = new JLabel("Curso");
        lblCurso.setBounds(50, 35, 90, 25);
        getContentPane().add(lblCurso);

        lblAluno = new JLabel("Professor");
        lblAluno.setBounds(50, 100, 90, 25);
        getContentPane().add(lblAluno);

        lblProfessor = new JLabel("Aluno");
        lblProfessor.setBounds(50, 165, 90, 25);
        getContentPane().add(lblProfessor);

        lblDisciplina = new JLabel("Disciplina");
        lblDisciplina.setBounds(50, 230, 90, 25);
        getContentPane().add(lblDisciplina);

        cmbCurso = new JComboBox<String>();
        cmbCurso.setBounds(110, 35, 300, 25);
        getContentPane().add(cmbCurso);

        cmbProfessor = new JComboBox<String>();
        cmbProfessor.setBounds(110, 100, 300, 25);
        getContentPane().add(cmbProfessor);

        cmbAluno = new JComboBox<String>();
        cmbAluno.setBounds(110, 165, 300, 25);
        getContentPane().add(cmbAluno);

        cmbDisciplina = new JComboBox<String>();
        cmbDisciplina.setBounds(110, 230, 300, 25);
        getContentPane().add(cmbDisciplina);

        btnSalvar = new JButton(new AbstractAction("Salvar") {

            private Boolean isUpdate = false;
            private Matricula matricula = new Matricula();
            private List<Object> matriculas = new ArrayList<Object>();
            private MatriculaDAO matriculaIO = new MatriculaDAO(connection);

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if ((cmbCurso.getItemCount() == 0) || cmbProfessor.getItemCount() == 0 ||
                            cmbAluno.getItemCount() == 0 || cmbDisciplina.getItemCount() == 0) {

                        JOptionPane.showMessageDialog(null, "Selecione todos os campos ",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);

                    } else {
                        for (Object Curso : cursos) {
                            Curso teste = (Curso) Curso;

                            if ((Objects.requireNonNull(cmbCurso.getSelectedItem())).equals(teste.getNome())) {
                                matricula.setIdCurso(teste.getId());
                            }

                        }

                        for (Object Professor : professores) {
                            Professor teste = (Professor) Professor;

                            if (Objects.requireNonNull(cmbProfessor.getSelectedItem()).equals(teste.getNm_professor())) {
                                matricula.setIdProfessor(teste.getcd_professor());
                            }

                        }

                        for (Object Aluno : alunos) {
                            Aluno teste = (Aluno) Aluno;

                            if (Objects.requireNonNull(cmbAluno.getSelectedItem()).equals(teste.getNm_aluno())) {
                                matricula.setIdAluno(teste.getCd_aluno());
                            }

                        }

                        for (Object Disciplina : disciplinas) {
                            Disciplina teste = (Disciplina) Disciplina;
                            if (Objects.requireNonNull(cmbDisciplina.getSelectedItem()).equals(teste.getDisciplina())) {
                                matricula.setIdDisciplina(teste.getCod_disciplina());
                            }

                        }

                        matriculas = matriculaIO.Select(null);
                        Matricula matriculaSelecionada = (Matricula) selectedObject;

                        for (Object o : matriculas) {
                            Matricula teste = (Matricula) o;
                            if (selectedObject != null) {

                                if (teste.getIdMatricula() == matriculaSelecionada.getIdMatricula()) {
                                    matricula.setIdMatricula(teste.getIdMatricula());
                                    matriculaIO.Update(matricula);
                                    isUpdate = true;
                                }

                            }
                        }

                        if (!isUpdate) {
                            JOptionPane.showMessageDialog(null, "Matrícula salva com " +
                                    "sucesso", "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                            matriculaIO.Insert(matricula);
                        } else {
                            JOptionPane.showMessageDialog(null, "Matrícula atualizada " +
                                    "com sucesso", "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                        }
                    }

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }

            }
        });
        btnSalvar.setBounds(125, 310, 115, 25);

        getContentPane().

                add(btnSalvar);

        btnNovo = new

                JButton(new AbstractAction("Novo") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                LimpaTela();
                selectedObject = null;
                setTitle(" Matrícula de aluno");
            }
        });
        btnNovo.setBounds(500, 310, 115, 25);

        getContentPane().

                add(btnNovo);

        btnExcluir = new

                JButton(new AbstractAction("Excluir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (selectedObject == null) {
                        JOptionPane.showMessageDialog(null, "Nenhuma matrícula selecionada",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else {
                        MatriculaDAO matriculaIO = new MatriculaDAO(connection);
                        int opc = JOptionPane.showConfirmDialog(null, "Você tem certeza que " +
                                        "deseja exluir", "Apagar matricula",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, alertIcon);
                        if (opc == 0) {
                            matriculaIO.Delete(selectedObject);
                            LimpaTela();
                            selectedObject = null;
                            setTitle(" Matrícula de aluno");
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnExcluir.setBounds(250, 310, 115, 25);

        getContentPane().

                add(btnExcluir);

        btnPesquisar = new

                JButton(new AbstractAction("Pesquisar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pesquisar(connection);
            }
        });
        btnPesquisar.setBounds(375, 310, 115, 25);

        getContentPane().

                add(btnPesquisar);

        for (
                int i = 0; i < alunos.size(); i++) {
            Aluno teste = (Aluno) alunos.get(i);
            cmbAluno.addItem(teste.getNm_aluno());
        }

        for (
                int i = 0; i < professores.size(); i++) {
            Professor teste = (Professor) professores.get(i);
            cmbProfessor.addItem(teste.getNm_professor());
        }

        for (
                int i = 0; i < disciplinas.size(); i++) {
            Disciplina teste = (Disciplina) disciplinas.get(i);
            cmbDisciplina.addItem(teste.getDisciplina());
        }

        for (
                int i = 0; i < cursos.size(); i++) {
            Curso teste = (Curso) cursos.get(i);
            cmbCurso.addItem(teste.getNome());
        }

    }

    public void LimpaTela() {
        try {
            cmbAluno.setSelectedIndex(0);
            cmbCurso.setSelectedIndex(0);
            cmbDisciplina.setSelectedIndex(0);
            cmbProfessor.setSelectedIndex(0);
        } catch (Exception ignored) {

        }
    }

    public void Pesquisar(final Connection connection) {
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
        PesquisaWindow lo_pesquisa = new PesquisaWindow(io_matricula_dao, la_colunas, la_classes, la_larguras,
                this, connection);
        lo_pesquisa.setVisible(true);
        try {
            selectedObject = lo_pesquisa.getObjetoSelecionado();
            setTitle(" Editando matrícula: " + ((Matricula) selectedObject).getIdMatricula());
        } catch (Exception ignored) {
            selectedObject = null;
        }

    }

    @Override
    public void update(Object arg) {
        Matricula matricula = (Matricula) arg;

        try {
            AlunoDAO alunoIO = new AlunoDAO(connection);
            CursoDAO cursoIO = new CursoDAO(connection);
            ProfessorDAO professorIO = new ProfessorDAO(connection);
            DisciplinaDAO disciplinaIO = new DisciplinaDAO(connection);

            List<Object> alunos = alunoIO.Select(null);
            List<Object> cursos = cursoIO.Select(null);
            List<Object> professores = professorIO.Select(null);
            List<Object> disciplinas = disciplinaIO.Select(null);

            for (Object curso : cursos) {
                Curso teste = (Curso) curso;
                if (matricula.getIdCurso() == teste.getId()) {
                    cmbCurso.setSelectedItem(teste.getNome());
                }
            }

            for (Object Professor : professores) {
                Professor teste = (Professor) Professor;
                if (matricula.getIdProfessor() == teste.getcd_professor()) {
                    cmbProfessor.setSelectedItem(teste.getNm_professor());
                }
            }

            for (Object Aluno : alunos) {
                Aluno teste = (Aluno) Aluno;
                if (matricula.getIdAluno() == teste.getCd_aluno()) {
                    cmbAluno.setSelectedItem(teste.getNm_aluno());
                }
            }

            for (Object Disciplina : disciplinas) {
                Disciplina teste = (Disciplina) Disciplina;
                if (matricula.getIdDisciplina() == teste.getCod_disciplina()) {
                    cmbDisciplina.setSelectedItem(teste.getDisciplina());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
