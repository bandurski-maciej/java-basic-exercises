package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class FirstPart {

  public static void main(String[] args) {

    int steps = 5;
    System.out.println("Distinct ways can you climb to the top: " + climbStairs(steps));

    int[] nums = {10, 20, 13, 20, 30, 40, 40, 52, 30};
    int result;
    System.out.println("Source Array : " + Arrays.toString(nums));
    result = getSingleNumber(nums);
    System.out.println("\n" + result + " appears only once.");

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

  public static int findNumberIndexInSortedArray(int[] array, int number) {
    int difference;
    int minDifference = 0;
    int index = 0;

    if (number > array[array.length - 1]) {
      return array.length;
    }

    for (int i = 0; i < array.length; i++) {
      difference = Math.abs(array[i] - number);

      if (difference <= minDifference) {
        minDifference = Math.abs(difference);
        index = i;
      }
    }

    return index;
  }

  public static int[] preorderTraversalNodeValue(BinaryTree binaryTree) {
    return new int[]{binaryTree.value, binaryTree.left.value, binaryTree.left.left.value, binaryTree.left.right.value, binaryTree.right.value};
  }


  public static int getSingleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }

  public static int minimizesPath(int[][] grid) {
    int sum = grid[0][0];
    int i = 0;
    int j = 0;

    while (i + j != grid.length * 2 - 2) {

      if (i == grid.length - 1 && j < grid.length) {
        j++;
      } else if (j == grid.length - 1) {
        i++;
      } else if (grid[i + 1][j] < grid[i][j + 1]) {
        i++;
      } else if (grid[i + 1][j] > grid[i][j + 1]) {
        j++;
      }
      sum += grid[i][j];
    }
    return sum;

  }

  public static int climbStairs(int n) {
    if (n <= 1) {
      return 1;
    }
    int[] s_case = new int[n + 1];
    s_case[0] = 1;
    s_case[1] = 1;
    for (int i = 2; i <= n; i++) {
      s_case[i] = s_case[i - 1] + s_case[i - 2];
    }
    return s_case[n];
  }

  /**
   * 17. Java program to add two binary numbers.
   */

  public static String getSumOfBinaryNumbers(String firstNumber, String secondNumber) {

    int firstNumberInt = Integer.parseInt(firstNumber, 2);
    int secondNumberInt = Integer.parseInt(secondNumber, 2);

    return Integer.toBinaryString(firstNumberInt + secondNumberInt);
  }

  public static String getSumOfBinaryNumbersManually(String firstNumber, String secondNumber) {
    StringBuilder resultBuilder = new StringBuilder();
    int carry = 0, sum = 0, first = firstNumber.length() - 1, second = secondNumber.length() - 1;

    while (first >= 0 || second >= 0) {
      if (first >= 0) {
        sum += Integer.parseInt(String.valueOf(firstNumber.charAt(first)));
        first--;
      }
      if (second >= 0) {
        sum += Integer.parseInt(String.valueOf(secondNumber.charAt(second)));
        second--;
      }

      switch (sum + carry) {
        case 3:
          carry = 1;
          resultBuilder.append('1');
          break;
        case 2:
          carry = 1;
          resultBuilder.append("0");
          break;
        case 1:
          carry = 0;
          resultBuilder.append("1");
          break;
        case 0:
          carry = 0;
          resultBuilder.append("0");
          break;
      }

      sum = 0;
    }

    if (firstNumber.length() == secondNumber.length() && carry == 1) {
      resultBuilder.append("1");
    }

    return resultBuilder.reverse().toString();
  }

  /**
   * 18. Java program to multiply two binary numbers.
   */

  public static String multiplyBinaryNumbers(String firstNumber, String secondNumber) {
    int firstBinaryNumber = Integer.parseInt(firstNumber, 2);
    int secondBinaryNumber = Integer.parseInt(secondNumber, 2);

    return Integer.toBinaryString(firstBinaryNumber * secondBinaryNumber);
  }

  /**
   * 19. Java program to convert a decimal number to binary number.
   */

  public static String getDecimalToBinary(int decimalNumber) {
    int quotient = decimalNumber;
    StringBuilder stringBuilder = new StringBuilder();

    while (quotient > 0) {

      if (quotient % 2 == 0) {
        stringBuilder.append("0");
      } else {
        stringBuilder.append("1");
      }

      quotient = quotient / 2;
    }

    return stringBuilder.reverse().toString();
  }

  /**
   * 20. Java program to convert a decimal number to hexadecimal number.
   */

  public static String getDecimalToHexadecimal(int decimalNumber) {
    char[] hexadecimalArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    int quotient = decimalNumber;
    StringBuilder stringBuilder = new StringBuilder();

    while (quotient > 0) {
      stringBuilder.append(hexadecimalArray[quotient % 16]);
      quotient = quotient / 16;
    }

    return stringBuilder.reverse().toString();
  }

  /**
   * 21. Java program to convert a decimal number to octal number.
   */

  public static String getDecimalToOctal(int decimalNumber) {
    char[] octalArray = {'0', '1', '2', '3', '4', '5', '6', '7'};
    int quotient = decimalNumber;
    StringBuilder stringBuilder = new StringBuilder();

    while (quotient > 0) {
      stringBuilder.append(octalArray[quotient % 8]);
      quotient = quotient / 8;
    }

    return stringBuilder.reverse().toString();
  }

  /**
   * 22. Java program to convert a binary number to decimal number.
   */

  public static int getBinaryToDecimal(String binaryNumber) {
    int power = 0, sum = 0;

    for (int i = binaryNumber.length() - 1; i >= 0; i--) {
      sum += Integer.parseInt(String.valueOf(binaryNumber.charAt(i))) * Math.pow(2, power);
      power++;
    }

    return sum;
  }

  /**
   * 23. Java program to convert a binary number to hexadecimal number.
   */

  public static String getBinaryToHexadecimal(String binaryNumber) {
    int power = 0, sum = 0;
    char[] hexadecimalArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = binaryNumber.length() - 1; i >= 0; i--) {
      sum += Integer.parseInt(String.valueOf(binaryNumber.charAt(i))) * Math.pow(2, power);

      if ((power % 3 == 0 && power != 0) || i == 0) {
        stringBuilder.append(hexadecimalArray[sum]);
        sum = 0;
        power = -1;
      }

      power++;

    }

    return stringBuilder.reverse().toString();
  }

  /**
   * 24. Java program to convert a binary number to hexadecimal number.
   */

  public static String getBinaryToOctal(String binaryNumber) {
    int power = 0, sum = 0;
    char[] octalArray = {'0', '1', '2', '3', '4', '5', '6', '7'};
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = binaryNumber.length() - 1; i >= 0; i--) {
      sum += Integer.parseInt(String.valueOf(binaryNumber.charAt(i))) * Math.pow(2, power);
      power++;

      if (power % 3 == 0) {
        stringBuilder.append(octalArray[sum]);
        sum = 0;
        power = 0;
      }
    }

    return stringBuilder.reverse().toString();
  }

  /**
   * 25. Java program to convert a octal number to decimal number.
   */

  public static int convertOctalToDecimal(String octalNumber) {
    int power = 0, sum = 0;

    for (int i = octalNumber.length() - 1; i >= 0; i--) {
      sum += Integer.parseInt(String.valueOf(octalNumber.charAt(i))) * Math.pow(8, power);
      power++;

    }
    return sum;
  }

  /**
   * 26. Java program to convert a octal number to a binary number.
   */

  public static String convertOctalToBinary(String octalNumber) {
    return getDecimalToBinary(convertOctalToDecimal(octalNumber));
  }

  /**
   * 27. Java program to convert a octal number to a hexadecimal number.
   */

  public static String convertOctalToHexadecimal(String octalNumber) {
    return getBinaryToHexadecimal(convertOctalToBinary(octalNumber));
  }

  /**
   * 28. Java program to convert a hexadecimal to a decimal number.
   */

  public static int convertHexadecimalToDecimal(String hexadecimalNumber) {
    char[] hexadecimalArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    int sum = 0, power = 0;
    for (int i = hexadecimalNumber.length() - 1; i >= 0; i--) {
      for (int j = 0; j < hexadecimalArray.length; j++) {
        if (hexadecimalNumber.charAt(i) == hexadecimalArray[j]) {
          sum += j * Math.pow(16, power);
          power++;
        }
      }
    }

    return sum;
  }

  /**
   * 29. Java program to convert a hexadecimal to a decimal number.
   */

  public static String convertHexadecimalToBinary(String hexadecimalNumber) {
    return getDecimalToBinary(convertHexadecimalToDecimal(hexadecimalNumber));
  }

  /**
   * 30. Java program to convert a hexadecimal to a octal number.
   */

  public static String convertHexadecimalToOctal(String hexadecimalNumber) {
    return getDecimalToOctal(convertHexadecimalToDecimal(hexadecimalNumber));
  }

  /**
   * 125. Java program to convert a hexadecimal to a octal number.
   */

  public static void getPreorderTraversalOfTree(BinaryTree binaryTree) {


    if (binaryTree != null) {
      System.out.print(binaryTree.value + " ");

      if (binaryTree.left != null) {
        System.out.print(binaryTree.left.value + " ");
      } else {
        System.out.print("-" + " ");
      }

      if (binaryTree.right != null) {
        System.out.print(binaryTree.right.value + " ");
      } else {
        System.out.print("-" + " ");
      }

      getPreorderTraversalOfTree(binaryTree.left);
      getPreorderTraversalOfTree(binaryTree.right);
    }
  }

  /**
   * 155. Write a Java program to print an array after changing the rows and columns of a given two-dimensional array.
   */

  public static int[][] changeArrayRowsWithColumns(int[][] array) {
    int[][] returnArray = new int[array[0].length][array.length];

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        returnArray[j][i] = array[i][j];
      }
    }

    return returnArray;
  }

  /**
   * 157. Write a Java program to prove that Euclid’s algorithm computes the greatest common divisor of two positive given integers.
   */

  public static int findGreatestCommonDivisor(int i, int i1) {
    int max = Math.max(i, i1), min = Math.min(i, i1), modulo = max;

    while (modulo > 0) {
      modulo = max % min;
      max = min;
      min = modulo;
    }
    return max;
  }


  /**
   * 167. Write a Java program to move every zero to the right side of a given array of integers.
   */

  public static int[] moveZerosToTheRight(int[] array) {
    int[] result = new int[array.length];
    int zeroCounter = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] != 0) {
        result[i - zeroCounter] = array[i];
      } else {
        zeroCounter++;
      }
    }

    for (int i = array.length - zeroCounter; i < array.length; i++) {
      result[i] = 0;
    }

    return result;
  }

  /**
   * 169. Write a Java program to reverse the content of a sentence (assume a single space between two words) without reverse every word.
   */

  public static String reverseWordsOrder(String sentence) {
    StringBuilder stringBuilder = new StringBuilder();
    String[] words = sentence.split(" ");

    for (int i = words.length - 1; i >= 0; i--) {
      stringBuilder.append(words[i]);
      if (i != 0) {
        stringBuilder.append(" ");
      }
    }
    return stringBuilder.toString();
  }
}




