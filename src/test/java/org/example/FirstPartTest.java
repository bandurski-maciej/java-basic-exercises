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

}

