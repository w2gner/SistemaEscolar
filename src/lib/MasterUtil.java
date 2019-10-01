//
// Pacote ao qual a classe pertence
//
package lib;

import java.io.File;

//
// Importa as bibliotecas VBI
//

//
// Importa as bibliotecas V&SPague
//

//
// Importa as bibliotecas Java
//

/**
 * 
 * @author Matheus Leandro Ferreira
 * @version $Revision: 0.0 $
 * 
 *          <pre font=helvetica>
==================================== VBI =======================================
Arquivo		:	$RCSfile: MasterUtil.java,v $
Projeto		:	MasterSys
Plataforma	:	Gen�rica
Cria��o		:	12/04/2011
Descri��o	:	(Descri��o detalhada da fun��o da classe).
 *          </pre>
 * 
 *          <br>
 * 
 *          <pre font=helvetica>
================================= HIST�RICO ====================================

$Log: MasterUtil.java,v $
 *          </pre>
 */

public class MasterUtil {
	/*
	 * ======================================================================
	 * 
	 * Alignment methods.
	 * 
	 * ======================================================================
	 */

	/**
	 * Alinha � esquerda.
	 */
	public static final int ALIGN_LEFT = 1;

	/**
	 * Alinha � direita.
	 */
	public static final int ALIGN_RIGHT = 2;

	/**
	 * Alinha no centro.
	 */
	public static final int ALIGN_CENTER = 3;

	/**
	 * Preenche ajustando o resultado � largura m�xima.
	 */
	public static final int ALIGN_JUSTIFY = 4;

	/**
	*/
	public static final String Align(final String as_source, final int an_length, final int an_align_option) {
		return (Align(as_source, an_length, an_align_option, " "));
	}

	/**
	 * Alinha um <b>String</b> de acordo com os argumentos. Caso o tamanho final
	 * seja menor que o tamanho original, o <b>String</b> resultante ser� truncada
	 * de acordo com a forma de alinhamento.
	 * 
	 * @param as_source       <b>String</b> a ser alinhado.
	 * @param an_length       Tamanho do <b>String</b> a retornar contendo o
	 *                        <b>String</b> original alinhado.
	 * @param an_align_option Op��es de alinhamento de acordo com as constantes:
	 *                        ALIGN_LEFT Alinha a <b>String</b> a esquerda
	 *                        prenchendo a direita com o caractere de preenchimento.
	 *                        ALIGN_RIGHT Alinha a <b>String</b> a direita
	 *                        prenchendo a esquerda com os caracteres de
	 *                        preenchimento. ALIGN_CENTER Alinha a <b>String</b> no
	 *                        centro prenchendo as laterais com o caractere de
	 *                        preenchimento. ALIGN_JUSTIFY Preenche entre os
	 *                        caracteres da <b>String</b> com o tantos caracteres de
	 *                        preenchimento quantos forem necess�rios para que a
	 *                        <b>String</b> original ocupe o espa�o ao m�ximo da
	 *                        <b>String</b> final.
	 * @param as_filler       Caractere a ser utilizado para preenchimento. Quando
	 *                        n�o especificado ser� utilizado o espa�o como padr�o.
	 * @return <b>String</b> resultante do alinhamento. Retornar� nulo se a
	 *         <b>String</b> origem for nula..
	 * @throws IllegalArgumentException
	 */
	public static final String Align(final String as_source, final int an_length, final int an_align_option,
			final String as_filler) {
		//
		// Para conter o resultado ...
		//
		StringBuffer ls_result = null;

		//
		// Se string origem fornecida ...
		//
		if (as_source != null) {
			//
			// Se tamanho final v�lido ...
			//
			if (an_length >= 0) {
				//
				// Diferen�a de tamanho entre origem e destino ...
				//
				int ln_diference = an_length - as_source.length();

				//
				// Aloca a �rea necess�ria ...
				//
				ls_result = new StringBuffer(an_length);

				//
				// Determina o tipo de alinhamento ...
				//
				switch (an_align_option) {
				//
				// Esquerda ...
				//
				case ALIGN_LEFT: {
					//
					// Carrega alinhando a esquerda ...
					//
					ls_result = new StringBuffer(as_source);

					while (ls_result.length() < an_length) {
						ls_result.append(as_filler);
					}

					break;
				}

				//
				// Direita ...
				//
				case ALIGN_RIGHT: {
					//
					// Carrega alinhando a direita ...
					//
					ls_result = new StringBuffer(as_source
							.substring(ln_diference >= 0 ? 0 : as_source.length() - an_length));

					while (ls_result.length() < an_length) {
						ls_result.insert(0, as_filler);
					}

					break;
				}

				//
				// Centro ...
				//
				case ALIGN_CENTER: {
					//
					// Carrega centralizando ...
					//
					while (ls_result.length() < an_length) {
						ls_result.append(as_filler);
					}

					ls_result.insert(ln_diference > 0 ? ln_diference / 2 : 0,
							ln_diference > 0 ? as_source : as_source.substring(-ln_diference / 2));

					break;
				}

				//
				// Prenchendo ...
				//
				case ALIGN_JUSTIFY: {
					//
					// HIGH: Zig - a implementar
					//
					ls_result = new StringBuffer(as_source);

					break;
				}

				//
				// Inv�lido ...
				//
				default: {
					throw new IllegalArgumentException("Tipo de alinhamento inv�lido");
				}
				}
			}

			//
			// Se tamanho final inv�lido ...
			//
			else {
				throw new IllegalArgumentException(
						"O tamanho da do resultado final (" + an_length + ") n�o pode ser negativo");
			}
		}

		//
		// Retorna a string alinhada ...
		//
		return (ls_result.substring(0, an_length));
	}

