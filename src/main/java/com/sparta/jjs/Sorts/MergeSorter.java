package com.sparta.jjs.Sorts;

import java.util.Arrays;

public class MergeSorter {

    public static int[] getSortedArray(int[] array) {
        //array length 0 or 1, nothing to sort, stopping condition
        if(array.length < 2){
            return array;
        }
        //middle of array
        int middle = array.length / 2;
        //split array into two, use middle to find array size
        int[] leftArray = new int[middle];
        int[] rightArray = new int[array.length - middle];

        //from start to middle
        for(int i = 0; i < middle; i++){
            leftArray[i] = array[i];
        }
        //from middle to end
        for(int i = middle;i < array.length;i++){
            rightArray[i - middle] = array[i];
        }
        //recursive call to split array into smaller arrays of 1
        leftArray = getSortedArray(leftArray);
        rightArray = getSortedArray(rightArray);

        //merge arrays of 1 back
        return mergeArrays(array, leftArray, rightArray);

    }


    public static int[] mergeArrays( int[] initialArray, int[] leftArray, int[] rightArray) {

        //counter for left and right
        int leftSize = initialArray.length / 2;
        int rightSize = initialArray.length - leftSize;

        //init counters
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                initialArray[k++] = leftArray[i++];
            }
            else {
                initialArray[k++] = rightArray[j++];
            }
        }
        while (i < leftSize) {
            initialArray[k++] = leftArray[i++];
        }
        while (j < rightSize) {
            initialArray[k++] = rightArray[j++];
        }
        return initialArray;
    }

}
