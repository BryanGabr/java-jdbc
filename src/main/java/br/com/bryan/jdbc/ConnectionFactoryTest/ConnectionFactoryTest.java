package br.com.bryan.jdbc.ConnectionFactoryTest;

import br.com.bryan.jdbc.model.Producer;
import br.com.bryan.jdbc.service.ProducerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ConnectionFactoryTest {
    private static final Logger log = LogManager.getLogger(ConnectionFactoryTest.class);

    public static void main(String[] args) {

        Producer producer = Producer.builder().name("Lima").build();
        Producer producerToUpdate = Producer.builder().id(7).name("Mirela").build();

        //ProducerService.update(producerToUpdate);
        //ProducerService.save(producer);

        //List<Producer> producers = ProducerService.findAll();

        //log.info("Found producers {}", producers);

        //log.info("Found Producer {}", ProducerService.findAllName("Bry"));

        //ProducerService.showMetaData();

        ProducerService.showDriverMetaData();
    }
}
