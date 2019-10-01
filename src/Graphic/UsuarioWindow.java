package graphic;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import database.dao.UsuarioDAO;
import database.model.Usuario;
import lib.Observer;

public class UsuarioWindow extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbxPerfil;
	private JTextField txfUsuario, txfSenha;
	private JLabel lblUsuario, lblSenha, lblPerfil;
	private JButton btnCancelar, btnRemover, btnSalvar, btnPesquisar;
	private UsuarioDAO io_usuario_dao;
	private final ImageIcon alertIcon = new ImageIcon("icons/alerta.png");
	private Object selectedObject;

	UsuarioWindow(final Connection connection) {
		setLayout(null);
		setSize(750, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(" Cadastro de Usuário");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

		lblUsuario = new JLabel("Usuário");
		lblUsuario.setBounds(50, 35, 50, 25);
		getContentPane().add(lblUsuario);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 70, 50, 25);
		getContentPane().add(lblSenha);

		lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(50, 105, 30, 25);
		getContentPane().add(lblPerfil);

		txfUsuario = new JTextField();
		txfUsuario.setBounds(110, 35, 300, 25);
		getContentPane().add(txfUsuario);

		txfSenha = new JPasswordField();
		txfSenha.setBounds(110, 70, 300, 25);
		getContentPane().add(txfSenha);

		cbxPerfil = new JComboBox<String>();
		cbxPerfil.setBounds(110, 105, 300, 25);
		getContentPane().add(cbxPerfil);
		cbxPerfil.addItem("Administrador");
		cbxPerfil.addItem("Convidado");

		btnCancelar = new JButton(new AbstractAction("Cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(500, 310, 115, 25);
		getContentPane().add(btnCancelar);

		btnRemover = new JButton(new AbstractAction("Excluir") {

            private static final long serialVersionUID = 1L;

            @Override
			public void actionPerformed(ActionEvent arg0) {
				Usuario usuario = (Usuario) selectedObject;
				UsuarioDAO usuarioIO;
				try {
					usuarioIO = new UsuarioDAO(connection);
					usuarioIO.Delete(usuario);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Usuário excluído", "Aviso", JOptionPane.WARNING_MESSAGE,
						alertIcon);
				LimpaTela();

			}
		});
		btnRemover.setBounds(250, 310, 115, 25);
		getContentPane().add(btnRemover);

		try {
			btnSalvar = new JButton(new AbstractAction("Salvar") {

				private static final long serialVersionUID = 1L;
				UsuarioDAO usuarioIO = new UsuarioDAO(connection);
				private ArrayList<Object> usuarios = new ArrayList<>();
				private Boolean isUpdate;

				@Override
				public void actionPerformed(ActionEvent e) {
					if (txfUsuario.getText().isEmpty() && txfSenha.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Insira as informações do usuário", "Aviso",
								JOptionPane.WARNING_MESSAGE, alertIcon);
					} else if (txfUsuario.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Nome do usuário requerido", "Aviso",
								JOptionPane.WARNING_MESSAGE, alertIcon);
					} else if (txfSenha.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Senha do usuário requerida", "Aviso",
								JOptionPane.WARNING_MESSAGE, alertIcon);
					} else {
						try {
							Usuario usuario = new Usuario();
							usuario.setNome(txfUsuario.getText());
							usuario.setSenha(txfSenha.getText());
							if (cbxPerfil.getSelectedItem().equals("Administrador")) {
								usuario.setIs_Admin(true);
							} else {
								usuario.setIs_Admin(false);
							}

							usuarioIO.Insert(usuario);
							JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso", "Aviso",
									JOptionPane.WARNING_MESSAGE, alertIcon);
							LimpaTela();

						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

				}
			});
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnSalvar.setBounds(125, 310, 115, 25);
		getContentPane().add(btnSalvar);

		btnPesquisar = new JButton(new AbstractAction("Pesquisar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				pesquisar(connection);

			}
		});
		btnPesquisar.setBounds(375, 310, 115, 25);
		getContentPane().add(btnPesquisar);

	}

	public void pesquisar(Connection connection) {
		//
		// Define as colunas da tabela de pesquisa
		//
		String[] la_colunas = { "Admin", "Aluno" };

		//
		// Define as classes das colunas
		//
		Class<?>[] la_classes = { Integer.class, String.class };

		//
		// Define as larguras das colunas da tabela de pesquisa
		//
		int[] la_larguras = { 55, 400 };

		//
		// Cria a janela de busca
		//
		PesquisaWindow lo_pesquisa = new PesquisaWindow(io_usuario_dao, la_colunas, la_classes, la_larguras, this,
				connection);
		lo_pesquisa.setVisible(true);
		selectedObject = lo_pesquisa.getObjetoSelecionado();
	}

	public void LimpaTela() {
		txfSenha.setText("");
		txfUsuario.setText("");
		cbxPerfil.setSelectedItem(0);
	}

	@Override
	public void update(Object arg) {

		try {
			Usuario usuario = (Usuario) arg;

			txfSenha.setText(usuario.getSenha());
			txfUsuario.setText(usuario.getNome());

			if (usuario.getIs_Admin()) {
				cbxPerfil.setSelectedItem(0);
			} else {
				cbxPerfil.setSelectedItem(1);
			}
		} catch (Exception e) {
		}

	}

}
