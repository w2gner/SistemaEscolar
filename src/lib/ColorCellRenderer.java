package			lib;

import			java.awt.Color;

import			javax.swing.table.DefaultTableCellRenderer;

public class		ColorCellRenderer
	extends		DefaultTableCellRenderer
{

	private static final long serialVersionUID = 1L;
	
	protected		Color[]
	ia_color		=	null;
	
	/**
	Seta as cores das linhas da tabela. 
	@param	la_color
		Define as cores de cada linha.
	*/
	public
	void			LineColor
				(
					Color[]			la_color
				)
	{
		ia_color		=	la_color;
	}

}
