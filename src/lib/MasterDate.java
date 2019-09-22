//
// Pacote ao qual a classe pertence
//
package lib;

//
// Importa as bibliotecas VBI
//

//
// Importa as bibliotecas Java
//
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import			java.util.Calendar;

/**
 * 
 * @author Matheus Leandro Ferreira
 * @version $Revision: 0.0 $
 * 
 *          ======================================================================
 *          Arquivo : $RCSfile: MasterDate.java,v $ Projeto : MasterSys Cria��o
 *          : 02/05/2011 Descri��o : Classe para controle de datas.
 *          ======================================================================
 * 
 * @Matheus 2011-18-04 - Cria��o da classe para controle de datas.
 * 
 */

public final class MasterDate extends Date {
	private static final long serialVersionUID = -1260650229541798920L;

	/*
	 * ==============================================================
	 * 
	 * Constants.
	 * 
	 * ==============================================================
	 */

	/**
	 * Year base.
	 */
	private static final int YEAR_BASE = 1900;

	// /**
	// Calendar default.
	// */
	// private static final Calendar
	// CALENDAR = Calendar.getInstance();

	/**
	 * Default mask:<br>
	 * <code>"dd/MM/yyyy HH:mm:ss.SSS"</code>
	 */
	public static final String MASK_DEFAULT = "dd/MM/yyyy HH:mm:ss.SSS";

	/**
	 * Default SQL mask:<br>
	 * <code>"yyyy-MM-dd HH:mm:ss.SSS"</code>.
	 */
	public static final String MASK_SQL_DEFAULT = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * Defaull date mask:<br>
	 * <code>"yyyy-MM-dd"</code>.
	 */
	public static final String MASK_DATE_DEFAULT = "yyyy-MM-dd";

	/**
	 * Default hour mask:<br>
	 * <code>"HH:mm:ss.SSS"</code>.
	 */
	public static final String MASK_HOUR_DEFAULT = "HH:mm:ss.SSS";

	/**
	 * Array with all possible masks.
	 */
	private static final VeSDateFormat[] ALL_MASKS = new VeSDateFormat[] { new VeSDateFormat(MASK_DEFAULT),
			new VeSDateFormat(MASK_SQL_DEFAULT), new VeSDateFormat(MASK_DATE_DEFAULT),
			new VeSDateFormat(MASK_HOUR_DEFAULT), new VeSDateFormat("dd/MM/yyyy") };

	/*
	 * ==============================================================
	 * 
	 * Editors.
	 * 
	 * ==============================================================
	 */

	/**
	 * Specific object for date/time format.
	 */
	private final VeSDateFormat io_df;

	/**
	 * Default object for date/time format.
	 */
	private static final VeSDateFormat io_df_default = new VeSDateFormat(MASK_DEFAULT);

	/**
	 * Class to parse and format date/time.
	 */
	private static class VeSDateFormat extends SimpleDateFormat {
		private static final long serialVersionUID = -5380707458989363995L;

		// /**
		// Constructor with default mask.
		// */
		// public VeSDateFormat
		// (
		//
		// )
		// {
		// this(MASK_DEFAULT);
		// }

		/**
		 * Constructor with specific mask.
		 * 
		 * @param as_mask Edit mask.
		 * @throws IllegalArgumentException Throws when <code>as_mask</code> is invalid.
		 */
		public VeSDateFormat(final String as_mask) throws IllegalArgumentException {
			super(as_mask);

			//
			// Don't accept lenient values ...
			//
			setLenient(false);
		}
	}

	/*
	 * ======================================================================
	 * 
	 * Constructors.
	 * 
	 * ======================================================================
	 */

	/**
	 * Construtor que utiliza a data/hora corrente para inicializa��o.
	 */
	public MasterDate(

	) {
		this((Date) null);
	}

	/**
	 * Construtor com uma data/hora especifica e que utliza a m�scara padr�o para
	 * edi��o.
	 * 
	 * @param an_date_time Data/hora utilizada para inicializa��o deste.
	 */
	public MasterDate(final long an_date_time) {
		this(an_date_time, null);
	}

	/**
	 * Construtor com uma data/hora e m�scara de edi��o especifica.
	 * 
	 * @param an_date_time Data/hora utilizada para inicializa��o deste.
	 * @param as_mask      M�scara de edi��o que se estiver preenchida ser�
	 *                     utilizada como padr�o.
	 */
	public MasterDate(final long an_date_time, final String as_mask) {
		//
		// Initialize date/hour ...
		//
		super(an_date_time);

		//
		// Set mask to default or that specified ...
		//
		io_df = as_mask == null ? (VeSDateFormat) io_df_default.clone() : new VeSDateFormat(as_mask);
	}

