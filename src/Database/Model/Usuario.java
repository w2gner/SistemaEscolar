package database.model;

public class Usuario implements MasterModel {
	private String senha;
	private String nome;
	private Boolean is_Admin;
	private int id;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIs_Admin() {
		return is_Admin;
	}

	public void setIs_Admin(Boolean is_Admin) {
		this.is_Admin = is_Admin;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	@Override
	public Object[] getSearchLine() {
		return new Object[] { is_Admin, nome };
	}
}
