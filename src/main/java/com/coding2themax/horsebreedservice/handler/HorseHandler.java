package com.coding2themax.horsebreedservice.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.coding2themax.horsebreedservice.model.Horse;
import com.coding2themax.horsebreedservice.repository.ReactiveHorseRepository;

import reactor.core.publisher.Mono;

@Component
public class HorseHandler {
  
  ReactiveHorseRepository repository;

  


  public HorseHandler(ReactiveHorseRepository repository) {
    this.repository = repository;
  }




  public Mono<ServerResponse> findAllHorses(ServerRequest request){

    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(repository.findAll(), Horse.class);
  }

  public Mono<ServerResponse> findHorse(ServerRequest request){
    String horseID = request.pathVariable("id");
    Mono<Horse> mockHorse = repository.findOne(horseID);
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(mockHorse, Horse.class);
  }
}
