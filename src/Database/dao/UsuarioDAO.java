package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.model.Usuario;

public class UsuarioDAO extends MasterDao {

    private Connection connection;
    private final String select = "select * from tb_usuarios";
    private final String insert = "insert into tb_usuarios (cod_usuario, usuario, senha) VALUES (DEFAULT, ?, ?)";
    private final String update = "update tb_alunos set cd_aluno=?, nm_aluno=?";
    private final String delete = "delete from tb_alunos where cd_aluno = ?";
    private final PreparedStatement pstSelect, pstInsert, pstDelete, pstUpdate;

    public UsuarioDAO(final Connection connection) throws SQLException {
        this.connection = connection;
        pstSelect = this.connection.prepareStatement(select);
        pstInsert = this.connection.prepareStatement(insert);
        pstUpdate = this.connection.prepareStatement(update);
        pstDelete = this.connection.prepareStatement(delete);
    }

    @Override
    public List<Object> Select(Object as_parameter) throws SQLException {
        
        pstSelect.clearParameters();
        
        ArrayList<Object> usuarios = new ArrayList<Object>();

        ResultSet resultado = pstSelect.executeQuery();

        while(resultado.next()){
            Usuario user = new Usuario();
            user.setIs_Admin(resultado.getBoolean("is_admin"));
            user.setNome(resultado.getString("usuario"));
            user.setSenha(resultado.getString("senha"));
            usuarios.add(user);
        }

        pstSelect.close();

        return usuarios;
    }

    @Override
    public void Insert(Object ao_object) throws SQLException {

        pstInsert.clearParameters();

		@SuppressWarnings("unused")
		Usuario ioUsuario = (Usuario) ao_object;
		
        Set(pstInsert, 1, ioUsuario.getNome());
        //Set(pstInsert, 2, ioUsuario.getIs_Admin());
        Set(pstInsert, 2, ioUsuario.getSenha());

		pstInsert.execute();
		//connection.commit();

    }

    @Override
    public void Update(Object ao_object) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void Delete(Object ao_object) throws SQLException {
        // TODO Auto-generated method stub

    }
}