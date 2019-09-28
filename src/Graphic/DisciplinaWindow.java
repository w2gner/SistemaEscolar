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
    private JLabel lblDisciplina, lblcargahoraria, lblprofessor, lblinvestimento;
    private JTextField txfDisciplina, txtcargahoraria, txtprofessor;
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
        txfDisciplina.setBounds(120, 35, 300, 25);
        getContentPane().add(txfDisciplina);

        txtprofessor = new JTextField();
		txtprofessor.setBounds(120, 100, 300, 25);
        getContentPane().add(txtprofessor);
        
        txtcargahoraria = new JTextField();
		txtcargahoraria.setBounds(145, 165, 275, 25);
		getContentPane().add(txtcargahoraria);
        
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
