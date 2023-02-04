package com.coding2themax.horsebreedservice.repository.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.coding2themax.horsebreedservice.model.BloodType;
import com.coding2themax.horsebreedservice.model.Horse;
import com.coding2themax.horsebreedservice.model.HorseType;
import com.coding2themax.horsebreedservice.repository.ReactiveHorseRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class ReactiveRepositoryServiceTest {


    @Mock
    ReactiveHorseRepository repository;

    @InjectMocks
    ReactiveRepositoryService service;


    @Test
    void testFindAll() {

        Horse h1 = new Horse("12", "breddN", BloodType.WARM, HorseType.HEAVY);   
        Flux<Horse> horsesFlux = Flux.just(h1);
        BDDMockito.given(repository.findAll()).willReturn(horsesFlux);
        Flux<Horse> resulFlux = service.findAll();
        StepVerifier.create(resulFlux).assertNext(sr -> {
            sr.id().equalsIgnoreCase("12");
          }).expectComplete().verify();

    }

    @Test
    void testFindOne() {
        Horse h1 = new Horse("12", "breddN", BloodType.WARM, HorseType.HEAVY);   
        Mono<Horse> oneHorse = Mono.just(h1);

        BDDMockito.given(repository.findOne("12")).willReturn(oneHorse);
        Mono<Horse> mockResult = service.findOne("12");

        StepVerifier.create(mockResult).assertNext( mr -> {
            mr.id().equalsIgnoreCase("12");
        }).expectComplete().verify();

    }
}
