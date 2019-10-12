package database.dao;

import database.model.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO extends MasterDAO{

    private Connection connection;
    private final String select = "select * from tb_disciplinas";
    private final String insert = "insert into tb_disciplinas(nm_disciplina, qtd_cargahoraria, investimento, professor_disciplina) VALUES (?, ?, ?, ?)";
    private final String update = "update tb_disciplinas SET nm_disciplina=?, qtd_cargahoraria=?, investimento=? WHERE id_disciplina = ?";
    private final String delete = "delete from tb_disciplinas WHERE id_disciplina = ?";
    private final PreparedStatement pstSelect, pstInsert, pstDelete, pstUpdate;


    public DisciplinaDAO(final Connection connection) throws SQLException {
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
            Disciplina disciplina = new Disciplina();
            disciplina.setDisciplina(resultado.getString("nm_disciplina"));
            disciplina.setCargaHoraria(resultado.getString("qtd_cargahoraria"));
            disciplina.setQtdCreditos(resultado.getInt("investimento"));
            disciplina.setProfessor_disciplina(resultado.getString("professor_disciplina"));
            disciplina.setCod_disciplina(resultado.getInt("id_disciplina"));

            arlDados.add(disciplina);

        }
        resultado.close();
        return arlDados;
    }

    @Override
    public void Insert(Object ao_object) throws SQLException {

        pstInsert.clearParameters();

        Disciplina ioDisciplina = (Disciplina) ao_object;

        Set(pstInsert, 1, ioDisciplina.getDisciplina());
        Set(pstInsert, 2, ioDisciplina.getCargaHoraria());
        Set(pstInsert, 3, ioDisciplina.getQtdCreditos());
        Set(pstInsert, 4, ioDisciplina.getProfessor_disciplina());

        pstInsert.execute();

    }

    @Override
    public void Update(Object ao_object) throws SQLException {

        pstUpdate.clearParameters();

        Disciplina ioDisciplina = (Disciplina) ao_object;

        Set(pstUpdate, 1, ioDisciplina.getDisciplina());
        Set(pstUpdate, 2, ioDisciplina.getCargaHoraria());
        Set(pstUpdate, 3, ioDisciplina.getQtdCreditos());
        Set(pstUpdate, 4, ioDisciplina.getCod_disciplina());

        pstUpdate.execute();

    }

    @Override
    public void Delete(Object ao_object) throws SQLException {

        pstDelete.clearParameters();

        Disciplina ioAluno = (Disciplina) ao_object;

        Set(pstDelete, 1, ioAluno.getCod_disciplina());

        pstDelete.execute();
    }
}
