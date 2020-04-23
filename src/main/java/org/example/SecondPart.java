package org.example;

import javax.management.AttributeNotFoundException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondPart {

  public static void main(String[] args) {

  }

  /**
   * 187. Write a Java program to find the index of first non-repeating character in a given string.
   */

  public static int getFirstNotRepeatingCharacterInGivenString(String s) throws AttributeNotFoundException {
    LinkedHashMap<String, Long> characterMap = Arrays.stream(s.split(""))
      .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

    String letter = characterMap.entrySet().stream()
      .filter(stringLongEntry -> stringLongEntry.getValue().equals(1L))
      .map(Map.Entry::getKey)
      .findFirst()
      .orElseThrow(AttributeNotFoundException::new);

    return Arrays.stream(s.split(""))
      .filter(c -> c.equals(letter))
      .map(s::indexOf)
      .findFirst()
      .orElseThrow(AttributeNotFoundException::new);
  }
}