	public static void MakeBackup() {
		//
		// Define o diret�rio default.
		//
		File lo_diretorio = new File("./Backup");

		//
		// Arquivo default de backup.
		//
		File lo_arquivo = new File("./Backup/MasterSysBackup.dmp");

		boolean lb_run_process = true;

		//
		// Se n�o existir o diret�rio.
		//
		if (!lo_diretorio.isDirectory()) {
			//
			// Cria o diret�rio default.
			//
			new File("./Backup").mkdir();
		}

		try {
			//
			// Se j� existe um arquivo de backup ...
			//
			if (lo_arquivo.isFile()) {
				//
				// Pergunta se deseja substituir o arquivo.
				//
				if (MasterWindowMessage.QuestionShow("MasterSys - Backup",
						"J� existe um arquivo de backup na pasta, deseja substitui-lo ?") == MasterWindowMessage.YES_OPTION) {
					//
					// Deleta o arquivo.
					//
					lo_arquivo.delete();
				} else {
					lb_run_process = false;
				}
			}

			//
			// Se for para rodar o processo de backup ...
			//
			if (lb_run_process) {
				if (new File("./bkp.bat").isFile()) {
					//
					// Roda o processo de backup.
					//
					Process lo_process = Runtime.getRuntime().exec("./bkp.bat admin admin");

					//
					// Aguarda at� ser finalizado.
					//
					lo_process.waitFor();

					//
					// Recebe a resposta do processo.
					//
					int lo_id = lo_process.exitValue();

					if (lo_id == 0) {
						MasterWindowMessage.InformationShow("MasterSys - Backup", "Backup criado com Sucesso !");
					} else {
						MasterWindowMessage.InformationShow("MasterSys - Backup", "Falha ao criar Backup");
					}
				} else {
					MasterWindowMessage.InformationShow("MasterSys - Backup",
							"Arquivo de execu��o (.bat) n�o encontrado !");
				}
			}
		} catch (Exception ex) {
			MasterWindowMessage.InformationShow("MasterSys - Backup",
					"Falha ao criar Backup \r\n\r\n" + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
