package com.sparta.jjs.Sorts;

import java.util.Scanner;

public class BubbleSorter
{
    public static int[] getBubbleSortedArray(int[] array)
    {
        //loop through entire array
        for (int i=0;i<array.length;i++)
        {

            //loop through array from after i to the end
            for (int j=i+1;j<array.length;j++)
            {
                //if j smaller than i
                if (array[j] < array[i])
                {
                    //the swap using a temp variable
                    int tempInt = array[i];
                    array[i] = array[j];
                    array[j] = tempInt;
                }
            }
        }
        return array;
    }

    public static int[] getUserInputArray()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int arrayLength = scanner.nextInt();
        int[] unsortedList = new int[arrayLength];
        for (int i = 0;i<arrayLength;i++)
        {
            System.out.println("Enter number to add to array: ");
            unsortedList[i] = scanner.nextInt();
        }
        scanner.close();
        return unsortedList;
    }

}
