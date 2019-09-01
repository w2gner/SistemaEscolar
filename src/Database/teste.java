package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import database.model.Aluno;
import database.dao.AlunoDAO;

public class teste {

	public static void main(String[] args) throws SQLException {

		Connection conn = ConnectionFactory.getConnection("teste", "postgres", "manager");

		conn.setAutoCommit(false);

		AlunoDAO dao = new AlunoDAO(conn);

		List<Object> alunos = dao.Select();

		for (Object obj : alunos) {
			Aluno a = (Aluno) obj;
			System.out.println("Código:"  +a.getCd_aluno());
			System.out.println("Nome:" + a.getNm_aluno());
		}
	}

}
