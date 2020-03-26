package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstPartTest {

  @Test
  public void checkIfArrayStartAndEndSequenceAreTheSameTest() {
    int[] array = {1, 2, 3, 4, 1, 2, 3};
    assertTrue(FirstPart.checkIfArrayStartAndEndSequenceAreTheSame(array, 3));
  }
}
