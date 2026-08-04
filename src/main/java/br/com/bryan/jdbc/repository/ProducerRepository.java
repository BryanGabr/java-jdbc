package br.com.bryan.jdbc.repository;

import br.com.bryan.jdbc.conn.ConnectionFactory;
import br.com.bryan.jdbc.model.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {

    public static void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s')".formatted(producer.getName());

        try (Connection conn = ConnectionFactory.getConnection();
             // Statement é usada para enviar comandos SQL sem parâmetros ao banco de dados.
             // executeUpdate responsável por executar os instruções SQL.

             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);

            log.info("Inserted producer '{}' in the Database, rows affected {}", producer.getName(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying for insert prducer '{}'", producer.getName(), e);
        }
    }

    public static void delete(int id) {
        String sql = "delete from anime_store.producer where id = '%d'".formatted(id);

        try (Connection conn = ConnectionFactory.getConnection();

             Statement stmt = conn.createStatement()) {

            int rowsAffected = stmt.executeUpdate(sql);

            log.info("Delete producer '{}' from the Database, rows affected {}", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying for delete producer '{}'", id, e);
        }
    }

    public static void update(Producer producer) {
        String sql = "update anime_store.producer set name = '%s' where id = '%d'".formatted(producer.getName(), producer.getId());

        try (Connection conn = ConnectionFactory.getConnection();

             Statement stmt = conn.createStatement()) {

            int rowsAffected = stmt.executeUpdate(sql);

            log.info("Update producer '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying for update producer '{}'", producer.getId(), e);
        }
    }

    public static List<Producer> findAll() {
        log.info("Finding all producers");

        return ProducerRepository.findByName("");
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding Producer");

        String sql = "select * from anime_store.producer where name like '%%%s%%'".formatted(name);

        List<Producer> producers = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                producers.add(Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build());
            }
        } catch (SQLException e) {
            log.error("Error while trying for find producer by name", e);
        }
        return producers;
    }

    public static void showMetaData() {
        log.info("Showing Producer MetaData");

        String sql = "select * from anime_store.producer";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            ResultSetMetaData rsMetaData = rs.getMetaData();
            rs.next();
            int columnCount = rsMetaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++){
                log.info(rsMetaData.getTableName(i));
                log.info(rsMetaData.getColumnName(i));
                log.info(rsMetaData.getColumnTypeName(i));
                log.info(rsMetaData.getColumnDisplaySize(i));
            }

        } catch (SQLException e) {
            log.error("Error while trying for show MetaData", e);
        }
    }
}
