package com.coding2themax.horsebreedservice.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.coding2themax.horsebreedservice.model.BloodType;
import com.coding2themax.horsebreedservice.model.Horse;
import com.coding2themax.horsebreedservice.model.HorseType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ReactiveHorseRepository {
  private static final Map<String, Horse> HORSE_DATA;

  static {
    //Using hashmap instead of hashtable because this object is inmutable
    HORSE_DATA = new HashMap<>();

    HORSE_DATA.put("1", new Horse("1", "Halflinger", BloodType.COLD, HorseType.LIGHT));
    HORSE_DATA.put("2", new Horse("2", "American Shetland", BloodType.WARM, HorseType.PONY));
    HORSE_DATA.put("3", new Horse("3", "Pinto", BloodType.WARM, HorseType.LIGHT));
    HORSE_DATA.put("4", new Horse("4", "Arabian", BloodType.HOT, HorseType.LIGHT));




  }

  public Flux<Horse> findAll(){
    return Flux.fromIterable(HORSE_DATA.values());
  }

  public Mono<Horse> findOne(String key){
    return Mono.just(HORSE_DATA.get(key));
  }
}
