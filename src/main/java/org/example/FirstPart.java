package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class FirstPart {

  public static void main(String[] args) {
  }

  public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
    for (Map.Entry<T, E> entry : map.entrySet()) {
      if (Objects.equals(value, entry.getValue())) {
        return entry.getKey();
      }
    }
    return null;
  }

  public static Map<String, Long> countCharOccurrence(String text) {
    return text.toLowerCase().chars()
      .filter(Character::isLetter)
      .mapToObj(c -> String.valueOf((char) c))
      .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

  }

  public static String findFindLetterInString(String text) {
    Map<String, Long> stringLongMap = countCharOccurrence(text);
    text = text.toLowerCase();
    String letter = "";
    char[] chars = text.toCharArray();
    for (int i = 0; i < text.length(); i++) {
      if (stringLongMap.get(String.valueOf(chars[i])).equals(1L)) {
        letter = String.valueOf(text.charAt(i));
        System.out.println(letter);
        break;
      }
    }
    return letter;
  }

  public static boolean checkIfContains(int[] array) {
    boolean check = false;
    for (int value : array) {
      if (value >= 10 && value < 20 || value >= 30 && value < 40) {
        check = true;
        break;
      }
    }
    return check;
  }

  public static boolean checkIfPowerOf(int number) {

    double power = 2.0;
    double divider = number;
    boolean check = false;

    while (divider > 1) {
      check = divider % power == 0;

      divider = divider / power;
    }
    return check;
  }

  public static Integer[] createNewArray(int[] array) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 10) {
        for (int j = i; j < array.length - i + 1; j++) {
          numbers.add(array[j]);
        }
        break;
      }
    }

    Integer[] returnArray = new Integer[numbers.size()];

    numbers.toArray(returnArray);

    return returnArray;
  }

  public static Integer[] createNewArrayUpgrade(int[] array) {
    List<Integer> numbers = new ArrayList<>();

    int indexOfLastNumber = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] == 10) {
        indexOfLastNumber = i;
      }
    }

    for (int i = indexOfLastNumber; i < array.length; i++) {
      numbers.add(array[i]);
    }

    Integer[] returnArray = new Integer[numbers.size()];
    numbers.toArray(returnArray);

    return returnArray;
  }

  public static boolean permutationCheck(String first, String second) {
    boolean check = true;
    String longer;
    String shorter;

    if (first.length() > second.length()) {
      longer = first;
      shorter = second;
    } else {
      longer = second;
      shorter = first;
    }

    for (int i = 0; i < longer.length(); i++) {
      if (shorter.indexOf(longer.charAt(i)) == -1) {
        check = false;
      }
    }
    return check;
  }

  public static String reverse(String inputString) {
    StringBuilder text = new StringBuilder();
    for (int i = inputString.length() - 1; i >= 0; i--) {
      text.append(inputString.charAt(i));
    }
    return text.toString();
  }

  public static void numberCombination() {
    int number;
    List<Integer> integerList = new ArrayList<>();

    for (int i = 1; i < 5; i++) {
      for (int j = 1; j < 5; j++) {
        for (int k = 1; k < 5; k++) {
          String numberString = i + String.valueOf(j) + k;
          number = Integer.parseInt(numberString);
          if (!integerList.contains(number) && i != j && i != k && k != j) {
            integerList.add(number);
            System.out.println(number);
          }
        }
      }
    }
    System.out.println(integerList.size());
  }

  public static void convertSeconds(int seconds) {
    int h = (int) Math.floor((double) seconds / 3600);
    int m = (int) Math.floor(((double) seconds - (h * 3600)) / 60);
    int s = (seconds - ((h * 3600) + (m * 60)));
    System.out.println(h + ":" + m + ":" + s);

  }

  public static boolean checkIfArrayStartAndEndSequenceAreTheSame(int[] array, int sequenceSize) {
    boolean result = false;
    for (int i = 0; i < array.length; i++) {
      if (i >= sequenceSize) {
        break;
      }
      result = array[i] == array[array.length + i - sequenceSize];
    }
    return result;
  }

  public static int[] shiftArrayLeft(int[] array) {
    int firstValue = array[0];
    for (int i = 0; i < array.length; i++) {
      if (i == array.length - 1) {
        array[i] = firstValue;
      } else {
        array[i] = array[i + 1];
      }
    }
    return array;
  }

  public static String repeat(int count, String with) {
    return new String(new char[count]).replace("\0", with);
  }

  public static void printStaircase(int n) {

    for (int i = 0; i < n; i++) {
      System.out.println(repeat(i, " ") + "_");
      System.out.println(repeat(i, " ") + " |");
    }

  }

  public static int[] findContiguousArrayWithBiggestSum(int[] array) {
    if (array.length < 1) {
      return new int[0];
    }
    int max = array[0];
    int max_Begin = 0;
    int max_End = 0;
    int begin = 0;
    int end = 0;
    int sum = 0;
    while (end < array.length) {
      sum += array[end];
      if (sum < 0) {
        sum = 0;
        begin = end + 1;
      } else {
        if (sum > max) {
          max = sum;
          max_Begin = begin;
          max_End = end;
        }
      }
      end++;
    }
    return Arrays.copyOfRange(array, max_Begin, max_End);
  }
}


