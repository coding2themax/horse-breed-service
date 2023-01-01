package com.coding2themax.horsebreedservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BloodTypeTest {


  @Test
  void testValues() {

    BloodType bt = BloodType.COLD;

    Assertions.assertEquals("COLD", bt.name()); 

  }
}
