package org.example;

import javax.management.AttributeNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
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

    return Arrays.stream(s.split(""))
      .filter(c -> characterMap.get(c) < 2)
      .map(s::indexOf)
      .findFirst()
      .orElseThrow(AttributeNotFoundException::new);
  }

  public static int getFibonacci(int element) {
    int a = 0, b = 1, c = 0;

    if (element == 1) {
      return 1;
    }

    for (int i = 0; i < element - 1; i++) {
      c = a + b;
      a = b;
      b = c;
    }

    return c;
  }

  /**
   * 188. Write a Java program to find all the start indices of a given string's anagrams in another given string.
   */

  public static List<Integer> getStartIndicesOfAGivenStringsAnagramsInAnotherGivenString(String s, String pattern) {
    List<String> stringList = Arrays.stream(pattern.split(""))
      .collect(Collectors.toList());
    List<String> matchedChars = new ArrayList<>(pattern.length());
    List<Integer> resultList = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      String letter = String.valueOf(s.charAt(i));

      if (stringList.contains(letter) && !matchedChars.contains(letter)) {
        matchedChars.add(letter);
      } else if (matchedChars.contains(letter)) {
        matchedChars.clear();
        matchedChars.add(letter);
      } else {
        matchedChars.clear();
      }

      if (matchedChars.size() == pattern.length()) {
        resultList.add(i - matchedChars.size() + 1);
        matchedChars.clear();
      }
    }

    return resultList;
  }
}
