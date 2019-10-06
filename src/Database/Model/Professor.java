package database.model;

public class Professor implements MasterModel {
	private int cd_professor;
	private String nm_professor;
	private String nasc_professor;
	private String sexo_professor;
	private String cpf_professor;
	private String rg_professor;
	private String cep_professor;
	private String end_professor;
	private String bairo_professor;
	private String cidade_professor;
	private String uf_professor;
	private String telefone_professor;
	private String celular_professor;
	private String email_professor;
	private int mat_professor;

	public int getcd_professor() {
		return cd_professor;
	}

	public void setcd_professor(int cd_professor) {
		this.cd_professor = cd_professor;
	}

	public String getNm_professor() {
		return nm_professor;
	}

	public void setNm_professor(String nm_professor) {
		this.nm_professor = nm_professor;
	}

	public String getNasc_professor() {
		return nasc_professor;
	}

	public void setNasc_professor(String nasc_professor) {
		this.nasc_professor = nasc_professor;
	}

	public String getSexo_professor() {
		return sexo_professor;
	}

	public void setSexo_professor(String sexo_professor) {
		this.sexo_professor = sexo_professor;
	}

	public String getCpf_professor() {
		return cpf_professor;
	}

	public void setCpf_professor(String cpf_professor) {
		this.cpf_professor = cpf_professor;
	}

	public String getRg_professor() {
		return rg_professor;
	}

	public void setRg_professor(String rg_professor) {
		this.rg_professor = rg_professor;
	}

	public String getCep_professor() {
		return cep_professor;
	}

	public void setCep_professor(String cep_professor) {
		this.cep_professor = cep_professor;
	}

	public String getEnd_professor() {
		return end_professor;
	}

	public void setEnd_professor(String end_professor) {
		this.end_professor = end_professor;
	}

	public String getBairo_professor() {
		return bairo_professor;
	}

	public void setBairo_professor(String bairo_professor) {
		this.bairo_professor = bairo_professor;
	}

	public String getCidade_professor() {
		return cidade_professor;
	}

	public void setCidade_professor(String cidade_professor) {
		this.cidade_professor = cidade_professor;
	}

	public String getUf_professor() {
		return uf_professor;
	}

	public void setUf_professor(String uf_professor) {
		this.uf_professor = uf_professor;
	}

	public String getTelefone_professor() {
		return telefone_professor;
	}

	public void setTelefone_professor(String telefone_professor) {
		this.telefone_professor = telefone_professor;
	}

	public String getCelular_professor() {
		return celular_professor;
	}

	public void setCelular_professor(String celular_professor) {
		this.celular_professor = celular_professor;
	}

	public String getEmail_professor() {
		return email_professor;
	}

	public void setEmail_professor(String email_professor) {
		this.email_professor = email_professor;
	}

	public int getMat_professor() {
		return mat_professor;
	}

	public void setMat_professor(int mat_professor) {
		this.mat_professor = mat_professor;
	}

	@Override
	public Object[] getSearchLine() {
		return new Object[] { mat_professor, nm_professor };
	}

}
