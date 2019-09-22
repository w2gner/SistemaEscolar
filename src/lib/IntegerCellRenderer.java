package lib;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class IntegerCellRenderer extends ColorCellRenderer {

	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int col) {
		String valor = String.valueOf(value);
		JLabel renderer = new JLabel(valor, SwingConstants.CENTER);

		if (isSelected) {
			renderer.setOpaque(true);
			renderer.setBackground(table.getSelectionBackground());
			renderer.setForeground(table.getSelectionForeground());
		} else {
			renderer.setOpaque(true);
			renderer.setBackground(ia_color != null ? ia_color[row] != null ? ia_color[row] : table.getBackground()
					: table.getBackground());
			renderer.setForeground(table.getForeground());
		}

		if (hasFocus) {
			renderer.setOpaque(true);
			renderer.setBackground(table.getSelectionBackground());
			renderer.setForeground(table.getSelectionForeground());
		}

		return renderer;
	}
}