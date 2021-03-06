package org.example;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

  @Test
  public void findContiguousArrayWithBiggestSum() {
    int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] array1 = new int[]{0, 1, 2, -5};

    assertThat(new int[]{4, -1, 2, 1}).containsSequence(FirstPart.findContiguousArrayWithBiggestSum(array));
    assertThat(new int[]{0, 1, 2}).containsSequence(FirstPart.findContiguousArrayWithBiggestSum(array1));
  }

  @Test
  public void findNumberIndexInSortedArray() {

    assertThat(0).isEqualTo(FirstPart.findNumberIndexInSortedArray(new int[]{1, 2, 4, 5, 6}, 0));
    assertThat(3).isEqualTo(FirstPart.findNumberIndexInSortedArray(new int[]{1, 2, 4, 5, 6}, 5));
    assertThat(5).isEqualTo(FirstPart.findNumberIndexInSortedArray(new int[]{1, 2, 4, 5, 6}, 7));
  }

  @Test
  public void preorderTraversalNodeValue() {
    assertThat(FirstPart.preorderTraversalNodeValue(new BinaryTree(10, new BinaryTree(20, new BinaryTree(40), new BinaryTree(50)), new BinaryTree(30)))).containsExactly(10, 20, 40, 50, 30);
  }

  @Test
  public void minimizesPath() {
    int[][] grid = new int[][]
      {{7, 4, 2},
        {0, 5, 6},
        {3, 1, 2}};

    int[][] grid2 = new int[][]
      {{7, 0, 2},
        {1, 5, 6},
        {3, 1, 2}};

    assertEquals(FirstPart.minimizesPath(grid), 13);
    assertEquals(FirstPart.minimizesPath(grid2), 17);

  }

  @Test
  public void shouldReturnSumOfBinaryNumbers() {
    assertEquals("101", FirstPart.getSumOfBinaryNumbers("10", "11"));
  }

  @Test
  public void shouldReturnSumOfBinaryNumbersManually() {
    assertEquals("101", FirstPart.getSumOfBinaryNumbersManually("10", "11"));
    assertEquals("1101", FirstPart.getSumOfBinaryNumbersManually("1010", "11"));
    assertEquals("110001", FirstPart.getSumOfBinaryNumbersManually("10101", "11100"));
  }

  @Test
  public void shouldReturnMultiplyBinaryNumbers() {
    assertEquals("110", FirstPart.multiplyBinaryNumbers("10", "11"));
  }

  @Test
  public void shouldReturnDecimalToBinary() {
    assertEquals("101", FirstPart.getDecimalToBinary(5));
  }

  @Test
  public void shouldReturnDecimalToHexadecimal() {
    assertEquals("F", FirstPart.getDecimalToHexadecimal(15));
    assertEquals("1D8A", FirstPart.getDecimalToHexadecimal(7562));
  }

  @Test
  public void shouldReturnDecimalToOctal() {
    assertEquals("17", FirstPart.getDecimalToOctal(15));
  }

  @Test
  public void shouldReturnBinaryToDecimal() {
    assertEquals(5, FirstPart.getBinaryToDecimal("101"));
  }

  @Test
  public void shouldReturnBinaryToHexadecimal() {
    assertEquals("D", FirstPart.getBinaryToHexadecimal("1101"));
    assertEquals("8E", FirstPart.getBinaryToHexadecimal("10001110"));
    assertEquals("40", FirstPart.getBinaryToHexadecimal("1000000"));
  }

  @Test
  public void shouldReturnBinaryToOctal() {
    assertEquals("7631", FirstPart.getBinaryToOctal("111110011001"));
  }

  @Test
  public void shouldConvertOctalToDecimal() {
    assertEquals(8, FirstPart.convertOctalToDecimal("10"));
  }

  @Test
  public void shouldConvertOctalToBinary() {
    assertEquals("111", FirstPart.convertOctalToBinary("7"));
  }

  @Test
  public void shouldConvertOctalToHexadecimal() {
    assertEquals("40", FirstPart.convertOctalToHexadecimal("100"));
  }

  @Test
  public void shouldConvertHexadecimalToDecimal() {
    assertEquals(37, FirstPart.convertHexadecimalToDecimal("25"));
    assertEquals(89838, FirstPart.convertHexadecimalToDecimal("15EEE"));
  }

  @Test
  public void shouldConvertHexadecimalToBinary() {
    assertEquals("110111", FirstPart.convertHexadecimalToBinary("37"));
  }

  @Test
  public void shouldConvertHexadecimalToOctal() {
    assertEquals("100", FirstPart.convertHexadecimalToOctal("40"));
  }

  @Test
  public void shouldGetPreorderTraversalOfTree() {
    BinaryTree tree = new BinaryTree(10);
    tree.right = new BinaryTree(30);
    tree.left = new BinaryTree(20);
    tree.left.left = new BinaryTree(40);
    tree.left.right = new BinaryTree(50);
    FirstPart.getPreorderTraversalOfTree(tree);
  }

  @Test
  public void changeArrayRowsWithColumns() {
    assertThat(FirstPart.changeArrayRowsWithColumns(new int[][]{{10, 20, 30}, {40, 50, 60}})).contains(new int[][]{{10, 40}, {20, 50}, {30, 60}});
  }

  @Test
  public void findGreatestCommonDivisor() {
    assertEquals(FirstPart.findGreatestCommonDivisor(282, 78), 6);
  }

  @Test
  public void moveZerosToTheRight() {
    assertThat(FirstPart.moveZerosToTheRight(new int[]{0, 3, 4, 0, 1, 2, 5, 0})).contains(3, 4, 1, 2, 5, 0, 0, 0);
  }

  @Test
  public void reverseWordsOrder() {
    assertEquals(FirstPart
      .reverseWordsOrder("The quick brown fox jumps over the lazy dog"), "dog lazy the over jumps fox brown quick The");
  }

  @Test
  public void checkIfStrobogrammatic() {
    assertTrue(FirstPart.checkIfStrobogrammatic("181"));
    assertFalse(FirstPart.checkIfStrobogrammatic("121"));
  }
}

