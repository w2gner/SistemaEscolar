//
// Pacote ao qual a classe pertence
//
package lib;

//
// Importa as bibliotecas Master
//

//
// Importa as bibliotecas Java
//
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Matheus Leandro Ferreira
 * @version $Revision: 0.0 $
 * 
 *          ======================================================================
 *          Arquivo : $RCSfile: MasterPeriod.java,v $ Projeto : MasterSys
 *          Cria��o : 02/05/2011 Descri��o : Classe para controle de datas.
 *          ======================================================================
 * 
 * @Matheus 2011-18-04 - Cria��o da classe para controle de datas.
 * 
 */

public final class MasterPeriod implements Serializable {
	private static final long serialVersionUID = -6643075558149134692L;

	/*
	 * ======================================================================
	 * 
	 * Properties to save values.
	 * 
	 * ======================================================================
	 */

	/**
	 * Year quantity.
	 */
	public final long in_year;

	/**
	 * Month quantity.
	 */
	public final long in_month;

	/**
	 * Day quantity.
	 */
	public final long in_day;

	/**
	 * Hour quantity.
	 */
	public final long in_hour;

	/**
	 * Minute quantity.
	 */
	public final long in_minute;

	/**
	 * Second quantity.
	 */
	public final long in_second;

	/**
	 * Millisecond quantity.
	 */
	public final long in_millisecond;

	/*
	 * ======================================================================
	 * 
	 * Constants.
	 * 
	 * ======================================================================
	 */

	/*
	 * Divisors for miscelaneous calcules.
	 */

	/**
	 * Year peso.
	 */
	public static final long YEAR_PESO = 1000L * 60L * 60L * 24L * 30L * 12L;

	/**
	 * Month peso.
	 */
	public static final long MONTH_PESO = 1000L * 60L * 60L * 24L * 30L;

	/**
	 * Day peso.
	 */
	public static final long DAY_PESO = 1000L * 60L * 60L * 24L;

	/**
	 * Hour peso.
	 */
	public static final long HOUR_PESO = 1000L * 60L * 60L;

	/**
	 * Minute peso.
	 */
	public static final long MINUTE_PESO = 1000L * 60L;

	/**
	 * Second peso.
	 */
	public static final long SECOND_PESO = 1000L;

	/**
	 * Millisecond peso.
	 */
	public static final long MILLISECOND_PESO = 1L;

	/**
	 * One year.
	 */
	public static final MasterPeriod YEAR_1 = new MasterPeriod(YEAR_PESO);

	/**
	 * One month.
	 */
	public static final MasterPeriod MONTH_1 = new MasterPeriod(MONTH_PESO);

	/**
	 * 1 week.
	 */
	public static final MasterPeriod WEEK_1 = new MasterPeriod(0L, 0L, 7L, 0L, 0L, 0L, 0L);

	/**
	 * One day.
	 */
	public static final MasterPeriod DAY_1 = new MasterPeriod(DAY_PESO);

	/**
	 * 30 days.
	 */
	public static final MasterPeriod DAY_30 = new MasterPeriod(0L, 0L, 30L, 0L, 0L, 0L, 0L);

	/**
	 * One hour.
	 */
	public static final MasterPeriod HOUR_1 = new MasterPeriod(HOUR_PESO);

	/**
	 * 24 hour.
	 */
	public static final MasterPeriod HOUR_24 = new MasterPeriod(0L, 0L, 0L, 24L, 0L, 0L, 0L);

	/**
	 * One minute.
	 */
	public static final MasterPeriod MINUTE_1 = new MasterPeriod(MINUTE_PESO);

	/**
	 * One second.
	 */
	public static final MasterPeriod SECOND_1 = new MasterPeriod(SECOND_PESO);

	/**
	 * One second.
	 */
	public static final MasterPeriod SECOND_30 = new MasterPeriod(0L, 0L, 0L, 0L, 0L, 30L, 0L);

	/**
	 * One millisecond.
	 */
	public static final MasterPeriod MILLISECOND_1 = new MasterPeriod(MILLISECOND_PESO);

	/*
	 * Characters to format (toString) and parse VeSPeriod.
	 */
	private static final char YEAR_MASK = 'y', MONTH_MASK = 'M', DAY_MASK = 'd', HOUR_MASK = 'H', MINUTE_MASK = 'm',
			SECOND_MASK = 's', MILLISECOND_MASK = 'S';