	/**
	 * Construtor com uma data/hora especifica e que utliza a m�scara padr�o para
	 * edi��o.
	 * 
	 * @param ad_date_time Data/hora utilizada para inicializa��o deste. Se for
	 *                     nulo, ser� utilizado a data/hora corrente.
	 */
	public MasterDate(final Date ad_date_time) {
		this(ad_date_time, null);
	}

	/**
	 * Construtor com uma data/hora e m�scara de edi��o especifica.
	 * 
	 * @param ad_date_time Data/hora utilizada para inicializa��o deste. Se for
	 *                     nulo, ser� utilizado a data/hora corrente.
	 * @param as_mask      M�scara de edi��o que se estiver preenchida ser�
	 *                     utilizada como padr�o.
	 */
	public MasterDate(final Date ad_date_time, final String as_mask) {
		this((ad_date_time == null ? new Date().getTime() : ad_date_time.getTime()), as_mask);
	}

	/**
	 * Construtor com data/hora especifica.
	 * 
	 * @param as_date_time Data/hora a ser utilizada para iniciar o valor deste
	 *                     objeto no formato da m�scara padr�o. Vide
	 *                     {@linkplain #MASK_DEFAULT}. Se for nulo, ser� utilizado a
	 *                     data/hora corrente.
	 */
	public MasterDate(final String as_date_time) throws IllegalArgumentException {
		this(as_date_time, null);
	}

	/**
	 * Construtor com data/hora especifica.
	 * 
	 * @param as_date_time Data/hora a ser utilizada para iniciar o valor deste
	 *                     objeto no formato da m�scara especificada. Se for nulo,
	 *                     ser� utilizado a data/hora corrente.
	 * @param as_mask      M�scara na qual a data e hora fornecida est� formatada, e
	 *                     a ser utilizada como padr�o para este objeto.
	 */
	public MasterDate(final String as_date_time, final String as_mask) throws IllegalArgumentException {
		this(ParseInternal(as_date_time, as_mask), as_mask);
	}

	/*
	 * ======================================================================
	 * 
	 * Validation.
	 * 
	 * ======================================================================
	 */

	/**
	 * Consiste se uma String cont�m uma data/hora v�lida de acordo com a m�scara de
	 * edi��o padr�o {@linkplain #MASK_DEFAULT}.
	 * 
	 * @return Retorna <b>true</b> se for uma data/hora v�lida, caso contr�rio
	 *         retorna <b>false</b>.
	 */
	public static final boolean isDate(final String as_date_time) {
		return (isDate(as_date_time, io_df_default));
	}

	/**
	 * Consiste se uma String cont�m uma data/hora v�lida de acordo com a m�scara de
	 * edi��o padr�o.
	 * 
	 * @return Retorna <b>true</b> se for uma data/hora v�lida, caso contr�rio
	 *         retorna <b>false</b>.
	 */
	public static final boolean isDate(final String as_date_time, final String as_mask) {
		return (isDate(as_date_time, new VeSDateFormat(as_mask)));
	}

	/**
	 * Validate date/time string according with format specified.
	 * 
	 * @param as_date_time Date/time to validate.
	 * @param ao_df        Validate tormat.
	 * @return Return <b>true</b> if valid, otherwise <b>false</b>.
	 */
	private static final boolean isDate(final String as_date_time, final VeSDateFormat ao_df) {
		//
		// At begining date/time is invalid ...
		//
		boolean lb = false;

		//
		// If date/time specified ...
		//
		if (lb = (as_date_time != null)) {
			try {
				//
				// Try to parse date/time ...
				//
				ao_df.parse(as_date_time);
			}

			catch (ParseException ex) {
				//
				// Date/time invalid ...
				//
				lb = false;
			}
		}

		//
		// Return if date/time is valid ...
		//
		return (lb);
	}

	/*
	 * ======================================================================
	 * 
	 * Edition.
	 * 
	 * ======================================================================
	 */

	/**
	 * Retorna a data/hora deste objeto editada de acordo com a m�scara padr�o.
	 * 
	 * @return A data/hora editada.
	 */
	public final String toString() {
		return (io_df.format(this));
	}

	/**
	 * Retorna a data/hora editada de acordo com a m�scara recebida.
	 * 
	 * @param as_mask M�scara de edi��o (ex.: dd/MM/yyyy HH:mm:ss.SSS).
	 * @return Data/hora editada.
	 */
	public final String toString(final String as_mask) {
		return (new VeSDateFormat(as_mask).format(this));
	}

