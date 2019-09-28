package database.model;

public class Aluno implements MasterModel{
	private int cd_aluno;
	private String nm_aluno;
	private String nasc_aluno;
	private char sexo_aluno;
	private String cpf_aluno;
	private String rg_aluno;
	private String cep_aluno;
	private String end_aluno;
	private String bairo_aluno;
	private String cidade_aluno;
	private String uf_aluno;
	private String telefone_aluno;
	private String celular_aluno;
	private String email_aluno;
	private int mat_aluno;

	public int getCd_aluno() {
		return cd_aluno;
	}

	public void setCd_aluno(int cd_aluno) {
		this.cd_aluno = cd_aluno;
	}

	public String getNm_aluno() {
		return nm_aluno;
	}

	public void setNm_aluno(String nm_aluno) {
		this.nm_aluno = nm_aluno;
	}

	public String getNasc_aluno() {
		return nasc_aluno;
	}

	public void setNasc_aluno(String nasc_aluno) {
		this.nasc_aluno = nasc_aluno;
	}

	public char getSexo_aluno() {
		return sexo_aluno;
	}

	public void setSexo_aluno(char sexo_aluno) {
		this.sexo_aluno = sexo_aluno;
	}

	public String getCpf_aluno() {
		return cpf_aluno;
	}

	public void setCpf_aluno(String cpf_aluno) {
		this.cpf_aluno = cpf_aluno;
	}

	public String getRg_aluno() {
		return rg_aluno;
	}

	public void setRg_aluno(String rg_aluno) {
		this.rg_aluno = rg_aluno;
	}

	public String getCep_aluno() {
		return cep_aluno;
	}

	public void setCep_aluno(String cep_aluno) {
		this.cep_aluno = cep_aluno;
	}

	public String getEnd_aluno() {
		return end_aluno;
	}

	public void setEnd_aluno(String end_aluno) {
		this.end_aluno = end_aluno;
	}

	public String getBairo_aluno() {
		return bairo_aluno;
	}

	public void setBairo_aluno(String bairo_aluno) {
		this.bairo_aluno = bairo_aluno;
	}

	public String getCidade_aluno() {
		return cidade_aluno;
	}

	public void setCidade_aluno(String cidade_aluno) {
		this.cidade_aluno = cidade_aluno;
	}

	public String getUf_aluno() {
		return uf_aluno;
	}

	public void setUf_aluno(String uf_aluno) {
		this.uf_aluno = uf_aluno;
	}

	public String getTelefone_aluno() {
		return telefone_aluno;
	}

	public void setTelefone_aluno(String telefone_aluno) {
		this.telefone_aluno = telefone_aluno;
	}

	public String getCelular_aluno() {
		return celular_aluno;
	}

	public void setCelular_aluno(String celular_aluno) {
		this.celular_aluno = celular_aluno;
	}

	public String getEmail_aluno() {
		return email_aluno;
	}

	public void setEmail_aluno(String email_aluno) {
		this.email_aluno = email_aluno;
	}

	public int getMat_aluno() {
		return mat_aluno;
	}

	public void setMat_aluno(int mat_aluno) {
		this.mat_aluno = mat_aluno;
	}

	@Override
	public Object[] getSearchLine() {
		// TODO Auto-generated method stub
		return new Object[] {
				cd_aluno,
				nm_aluno
		};
	}

}
