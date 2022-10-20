package com.sparta.jjs.Sorts;

public class InsertionSorter {
    public static int[] getSortedArray(int[] array) {
        for(int i = 1; i < array.length;i++)
        {
            int value = array[i];
            int j = i;
            for(;j>0 && value <array[j-1];j--)
            {
                array[j] = array[j-1];
            }
            array[j] = value;
        }
        return array;
    }
}
