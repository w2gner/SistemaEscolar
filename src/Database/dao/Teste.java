package database.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import database.ConnectionFactory;
import database.model.Aluno;

public class Teste {
	public static void main(String[] args) throws SQLException {

		Connection conn = ConnectionFactory.getConnection("localhost", "5432", "SistemaDBA", "postgres", "manager");
		conn.setAutoCommit(false);

		AlunoDAO dao = new AlunoDAO(conn);
		List<Object> alunos = dao.Select(null);
		Aluno teste = new Aluno();

		// teste.setCd_aluno(1);
		// dao.Delete(teste);

		// alunos = dao.Select(null);
		// teste.setNm_aluno("Aluno 1");
		// dao.Insert(teste);

		// teste.setCd_aluno(9);
		// teste.setNm_aluno("Aluno 9 atualizado");
		// dao.Update(teste);

		for (Object obj : alunos) {
			Aluno a = (Aluno) obj;
			System.out.println("Código: " + a.getCd_aluno());
			System.out.println("Nome: " + a.getNm_aluno());
		}

	}

}
