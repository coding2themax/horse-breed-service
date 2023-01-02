package com.coding2themax.horsebreedservice.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.coding2themax.horsebreedservice.handler.HorseHandler;

@Configuration
public class HorseRouter {


  @Bean
  public RouterFunction<ServerResponse> horseRoute(HorseHandler handler) {

    return RouterFunctions
      .route(RequestPredicates.GET("/horses").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::findAllHorses);

  }
  
}
