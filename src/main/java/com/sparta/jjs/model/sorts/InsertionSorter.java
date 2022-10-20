package com.sparta.jjs.model.sorts;

public class InsertionSorter implements Sortable{


    @Override
    public int[] getSortedArray(int[] array) {
        return getInsertionSortedArray(array);
    }

    private int[] getInsertionSortedArray(int[] array) {
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
