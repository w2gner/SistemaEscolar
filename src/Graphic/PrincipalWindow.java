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
	private JMenuItem menuSair;

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

		menuSistema.add(menuSair);
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