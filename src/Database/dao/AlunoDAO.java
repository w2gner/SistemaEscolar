package Database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Model.Aluno;

public class AlunoDAO extends MFLDao {

	private Connection conection;
	private String select = "select * from tb_alunos";
	private String insert = "insert into tb_alunos(nm_aluno) VALUES (?) ";
	private String delete = "delete from tb_alunos";
	// private String update = "delete from tb_alunos";
	private PreparedStatement pstSelect;

	public AlunoDAO(final Connection connection) throws SQLException {
		this.conection = connection;
		pstSelect = this.conection.prepareStatement(select);
	}

	@Override
	public List<Object> Select() throws SQLException {

		ArrayList<Object> arlDados = new ArrayList<Object>();

		ResultSet resultado = pstSelect.executeQuery();

		while (resultado.next()) {
			Aluno aluno = new Aluno();
			aluno.setCd_aluno(resultado.getInt(1));
			aluno.setNm_aluno(resultado.getString(2));

			arlDados.add(aluno);
		}

		return arlDados;
	}

	@Override
	public int Delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Update() {
		// TODO Auto-generated method stub
		return 0;
	}

}
