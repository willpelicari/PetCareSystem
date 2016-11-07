package br.com.Modelo;

public class tipopessoa {

    private int IdTipoPessoa;
    private String Descricao;

    public tipopessoa() {
    }

    public tipopessoa(int IdTipoPessoa, String Descricao) {
        this.IdTipoPessoa = IdTipoPessoa;
        this.Descricao = Descricao;
    }

    public int getIdTipoPessoa() {
        return IdTipoPessoa;
    }

    public void setIdTipoPessoa(int IdTipoPessoa) {
        this.IdTipoPessoa = IdTipoPessoa;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

}
