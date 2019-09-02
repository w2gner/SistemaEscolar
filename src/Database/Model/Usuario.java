package database.model;

public class Usuario {
	private String senha;
	private String nome;
	private Boolean is_Admin;

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
}
