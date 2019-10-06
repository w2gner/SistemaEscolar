package database.model;

public class Curso implements MasterModel {
    private int id;
    private String nome;
    private int qtdCreditos;
    private Double valorCreditos;

    public Double getValorCreditos() {
        return valorCreditos;
    }

    public void setValorCreditos(Double valorCreditos) {
        this.valorCreditos = valorCreditos;
    }

    public int getQtdCreditos() {
        return qtdCreditos;
    }

    public void setQtdCreditos(int qtdCreditos) {
        this.qtdCreditos = qtdCreditos;
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
