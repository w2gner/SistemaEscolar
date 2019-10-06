package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.model.Professor;

public class ProfessorDAO extends MasterDAO {

    private Connection connection;
    private final String select = "select * from tb_professores";
    private final String insert = "insert into tb_professores(cd_professor, nm_professor, nasc_professor, sexo_professor, cpf_professor,rg_professor, cep_professor, ende_professor, bairro_professor, cidade_professor, uf_professor, telefone_professor, celular_professor,email_professor, mat_professor) VALUES (DEFAULT, ?, ?::date, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private final String update = "update tb_professores set cd_professor=?, nm_professor=?, nasc_professor=?::date, sexo_professor= ?, cpf_professor=?, rg_professor=?, cep_professor=?, ende_professor=?, bairro_professor=?, cidade_professor=?,  uf_professor=?, telefone_professor=?, celular_professor=?, email_professor=?,  mat_professor=? WHERE cd_professor = ?";
    private final String delete = "delete from tb_professores where cd_professor = ?";
    private final PreparedStatement pstSelect, pstInsert, pstDelete, pstUpdate;

    public ProfessorDAO(final Connection connection) throws SQLException {
        this.connection = connection;
        pstSelect = this.connection.prepareStatement(select);
        pstInsert = this.connection.prepareStatement(insert);
        pstUpdate = this.connection.prepareStatement(update);
        pstDelete = this.connection.prepareStatement(delete);

    }

    @Override
    public List<Object> Select(Object as_parameter) throws SQLException {

        pstSelect.clearParameters();

        ArrayList<Object> arlDados = new ArrayList<>();

        ResultSet resultado = pstSelect.executeQuery();

        while (resultado.next()) {
            Professor professor = new Professor();
            professor.setcd_professor(resultado.getInt(1));
            professor.setNm_professor(resultado.getString(2));
            professor.setNasc_professor(resultado.getString(3));
            professor.setSexo_professor(resultado.getString(4));
            professor.setCpf_professor(resultado.getString(5));
            professor.setRg_professor(resultado.getString(6));
            professor.setCep_professor(resultado.getString(7));
            professor.setEnd_professor(resultado.getString(8));
            professor.setBairo_professor(resultado.getString(9));
            professor.setCidade_professor(resultado.getString(10));
            professor.setUf_professor(resultado.getString(11));
            professor.setTelefone_professor(resultado.getString(12));
            professor.setCelular_professor(resultado.getString(13));
            professor.setEmail_professor(resultado.getString(14));
            professor.setMat_professor(resultado.getInt(15));

            arlDados.add(professor);

        }
        resultado.close();
        return arlDados;
    }

    @Override
    public void Delete(Object ao_object) throws SQLException {

        pstDelete.clearParameters();

        Professor ioprofessor = (Professor) ao_object;

        Set(pstDelete, 1, ioprofessor.getcd_professor());

        pstDelete.execute();

    }

    @Override
    public void Insert(Object ao_object) throws SQLException {

        pstInsert.clearParameters();

        Professor ioprofessor = (Professor) ao_object;

        Set(pstInsert, 1, ioprofessor.getNm_professor());
        Set(pstInsert, 2, ioprofessor.getNasc_professor());
        Set(pstInsert, 3, ioprofessor.getSexo_professor());
        Set(pstInsert, 4, ioprofessor.getCpf_professor());
        Set(pstInsert, 5, ioprofessor.getRg_professor());
        Set(pstInsert, 6, ioprofessor.getCep_professor());
        Set(pstInsert, 7, ioprofessor.getEnd_professor());
        Set(pstInsert, 8, ioprofessor.getBairo_professor());
        Set(pstInsert, 9, ioprofessor.getCidade_professor());
        Set(pstInsert, 10, ioprofessor.getUf_professor());
        Set(pstInsert, 11, ioprofessor.getTelefone_professor());
        Set(pstInsert, 12, ioprofessor.getCelular_professor());
        Set(pstInsert, 13, ioprofessor.getEmail_professor());
        Set(pstInsert, 14, ioprofessor.getMat_professor());

        pstInsert.execute();

    }

    @Override
    public void Update(Object ao_object) throws SQLException {

        pstUpdate.clearParameters();

        Professor ioprofessor = (Professor) ao_object;

        Set(pstUpdate, 1, ioprofessor.getcd_professor());
        Set(pstUpdate, 2, ioprofessor.getNm_professor());
        Set(pstUpdate, 3, ioprofessor.getNasc_professor());
        Set(pstUpdate, 4, ioprofessor.getSexo_professor());
        Set(pstUpdate, 5, ioprofessor.getCpf_professor());
        Set(pstUpdate, 6, ioprofessor.getRg_professor());
        Set(pstUpdate, 7, ioprofessor.getCep_professor());
        Set(pstUpdate, 8, ioprofessor.getEnd_professor());
        Set(pstUpdate, 9, ioprofessor.getBairo_professor());
        Set(pstUpdate, 10, ioprofessor.getCidade_professor());
        Set(pstUpdate, 11, ioprofessor.getUf_professor());
        Set(pstUpdate, 12, ioprofessor.getTelefone_professor());
        Set(pstUpdate, 13, ioprofessor.getCelular_professor());
        Set(pstUpdate, 14, ioprofessor.getEmail_professor());
        Set(pstUpdate, 15, ioprofessor.getMat_professor());
        Set(pstUpdate, 16, ioprofessor.getcd_professor());

        pstUpdate.execute();

    }

}
