package br.com.bryan.jdbc.repository;

import br.com.bryan.jdbc.conn.ConnectionFactory;
import br.com.bryan.jdbc.model.Producer;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ProducerRepository {

    public static void save(Producer producer){
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s')".formatted(producer.getName());

        try (Connection conn = ConnectionFactory.getConnection();
             // Statement é usada para enviar comandos SQL estáticos ao banco de dados.
            // Responsável por executar os instruções SQL estáticos.

             Statement stmt = conn.createStatement()) {
             int rowsAffected = stmt.executeUpdate(sql);

            log.info("Database rows affected {}", rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
