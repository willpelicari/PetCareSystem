package br.com.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

    private static final String BANCODADOS = "petcaresystem";
    private static final String URL = "jdbc:mysql://localhost/" + BANCODADOS;
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            System.out.println(" ");
            System.out.println(" --- Conexão criada com o banco de dados MySQL --- ");
            System.out.println(" ");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());            
            throw new SQLException(e.getMessage());            
        }
    }

}