	/*
	 * ======================================================================
	 * 
	 * Constructors.
	 * 
	 * ======================================================================
	 */

	/**
	 * Construct using a milliseconds value.
	 * 
	 * @param an_period A miliseconds value to be converted in years, mounths, days,
	 *                  hours, minutes, seconds and milliseconds, as follow:<br>
	 *                  1 second = 1000<br>
	 *                  1 minute = 60.000 (1000*60)<br>
	 *                  1 hour = 3.600.000 (1000*60*60)<br>
	 *                  1 day = 86.400.000 (1000*60*60*24)<br>
	 *                  1 month = 2.592.000.000 (1000*60*60*24*30)<br>
	 *                  1 year = 31.104.000.000 (1000*60*60*24*30*12)<br>
	 */
	public MasterPeriod(long an_period) {
		//
		// Calcula a quantidade de anos ...
		//
		an_period -= (in_year = an_period / YEAR_PESO) * YEAR_PESO;

		//
		// Calcula a quantidade de meses ...
		//
		an_period -= (in_month = an_period / MONTH_PESO) * MONTH_PESO;

		//
		// Calcula a quantidade de dias ...
		//
		an_period -= (in_day = an_period / DAY_PESO) * DAY_PESO;

		//
		// Calcula a quantidade de horas ...
		//
		an_period -= (in_hour = an_period / HOUR_PESO) * HOUR_PESO;

		//
		// Calcula a quantidade de minutos ...
		//
		an_period -= (in_minute = an_period / MINUTE_PESO) * MINUTE_PESO;

		//
		// Calcula a quantidade de segundos ...
		//
		an_period -= (in_second = an_period / SECOND_PESO) * SECOND_PESO;

		//
		// Calcula a quantidade de milisegundos ...
		//
		an_period -= (in_millisecond = an_period / MILLISECOND_PESO) * MILLISECOND_PESO;
	}

	/**
	 * Construct using data from a date.
	 * 
	 * @param ad_date Date used to construct the period.
	 */
	@SuppressWarnings("deprecation")
	public MasterPeriod(Date ad_date) {
		this(ad_date.getYear() + 1900L, ad_date.getMonth(), ad_date.getDay(), ad_date.getHours(), ad_date.getMinutes(),
				ad_date.getSeconds(), 0);
	}

	/**
	 * Construct with hour values.
	 * 
	 * @param an_hour        Hours quantity.
	 * @param an_minute      Minutes quantity.
	 * @param an_second      Seconds quantity.
	 * @param an_millisecond Milliseconds quantity.
	 */
	public MasterPeriod(final long an_hour, final long an_minute, final long an_second, final long an_millisecond) {
		this(0, 0, 0, an_hour, an_minute, an_second, an_millisecond);
	}

	/**
	 * Construct with date values.
	 * 
	 * @param an_year  Years quantity.
	 * @param an_month Months quantity.
	 * @param an_day   Days quantity.
	 */
	public MasterPeriod(final long an_year, final long an_month, final long an_day) {
		this(an_year, an_month, an_day, 0, 0, 0, 0);
	}

	/**
	 * Construct with all date/hour values.
	 * 
	 * @param an_year        Years quantity.
	 * @param an_month       Months quantity.
	 * @param an_day         Days quantity.
	 * @param an_hour        Hours quantity.
	 * @param an_minute      Minutes quantity.
	 * @param an_second      Seconds quantity.
	 * @param an_millisecond Milliseconds quantity.
	 */
	public MasterPeriod(final long an_year, final long an_month, final long an_day, final long an_hour,
			final long an_minute, final long an_second, final long an_millisecond) {
		//
		// Inicializa cada uma das propriedades ...
		//
		in_year = an_year;
		in_month = an_month;
		in_day = an_day;
		in_hour = an_hour;
		in_minute = an_minute;
		in_second = an_second;
		in_millisecond = an_millisecond;
	}

