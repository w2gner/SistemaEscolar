package Database.dao;

import java.awt.List;
import java.sql.SQLException;

public abstract class MFLDao {
	public abstract
	java.util.List<Object>	Select() throws SQLException;
	
	public abstract
	int	Delete();
	
	public abstract
	int	Insert();
	
	public abstract
	int	Update();
}
