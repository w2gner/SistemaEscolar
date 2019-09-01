package graphic;

import java.awt.Font;
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
    private Font fonte = new Font("Microsoft JhengHei UI", Font.PLAIN, 15); 


    public BackupWindow() {
        setLayout(null);
        setSize(600, 270);
        setTitle(" Backup");
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblTexto = new JLabel("Você deseja fazer backup agora?");
        lblTexto.setBounds(180, 50, 250, 25);
        lblTexto.setFont(fonte);
        getContentPane().add(lblTexto);

        btnSim = new JButton("Sim");
        btnSim.setBounds(190, 180, 100, 25);
        getContentPane().add(btnSim);

        btNao = new JButton(new AbstractAction("Não") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btNao.setBounds(310, 180, 100, 25);
        getContentPane().add(btNao);

        progressBar = new JProgressBar();
        progressBar.setBounds(150, 115, 300, 25);
        getContentPane().add(progressBar);
    }

    public static void main(String[] args) {
        new BackupWindow().setVisible(true);
    }
}