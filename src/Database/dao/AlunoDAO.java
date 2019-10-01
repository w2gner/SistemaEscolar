package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.model.Aluno;

public class AlunoDAO extends MasterDAO {

	private Connection connection;
	private final String select = "select * from tb_alunos";
	private final String insert = "insert into tb_alunos( cd_aluno, nm_aluno, nasc_aluno, sexo_aluno, cpf_aluno, rg_aluno, cep_aluno, ende_aluno, bairro_aluno, cidade_aluno, uf_aluno, telefone_aluno, celular_aluno, email_aluno, mat_aluno) values (DEFAULT, ?, ?::date, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String update = "update tb_alunos SET cd_aluno=?, nm_aluno=?, nasc_aluno=?::date, sexo_aluno= ?, cpf_aluno=?, rg_aluno=?, cep_aluno=?, ende_aluno=?, bairro_aluno=?, cidade_aluno=?,  uf_aluno=?, telefone_aluno=?, celular_aluno=?, email_aluno=?,  mat_aluno=? WHERE cd_aluno = ?";
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

		pstSelect.clearParameters();

		ArrayList<Object> arlDados = new ArrayList<Object>();

		ResultSet resultado = pstSelect.executeQuery();

		while (resultado.next()) {
			Aluno aluno = new Aluno();
			aluno.setCd_aluno(resultado.getInt(1));
			aluno.setNm_aluno(resultado.getString(2));
			aluno.setNasc_aluno(resultado.getString(3));
			aluno.setSexo_aluno(resultado.getString(4));
			aluno.setCpf_aluno(resultado.getString(5));
			aluno.setRg_aluno(resultado.getString(6));
			aluno.setCep_aluno(resultado.getString(7));
			aluno.setEnd_aluno(resultado.getString(8));
			aluno.setBairo_aluno(resultado.getString(9));
			aluno.setCidade_aluno(resultado.getString(10));
			aluno.setUf_aluno(resultado.getString(11));
			aluno.setTelefone_aluno(resultado.getString(12));
			aluno.setCelular_aluno(resultado.getString(13));
			aluno.setEmail_aluno(resultado.getString(14));
			aluno.setMat_aluno(resultado.getInt(15));

			arlDados.add(aluno);

		}
		resultado.close();
		return arlDados;
	}

	@Override
	public void Delete(Object ao_object) throws SQLException {

		pstDelete.clearParameters();

		Aluno ioAluno = (Aluno) ao_object;

		Set(pstDelete, 1, ioAluno.getCd_aluno());

		pstDelete.execute();

	}

	@Override
	public void Insert(Object ao_object) throws SQLException {

		pstInsert.clearParameters();

		Aluno ioAluno = (Aluno) ao_object;

		Set(pstInsert, 1, ioAluno.getNm_aluno());
		Set(pstInsert, 2, ioAluno.getNasc_aluno());
		Set(pstInsert, 3, ioAluno.getSexo_aluno());
		Set(pstInsert, 4, ioAluno.getCpf_aluno());
		Set(pstInsert, 5, ioAluno.getRg_aluno());
		Set(pstInsert, 6, ioAluno.getCep_aluno());
		Set(pstInsert, 7, ioAluno.getEnd_aluno());
		Set(pstInsert, 8, ioAluno.getBairo_aluno());
		Set(pstInsert, 9, ioAluno.getCidade_aluno());
		Set(pstInsert, 10, ioAluno.getUf_aluno());
		Set(pstInsert, 11, ioAluno.getTelefone_aluno());
		Set(pstInsert, 12, ioAluno.getCelular_aluno());
		Set(pstInsert, 13, ioAluno.getEmail_aluno());
		Set(pstInsert, 14, ioAluno.getMat_aluno());

		pstInsert.execute();

		}

	@Override
	public void Update(Object ao_object) throws SQLException {

		pstUpdate.clearParameters();

		Aluno ioAluno = (Aluno) ao_object;

		Set(pstUpdate, 1, ioAluno.getCd_aluno());
		Set(pstUpdate, 2, ioAluno.getNm_aluno());
		Set(pstUpdate, 3, ioAluno.getNasc_aluno());
		Set(pstUpdate, 4, ioAluno.getSexo_aluno());
		Set(pstUpdate, 5, ioAluno.getCpf_aluno());
		Set(pstUpdate, 6, ioAluno.getRg_aluno());
		Set(pstUpdate, 7, ioAluno.getCep_aluno());
		Set(pstUpdate, 8, ioAluno.getEnd_aluno());
		Set(pstUpdate, 9, ioAluno.getBairo_aluno());
		Set(pstUpdate, 10, ioAluno.getCidade_aluno());
		Set(pstUpdate, 11, ioAluno.getUf_aluno());
		Set(pstUpdate, 12, ioAluno.getTelefone_aluno());
		Set(pstUpdate, 13, ioAluno.getCelular_aluno());
		Set(pstUpdate, 14, ioAluno.getEmail_aluno());
		Set(pstUpdate, 15, ioAluno.getMat_aluno());
		Set(pstUpdate, 16, ioAluno.getCd_aluno());

		pstUpdate.execute();

	}

}
