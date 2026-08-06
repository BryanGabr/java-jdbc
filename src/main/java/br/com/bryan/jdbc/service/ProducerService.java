package br.com.bryan.jdbc.service;

import br.com.bryan.jdbc.model.Producer;
import br.com.bryan.jdbc.repository.ProducerRepository;

import java.util.List;

public class ProducerService {


    public static void save(Producer producer) {
        ProducerRepository.save(producer);
    }

    public static void delete(Integer id) {
        requereValidId(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer) {
        requereValidId(producer.getId());
        ProducerRepository.update(producer);
    }

    public static void requereValidId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }
    }

    public static List<Producer> findAll() {
        return ProducerRepository.findAll();
    }

    public static List<Producer> findAllName(String name) {
        return ProducerRepository.findByName(name);
    }

    public static void showMetaData() {
        ProducerRepository.showMetaData();
    }

    public static void showDriverMetaData() {
        ProducerRepository.showDriverMetaData();
    }

    public static void showTypeScrollWorking() {
        ProducerRepository.showTypeScrollWorking();
    }

    public static List<Producer> findByNameAndUpdateForUpperCase(String name) {
        return ProducerRepository.findByNameAndUpdateToUpperCase(name);
    }
}
