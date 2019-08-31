package Database.dao;

import java.sql.SQLException;
import java.util.List;

public abstract class MFLDao {
	public abstract List<Object> Select() throws SQLException;

	public abstract int Delete();

	public abstract int Insert();

	public abstract int Update();
}
