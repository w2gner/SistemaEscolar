package graphic;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DisciplinaWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel lblDisciplina;
    private JTextField txfDisciplina;
    private JButton btnSalvar, btnCancelar;

    public DisciplinaWindow() {
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setTitle(" Cadastro de Disciplina");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblDisciplina = new JLabel("Disciplina");
        lblDisciplina.setBounds(50, 35, 90, 25);
        getContentPane().add(lblDisciplina);

        txfDisciplina = new JTextField();
        txfDisciplina.setBounds(120, 35, 300, 25);
        getContentPane().add(txfDisciplina);
        
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

    public static void main(String[] args) {
        new DisciplinaWindow().setVisible(true);
    }
}