//
// Pacote ao qual a classe pertence
//
package lib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;


public class		MasterWindowMessage
	extends		JDialog
{

	private static final	long
	serialVersionUID	=	986649505568430925L;
	
        /*======================================================================
        
        Constants
        
        ======================================================================*/

	public static final	int
	QUESTION		=	0,
	INFORMATION		=	1,
	WARNING			=	2,
	ERROR			=	3;
	
	public static final	Object
	OK_OPTION		=	"Ok",
	CANCEL_OPTION		=	"Cancelar",
	YES_OPTION		=	"Sim",
	NO_OPTION		=	"N�o",
	NULL_OPTION		=	null;
	
	public static final	Object[]
	OK_CANCEL_OPTIONS	=	new Object[]{OK_OPTION, CANCEL_OPTION},
	YES_NO_OPTIONS		=	new Object[]{YES_OPTION, NO_OPTION},
	YES_NO_CANCEL_OPTIONS	=	new Object[]{YES_OPTION, NO_OPTION, CANCEL_OPTION},
	OK_OPTIONS		=	new Object[]{OK_OPTION};
	
	private static final	String
	CHOICE_KEY		=	"<Choice Object>";
	
	private			Object
	io_choice		=	NULL_OPTION;
	
	private			JTextComponent
	io_input;

	
        /*======================================================================
        
        Constructors
        
        ======================================================================*/
	
	@SuppressWarnings("serial")
	private			MasterWindowMessage
				(
					final String		as_title,
					final Object		ao_message,
					final int		an_type,
					final Object[]		ao_options,
					final JTextComponent	ao_input,
					final Object		ao_option_default
				)
	{
		super
		(
			new JFrame(as_title),
			true			
		);
		
		setSize(400,160);
		super.setContentPane(new JPanel(new GridBagLayout()));
		
		if	(
				ao_options		==	null
				||
				ao_options.length	==	0
			)
		{
			throw	new IllegalArgumentException("Options must be specified");
		}
		
		//
		// Set icon ...
		//
		Icon
		lo_icon			=	null;
		
		switch	(an_type)
		{
			case	QUESTION:
			{
				//lo_icon			=	MasterImage.dialog_question_48x48;
				break;
			}
			
			case	INFORMATION:
			{
				//lo_icon			=	MasterImage.dialog_information_48x48;
				break;
			}
			
			case	WARNING:
			{
				//lo_icon			=	MasterImage.dialog_warning_48x48;
				break;
			}
			
			case	ERROR:
			{
				//lo_icon			=	MasterImage.dialog_error_48x48;
				break;
			}
			
			default:
			{
				throw	new IllegalArgumentException("Message type invalid");
			}
		}
		
		getContentPane().add
		(
			new JLabel
			(
				
			)
			{
				{
					//
					// Set icon size ...
					//
					setPreferredSize(new Dimension(60, 60));
				}
			},
			new GridBagConstraints
			(
				0,
				0,
				1,
				1,
				0,
				0,
				GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE,
				new Insets(0,0,0,0),
				0,
				0
			)
		);
		
		//
		// Adiciona a mensagem do erro
		//
		getContentPane().add
		(
			new JPanel
			(
				new BorderLayout()
			)
			{
				{
					add
					(
						(JComponent)
						(
							ao_message		instanceof	JComponent
								?	ao_message
								:	new JTextArea
									(
										ao_message		!=	null
											?	ao_message.toString()
											:	"(without message)"
									)
									{
										{
											setFont(new JLabel().getFont());
											setBackground(getContentPane().getBackground());
											setEditable(false);
											setFocusable(false);
										}
									}
						),
						BorderLayout.CENTER
					);
				}
			},
			new GridBagConstraints
			(
				1,
				0,
				1,
				1,
				100,
				0,
				GridBagConstraints.NORTHWEST,
				GridBagConstraints.BOTH,
				new Insets(18,5,10,10),
				0,
				0
			)
		);

		//
		// If input object specified, add it ...
		//
		if	(
				ao_input		!=	null
			)
		{
			io_input		=	ao_input;

			io_input.addKeyListener
			(
				new KeyAdapter()
				{	
					public 
					void			keyPressed
								(
									KeyEvent		evt
								)
					{
						//
						// Se for clicado na tecla ENTER e existir conteudo no campo.
						//
						if	(
								evt.getKeyChar()	==	KeyEvent.VK_ENTER
								&&
								io_input.getText().length()
											!=	0
							)
						{
							//
							// Marca a op��o OK_OPTION.
							//
							io_choice		=	OK_OPTION;
									
							//
							// Fecha a janela.
							//
							dispose();
						}
						
						//
						// Se for clicado nas teclas ESC.
						//
						else if	(
								evt.getKeyChar()	==	KeyEvent.VK_ESCAPE
							)
						{
							//
							// Marca a op��o OK_OPTION.
							//
							io_choice		=	CANCEL_OPTION;
							
							//
							// Fecha a janela.
							//
							dispose();	
						}
					}
				}
			);    
			
			//
			// adiciona o painel temporario
			//
			getContentPane().add
			(
				io_input,
				new GridBagConstraints
				(
					0,
					1,
					2,
					1,
					100,
					100,
					GridBagConstraints.NORTHWEST,
					GridBagConstraints.BOTH,
					new Insets(0, 5, 0, 5),
					0,
					0
				)
			);
		}
		
		else
		{
			//
			// adiciona o painel temporario
			//
			getContentPane().add
			(
				new JPanel(),
				new GridBagConstraints
				(
					0,
					1,
					2,
					1,
					100,
					100,
					GridBagConstraints.NORTHWEST,
					GridBagConstraints.BOTH,
					new Insets(0, 5, 0, 5),
					0,
					0
				)
			);
		}
				
		//
		// Adiciona os bot�es
		//
		getContentPane().add
		(
			new JPanel(new BorderLayout())
			{
				{
					add
					(
						new JPanel()
						{
							
							{
								for	(
										int
										ln			=	0
										;
										ln			<	ao_options.length
										;
										ln++
									)
								{									
									final			int
									ln_option_index		=	ln;
									
									add
									(
										new JButton
										(
											new AbstractAction(ao_options[ln_option_index].toString())
											{
												{
													putValue(CHOICE_KEY, ao_options[ln_option_index]);
												}
												
												public
												void			actionPerformed
															(
																ActionEvent		e
															)
												{
													io_choice		=	getValue(CHOICE_KEY);
													dispose();
												}
											}										
										)
										{
											{		
												getInputMap(WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put
												(
													KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
													"action"
												);
												
												//
												// Adiciona o evento ao mapa de eventos ...
												//
												getActionMap().put
												(
													"action",
													getAction()
												);												
											}
										}
									);
								}
							}
						},
						BorderLayout.EAST
					);	
				}
			},
			new GridBagConstraints
			(
				1,
				2,
				1,
				1,
				0,
				0,
				GridBagConstraints.SOUTH,
				GridBagConstraints.BOTH,
				new Insets(0,0,0,0),
				0,
				0
			)
		);
		
		pack();
		
		//
		// Gets the size of the screen. On systems with multiple displays, the primary display is used.
		//
		Dimension
		lo_dm_screen_size	=	Toolkit.getDefaultToolkit().getScreenSize();

		//
		// Moves and resizes this component. The new location of the top-left corner is specified by x and y,
		// and the new size is specified by width and height.
		//
		setBounds
		(
			(lo_dm_screen_size.width - getWidth()) / 2,
			(lo_dm_screen_size.height - getHeight()) / 2,
			getWidth(),
			getHeight()
		);
		
		//
		// Se existe op��o default
		// Adiciona o listener que colocar� a op��o default em foco
		//
		if	(
				ao_option_default	!=	null
			)
		{
			addWindowListener
			(
				new WindowAdapter()
				{
					public
					void			windowOpened
								(
									WindowEvent		e
								)
					{
						JPanel
						lo_button_panel		=	(JPanel)((JPanel)getContentPane().getComponent(getContentPane().getComponentCount()-1)).getComponent(0);
						
						//
						// Percorre os bot�es do componente.
						//
						for	(
								int
								ln			=	0
								;
								ln			<	lo_button_panel.getComponentCount()
								;
								ln++
							)
						{
							//
							// Se for uma op��o v�lida.
							//
							if	(
									((JButton)lo_button_panel.getComponent(ln)).getAction().getValue(CHOICE_KEY)
												==	ao_option_default
								)
							{
								//
								// Se n�o existir um componente para digita��o de texto.
								//
								if	(
										io_input		==	null
									)
								{
									//
									// Requisita foco aos bot�es.
									//
									((JButton)lo_button_panel.getComponent(ln)).requestFocusInWindow();
								}
								
								break;
							}
						}
					}
				}
			);
		}
		
		//
		// Show window ...
		// 
		setVisible(true);
	}

	
        /*======================================================================
        
        Methods
        
        ======================================================================*/
	
	public static
	Object			Show
				(
					final String		as_title,
					final Object		ao_message,
					final int		an_type,
					final Object[]		ao_options
				)
	{
		return
		(
			Show
			(
				as_title,
				ao_message,
				an_type,
				ao_options,
				null,
				null
			)
		);
	}
	
	public static
	Object			Show
				(
					final String		as_title,
					final Object		ao_message,
					final int		an_type,
					final Object[]		ao_options,
					final Object		ao_default_option
				)
	{
		return
		(
			Show
			(
				as_title,
				ao_message,
				an_type,
				ao_options,
				null,
				ao_default_option
			)
		);
	}
	
	public static
	Object			Show
				(
					final String		as_title,
					final Object		ao_message,
					final int		an_type,
					final Object[]		ao_options,
					final JTextComponent	ao_input,
					final Object		ao_default_option
				)
	{
		return
		(
			new MasterWindowMessage
			(
				as_title,
				ao_message,
				an_type,
				ao_options,
				ao_input,
				ao_default_option
			).io_choice
		);
	}	
	
	public static
	void			InformationShow
				(
					final String		as_title,
					final Object		ao_message
				)
	{
		Show
		(
			as_title,
			ao_message,
			INFORMATION,
			TypeOptionDefaultGet(INFORMATION),
			null
		);
	}
	
	public static
	void			InformationShow
				(
					final String		as_title,
					final Object		ao_message,
					final boolean		ab_command
				)
	{
		Show
		(
			as_title,
			ao_message,
			INFORMATION,
			TypeOptionDefaultGet(INFORMATION),
			null,
			ab_command
		);
	}
	
	public static
	Object			QuestionShow
				(
					final String		as_title,
					final Object		ao_message
				)
	{
		return
		(
			Show
			(
				as_title,
				ao_message,
				QUESTION,
				TypeOptionDefaultGet(QUESTION),
				null
			)
		);
	}
	
	public static
	Object			QuestionShow
				(
					final String		as_title,
					final Object		ao_message,
					final boolean		ab_command
				)
	{
		return
		(
			Show
			(
				as_title,
				ao_message,
				QUESTION,
				TypeOptionDefaultGet(QUESTION),
				null,
				ab_command
			)
		);
	}
	
	public static
	Object			WarningShow
				(
					final String		as_title,
					final Object		ao_message
				)
	{
		return
		(
			Show
			(
				as_title,
				ao_message,
				WARNING,
				TypeOptionDefaultGet(WARNING),
				null
			)
		);
	}
	
	public static
	Object			WarningShow
				(
					final String		as_title,
					final Object		ao_message,
					final boolean		ab_command
				)
	{
		return
		(
			Show
			(
				as_title,
				ao_message,
				WARNING,
				TypeOptionDefaultGet(WARNING),
				null,
				ab_command
			)
		);
	}
	
	public static
	Object			ErrorShow
				(
					final String		as_title,
					final Object		ao_message
				)
	{
		return
		(
			Show
			(
				as_title,
				ao_message,
				ERROR,
				TypeOptionDefaultGet(ERROR),
				null
			)
		);
	}
	
	public static
	Object			ErrorShow
				(
					final String		as_title,
					final Object		ao_message,
					final boolean		ab_command
				)
	{
		return
		(
			Show
			(
				as_title,
				ao_message,
				ERROR,
				TypeOptionDefaultGet(ERROR),
				null,
				ab_command
			)
		);
	}
	
	public static
	Object			QuestionInputShow
				(
					final String		as_title,
					final Object		ao_message
				)
	{
		MasterWindowMessage
		lo_message		=	new MasterWindowMessage
						(
							as_title,
							ao_message,
							QUESTION,
							new Object[]
							{
								OK_OPTION,
								CANCEL_OPTION
							},
							new JTextField(),
							OK_OPTION
						);
		
		return
		(
			lo_message.io_choice	==	OK_OPTION
				?	lo_message.io_input.getText()
				:	lo_message.io_choice
		);
	}
	
	public static
	Object[]		TypeOptionDefaultGet
				(
					final int		an_type
				)
	{
		Object[]
		lo_return		=	null;
		
		switch	(an_type)
		{
			case	QUESTION:
			{
				lo_return		=	YES_NO_OPTIONS;
				break;
			}
			
			case	ERROR:
			{
				lo_return		=	OK_OPTIONS;
				break;
			}
			
			case	INFORMATION:
			{
				lo_return		=	OK_OPTIONS;
				break;
			}
			
			case	WARNING:
			{
				lo_return		=	OK_CANCEL_OPTIONS;
				break;
			}
		}
		
		return	(lo_return);
	}
	
	/**
        Redefine a posi��o e o tamanho da janela.
        Este m�todo bloqueia o tamanho m�nimo da janela para 400x160 pixels 
        */
	@Override
	public final
	void			setBounds
				(
					final int		an_x,
					final int		an_y,
					final int		an_width,
					final int		an_height
				)
	{
		//
		// Chama a implementa��o do pai.
		//
		super.setBounds
		(
			an_x,
			an_y,
			an_width		<	400
				?	400
				:	an_width,
			an_height		<	160
				?	160
				:	an_height
		);
	}
}

