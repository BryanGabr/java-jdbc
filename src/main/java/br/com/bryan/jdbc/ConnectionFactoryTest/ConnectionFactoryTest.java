package br.com.bryan.jdbc.ConnectionFactoryTest;

import br.com.bryan.jdbc.model.Producer;
import br.com.bryan.jdbc.service.ProducerService;

public class ConnectionFactoryTest {
    public static void main(String[] args) {

        Producer producer = Producer.builder().name("Gabriel").build();
        Producer producerToUpdate = Producer.builder().id(7).name("Mirela").build();

        ProducerService.update(producerToUpdate);

    }
}
