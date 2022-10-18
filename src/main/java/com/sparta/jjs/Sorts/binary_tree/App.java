package com.sparta.jjs.Sorts.binary_tree;

public class App {
    public static void main(String[] args) {
        BinaryTreeSorter tree = new BinaryTreeSorter(5);
        tree.addElementToTree(6);
        tree.addElementToTree(10);
        tree.addElementToTree(11);
        tree.addElementToTree(15);
        tree.addElementToTree(100);
        tree.addElementToTree(2);
        tree.addElementToTree(10);

        System.out.println(tree.findElement(11));
        System.out.println(tree.findElement(213123));
    }
}
