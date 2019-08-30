package Graphic;

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
	private JMenuItem menuSair, menuCurso, menuDisciplina, menuProfessores, menuAlunos, menuMatricular, menuBackup, menuReplicador;

	public PrincipalWindow() {
		setSize(1150, 650);
		setTitle("Sistema");
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
		menuBar = new JMenuBar();
		menuSistema = new JMenu("Sistema");
		menuSair = new JMenuItem(new AbstractAction("Sair") {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuCasdastro = new JMenu("Cadastro");
		menuProcessos = new JMenu("Processos");
		menuFerramentas = new JMenu("Ferramentas");
		
		menuCurso = new JMenuItem("Curso");
		menuDisciplina = new JMenuItem("Curso");
		menuProfessores = new JMenuItem("Professores");
		menuAlunos = new JMenuItem("Alunos");
		menuMatricular = new JMenuItem("Matricular");
		menuBackup = new JMenuItem("Backup");
		menuReplicador = new JMenuItem("Replicador");

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