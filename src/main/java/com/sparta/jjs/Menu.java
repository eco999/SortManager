package com.sparta.jjs;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void printMenu()
    {
        System.out.println(
                "1. Bubblesort\n" +
                "2. Merge Sort\n" +
                "3. Binary Tree Sort\n" +
                "4. Insertion Sort");
    }

    private int returnUserInput()
    {
        return scanner.nextInt();
    }


}
