package			lib;

import			java.awt.Component;
import			java.awt.Font;
import			java.math.BigDecimal;
import			java.text.DecimalFormat;

import			javax.swing.JLabel;
import			javax.swing.JTable;
import			javax.swing.SwingConstants;
import			javax.swing.table.DefaultTableCellRenderer;

public class		NumberCellRenderer
	extends		ColorCellRenderer
{

	private static final long serialVersionUID = 1L;
	
	public
	Component		getTableCellRendererComponent
				(
					JTable			table,
					Object			value,
					boolean			isSelected,
					boolean			hasFocus,
					int			row,
					int			col
				)
	{
		BigDecimal
		lo_value		=	(BigDecimal) value;
		
		JLabel
		renderer		=	new JLabel
						(
							lo_value			==	null
								?	"0,00"
								:	new DecimalFormat(",##0.00").format(lo_value)
							,
							SwingConstants.CENTER
						);
		
		renderer.setFont(new Font("Verdana", Font.PLAIN, 12));
		
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
