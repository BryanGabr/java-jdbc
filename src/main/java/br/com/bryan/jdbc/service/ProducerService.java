package br.com.bryan.jdbc.service;

import br.com.bryan.jdbc.model.Producer;
import br.com.bryan.jdbc.repository.ProducerRepository;

public class ProducerService {

    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }

    public static void delete(Integer id) {
        requereValidId(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer){
        requereValidId(producer.getId());
        ProducerRepository.update(producer);
    }

    public static void requereValidId(Integer id){
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Invalid value for id");
        }
    }
}
