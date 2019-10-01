package database.dao;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

public abstract class MasterDAO {

	/**
	 * Select Method.
	 */
	public abstract List<Object> Select(Object as_parameter) throws SQLException;

	/**
	 * Insert Method.
	 */
	public abstract void Insert(Object ao_object) throws SQLException;

	/**
	 * Update Method.
	 */
	public abstract void Update(Object ao_object) throws SQLException;

	/**
	 * Delete Method.
	 */
	public abstract void Delete(Object ao_object) throws SQLException;

	/**
	 * Sets the value into the Prepared Statement according to the Object class.
	 */
	public void Set(PreparedStatement ao_pst, final int an_parameter, final Object ao_value) throws SQLException {
		//
		// null ...
		//
		if (ao_value == null) {
			ao_pst.setNull(an_parameter, Types.NULL);
		}

		//
		// String ...
		//
		else if (ao_value instanceof String) {
			ao_pst.setString(an_parameter, (String) ao_value);
		}

		//
		// Char ...
		//
		else if (ao_value instanceof Character) {
			ao_pst.setString(an_parameter, ((Character) ao_value).toString());
		}

		//
		// BigDecimal ...
		//
		else if (ao_value instanceof BigDecimal) {
			ao_pst.setBigDecimal(an_parameter, (BigDecimal) ao_value);
		}

		//
		// Timestamp ...
		//
		else if (ao_value instanceof Timestamp) {
			ao_pst.setTimestamp(an_parameter, (Timestamp) ao_value);
		}

		//
		// Date ...
		//
		else if (ao_value instanceof java.util.Date) {
			ao_pst.setTimestamp(an_parameter, new Timestamp(((java.util.Date) ao_value).getTime()));
		}

		else if (ao_value instanceof java.sql.Date) {
			ao_pst.setDate(an_parameter, (java.sql.Date) ao_value);
		}

		//
		// Time ...
		//
		else if (ao_value instanceof Time) {
			ao_pst.setTime(an_parameter, (Time) ao_value);
		}

		//
		// Boolean ...
		//
		else if (ao_value instanceof Boolean) {
			ao_pst.setString(an_parameter, ((Boolean) ao_value).booleanValue() ? "S" : "N");
		}

		//
		// Byte ...
		//
		else if (ao_value instanceof Byte) {
			ao_pst.setInt(an_parameter, ((Byte) ao_value).byteValue());
		}

		//
		// byte[] (Blob)...
		//
		else if (ao_value instanceof byte[]) {
			ao_pst.setBytes(an_parameter, (byte[]) ao_value);
		}

		//
		// char[] (Clob)...
		//
		else if (ao_value instanceof char[]) {
			ao_pst.setString(an_parameter, new String((char[]) ao_value));
		}

		//
		// Integer ...
		//
		else if (ao_value instanceof Integer) {
			ao_pst.setInt(an_parameter, ((Integer) ao_value).intValue());
		}

		//
		// Long ...
		//
		else if (ao_value instanceof Long) {
			ao_pst.setLong(an_parameter, ((Long) ao_value).longValue());
		}

		//
		// Double ...
		//
		else if (ao_value instanceof Double) {
			ao_pst.setDouble(an_parameter, ((Double) ao_value).doubleValue());
		}

		//
		// Float ...
		//
		else if (ao_value instanceof Float) {
			ao_pst.setFloat(an_parameter, ((Float) ao_value).floatValue());
		}

		//
		// Blob ...
		//
		else if (ao_value instanceof Blob) {
			ao_pst.setBlob(an_parameter, (Blob) ao_value);
		}

		//
		// Clob ...
		//
		else if (ao_value instanceof Clob) {
			ao_pst.setClob(an_parameter, (Clob) ao_value);
		}

		//
		// Ref ...
		//
		else if (ao_value instanceof Ref) {
			ao_pst.setRef(an_parameter, (Ref) ao_value);
		}
	}
}
