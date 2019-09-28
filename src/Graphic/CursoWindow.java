package graphic;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CursoWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel lblCurso;
    private JTextField txfCurso;
    private JButton btnSalvar, btnCancelar;

    public CursoWindow() {
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setTitle(" Cadastro de Curso");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblCurso = new JLabel("Curso");
        lblCurso.setBounds(50, 35, 90, 25);
        getContentPane().add(lblCurso);

        txfCurso = new JTextField();
        txfCurso.setBounds(110, 35, 300, 25);
        getContentPane().add(txfCurso);
        
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(220, 310, 115, 25);
        getContentPane().add(btnSalvar);

        btnCancelar = new JButton(new AbstractAction("Cancelar") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setBounds(390, 310, 115, 25);
        getContentPane().add(btnCancelar);
    }

}
