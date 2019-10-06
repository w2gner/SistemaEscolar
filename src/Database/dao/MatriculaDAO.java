package database.dao;

import database.model.Matricula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO extends MasterDAO {

    private Connection connection;
    private final String select = "select * from tb_matriculas";
    private final String insert = "insert into tb_matriculas( id_curso, id_professor, id_aluno, id_disciplina, id_matricula) VALUES (?, ?, ?, ?, DEFAULT);";
    private final String update = "update tb_matriculas SET id_curso=?, id_professor=?, id_aluno=?, id_disciplina=? WHERE id_matricula = ?";
    private final String delete = "delete from tb_matriculas WHERE id_matricula = ?";
    private final PreparedStatement pstSelect, pstInsert, pstDelete, pstUpdate;

    public MatriculaDAO(final Connection connection) throws SQLException {
        this.connection = connection;
        pstSelect = connection.prepareStatement(select);
        pstInsert = connection.prepareStatement(insert);
        pstUpdate = connection.prepareStatement(update);
        pstDelete = connection.prepareStatement(delete);
    }

    @Override
    public List<Object> Select(Object as_parameter) throws SQLException {

        pstSelect.clearParameters();

        ArrayList<Object> arlDados = new ArrayList<>();

        ResultSet resultado = pstSelect.executeQuery();

        while (resultado.next()) {
            Matricula matricula = new Matricula();
            matricula.setIdAluno(resultado.getInt("id_aluno"));
            matricula.setIdCurso(resultado.getInt("id_curso"));
            matricula.setIdDisciplina(resultado.getInt("id_disciplina"));
            matricula.setIdProfessor(resultado.getInt("id_professor"));
            matricula.setIdMatricula(resultado.getInt("id_matricula"));

            arlDados.add(matricula);
        }

        resultado.close();
        return arlDados;
    }

    @Override
    public void Insert(Object ao_object) throws SQLException {

        pstInsert.clearParameters();

        Matricula ioDisciplina = (Matricula) ao_object;

        Set(pstInsert, 1, ioDisciplina.getIdCurso());
        Set(pstInsert, 2, ioDisciplina.getIdProfessor());
        Set(pstInsert, 3, ioDisciplina.getIdAluno());
        Set(pstInsert, 4, ioDisciplina.getIdDisciplina());

        pstInsert.execute();

    }

    @Override
    public void Update(Object ao_object) throws SQLException {

        pstUpdate.clearParameters();

        Matricula ioMatricula = (Matricula) ao_object;

        Set(pstUpdate, 1, ioMatricula.getIdCurso());
        Set(pstUpdate, 2, ioMatricula.getIdProfessor());
        Set(pstUpdate, 3, ioMatricula.getIdAluno());
        Set(pstUpdate, 4, ioMatricula.getIdDisciplina());
        Set(pstUpdate, 5, ioMatricula.getIdMatricula());

        pstUpdate.execute();

    }

    @Override
    public void Delete(Object ao_object) throws SQLException {

        pstDelete.clearParameters();

        Matricula ioMatricula = (Matricula) ao_object;

        Set(pstDelete, 1, ioMatricula.getIdMatricula());

        pstDelete.execute();

    }
}
