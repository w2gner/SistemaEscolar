package graphic;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class BackupWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JButton btnSim, btNao;
    private JLabel lblTexto;
    private JProgressBar progressBar;

    public BackupWindow() {
        setSize(600, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle(" Backup");
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));

        lblTexto = new JLabel("Você deseja fazer backup agora?");
        lblTexto.setBounds(200, 50, 250, 25);
        getContentPane().add(lblTexto);

        btnSim = new JButton("Sim");
        btnSim.setBounds(190, 200, 100, 25);
        getContentPane().add(btnSim);

        btNao = new JButton(new AbstractAction("Não") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btNao.setBounds(310, 200, 100, 25);
        getContentPane().add(btNao);

        progressBar = new JProgressBar();
        progressBar.setBounds(150, 125, 300, 25);
        getContentPane().add(progressBar);
    }

    public static void main(String[] args) {
        new BackupWindow().setVisible(true);
    }
}