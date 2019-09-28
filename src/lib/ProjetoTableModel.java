package lib;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;

public class ProjetoTableModel extends AbstractTableModel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private List<Object> linhas = null;

	private String[] colunas = null;

	private boolean[] colunas_edicao = null;

	private Class<?>[] classes_colunas = null;

	/**
	 * Construtor da Classe, passando apenas as colunas.
	 * 
	 * @param colunas
	 */
	public ProjetoTableModel(String[] colunas) {
		//
		// Chama o construtor completo
		//
		this(null, colunas, null, null);
	}

	/**
	 * Construtor da Classe, passando as colunas e suas respectivas classes.
	 * 
	 * @param colunas
	 */
	public ProjetoTableModel(String[] colunas, Class<?>[] classes) {
		//
		// Chama o construtor completo
		//
		this(null, colunas, null, classes);
	}

	/**
	 * Construtor da Classe, passando as colunas e suas respectivas classes.
	 * 
	 * @param colunas
	 */
	public ProjetoTableModel(String[] colunas, boolean[] edicao, Class<?>[] classes) {
		//
		// Chama o construtor completo
		//
		this(null, colunas, edicao, classes);
	}

	/**
	 * Construtor da Classe
	 * 
	 * @param dados
	 * @param colunas
	 * @param edicao
	 */
	public ProjetoTableModel(ArrayList<Object> dados, String[] colunas, boolean[] edicao) {
		//
		// Chama o construtor completo
		//
		this(dados, colunas, edicao, null);
	}

	/**
	 * Construtor Completo da Classe
	 * 
	 * @param dados
	 * @param colunas
	 * @param edicao
	 * @param classes
	 */
	public ProjetoTableModel(ArrayList<Object> dados, String[] colunas, boolean[] edicao, Class<?>[] classes) {
		//
		// Seta as linhas do modelo
		//
		if (dados == null) {
			setLinhas(new ArrayList<Object>());
		} else {
			setLinhas(dados);
		}

		//
		// Seta as colunas do modelo
		//
		setColunas(colunas);

		//
		// Seta a edi��o das colunas
		//
		if (edicao == null) {
			//
			// Instancia o array de edicao
			//
			colunas_edicao = new boolean[colunas.length];

			//
			// Define todas as colunas da tabela como n�o edit�veis
			//
			for (int i = 0; i < colunas_edicao.length; i++) {
				//
				// Seta false para edi��o da coluna
				//
				colunas_edicao[i] = false;
			}
		} else {
			colunas_edicao = edicao;
		}

		//
		// Seta as classes das colunas
		//
		if (classes == null) {
			//
			// Instancia o array de classes
			//
			classes_colunas = new Class<?>[colunas.length];

			//
			// Define todas as colunas da tabela como Object por padr�o
			//
			for (int i = 0; i < classes_colunas.length; i++) {
				//
				// Seta a classe para a coluna
				//
				classes_colunas[i] = Object.class;
			}
		} else {
			classes_colunas = classes;
		}
	}

	/**
	 * Retorna um array com as colunas da tabela
	 */
	public String[] getColunas() {
		return colunas;
	}

	/**
	 * Retorna uma lista com os dados da tabela
	 * 
	 * @return linhas
	 */
	public List<Object> getLinhas() {
		return linhas;
	}

	/**
	 * Seta as colunas da tabela
	 */
	public void setColunas(String[] strings) {
		colunas = strings;
	}

	/**
	 * Seta as linhas da tabela
	 */
	public void setLinhas(List<Object> list) {
		linhas = list;
	}

	/**
	 * Retorna a quantidade de colunas da tabela
	 */
	public int getColumnCount() {
		return getColunas().length;
	}

	/**
	 * Retorna a classe de coluna solicitada
	 */
	public Class<?> getColumnClass(int col) {
		return classes_colunas[col];
	}

	/**
	 * Retorna o n�mero de linhas existentes na tabela
	 */
	public int getRowCount() {
		return getLinhas().size();
	}

	/**
	 * Informa se � poss�vel editar determinada celula
	 */
	public boolean isCellEditable(int row, int col) {
		return colunas_edicao[col];
	}

	/**
	 * Retorna o valor de determinada c�lula
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			Object[] linha = (Object[]) getLinhas().get(rowIndex);

			return linha[columnIndex];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * Seta o valor de determinada c�lula
	 */
	public void setValueAt(Object value, int row, int col) {
		Object[] linha = (Object[]) getLinhas().get(row);

		linha[col] = (Object) value;

		fireTableCellUpdated(row, col);
	}

	/**
	 * Seta a classe de determinada coluna
	 * 
	 * @param col    Indice da coluna
	 * @param classe Classe a ser setada na coluna
	 */
	public void setColumnClass(int col, Class<?> classe) {
		classes_colunas[col] = classe;
	}

	/**
	 * Adiciona uma linha na tabela
	 * 
	 * @param dadosLinha Array de objetos contendo o valor de cada coluna
	 */
	public void addRow(Object[] dadosLinha) {
		getLinhas().add(dadosLinha);

		int linha = getLinhas().size() - 1;

		fireTableRowsInserted(linha, linha);
	}

	/**
	 * Remove determinada linha da tabela
	 * 
	 * @param row Linha a ser removida
	 */
	public void removeRow(int row) {
		//
		// Se a linha � maior que zero e menor que o tamanho do modelo
		//
		if (row >= 0 && row < getLinhas().size()) {
			getLinhas().remove(row);

			//
			// Informa a jtable que houve dados deletados passando a
			// linha removida
			//
			fireTableRowsDeleted(row, row);
		}
	}

	/**
	 * Remove a linha pelo valor da coluna informada
	 * 
	 * @param val Valor a ser encontrado na coluna
	 * @param col Coluna a ser pesquisada
	 * @return true se conseguiu remover
	 */
	public boolean removeRow(String val, int col) {
		//
		// Obtem o iterator
		//
		Iterator<Object> i = getLinhas().iterator();

		int linha = 0;

		//
		// Faz um looping em cima das linhas
		//
		while (i.hasNext()) {
			//
			// Obtem as colunas da linha atual
			//
			String[] linhaCorrente = (String[]) i.next();

			linha++;

			//
			// Compara o conteudo String da linha atual na coluna desejada
			// com o valor informado
			//
			if (linhaCorrente[col].equals(val)) {
				getLinhas().remove(linha);

				//
				// Informa a jtable que houve dados deletados,
				// passando a linha removida
				//
				fireTableRowsDeleted(linha, linha);

				return true;
			}
		}

		//
		// Nao encontrou nada
		return false;
	}

	/**
	 * Remove todas as linhas existentes
	 */
	public void removeAllRows() {
		if (linhas.size() > 0) {
			int total = linhas.size() - 1;

			linhas.removeAll(linhas);

			fireTableRowsDeleted(0, total);
		}
	}

	/**
	 * Retorna o nome da coluna determinada
	 */
	public String getColumnName(int col) {
		return getColunas()[col];
	}

}
