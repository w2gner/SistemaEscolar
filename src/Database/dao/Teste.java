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
				
		// List<Object> alunos = dao.Select(null);

		// for (Object obj : alunos) {
		// 	Aluno a = (Aluno) obj;
		// 	System.out.println("Código: " + a.getCd_aluno());
		// 	System.out.println("Nome: " + a.getNm_aluno());
		// }
//		
//		Aluno teste = new Aluno();
//		teste.setCd_aluno(2);
//		dao.Delete(teste);
//
//		alunos = dao.Select(null);
//
//		for (Object obj : alunos) {
//			Aluno a = (Aluno) obj;
//			System.out.println("Código: " + a.getCd_aluno());
//			System.out.println("Nome: " + a.getNm_aluno());
//		}

		
//		Aluno teste = new Aluno();
//		//teste.setCd_aluno(3);
//		teste.setNm_aluno("teste123");
//		dao.Insert(teste);
		
	}

}
