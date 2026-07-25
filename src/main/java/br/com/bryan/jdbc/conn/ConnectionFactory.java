package br.com.bryan.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "";

        return DriverManager.getConnection(url, username, password);

        // DriverManager: Classe do jdbc responsável para abrir conexão Java e o banco de dados.
        // getConnection: Método tentar criar uma conexão.
    }
}
