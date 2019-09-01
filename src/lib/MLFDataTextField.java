/*
Importa o pacote pertecente a esta classe.
*/
package lib;

/*
Importa as bibliotecas necessárias.
*/
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * 
 * @author Matheus Leandro Ferreira
 * @version $Revision: 0.0 $
 * 
 *          ======================================================================
 *          Arquivo : $RCSfile: MLFDataTextField.java,v $ Projeto : MLFLib
 *          Criação : 13/03/2015 Descrição : Campo texto preparado para data.
 *          ======================================================================
 * 
 */

public class MLFDataTextField extends JFormattedTextField {
	private static final long serialVersionUID = 1L;

	/*
	 * Mascara do textfield
	 */
	private MaskFormatter io_mascara;

	/*
	 * Formato para realizar parse
	 */
	private SimpleDateFormat io_formato;

	/*
	 * Construtor
	 */
	public MLFDataTextField() {
		/*
		 * Chama o construtor da superclasse
		 */
		super();

		/*
		 * Adiciona evento de foco para que quando o foco chegar no campo o cursor ir
		 * para a posição inicial
		 */
		addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				setCaretPosition(0);
			}
		});

		/*
		 * Cria o objeto mascara
		 */
		try {
			io_mascara = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/*
		 * Define a mascara como formatadora do campo
		 */
		setFormatterFactory(new DefaultFormatterFactory(io_mascara));

		/*
		 * Cria o formato de data para conversões entre String e Date
		 */
		io_formato = new SimpleDateFormat("dd/MM/yyyy");

		/*
		 * Seta a fonte para manter o espaço no campo
		 */
		setFont(new Font("Monospaced", Font.PLAIN, 12));

		/*
		 * Alinha os dados no centro do campo
		 */
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	/**
	 * Método responsável por gerar um Objeto Date.
	 * 
	 * @return Retorna o objeto Date referente ao texto do campo.
	 */
	public Date getDate() {
		try {
			/*
			 * Cria uma date com o texto do componente
			 */
			Date lo_data = io_formato.parse(getText());

			/*
			 * Retorna o objeto Date
			 */
			return lo_data;
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * Este método pega um objeto Date e converte diretamente para String, para
	 * mostrar no campo.
	 * 
	 * @param ao_data Objeto Date a ser mostrado no campo.
	 */
	public void setDate(Date ao_data) {
		try {
			setText(io_formato.format(ao_data));
		} catch (NullPointerException e) {
			setText("");
		}
	}
}