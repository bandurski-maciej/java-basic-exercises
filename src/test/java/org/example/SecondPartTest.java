package org.example;

import org.junit.Test;

import javax.management.AttributeNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondPartTest {

  @Test
  public void shouldReturnFirstNotRepeatingCharacterInGivenString() throws AttributeNotFoundException {
    assertEquals(SecondPart.getFirstNotRepeatingCharacterInGivenString("google"), 4);
  }

  @Test
  public void shouldReturnStartIndicesOfAGivenStringsAnagramsInAnotherGivenString() {
    assertThat(SecondPart.getStartIndicesOfAGivenStringsAnagramsInAnotherGivenString("zyxwyxyxzwxyz", "xyz")).containsSequence(0, 6, 10);
  }

}
