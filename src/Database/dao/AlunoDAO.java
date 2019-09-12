package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.model.Aluno;

public class AlunoDAO extends MasterDao {

	private Connection connection;
	private final String select = "select * from tb_alunos";
	// private final String insert = "insert into tb_alunos (cd_aluno, nm_aluno) values (DEFAULT,?)";
	private final String insert = "insert into tb_alunos( cd_aluno, nm_aluno, nasc_aluno, sexo_aluno, cpf_aluno, rg_aluno, cep_aluno, ende_aluno, bairro_aluno, cidade_aluno, uf_aluno,  telefone_aluno, celular_aluno, email_aluno) values (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private final String update = "update tb_alunos set cd_aluno=?, nm_aluno=?";
	private final String delete = "delete from tb_alunos where cd_aluno = ?";
	private final PreparedStatement pstSelect, pstInsert, pstDelete, pstUpdate;

	public AlunoDAO(final Connection connection) throws SQLException {
		this.connection = connection;
		pstSelect = this.connection.prepareStatement(select);
		pstInsert = this.connection.prepareStatement(insert);
		pstUpdate = this.connection.prepareStatement(update);
		pstDelete = this.connection.prepareStatement(delete);

	}

	@Override
	public List<Object> Select(Object as_parameter) throws SQLException {

		ArrayList<Object> arlDados = new ArrayList<Object>();

		ResultSet resultado = pstSelect.executeQuery();

		while (resultado.next()) {
			Aluno aluno = new Aluno();
			aluno.setCd_aluno(resultado.getInt(1));
			aluno.setNm_aluno(resultado.getString(2));

			arlDados.add(aluno);
		}
		resultado.close();
		return arlDados;
	}

	@Override
	public void Delete(Object ao_object) throws SQLException {

		pstDelete.clearParameters();

		@SuppressWarnings("unused")
		Aluno ioAluno = (Aluno) ao_object;

		Set(pstDelete, 1, ioAluno.getCd_aluno());

		pstDelete.execute();

	}

	@Override
	public void Insert(Object ao_object) throws SQLException {

		pstInsert.clearParameters();

		@SuppressWarnings("unused")
		Aluno ioAluno = (Aluno) ao_object;

		// Set(pstInsert, 1, ioAluno.getCd_aluno());
		Set(pstInsert, 1, ioAluno.getNm_aluno());

		pstInsert.execute();
		connection.commit();
	}

	@Override
	public void Update(Object ao_object) throws SQLException {

		pstUpdate.clearParameters();

		@SuppressWarnings("unused")
		Aluno ioAluno = (Aluno) ao_object;

		Set(pstUpdate, 1, ioAluno.getCd_aluno());
		Set(pstUpdate, 2, ioAluno.getNm_aluno());

		pstUpdate.execute();

	}

}
