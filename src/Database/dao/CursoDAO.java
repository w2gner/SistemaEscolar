package database.dao;

import database.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO extends MasterDAO {
    private Connection connection;
    private final String select = "select * from tb_cursos";
    private final String insert = "insert into tb_cursos(nm_curso, num_creditos, valor_creditos) VALUES (?, ?, ?)";
    private final String update = "update tb_cursos SET nm_curso=?, num_creditos=?, valor_creditos=? WHERE id_curso = ?";
    private final String delete = "delete from tb_cursos WHERE id_curso = ?";
    private final PreparedStatement pstSelect, pstInsert, pstDelete, pstUpdate;

    public CursoDAO(final Connection connection) throws SQLException {
        this.connection = connection;
        pstSelect = connection.prepareStatement(select);
        pstInsert = connection.prepareStatement(insert);
        pstUpdate = connection.prepareStatement(update);
        pstDelete = connection.prepareStatement(delete);
    }

    @Override
    public List<Object> Select(Object as_parameter) throws SQLException {

        pstSelect.clearParameters();

        ArrayList<Object> arlDados = new ArrayList<Object>();
        ResultSet resultado = pstSelect.executeQuery();

        while (resultado.next()) {
            Curso curso = new Curso();
            curso.setId(resultado.getInt("id_curso"));
            curso.setNome(resultado.getString("nm_curso"));
            curso.setValorMatricula(resultado.getDouble("num_creditos"));
            curso.setValorCreditos(resultado.getDouble("valor_creditos"));

            arlDados.add(curso);

        }
        resultado.close();
        return arlDados;
    }

    @Override
    public void Insert(Object ao_object) throws SQLException {

        pstInsert.clearParameters();

        Curso ioDisciplina = (Curso) ao_object;

        Set(pstInsert, 1, ioDisciplina.getNome());
        Set(pstInsert, 2, ioDisciplina.getValorMatricula());
        Set(pstInsert, 3, ioDisciplina.getValorCreditos());

        pstInsert.execute();

    }

    @Override
    public void Update(Object ao_object) throws SQLException {

        pstUpdate.clearParameters();

        Curso ioCurso = (Curso) ao_object;

        Set(pstUpdate, 1, ioCurso.getNome());
        Set(pstUpdate, 2, ioCurso.getValorMatricula());
        Set(pstUpdate, 3, ioCurso.getValorCreditos());
        Set(pstUpdate, 4, ioCurso.getId());

        pstUpdate.execute();

    }

    @Override
    public void Delete(Object ao_object) throws SQLException {

        pstDelete.clearParameters();

        Curso ioCurso = (Curso) ao_object;

        Set(pstDelete, 1, ioCurso.getId());

        pstDelete.execute();

    }
}
