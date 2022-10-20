package com.sparta.jjs.model.sorts;

public class BubbleSorter implements Sortable
{
    @Override
    public int[] getSortedArray(int[] array) {
        return getBubbleSortedArray(array);
    }

    private int[] getBubbleSortedArray(int[] array)
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
}