	/**
	 * Retorna a data/hora formatada de acordo com a m�scara SQL padr�o.
	 * 
	 * @param ad_date Data a ser editada.
	 * @return Data/hora editada no formato padr�o SQL.
	 */
	public static final String toString(final MasterDate ad_date) {
		return (io_df_default.format(ad_date));
	}

	/**
	 * Edita uma data/hora de acordo com uma m�scara.
	 * 
	 * @param ad_date Data a ser editada.
	 * @param as_mask M�scara de edi��o.
	 * @return Data/hora editada.
	 */
	public static final String toString(final MasterDate ad_date, final String as_mask) {
		return (new VeSDateFormat(as_mask).format(ad_date));
	}

	/*
	 * ======================================================================
	 * 
	 * Comparation.
	 * 
	 * ======================================================================
	 */

	/*
	 * ======================================================================
	 * 
	 * Convertion.
	 * 
	 * ======================================================================
	 */

	// /**
	// Nome dos meses.
	// */
	// private static final String[]
	// MONTH_NAME =
	// {
	// "Janeiro",
	// "Fevereiro",
	// "Mar�o",
	// "Abril",
	// "Maio",
	// "Junho",
	// "Julho",
	// "Agosto",
	// "Setembro",
	// "Outubro",
	// "Novembro",
	// "Dezembro"
	// };
	//
	// /**
	// Nome dos dias da semana.
	// */
	// private static final String[]
	// WEEK_DAY_NAME =
	// {
	// "Domingo",
	// "Segunda-feira",
	// "Ter�a-feira",
	// "Quarta-feira",
	// "Quinta-feira",
	// "Sexta-feira",
	// "S�bado"
	// };
	//
	// /**
	// Converte uma data para o formato extenso brasileiro.
	// @param ad_date
	// Data a ser formatado o extenso.
	// @return
	// Extenso da data no formato brasileiro.
	// */
	// public static final
	// String toText
	// (
	// final VeSDate ad_date
	// )
	// {
	// return
	// (
	// WEEK_DAY_NAME[ad_date.getDay()]
	// + ", "
	// + ad_date.getDate()
	// + " de "
	// + MONTH_NAME[ad_date.getMonth()]
	// + " de "
	// + (YEAR_BASE + ad_date.getYear())
	// );
	// }

	/*
	 * ======================================================================
	 * 
	 * Compute.
	 * 
	 * ======================================================================
	 */

	/**
	 * Add a period <b>MasterPeriod</b> to this date.
	 * 
	 * @param ao_periodo Period to be added.
	 * @return New <b>VeSDate</b> with period added.
	 */
	public final MasterDate add(final MasterPeriod ao_periodo) {
		return (add(this, ao_periodo));
	}

	/**
	 * Add a period <b>MasterPeriod</b> to this date.
	 * 
	 * @param ao_date   Date to add period.
	 * @param ao_period Period to be added.
	 * @return New <b>VeSDate</b> with period added.
	 */
	public static final MasterDate add(final MasterDate ad_date, final MasterPeriod ao_period) {
		//
		// �rea de trabalho ...
		//
		MasterDate ld_date = (MasterDate) ad_date.clone();

		//
		// Calcula a data relativa ao numero de anos ...
		//
		ld_date.setYear(ld_date.getYear() + (int) ao_period.in_year);

		//
		// Calcula a data relativa ao numero de meses ...
		//
		ld_date.setMonth(ld_date.getMonth() + (int) ao_period.in_month);

		//
		// Soma os dias/horas/minutos/segundos e milisegundos ...
		//
		ld_date.setTime(ld_date.getTime() + (ao_period.in_day * MasterPeriod.DAY_PESO)
				+ (ao_period.in_hour * MasterPeriod.HOUR_PESO) + (ao_period.in_minute * MasterPeriod.MINUTE_PESO)
				+ (ao_period.in_second * MasterPeriod.SECOND_PESO)
				+ (ao_period.in_millisecond * MasterPeriod.MILLISECOND_PESO));

		//
		// Retorna a data adicionada o periodo ...
		//
		return (ld_date);
	}