	/**
	 * Constructor using a <code>String</code>.
	 * 
	 * @param as_period <code>String</code> used to create <code>VeSPeriod</code>.
	 *                  Must be on <code>VeSPeriod.toString()</code> format.
	 */
	public MasterPeriod(final String as_period) throws IllegalArgumentException {
		//
		// Vari�vel para conter o valor sendo c�lculado
		//
		long ln_year = 0L, ln_month = 0L, ln_day = 0L, ln_hour = 0L, ln_minute = 0L, ln_second = 0L,
				ln_millisecond = 0L, ln_value = -1L;

		//
		// V�ri�veis de trabalho ...
		//
		int ln_index_start, ln_index_end = as_period.length(), ln_fase, ln_fase_current;

		//
		// Inicializa as fases ...
		//
		ln_fase = ln_fase_current = 99;

		//
		// Inicializa cada uma das propriedades ...
		//
		for (ln_index_start = ln_index_end - 1; ln_index_start >= 0; ln_index_start--) {
			//
			// Trata cada uma das propriedades ...
			//
			switch (as_period.charAt(ln_index_start)) {
			//
			// Se � o ano carrega a sua fase ...
			//
			case YEAR_MASK: {
				ln_fase = 1;
				break;
			}

			//
			// Se � o m�s carrega a sua fase ...
			//
			case MONTH_MASK: {
				ln_fase = 2;
				break;
			}

			//
			// Se � o dia carrega a sua fase ...
			//
			case DAY_MASK: {
				ln_fase = 3;
				break;
			}

			//
			// Se � a hora carrega a sua fase ...
			//
			case HOUR_MASK: {
				ln_fase = 4;
				break;
			}

			//
			// Se � o minuto carrega a sua fase ...
			//
			case MINUTE_MASK: {
				ln_fase = 5;
				break;
			}

			//
			// Se � o segundo carrega a sua fase ...
			//
			case SECOND_MASK: {
				ln_fase = 6;
				break;
			}

			//
			// Se � o milisegundo carrega a sua fase ...
			//
			case MILLISECOND_MASK: {
				ln_fase = 7;
				break;
			}
			}

			//
			// Se mudou de fase ...
			//
			if (ln_fase != ln_fase_current) {
				//
				// Se fase consistente ...
				//
				if (ln_fase < ln_fase_current) {
					//
					// Carrega o valor do periodo ...
					//
					ln_value = Long.parseLong(as_period.substring(ln_index_start + 1, ln_index_end - 1));

					//
					// Carrega o valor no periodo conforme ...
					//
					switch (ln_fase) {
					//
					// Se � o ano carrega a sua fase ...
					//
					case 1: {
						ln_year = ln_value;
						break;
					}

					//
					// Se � o m�s carrega a sua fase ...
					//
					case 2: {
						ln_month = ln_value;
						break;
					}

					//
					// Se � o dia carrega a sua fase ...
					//
					case 3: {
						ln_day = ln_value;
						break;
					}

					//
					// Se � a hora carrega a sua fase ...
					//
					case 4: {
						ln_hour = ln_value;
						break;
					}

					//
					// Se � o minuto carrega a sua fase ...
					//
					case 5: {
						ln_minute = ln_value;
						break;
					}

					//
					// Se � o segundo carrega a sua fase ...
					//
					case 6: {
						ln_second = ln_value;
						break;
					}

					//
					// Se � o milisegundo carrega a sua fase ...
					//
					case 7: {
						ln_millisecond = ln_value;
						break;
					}
					}

					//
					// Salva o fim do pr�ximo valor ...
					//
					ln_index_end = ln_index_start;

					//
					// Atualiza a fase corrente ...
					//
					ln_fase_current = ln_fase;
				}

				//
				// If invalid ...
				//
				else {
					//
					// Exit from loop ...
					//
					break;
				}
			}
		}

		//
		// If all data processed ...
		//
		if (ln_index_start == -1 && ln_index_end == 0) {
			//
			// Load values calculated ...
			//
			in_year = ln_year;
			in_month = ln_month;
			in_day = ln_day;
			in_hour = ln_hour;
			in_minute = ln_minute;
			in_second = ln_second;
			in_millisecond = ln_millisecond;
		}

		//
		// If any data unprocessed ...
		//
		else {
			throw new IllegalArgumentException("Argumento (" + as_period + ") para inicializa��o do periodo inv�lido");
		}
	}

	/*
	 * ======================================================================
	 * 
	 * Converters.
	 * 
	 * ======================================================================
	 */

