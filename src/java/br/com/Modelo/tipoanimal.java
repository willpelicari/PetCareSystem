package br.com.Modelo;

public class tipoanimal {

    private int IdTipoAnimal;
    private String Descricao;

    public tipoanimal() {
    }

    public tipoanimal(int IdTipoAnimal, String Descricao) {
        this.IdTipoAnimal = IdTipoAnimal;
        this.Descricao = Descricao;
    }

    public int getIdTipoAnimal() {
        return IdTipoAnimal;
    }

    public void setIdTipoAnimal(int IdTipoAnimal) {
        this.IdTipoAnimal = IdTipoAnimal;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

}
