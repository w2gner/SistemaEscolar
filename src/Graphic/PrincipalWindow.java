package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class PrincipalWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lblimagemcurso;
    private JMenuBar menuBar;
    private JMenu menuSistema, menuCasdastro, menuProcessos, menuFerramentas;
    private JMenuItem menuUsuarios, menuSair, menuCurso, menuDisciplina, menuProfessores, menuAlunos, menuMatricular,
            menuBackup, menuReplicador;

    public PrincipalWindow(Connection conn) {
        setSize(1150, 650);
        setLayout(null);
        setTitle("Sistema");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.darkGray);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));
        lblimagemcurso = new JLabel(new ImageIcon("icons/BackGround.png"));

		add(lblimagemcurso);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
        setLayout(new GridBagLayout());
        lblimagemcurso.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(1150, 650);
        getContentPane().add(lblimagemcurso);

        menuBar = new JMenuBar();
        menuSistema = new JMenu("Sistema");
        menuCasdastro = new JMenu("Cadastro");
        menuProcessos = new JMenu("Processos");
        menuFerramentas = new JMenu("Ferramentas");

        menuCurso = new JMenuItem(new AbstractAction("Curso") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CursoWindow(conn).setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        menuUsuarios = new JMenuItem(new AbstractAction("Usuários") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                new UsuarioWindow(conn).setVisible(true);
            }
        });
        menuSair = new JMenuItem(new AbstractAction("Sair") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        menuDisciplina = new JMenuItem(new AbstractAction("Disciplina") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new DisciplinaWindow(conn).setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        menuProfessores = new JMenuItem(new AbstractAction("Professores") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ProfessorWindow(conn).setVisible(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        menuAlunos = new JMenuItem(new AbstractAction("Alunos") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new AlunoWindow(conn).setVisible(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
        menuMatricular = new JMenuItem(new AbstractAction("Matricular") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new MatriculaWindow(conn).setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        menuBackup = new JMenuItem(new AbstractAction("Backup") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                new BackupWindow().setVisible(true);
            }
        });
        menuReplicador = new JMenuItem("Replicador");

        menuSistema.add(menuUsuarios);
        menuSistema.add(menuSair);
        menuCasdastro.add(menuCurso);
        menuCasdastro.add(menuDisciplina);
        menuCasdastro.add(menuProfessores);
        menuCasdastro.add(menuAlunos);
        menuProcessos.add(menuMatricular);
        menuFerramentas.add(menuBackup);
        menuFerramentas.add(menuReplicador);

        menuBar.add(menuSistema);
        menuBar.add(menuCasdastro);
        menuBar.add(menuProcessos);
        menuBar.add(menuFerramentas);

        setJMenuBar(menuBar);

    }
}
