package com.sparta.jjs;


import com.sparta.jjs.Sorts.BubbleSorter;
import com.sparta.jjs.Sorts.InsertionSorter;
import com.sparta.jjs.Sorts.MergeSorter;
import com.sparta.jjs.Sorts.binary_tree.BinaryTreeSorter;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);


    public static void printMenu()
    {
        System.out.println(
                "1. Bubblesort\n" +
                "2. Merge Sort\n" +
                "3. Binary Tree Sort\n" +
                "4. Insertion Sort");
    }


    public static int getUserInputArrayLength()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int arrayLength = scanner.nextInt();
        scanner.close();
        return arrayLength;
    }

    public static int[] generateRandomArray(int arrayLength)
    {
        Random random = new Random();
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(1000);
        }
        return randomArray;
    }


    private static int getAlgorithmInput()
    {
        return scanner.nextInt();
    }

    public static void doMenu()
    {
        printMenu();
        int algorithmChoice = getAlgorithmInput();
        int[] randomArray = generateRandomArray(getUserInputArrayLength());
        switch (algorithmChoice) {
            case 1:
                BubbleSorter.getSortedArray(randomArray);
                break;
            case 2:
                MergeSorter.getSortedArray(randomArray);
            case 3:
                BinaryTreeSorter.getSortedArray(randomArray);
            case 4:
                InsertionSorter.getSortedArray(randomArray);
        }
    }

}
