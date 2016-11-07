package br.com.Modelo;

public class pessoa {

    private Integer IdPessoa;
    private String Nome;
    private Integer IdTipo;
    private String Login;
    private String Senha;
    private String CEP;
    private String Numero;
    private String Telefone;
    private String Email;

    public pessoa() {
    }
    
    public pessoa(Integer IdPessoa) {
        this.IdPessoa = IdPessoa;
    }    

    public pessoa(Integer IdPessoa, String Nome, Integer IdTipo, String Login, String Senha, String CEP, String Numero, String Telefone, String Email) {
        this.IdPessoa = IdPessoa;
        this.Nome = Nome;
        this.IdTipo = IdTipo;
        this.Login = Login;
        this.Senha = Senha;
        this.CEP = CEP;
        this.Numero = Numero;
        this.Telefone = Telefone;
        this.Email = Email;
    }

    public pessoa(Integer IdPessoa, String Nome, Integer IdTipo, String Login, String Senha) {
        this.IdPessoa = IdPessoa;
        this.Nome = Nome;
        this.IdTipo = IdTipo;
        this.Login = Login;
        this.Senha = Senha;
        this.CEP = CEP;
        this.Numero = Numero;
        this.Telefone = Telefone;
        this.Email = Email;
    }    
    
    public Integer getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(Integer IdPessoa) {
        this.IdPessoa = IdPessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Integer getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(Integer IdTipo) {
        this.IdTipo = IdTipo;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
