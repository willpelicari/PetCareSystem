package br.com.Modelo;

import java.util.Date;

public class evento {

    private int IdEvento;
    private Date Data;
    private String Descricao;
    private int IdAnimal;
    private int IdResponsavel;
    private float Valor;

    public evento() {
    }
    
    public evento(Integer ID) {
        this.IdEvento = ID;
    }  

    public evento(int IdEvento, Date Data, String Descricao, int IdAnimal, int IdResponsavel, float Valor) {
        this.IdEvento = IdEvento;
        this.Data = Data;
        this.Descricao = Descricao;
        this.IdAnimal = IdAnimal;
        this.IdResponsavel = IdResponsavel;
        this.Valor = Valor;
    }

    public int getIdEvento() {
        return IdEvento;
    }

    public void setIdEvento(int IdEvento) {
        this.IdEvento = IdEvento;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getIdAnimal() {
        return IdAnimal;
    }

    public void setIdAnimal(int IdAnimal) {
        this.IdAnimal = IdAnimal;
    }

    public int getIdResponsavel() {
        return IdResponsavel;
    }

    public void setIdResponsavel(int IdResponsavel) {
        this.IdResponsavel = IdResponsavel;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

}