	/**
	 * Subtrai um periodo da data.
	 * 
	 * @param ao_periodo Periodo a ser subtraido.
	 * @return Um VeSDate a nova data.
	 */
	public final MasterDate subtract(final MasterPeriod ao_periodo) {
		//
		// �rea de trabalho ...
		//
		MasterDate ld_date = (MasterDate) clone();

		//
		// Calcula a data relativa ao numero de anos ...
		//
		ld_date.setYear(ld_date.getYear() - (int) ao_periodo.in_year);

		//
		// Calcula a data relativa ao numero de meses ...
		//
		ld_date.setMonth(ld_date.getMonth() - (int) ao_periodo.in_month);

		//
		// Soma os dias/horas/minutos/segundos e milisegundos ...
		//
		ld_date.setTime(ld_date.getTime() - (ao_periodo.in_day * MasterPeriod.DAY_PESO)
				- (ao_periodo.in_hour * MasterPeriod.HOUR_PESO) - (ao_periodo.in_minute * MasterPeriod.MINUTE_PESO)
				- (ao_periodo.in_second * MasterPeriod.SECOND_PESO)
				- (ao_periodo.in_millisecond * MasterPeriod.MILLISECOND_PESO));

		//
		// Retorna a data adicionada o periodo ...
		//
		return (ld_date);
	}

	//
	// Adjusts to compute difference
	//
	private static final long[] ln_adjust = { 0, 12, 31, 24, 60, 60, 1000 };

	/**
	 * Compute difference between this and another date.
	 * 
	 * @param ao_date Other date to be used on calcule.
	 * @return <b>MasterPeriod</b> with date's difference.
	 */
	public final MasterPeriod difference(final MasterDate ad_date) {
		//
		// Work areas
		//
		long[] ln_date_this = new long[7];
		ln_date_this[0] = getYear() + YEAR_BASE;
		ln_date_this[1] = getMonth();
		ln_date_this[2] = getDate();
		ln_date_this[3] = getHours();
		ln_date_this[4] = getMinutes();
		ln_date_this[5] = getSeconds();
		ln_date_this[6] = Long.parseLong(toString("SSS"));

		long[] ln_date_argument = new long[7];
		ln_date_argument[0] = ad_date.getYear() + YEAR_BASE;
		ln_date_argument[1] = ad_date.getMonth();
		ln_date_argument[2] = ad_date.getDate();
		ln_date_argument[3] = ad_date.getHours();
		ln_date_argument[4] = ad_date.getMinutes();
		ln_date_argument[5] = ad_date.getSeconds();
		ln_date_argument[6] = Long.parseLong(ad_date.toString("SSS"));

		//
		//
		//
		for (int ln_1 = 6; ln_1 >= 0; ln_1--) {
			//
			// Compute difference ...
			//
			ln_date_this[ln_1] -= ln_date_argument[ln_1];

			//
			// if first greater or equal then second ...
			//
			if (ln_1 > 0 && ln_date_this[ln_1] < 0) {
				//
				// Restore to positive value ...
				//
				ln_date_this[ln_1] += ln_adjust[ln_1];

				//
				// Adjust next value ...
				//
				ln_date_this[ln_1 - 1]--;
			}
		}

		//
		// Create MasterPeriod with result and return it ...
		//
		return (new MasterPeriod(ln_date_this[0], ln_date_this[1], ln_date_this[2], ln_date_this[3], ln_date_this[4],
				ln_date_this[5], ln_date_this[6]));
	}

	/*
	 * ======================================================================
	 * 
	 * Internal.
	 * 
	 * ======================================================================
	 */

	/**
	 * Make a parse of date/time string using mask specified or any of default
	 * masks. m�scara.
	 * 
	 * @param as_date_time Date/time to be parsed.
	 * @param as_mask      When epecified must contains parse mask.
	 * @return Date parsed.
	 * @throws ParseException
	 */
	private static Date ParseInternal(final String as_date_time, final String as_mask) throws IllegalArgumentException {
		//
		// Result area
		//
		Date ld_result = null;

		//
		// If date/time specified ...
		//
		if (as_date_time != null) {
			//
			// If mask specified ...
			//
			if (as_mask != null) {
				try {
					//
					// Try to parse ...
					//
					ld_result = new VeSDateFormat(as_mask).parse(as_date_time);
				}

				catch (ParseException ex) {
					//
					// Ignore because above exception are throwed ...
					//
				}
			}

			//
			// If mask not specified ...
			//
			else {
				synchronized (ALL_MASKS) {
					//
					// Try to find the right mask ...
					//
					for (int ln = 0; ln < ALL_MASKS.length && ld_result == null; ln++) {
						try {
							//
							// Try to parse until the right mask have been found ...
							//
							ld_result = ALL_MASKS[ln].parse(as_date_time);
						}

						catch (ParseException ex) {
							//
							// Try another mask.
							//
							continue;
						}
					}
				}
			}
		}

		//
		// If date/time not parsed ...
		//
		if (ld_result == null) {
			throw new IllegalArgumentException("Date/time \"" + as_date_time + "\" invalid"
					+ (as_mask == null ? "" : " or format not match with mask \"" + as_mask + "\" or mask invalid"));
		}

		//
		// Return date/time parsed ...
		//
		return (ld_result);
	}
}