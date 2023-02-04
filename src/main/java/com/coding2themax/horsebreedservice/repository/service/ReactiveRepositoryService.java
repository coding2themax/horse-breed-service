package com.coding2themax.horsebreedservice.repository.service;

import org.springframework.stereotype.Service;

import com.coding2themax.horsebreedservice.model.Horse;
import com.coding2themax.horsebreedservice.repository.ReactiveHorseRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveRepositoryService implements HorseRepositoryService {



    ReactiveHorseRepository repository;

    
    public ReactiveRepositoryService(ReactiveHorseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Horse> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Horse> findOne(String key) {
        return repository.findOne(key);
    }
    
}
