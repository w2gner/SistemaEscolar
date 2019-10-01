package lib;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaPadrao {

	public JScrollPane sp_padrao;

	public JTable tb_padrao;

	public ProjetoTableModel modelo;

	/**
	 * Construtor padr�o da classe
	 * 
	 * @param colunas
	 * @param largura_colunas
	 */
	public TabelaPadrao(String[] colunas, Class<?>[] classes, int[] largura_colunas) {
		this(null, colunas, null, classes, largura_colunas);
	}

	/**
	 * Construtor padr�o da classe
	 * 
	 * @param dados
	 * @param colunas
	 * @param edicao
	 * @param classes
	 * @param largura_colunas
	 */
	public TabelaPadrao(ArrayList<Object> dados, String[] colunas, boolean[] edicao, Class<?>[] classes,
			int[] largura_colunas) {
		//
		// Cria o modelo da tabela
		//
		modelo = new ProjetoTableModel(dados, colunas, edicao, classes);

		//
		// Cria tabela padrao (NORMAL)
		//
		tb_padrao = new JTable(modelo);

		//
		// Seta atributos padr�es de sele��o da tabela
		//
		tb_padrao.setAutoCreateColumnsFromModel(false);
		tb_padrao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//
		// Define a largura das colunas
		//
		for (int i = 0; i < largura_colunas.length; i++) {
			tb_padrao.getColumnModel().getColumn(i).setPreferredWidth(largura_colunas[i]);
		}

		//
		// Seta os renderers padr�es da tabela
		//
		tb_padrao.setDefaultRenderer(Integer.class, new IntegerCellRenderer());
		tb_padrao.setDefaultRenderer(String.class, new StringCellRenderer());
		tb_padrao.setDefaultRenderer(Date.class, new DateCellRenderer());
		tb_padrao.setDefaultRenderer(BigDecimal.class, new NumberCellRenderer());

		//
		// Cria o scrollpane adicionando a tabela a ele
		//
		sp_padrao = new JScrollPane(tb_padrao);

		// Cria a tabela com o modelo (COM EFEITO ZEBRA)
		/*
		 * tb_padrao = new JTable(modelo){ public Component
		 * prepareRenderer(TableCellRenderer renderer, int row, int column){ Component c
		 * = super.prepareRenderer(renderer, row, column); if (row % 2 == 0){
		 * c.setBackground(Color.LIGHT_GRAY); } else{ c.setBackground(getBackground());
		 * } return c; } };
		 */
	}
}
