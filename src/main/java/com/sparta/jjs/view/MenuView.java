package com.sparta.jjs.view;


import com.sparta.jjs.controller.SORTER_TYPES;

import java.util.Arrays;
import java.util.Scanner;

public class MenuView {
    static Scanner scanner = new Scanner(System.in);


    public void printSorts()
    {
        System.out.println(
                "1. Bubblesort\n" +
                "2. Merge Sort\n" +
                "3. Binary Tree Sort\n" +
                "4. Insertion Sort");
    }


    public int getUserInputArrayLength()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length between 1 and 1000: ");
        int arrayLength = scanner.nextInt();;
        while (arrayLength < 1 || arrayLength > 1000)
        {
            System.out.println("Invalid input");
            arrayLength = scanner.nextInt();
        }

        return arrayLength;
    }


    public SORTER_TYPES getAlgorithmInput()
    {
        printSorts();
        return switch (scanner.nextInt()) {
            case 1 -> SORTER_TYPES.BUBBLE;
            case 2 -> SORTER_TYPES.MERGE;
            case 3 -> SORTER_TYPES.BINARYTREE;
            case 4 -> SORTER_TYPES.INSERTION;
            default -> getAlgorithmInput();
        };
    }

    public void displayArray(int[] array)
    {
        System.out.println(Arrays.toString(array));
    }

    /*public void doMenu()
    {
        printSorts();
        int algorithmChoice = getAlgorithmInput();
        int[] randomArray = generateRandomArray(getUserInputArrayLength());
        System.out.println("Random array generated: "+ Arrays.toString(randomArray));
        switch (algorithmChoice) {
            case 1 -> System.out.println("Bubble sorted array: "+Arrays.toString(BubbleSorter.getSortedArray(randomArray)));
            case 2 -> System.out.println("Merge sorted array: "+Arrays.toString(MergeSorter.getSortedArray(randomArray)));
            case 3 -> {
                BinaryTreeSorter bst = new BinaryTreeSorter(randomArray[0]);
                bst.addElements(randomArray);
                System.out.println(Arrays.toString(bst.SortInOrder()));
            }
            case 4 -> System.out.println("Insertion sorted array: "+Arrays.toString(InsertionSorter.getSortedArray(randomArray)));
        }
    }*/

}
