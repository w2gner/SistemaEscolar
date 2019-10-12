package database.model;

public class Disciplina implements MasterModel {

    private int qtdCreditos;
    private int cod_disciplina;
    private String disciplina;
    private String cargaHoraria;
    private String professor_disciplina;

    public int getQtdCreditos() {
        return qtdCreditos;
    }

    public void setQtdCreditos(int qtdCreditos) {
        this.qtdCreditos = qtdCreditos;
    }

    public String getProfessor_disciplina() {
        return professor_disciplina;
    }

    public void setProfessor_disciplina(String professor_disciplina) {
        this.professor_disciplina = professor_disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCod_disciplina() {
        return cod_disciplina;
    }

    public void setCod_disciplina(int cod_disciplina) {
        this.cod_disciplina = cod_disciplina;
    }

    @Override
    public Object[] getSearchLine() {
        return new Object[]{cod_disciplina, disciplina};
    }

}
