package graphic;

import database.dao.CursoDAO;
import database.model.Curso;
import lib.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoWindow extends JFrame implements Observer {
    private static final long serialVersionUID = 1L;
    private JLabel lblCurso, lblimagemcurso, lblValorCreditos, lblQtdCreditos;
    private JTextField txfCurso, txfValorCreditos, txfQtdCreditos;
    private JButton btnSalvar, btnNovo, btnPesquisar, btnExcluir;
    private Object selectedObject;
    private CursoDAO io_curso_dao;
    private final ImageIcon alertIcon = new ImageIcon("icons/alerta.png");

    public CursoWindow(final Connection connection) throws SQLException {
        setLayout(null);
        setSize(750, 400);
        setResizable(false);
        setTitle(" Cadastro de Curso");
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logo.png"));

        lblimagemcurso = new JLabel(new ImageIcon("icons/curso.png"));
        lblimagemcurso.setBounds(450, 20, 256, 256);
        getContentPane().add(lblimagemcurso);

        lblCurso = new JLabel("Curso");
        lblCurso.setBounds(50, 70, 90, 25);
        getContentPane().add(lblCurso);

        lblQtdCreditos = new JLabel("Nº de créditos");
        lblQtdCreditos.setBounds(50, 135, 90, 25);
        getContentPane().add(lblQtdCreditos);

        lblValorCreditos = new JLabel("Valor dos créditos");
        lblValorCreditos.setBounds(50, 200, 90, 25);
        getContentPane().add(lblValorCreditos);

        txfCurso = new JTextField();
        txfCurso.setBounds(145, 70, 275, 25);
        getContentPane().add(txfCurso);

        txfQtdCreditos = new JTextField();
        txfQtdCreditos.setBounds(145, 135, 275, 25);
        getContentPane().add(txfQtdCreditos);

        txfValorCreditos = new JTextField();
        txfValorCreditos.setBounds(145, 200, 275, 25);
        getContentPane().add(txfValorCreditos);

        btnSalvar = new JButton(new AbstractAction("Salvar") {

            private Boolean isUpdate = false;
            private Curso curso = new Curso();
            private List<Object> cursos = new ArrayList<Object>();
            private CursoDAO cursoIO = new CursoDAO(connection);

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txfCurso.getText().isEmpty() || txfQtdCreditos.getText().isEmpty() ||
                            txfValorCreditos.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else {

                        if (txfValorCreditos.getText().contains(",")) {
                            curso.setValorCreditos(Double.parseDouble(txfValorCreditos.getText().replace(",",
                                    ".")));
                        } else {
                            curso.setValorCreditos(Double.parseDouble(txfValorCreditos.getText()));
                        }

                        curso.setNome(txfCurso.getText());
                        curso.setQtdCreditos(Integer.parseInt(txfQtdCreditos.getText()));

                        cursos = cursoIO.Select(null);
                        Curso cursoSelecionado = (Curso) selectedObject;

                        for (Object o : cursos) {
                            Curso teste = (Curso) o;
                            if (selectedObject != null) {
                                if (teste.getId() == cursoSelecionado.getId()) {
                                    curso.setId(teste.getId());
                                    cursoIO.Update(curso);
                                    isUpdate = true;
                                }
                            }
                        }

                        if (!isUpdate) {
                            JOptionPane.showMessageDialog(null, "Curso salvo com sucesso",
                                    "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                            cursoIO.Insert(curso);
                        } else {
                            JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso",
                                    "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                        }

                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        btnSalvar.setBounds(125, 310, 115, 25);
        getContentPane().add(btnSalvar);

        btnNovo = new JButton(new AbstractAction("Novo") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                LimpaTela();
                selectedObject = null;
                setTitle(" Cadastro de Curso");
            }
        });
        btnNovo.setBounds(500, 310, 115, 25);
        getContentPane().add(btnNovo);

        btnPesquisar = new JButton(new AbstractAction("Pesquisar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pesquisar(connection);
            }
        });
        btnPesquisar.setBounds(375, 310, 115, 25);
        getContentPane().add(btnPesquisar);

        btnExcluir = new JButton(new AbstractAction("Excluir") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (selectedObject == null) {
                        JOptionPane.showMessageDialog(null, "Nenhum curso selecionado",
                                "Aviso", JOptionPane.WARNING_MESSAGE, alertIcon);
                    } else {
                        CursoDAO curso = new CursoDAO(connection);
                        int opc = JOptionPane.showConfirmDialog(null, "Você tem certeza que " +
                                        "deseja exluir", "Apagar curso",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, alertIcon);
                        if (opc == 0) {
                            curso.Delete(selectedObject);
                            LimpaTela();
                            selectedObject = null;
                            setTitle(" Cadastro de Curso");
                        }
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnExcluir.setBounds(250, 310, 115, 25);
        getContentPane().add(btnExcluir);

    }

    public void LimpaTela() {
        txfValorCreditos.setText("");
        txfQtdCreditos.setText("");
        txfCurso.setText("");
    }

    public void Pesquisar(Connection connection) {
        //
        // Define as colunas da tabela de pesquisa
        //
        String[] la_colunas = {"Código", "Curso"};

        //
        // Define as classes das colunas
        //
        Class<?>[] la_classes = {Integer.class, String.class};

        //
        // Define as larguras das colunas da tabela de pesquisa
        //
        int[] la_larguras = {55, 400};

        //
        // Cria a janela de busca
        //
        PesquisaWindow lo_pesquisa = new PesquisaWindow(io_curso_dao, la_colunas, la_classes, la_larguras,
                this, connection);
        lo_pesquisa.setVisible(true);
        try {
            selectedObject = lo_pesquisa.getObjetoSelecionado();
            setTitle(" Editando curso: " + ((Curso) selectedObject).getNome());
        } catch (Exception ignored) {
            selectedObject = null;
        }

    }

    @Override
    public void update(Object arg) {
        try {
            Curso curso = (Curso) arg;
            txfCurso.setText(curso.getNome());
            txfQtdCreditos.setText(Integer.toString(curso.getQtdCreditos()));
            txfValorCreditos.setText(Double.toString(curso.getValorCreditos()));
        } catch (Exception ignored) {

        }
    }
}
