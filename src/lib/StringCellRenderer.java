package lib;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class		StringCellRenderer
	extends		ColorCellRenderer
{

	private static final long serialVersionUID = 1L;
	
	public Component getTableCellRendererComponent(JTable table,
													Object value,
													boolean isSelected,
													boolean hasFocus,
													int row,
													int col)
	{
		String valor = String.valueOf(value);
		JLabel renderer = new JLabel(valor);
		renderer.setFont(new Font("Verdana",Font.PLAIN,12));
		
		if	(
				isSelected
			)
		{
			renderer.setOpaque(true);
			renderer.setBackground(table.getSelectionBackground());
			renderer.setForeground(table.getSelectionForeground());
		}
		else
		{
			renderer.setOpaque(true);
			renderer.setBackground
			(
				ia_color		!=	null
					?	ia_color[row]		!=	null
						?	ia_color[row]
						:	table.getBackground()
					:	table.getBackground()
			);
			renderer.setForeground(table.getForeground());
		}
		
		if	(
				hasFocus
			)
		{
			renderer.setOpaque(true);
			renderer.setBackground(table.getSelectionBackground());
			renderer.setForeground(table.getSelectionForeground());
		}

		return renderer;
	}
}