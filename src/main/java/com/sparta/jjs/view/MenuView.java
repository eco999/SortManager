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
        System.out.println("Enter array length: ");
        int arrayLength = scanner.nextInt();;
        while (arrayLength < 1)
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

    public int getAlgorithmInputAmount()
    {
        System.out.println("Select how many algorithms you want to compare: ");
        int input = scanner.nextInt();
        while(input < 1)
        {
            System.out.println("Invalid input");
            input = scanner.nextInt();
        }
        return input;
    }

    public void displayArray(int[] array, long timeTaken, SORTER_TYPES chosenSort)
    {
        System.out.println(chosenSort.toString()+" Sort");
        System.out.println(Arrays.toString(array));
        System.out.println("Time taken: "+timeTaken);
    }

    public void displayArray(int[] array)
    {
        System.out.println(Arrays.toString(array));
    }


}
