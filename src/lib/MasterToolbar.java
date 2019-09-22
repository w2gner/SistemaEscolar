//
// Pacote ao qual a classe pertence
//
package			lib;

//
//Importa as bibliotecas Java
//
import			javax.swing.JPanel;

import java.awt.BorderLayout;
import			java.awt.GridBagLayout;
import			javax.swing.JToolBar;
import			java.awt.GridBagConstraints;
import			javax.swing.JButton;
import			java.awt.Insets;
import			javax.swing.JSeparator;

/**

@author		Matheus Leandro Ferreira
@version	$Revision: 0.0 $

======================================================================
Arquivo		:	$RCSfile: MasterToolbar.java,v $
Projeto		:	MasterSys
Cria��o		:	21/02/2011
Descri��o	:	Componente de navegacao.
======================================================================

*/


public class 		MasterToolbar 
	extends		JPanel
{
	//
	// Bot�es.
	//
	public			JButton 
	io_btn_buscar,
	io_btn_adicionar,
	io_btn_remover,
	io_btn_salvar;

	/**
	Monta a toolbar.
	*/
	public			MasterToolbar()
	{		
		super(new BorderLayout());
		
		//
		// Cria a toolbar.
		//
		JToolBar 
		toolBar			=	new JToolBar();	
		add(toolBar, BorderLayout.PAGE_START);
		
		//
		// Crias os botoes.
		//
		io_btn_buscar		=	new JButton("Buscar");
		toolBar.add(io_btn_buscar);
		
		JSeparator 
		io_spt_buscar		=	new JSeparator();
		toolBar.add(io_spt_buscar);
		
		io_btn_adicionar	=	new JButton("Adicionar");
		toolBar.add(io_btn_adicionar);
		
		JSeparator 
		io_spt_adicionar	=	new JSeparator();
		toolBar.add(io_spt_adicionar);
		
		io_btn_remover		=	new JButton("Remover");
		toolBar.add(io_btn_remover);
		
		JSeparator 
		io_spt_remover		=	new JSeparator();
		toolBar.add(io_spt_remover);
		
		io_btn_salvar		=	new JButton("Salvar");
		toolBar.add(io_btn_salvar);
	}
}
