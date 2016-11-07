package br.com.Modelo;

import java.util.Date;

public class animal {

    private int IdAnimal;
    private int IdPessoa;
    private String Nome;
    private int IdTipo;
    private String Raca;
    private Date DtNasc;
    private String Observacoes;

    public animal() {
    }

    public animal(int IdAnimal, int IdPessoa, String Nome, int IdTipo, String Raca, Date DtNasc, String Observacoes) {
        this.IdAnimal = IdAnimal;
        this.IdPessoa = IdPessoa;
        this.Nome = Nome;
        this.IdTipo = IdTipo;
        this.Raca = Raca;
        this.DtNasc = DtNasc;
        this.Observacoes = Observacoes;
    }

    public int getIdAnimal() {
        return IdAnimal;
    }

    public void setIdAnimal(int IdAnimal) {
        this.IdAnimal = IdAnimal;
    }

    public int getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(int IdPessoa) {
        this.IdPessoa = IdPessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(int IdTipo) {
        this.IdTipo = IdTipo;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String Raca) {
        this.Raca = Raca;
    }

    public Date getDtNasc() {
        return DtNasc;
    }

    public void setDtNasc(Date DtNasc) {
        this.DtNasc = DtNasc;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

}
