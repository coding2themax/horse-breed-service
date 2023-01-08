package com.coding2themax.horsebreedservice.handler;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.reactive.function.server.MockServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.coding2themax.horsebreedservice.model.BloodType;
import com.coding2themax.horsebreedservice.model.Horse;
import com.coding2themax.horsebreedservice.model.HorseType;
import com.coding2themax.horsebreedservice.repository.ReactiveHorseRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class HorseHandlerTest {


  @Mock
  ReactiveHorseRepository reactiveHorseRepository;

  @InjectMocks
  HorseHandler handler;
  
  @Test
  void testFindAllHorses() {

    Map<String, Horse> HORSE_DATA = new HashMap<>();

    HORSE_DATA.put("1", new Horse("1", "horse breed 1", BloodType.COLD, HorseType.PONY));
    HORSE_DATA.put("2", new Horse("2", "horse breed 2", BloodType.WARM,HorseType.HEAVY));
    HORSE_DATA.put("3", new Horse("3", "horse breed 3", BloodType.HOT,HorseType.LIGHT));
    HORSE_DATA.put("4", new Horse("4", "horse breed 4", BloodType.WARM,HorseType.PONY));
    Flux<Horse> mockHorse = Flux.fromIterable(HORSE_DATA.values());

    BDDMockito.given(reactiveHorseRepository.findAll()).willReturn(mockHorse);

    MockServerRequest request = MockServerRequest.builder().build();
    Mono<ServerResponse> mockResult = handler.findAllHorses(request);
    
    StepVerifier.create(mockResult).assertNext(sr -> {
      sr.statusCode().is2xxSuccessful();  
    }).expectComplete().verify();


  }
}
