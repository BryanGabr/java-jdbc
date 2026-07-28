package br.com.bryan.jdbc.ConnectionFactoryTest;

import br.com.bryan.jdbc.model.Producer;
import br.com.bryan.jdbc.repository.ProducerRepository;

public class ConnectionFactoryTest {
    public static void main(String[] args) {

        Producer producer = Producer.builder().name("Mirella").build();

        ProducerRepository.save(producer);
    }
}
