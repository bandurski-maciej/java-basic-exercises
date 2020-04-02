package org.example;

public class BinaryTree {

  int value;
  BinaryTree left;
  BinaryTree right;

  public BinaryTree(int value, BinaryTree left, BinaryTree right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public BinaryTree(int value) {
    this.value = value;
  }
}
