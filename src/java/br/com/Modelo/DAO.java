package br.com.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private final Connection conn;
    private ResultSet rs;

    //construtor da classe que inicializa uma conexão
    public DAO() throws SQLException {
        this.conn = FabricaDeConexoes.getConnection();
    }

    public void insereTipoPessoa(tipopessoa tppessoa) {
        String sql = "INSERT INTO tipopessoa (IdTipoPessoa, Descricao) VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tppessoa.getIdTipoPessoa());
            stmt.setString(2, tppessoa.getDescricao());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void insereTipoAnimal(tipoanimal tpanimal) {
        String sql = "INSERT INTO tipoanimal (IdTipoAnimal, Descricao) VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tpanimal.getIdTipoAnimal());
            stmt.setString(2, tpanimal.getDescricao());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void inserePessoa(pessoa p) {
        String sql = "INSERT INTO pessoa (IdPessoa, Nome, IdTipo, Login, Senha, CEP, Numero, Telefone, Email) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, p.getIdPessoa());
            stmt.setString(2, p.getNome());
            stmt.setInt(3, p.getIdTipo());
            stmt.setString(4, p.getLogin());
            stmt.setString(5, p.getSenha());
            stmt.setString(6, p.getCEP());
            stmt.setString(7, p.getNumero());
            stmt.setString(8, p.getTelefone());
            stmt.setString(9, p.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void insereAnimal(animal a) {
        String sql = "INSERT INTO animal (IdAnimal, IdPessoa, Nome, IdTipo, Raca, DtNasc, Observacoes) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            //Converte data
            java.util.Date utilStartDate = a.getDtNasc();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());            
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, a.getIdAnimal());
            stmt.setInt(2, a.getIdPessoa());
            stmt.setString(3, a.getNome());
            stmt.setInt(4, a.getIdTipo());
            stmt.setString(5, a.getRaca());
            stmt.setDate(6, sqlStartDate);
            stmt.setString(7, a.getObservacoes());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public void editaAnimal(animal a) {
        String sql = "UPDATE animal SET IdPessoa = ?, Nome = ?, IdTipo = ?,  Raca = ?, DtNasc = ?, Observacoes = ? WHERE IdAnimal = ?";
        try {
            //Converte data
            java.util.Date utilStartDate = a.getDtNasc();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());            
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, a.getIdPessoa());
            stmt.setString(2, a.getNome());
            stmt.setInt(3, a.getIdTipo());
            stmt.setString(4, a.getRaca());
            stmt.setDate(5, sqlStartDate);
            stmt.setString(6, a.getObservacoes());
            stmt.setInt(7, a.getIdAnimal());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }    

    public void editaEvento(evento e) {
        String sql = "UPDATE evento SET Data = ?, Descricao = ?, IdAnimal = ?,  IdResponsavel = ?, Valor = ? WHERE IdEvento = ?";
        try {
            //Converte data
            java.util.Date utilStartDate = e.getData();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());            
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, sqlStartDate);
            stmt.setString(2, e.getDescricao());
            stmt.setInt(3, e.getIdAnimal());
             stmt.setInt(4, e.getIdResponsavel());
            stmt.setFloat(5, e.getValor());
            stmt.setInt(6, e.getIdEvento());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }     
    
    public void insereEvento(evento ev) {
        String sql = "INSERT INTO evento (IdEvento, Data, Descricao, IdAnimal, IdResponsavel, Valor) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            //Converte data
            java.util.Date utilStartDate = ev.getData();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ev.getIdEvento());
            stmt.setDate(2, sqlStartDate);
            stmt.setString(3, ev.getDescricao());
            stmt.setInt(4, ev.getIdAnimal());
            stmt.setInt(5, ev.getIdResponsavel());
            stmt.setFloat(6, ev.getValor());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //método para REMOVER UM ITEM DO BANCO
    public void removeTipoPessoa(tipopessoa tp) {
        try {
            int x;
            //string SQL
            String sql = "DELETE FROM tipopessoa WHERE IdTipoPessoa=?";
            //envia o SQL para o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            //obtém o valor de idtipopessoa do Servlet
            x = tp.getIdTipoPessoa();
            //seta o valor de idtipopessoa na SQL
            stmt.setInt(1, x);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void removeTipoAnimal(tipoanimal ta) {
        try {
            int x;
            //string SQL
            String sql = "DELETE FROM tipoanimal WHERE IdTipoAnimal=?";
            //envia o SQL para o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            //obtém o valor de idtipopessoa do Servlet
            x = ta.getIdTipoAnimal();
            //seta o valor de idtipopessoa na SQL
            stmt.setInt(1, x);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void removePessoa(pessoa p) {
        try {
            int x;
            //string SQL
            String sql = "DELETE FROM pessoa WHERE IdPessoa=?";
            //envia o SQL para o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            //obtém o valor de idtipopessoa do Servlet
            x = p.getIdPessoa();
            //seta o valor de idtipopessoa na SQL
            stmt.setInt(1, x);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void removeAnimal(animal a) {
        try {
            int x;
            //string SQL
            String sql = "DELETE FROM animal WHERE IdAnimal=?";
            //envia o SQL para o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            //obtém o valor de idtipopessoa do Servlet
            x = a.getIdAnimal();
            //seta o valor de idtipopessoa na SQL
            stmt.setInt(1, x);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void removeEvento(evento ev) {
        try {
            int x;
            //string SQL
            String sql = "DELETE FROM evento WHERE IdEvento=?";
            //envia o SQL para o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            //obtém o valor de idtipopessoa do Servlet
            x = ev.getIdEvento();
            //seta o valor de idtipopessoa na SQL
            stmt.setInt(1, x);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //método para obter uma lista da tabela 
    public List<tipopessoa> obtemListaTipoPessoa() {
        try {
            //criando uma lista do tipo autores
            List<tipopessoa> Lista = new ArrayList<tipopessoa>();
            //SQL que seleciona todos os registros do banco
            String sql = "SELECT * FROM tipopessoa";
            //envia a string sql para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //resultado da consulta
            ResultSet rs = stmt.executeQuery(sql);
            //enquanto houver registros faça
            while (rs.next()) {
                tipopessoa tp = new tipopessoa();
                //seta o objeto autor com a obtenção do registro a partir de RS
                tp.setIdTipoPessoa(rs.getInt("IdTipoPessoa"));
                tp.setDescricao(rs.getString("Descricao"));
                //adicionando o objeto autores na LISTA
                Lista.add(tp);
            }
            rs.close();
            stmt.close();
            return Lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //método para obter uma lista da tabela 
    public List<tipoanimal> obtemListaTipoAnimal() {
        try {
            //criando uma lista do tipo autores
            List<tipoanimal> Lista = new ArrayList<tipoanimal>();
            //SQL que seleciona todos os registros do banco
            String sql = "SELECT * FROM tipoanimal";
            //envia a string sql para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //resultado da consulta
            ResultSet rs = stmt.executeQuery(sql);
            //enquanto houver registros faça
            while (rs.next()) {
                tipoanimal ta = new tipoanimal();
                //seta o objeto autor com a obtenção do registro a partir de RS
                ta.setIdTipoAnimal(rs.getInt("IdTipoAnimal"));
                ta.setDescricao(rs.getString("Descricao"));
                //adicionando o objeto autores na LISTA
                Lista.add(ta);
            }
            rs.close();
            stmt.close();
            return Lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<pessoa> obtemListaPessoa() {
        try {
            //criando uma lista do tipo autores
            List<pessoa> Lista = new ArrayList<pessoa>();
            //SQL que seleciona todos os registros do banco
            String sql = "SELECT * FROM pessoa";
            //envia a string sql para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //resultado da consulta
            ResultSet rs = stmt.executeQuery(sql);
            //enquanto houver registros faça
            while (rs.next()) {
                pessoa p = new pessoa();
                //seta o objeto autor com a obtenção do registro a partir de RS
                p.setIdPessoa(rs.getInt("IdPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setIdTipo(rs.getInt("IdTipo"));
                p.setLogin(rs.getString("Login"));
                p.setSenha(rs.getString("Senha"));
                p.setCEP(rs.getString("CEP"));
                p.setNumero(rs.getString("Numero"));
                p.setTelefone(rs.getString("Telefone"));
                p.setEmail(rs.getString("Email"));
                //adicionando o objeto autores na LISTA
                Lista.add(p);
            }
            rs.close();
            stmt.close();
            return Lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<animal> obtemListaAnimal() {
        try {
            //criando uma lista do tipo autores
            List<animal> Lista = new ArrayList<animal>();
            //SQL que seleciona todos os registros do banco
            String sql = "SELECT * FROM animal";
            //envia a string sql para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //resultado da consulta
            ResultSet rs = stmt.executeQuery(sql);
            //enquanto houver registros faça
            while (rs.next()) {
                animal a = new animal();
                //seta o objeto autor com a obtenção do registro a partir de RS
                a.setIdAnimal(rs.getInt("IdAnimal"));
                a.setIdPessoa(rs.getInt("IdPessoa"));
                a.setNome(rs.getString("Nome"));
                a.setIdTipo(rs.getInt("IdTipo"));
                a.setRaca(rs.getString("Raca"));
                a.setDtNasc(rs.getDate("DtNasc"));
                //adicionando o objeto autores na LISTA
                Lista.add(a);
            }
            rs.close();
            stmt.close();
            return Lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public List<evento> obtemListaEvento() {
        try {
            //criando uma lista do tipo autores
            List<evento> Lista = new ArrayList<evento>();
            //SQL que seleciona todos os registros do banco
            String sql = "SELECT * FROM evento";
            //envia a string sql para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //resultado da consulta
            ResultSet rs = stmt.executeQuery(sql);
            //enquanto houver registros faça
            while (rs.next()) {
                evento ev = new evento();
                //seta o objeto autor com a obtenção do registro a partir de RS
                ev.setIdEvento(rs.getInt("Cod"));
                ev.setData(rs.getDate("Data"));
                ev.setDescricao(rs.getString("Descricao"));
                ev.setIdAnimal(rs.getInt("IdTipoAnimal"));
                ev.setIdResponsavel(rs.getInt("IdResponsavel"));
                ev.setValor(rs.getFloat("Valor"));
                //adicionando o objeto autores na LISTA
                Lista.add(ev);
            }
            rs.close();
            stmt.close();
            return Lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void alteraTipoPessoa(tipopessoa tp) {
        String sql = "UPDATE tipopessoa SET descricao=? WHERE IdTipoPessoa = ?";
        try {
            //envia a SQL para o banco
            PreparedStatement stmt = conn.prepareStatement(sql);
            //seta os valores da SQL a partir dos parametros do SERVLET
            stmt.setString(1, tp.getDescricao());
            stmt.setInt(2, tp.getIdTipoPessoa());
            //executa a string sql
            stmt.execute();
            //fecha a conexão 
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //método para buscar pelo ID
    public List<tipopessoa> obtemTipoPessoaPeloId(tipopessoa tp) {
        try {
            //id recebe o valor de idtipopessoa do SERVLET
            //int id = a.getIdTipoPessoa();
            //cria uma lista para receber os valores da pesquisa
            List<tipopessoa> listTipoPessoa = new ArrayList<tipopessoa>();
            //STRINGL SQL
            String sql = "SELECT * FROM tipopessoa WHERE IdTipoPessoa = ?";
            //envia a string para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //seta a string SQL
            stmt.setInt(1, tp.getIdTipoPessoa());
            //executa a sql e retorna em RS
            ResultSet rs = stmt.executeQuery();
            //percorrendo o RS
            while (rs.next()) {
                tipopessoa tipoPessoa = new tipopessoa();
                //obtem os valores do banco e passa para o objeto autor
                tipoPessoa.setIdTipoPessoa(rs.getInt("IdTipoPessoa"));
                tipoPessoa.setDescricao(rs.getString("Descricao"));
                //lista é configurada com o objeto autor
                listTipoPessoa.add(tipoPessoa);
            }
            rs.close();
            stmt.close();
            return listTipoPessoa;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }    
    
    //método para buscar pelo ID
    public pessoa obtemPessoaPeloId(Integer ID) {
        try {
            //id recebe o valor de idtipopessoa do SERVLET
            //int id = a.getIdTipoPessoa();
            //cria uma lista para receber os valores da pesquisa
            //STRING SQL
            String sql = "SELECT * FROM pessoa WHERE IdPessoa = ?";
            //envia a string para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //seta a string SQL
            stmt.setInt(1, ID);
            //executa a sql e retorna em RS
            ResultSet rs = stmt.executeQuery();
            
            pessoa Pessoa = new pessoa();
            //obtem os valores do banco e passa para o objeto autor
            Pessoa.setIdPessoa(rs.getInt("IdPessoa"));
            Pessoa.setNome(rs.getString("Nome"));
            Pessoa.setIdTipo(rs.getInt("IdTipo"));
            Pessoa.setLogin(rs.getString("Login"));
            Pessoa.setSenha(rs.getString("Senha"));
            Pessoa.setCEP(rs.getString("CEP"));
            Pessoa.setNumero(rs.getString("Numero"));
            Pessoa.setTelefone(rs.getString("Telefone"));
            Pessoa.setEmail(rs.getString("Email"));
            
            rs.close();
            stmt.close();
            return Pessoa;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public pessoa autenticaPessoa(String Login, String Senha){
        try {
            String sql = "SELECT * FROM pessoa WHERE Login = ? AND Senha = ?";
            //envia a string para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //seta a string SQL
            stmt.setString(1, Login);
            stmt.setString(2, Senha);
            //executa a sql e retorna em RS
            ResultSet rs = stmt.executeQuery();
            //percorrendo o RS
            if(!rs.next()){
                return new pessoa(0);
            }
            pessoa Pessoa = new pessoa();
            Pessoa.setIdPessoa(rs.getInt("IdPessoa"));
            Pessoa.setNome(rs.getString("Nome"));
            Pessoa.setIdTipo(rs.getInt("IdTipo"));
            Pessoa.setLogin(rs.getString("Login"));
            Pessoa.setSenha(rs.getString("Senha"));
            Pessoa.setCEP(rs.getString("CEP"));
            Pessoa.setNumero(rs.getString("Numero"));
            Pessoa.setTelefone(rs.getString("Telefone"));
            Pessoa.setEmail(rs.getString("Email"));            
            
            rs.close();
            stmt.close();
            return Pessoa;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    } 
    
    public List<evento> getEventos(pessoa P){
        try {
            List<evento> listEvento = new ArrayList<evento>();
            String sql = "SELECT * FROM evento WHERE IdResponsavel = ?";
            //envia a string para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //seta a string SQL
            stmt.setInt(1, P.getIdPessoa());
            //executa a sql e retorna em RS
            ResultSet rs = stmt.executeQuery();
            
            //percorrendo o RS
            while (rs.next()) {
                evento Evento = new evento();
                //obtem os valores do banco
                Evento.setIdEvento(rs.getInt("IdEvento"));
                Evento.setData(rs.getDate("Data"));
                Evento.setDescricao(rs.getString("Descricao"));
                Evento.setIdAnimal(rs.getInt("IdAnimal"));
                Evento.setIdResponsavel(rs.getInt("IdResponsavel"));
                //lista é configurada com o objeto autor
                listEvento.add(Evento);
            }
            rs.close();
            stmt.close();
            return listEvento;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }   
    
    public List<animal> getAnimais(pessoa P){
        try {
            List<animal> listAnimal = new ArrayList<animal>();
            String sql = "SELECT * FROM animal WHERE IdPessoa = ?";
            //envia a string para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //seta a string SQL
            stmt.setInt(1, P.getIdPessoa());
            //executa a sql e retorna em RS
            ResultSet rs = stmt.executeQuery();
            
            //percorrendo o RS
            while (rs.next()) {
                animal Animal = new animal();
                //obtem os valores do banco
                Animal.setIdAnimal(rs.getInt("IdAnimal"));
                Animal.setIdPessoa(rs.getInt("IdPessoa"));
                Animal.setNome(rs.getString("Nome"));
                Animal.setIdTipo(rs.getInt("IdTipo"));
                Animal.setRaca(rs.getString("Raca"));
                Animal.setDtNasc(rs.getDate("DtNasc"));
                Animal.setObservacoes(rs.getString("Observacoes"));
                //lista é configurada com o objeto autor
                listAnimal.add(Animal);
            }
            rs.close();
            stmt.close();
            return listAnimal;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    } 
    
    public String getNomeAnimalPeloId(Integer ID){
        try {
            String sql = "SELECT Nome FROM animal WHERE IdAnimal = ?";
            //envia a string para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //seta a string SQL
            stmt.setInt(1, ID);
            //executa a sql e retorna em RS
            ResultSet rs = stmt.executeQuery();
            rs.next();
            String Nome = rs.getString("Nome");
            rs.close();
            stmt.close();
            return Nome;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public String getNomeTipoAnimalPeloId(Integer ID){
        try {
            String sql = "SELECT Descricao FROM tipoanimal WHERE IdTipoAnimal = ?";
            //envia a string para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //seta a string SQL
            stmt.setInt(1, ID);
            //executa a sql e retorna em RS
            ResultSet rs = stmt.executeQuery();
            rs.next();
            String Nome = rs.getString("Descricao");
            rs.close();
            stmt.close();
            return Nome;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }    
    
    public animal getAnimalPeloId(Integer ID){
        try {
            String sql = "SELECT * FROM animal WHERE IdAnimal = ?";
            //envia a string para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //seta a string SQL
            stmt.setInt(1, ID);
            //executa a sql e retorna em RS
            ResultSet rs = stmt.executeQuery();
            rs.next();
            animal Animal = new animal();
            //obtem os valores do banco
            Animal.setIdAnimal(rs.getInt("IdAnimal"));
            Animal.setIdPessoa(rs.getInt("IdPessoa"));
            Animal.setNome(rs.getString("Nome"));
            Animal.setIdTipo(rs.getInt("IdTipo"));
            Animal.setRaca(rs.getString("Raca"));
            Animal.setDtNasc(rs.getDate("DtNasc"));
            Animal.setObservacoes(rs.getString("Observacoes"));
            rs.close();
            stmt.close();
            return Animal;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    } 
    
    public evento getEventoPeloId(Integer ID){
        try {
            String sql = "SELECT * FROM evento WHERE IdEvento = ?";
            //envia a string para o banco
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            //seta a string SQL
            stmt.setInt(1, ID);
            //executa a sql e retorna em RS
            ResultSet rs = stmt.executeQuery();
            rs.next();
            evento Evento = new evento();
            //obtem os valores do banco
            Evento.setIdEvento(rs.getInt("IdEvento"));
            Evento.setData(rs.getDate("Data"));
            Evento.setDescricao(rs.getString("Descricao"));
            Evento.setIdAnimal(rs.getInt("IdAnimal"));
            Evento.setIdResponsavel(rs.getInt("IdResponsavel"));
            rs.close();
            stmt.close();
            return Evento;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }    
}
