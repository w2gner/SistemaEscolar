package database.model;

public class Curso implements MasterModel {
    private int id;
    private String nome;
    private Double valorMatricula;
    private Double valorCreditos;

    public Double getValorCreditos() {
        return valorCreditos;
    }

    public void setValorCreditos(Double valorCreditos) {
        this.valorCreditos = valorCreditos;
    }

    public Double getValorMatricula() {
        return valorMatricula;
    }

    public void setValorMatricula(Double valorMatricula) {
        this.valorMatricula = valorMatricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Object[] getSearchLine() {
        return new Object[]{id, nome};
    }
}
