package graphic;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PrincipalWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menuSistema, menuCasdastro, menuProcessos, menuFerramentas;
	private JMenuItem menuUsuarios, menuSair, menuCurso, menuDisciplina, menuProfessores, menuAlunos, menuMatricular, menuBackup, menuReplicador;

	public PrincipalWindow() {
		setSize(1150, 650);
		setLayout(null);
		setTitle("Sistema");
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

		menuBar = new JMenuBar();
		menuSistema = new JMenu("Sistema");
		menuCasdastro = new JMenu("Cadastro");
		menuProcessos = new JMenu("Processos");
		menuFerramentas = new JMenu("Ferramentas");

		menuCurso = new JMenuItem("Curso");
		menuUsuarios = new JMenuItem(new AbstractAction("Usuários"){
		
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				new UsuarioWindow().setVisible(true);
			}
		});
		menuSair = new JMenuItem(new AbstractAction("Sair") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuDisciplina = new JMenuItem("Disciplina");
		menuProfessores = new JMenuItem("Professores");
		menuAlunos = new JMenuItem(new AbstractAction("Alunos") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				new AlunoWindow().setVisible(true);
			}
		});
		menuMatricular = new JMenuItem(new AbstractAction("Matricular") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				new MatricularWindow().setVisible(true);
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

	public static void main(String[] args) {
		new PrincipalWindow().setVisible(true);
	}
}