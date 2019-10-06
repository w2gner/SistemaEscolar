import java.sql.Connection;
import java.sql.SQLException;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import database.ConnectionFactory;
import database.dao.UsuarioDAO;
import graphic.LoginWindow;
import database.model.Usuario;

public class Principal {
    public static void main(String[] args) {

        Connection connection = ConnectionFactory.getConnection("localhost", "5432", "SistemaDBA", "postgres", "manager");

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel((UIManager.getSystemLookAndFeelClassName()));

                    UsuarioDAO user = new UsuarioDAO(connection);

                    if (connection != null) {
                        if (user.Select(null).size() == 0) {
                            Usuario usuarioPadrao = new Usuario();
                            usuarioPadrao.setNome("admin");
                            usuarioPadrao.setSenha("admin");
                            usuarioPadrao.setIs_Admin(true);
                            user.Insert(usuarioPadrao);
                        }
                    } else {
                        System.out.println("Não foi possível estabelecer conexão");
                    }

                    new LoginWindow(connection).setVisible(true);

                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}