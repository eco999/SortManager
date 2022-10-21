package com.sparta.jjs.view;


import com.sparta.jjs.controller.SORTER_TYPES;
import com.sparta.jjs.utility.logging.CustomLoggerConfiguration;
import com.sparta.jjs.utility.logging.LoggerSingleton;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuView {
    private static final Logger logger = LoggerSingleton.getSingleton().getLogger();
    static Scanner scanner = new Scanner(System.in);


    public void printSorts()
    {
        System.out.println(
                "1. Bubblesort\n" +
                "2. Merge Sort\n" +
                "3. Binary Tree Sort\n" +
                "4. Insertion Sort\n" +
                "\nChoose an algorithm: ");
    }


    public int getUserInputArrayLength()
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int arrayLength = scanner.nextInt();;
        while (arrayLength < 1)
        {
            logger.log(Level.INFO, "Invalid input from user: "+arrayLength);
            System.out.println("Invalid input");
            arrayLength = scanner.nextInt();
        }
        logger.log(Level.FINE, "Valid input from user: "+arrayLength);
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
            logger.log(Level.INFO, "Invalid input from user: "+input);
            System.out.println("Invalid input");
            input = scanner.nextInt();
        }
        logger.log(Level.FINE, "Valid input from user: "+input);
        return input;
    }

    public void displayArray(int[] array, long timeTaken, SORTER_TYPES chosenSort)
    {
        System.out.println(chosenSort.toString()+" Sort: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Time taken: "+timeTaken);
    }

    public void displayArray(int[] array)
    {
        System.out.println("Randomised array: ");
        System.out.println(Arrays.toString(array));
    }


}