	/**
	 * Return sum of years, months, days, hours, minutes and seconds converted to
	 * milliseconds, plus millisecons.
	 * 
	 * @return Return total of period in milliseconds.
	 */
	public final long longValue() {
		//
		// Retorna o valor long deste objeto ...
		//
		return (in_year * YEAR_PESO + in_month * MONTH_PESO + in_day * DAY_PESO + in_hour * HOUR_PESO
				+ in_minute * MINUTE_PESO + in_second * SECOND_PESO + in_millisecond * MILLISECOND_PESO);
	}

	/**
	 * Convert <code>this</code> value to text format.
	 * 
	 * @return <code>String</code> representing contents of this
	 *         <code>VeSPeriod</code>.
	 */
	public final String Text(

	) {
		return (Text(this));
	}

	/**
	 * Convert a <code>VeSPeriod</code> value to text format.
	 * 
	 * @param ao_period <code>VeSPeriod</code> to convert to text.
	 * @return <code>String</code> representing contents of <code>VeSPeriod</code>.
	 */
	public static final String Text(MasterPeriod ao_period) {
		StringBuffer ls_date = new StringBuffer();

		boolean lb_before_period = false;

		//
		// If have year ...
		//
		if (ao_period.in_year != 0) {
			//
			// Adiciona ao retorno
			//
			ls_date.append(ao_period.in_year).append(" ano").append(ao_period.in_year != 1 ? "s " : " ");

			lb_before_period = true;
		}

		//
		// If have month ...
		//
		if (ao_period.in_month != 0) {
			if (lb_before_period) {
				ls_date.append("e ");
			} else {
				lb_before_period = true;
			}

			//
			// Adiciona ao retorno
			//
			ls_date.append(ao_period.in_month).append(' ').append(ao_period.in_month != 1 ? "meses " : "m�s ");
		}

		//
		// If have day ...
		//
		if (ao_period.in_day != 0) {
			if (lb_before_period) {
				ls_date.append("e ");
			} else {
				lb_before_period = true;
			}

			//
			// Adiciona ao retorno
			//
			ls_date.append(ao_period.in_day).append(" dia").append(ao_period.in_day != 1 ? "s " : " ");
		}

		//
		// If have hour ...
		//
		if (ao_period.in_hour != 0) {
			if (lb_before_period) {
				ls_date.append("e ");
			} else {
				lb_before_period = true;
			}

			//
			// Add suffix ...
			//
			ls_date.append(ao_period.in_hour).append(" hora").append(ao_period.in_hour != 1 ? "s " : " ");
		}

		//
		// If have minute ...
		//
		if (ao_period.in_minute != 0) {
			if (lb_before_period) {
				ls_date.append("e ");
			} else {
				lb_before_period = true;
			}

			//
			// Adiciona ao retorno
			//
			ls_date.append(ao_period.in_minute).append(" minuto").append(ao_period.in_minute != 1 ? "s " : " ");
		}

		//
		// If have second ...
		//
		if (ao_period.in_second != 0) {
			if (lb_before_period) {
				ls_date.append("e ");
			} else {
				lb_before_period = true;
			}

			//
			// Adiciona ao retorno
			//
			ls_date.append(ao_period.in_second).append(" segundo").append(ao_period.in_second != 1 ? "s " : " ");
		}

		//
		// If have milliseconds ...
		//
		if (ao_period.in_millisecond != 0) {
			if (lb_before_period) {
				ls_date.append("e ");
			} else {
				lb_before_period = true;
			}

			//
			// Adiciona ao retorno
			//
			ls_date.append(ao_period.in_millisecond).append(" milisegundo")
					.append(ao_period.in_millisecond != 1 ? "s " : " ");
		}

		//
		// Returm text of VeSPeriod ...
		//
		return (ls_date.toString());
	}

	/**
	 * Convert to <b>String</b>.
	 * 
	 * @return Return a <code>VeSPeriod</code> standard string value.
	 */
	public final String toString() {
		//
		// Retorna o valor no formado long deste objeto ...
		//
		return ((in_year == 0 ? "" : "" + YEAR_MASK + in_year) + (in_month == 0 ? "" : "" + MONTH_MASK + in_month)
				+ (in_day == 0 ? "" : "" + DAY_MASK + in_day) + (in_hour == 0 ? "" : "" + HOUR_MASK + in_hour)
				+ (in_minute == 0 ? "" : "" + MINUTE_MASK + in_minute)
				+ (in_second == 0 ? "" : "" + SECOND_MASK + in_second)
				+ (in_millisecond == 0 ? "" : "" + MILLISECOND_MASK + in_millisecond));
	}
}