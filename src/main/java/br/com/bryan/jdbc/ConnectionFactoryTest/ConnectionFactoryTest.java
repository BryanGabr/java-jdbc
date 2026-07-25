package br.com.bryan.jdbc.ConnectionFactoryTest;

import br.com.bryan.jdbc.conn.ConnectionFactory;
import br.com.bryan.jdbc.model.Producer;
import br.com.bryan.jdbc.repository.ProducerRepository;

import java.sql.SQLException;

public class ConnectionFactoryTest {
    public static void main(String[] args) {

        Producer producer = Producer.ProducerBuilder.builder().name("Gabriel").build();

        ProducerRepository.save(producer);
    }
}
