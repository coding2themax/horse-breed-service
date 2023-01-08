package com.coding2themax.horsebreedservice.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coding2themax.horsebreedservice.model.BloodType;
import com.coding2themax.horsebreedservice.model.Horse;
import com.coding2themax.horsebreedservice.model.HorseType;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class ReactiveHorseRepositoryTest {
  ReactiveHorseRepository repository;

  @BeforeEach
  void setUp(){
    repository = new ReactiveHorseRepository();
  }

  @Test
  void testFindOne() {

    repository.findOne("1");
    

  }

  @Test
  void testFindAll() {
     Flux<Horse> mockResults =  repository.findAll();
     StepVerifier.create(mockResults).expectNext( new Horse("1", "horse breed 1", BloodType.COLD, HorseType.HORSETYPE3));

  
  }
}
