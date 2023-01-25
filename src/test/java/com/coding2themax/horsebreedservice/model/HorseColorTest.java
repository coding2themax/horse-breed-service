package com.coding2themax.horsebreedservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HorseColorTest {
  @Test
  void testGetColorName() {
    HorseColor hc = new HorseColor();
    hc.setColorName("blue");

    Assertions.assertEquals("blue", hc.getColorName());
  }

 
}
