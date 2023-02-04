package com.coding2themax.horsebreedservice.repository.service;

import com.coding2themax.horsebreedservice.model.Horse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HorseRepositoryService {
    public Flux<Horse> findAll();
    
    public Mono<Horse> findOne(String key);


}
