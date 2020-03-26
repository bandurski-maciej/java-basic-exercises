package org.example;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstPartTest {

  @Test
  public void checkIfArrayStartAndEndSequenceAreTheSameTest() {
    int[] array = {1, 2, 3, 4, 1, 2, 3};
    assertTrue(FirstPart.checkIfArrayStartAndEndSequenceAreTheSame(array, 3));
  }

  @Test
  public void shiftArrayLeft() {
    int[] array = {1, 2, 3, 4, 1, 2, 3};
    int[] shiftedArray = {2, 3, 4, 1, 2, 3, 1};
    assertThat(shiftedArray).containsSequence(FirstPart.shiftArrayLeft(array));
  }

}
