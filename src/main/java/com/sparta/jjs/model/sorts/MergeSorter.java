package com.sparta.jjs.model.sorts;

import com.sparta.jjs.utility.logging.CustomLoggerConfiguration;
import com.sparta.jjs.utility.logging.LoggerSingleton;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSorter implements Sortable{
    private static final Logger logger = LoggerSingleton.getSingleton().getLogger();
    @Override
    public int[] getSortedArray(int[] array) {

        return getMergeSortedArray(array);
    }

    private int[] getMergeSortedArray(int[] array) {

        logger.log(Level.INFO, "Method has started");
        logger.log(Level.INFO, "Using the following list: "+ Arrays.toString(array));
        //array length 0 or 1, nothing to sort, stopping condition
        if(array.length < 2){
            logger.log(Level.FINEST, "Stopping condition met, array length 1");
            return array;
        }
        //middle of array
        int middle = array.length / 2;
        //split array into two, use middle to find array size
        int[] leftArray = new int[middle];
        int[] rightArray = new int[array.length - middle];

        //from start to middle
        for(int i = 0; i < middle; i++){
            logger.log(Level.FINEST, "Adding items to left array, iteration: "+i);
            leftArray[i] = array[i];
        }
        //from middle to end
        for(int i = middle;i < array.length;i++){
            logger.log(Level.FINEST, "Adding items to right array, iteration: "+i);
            rightArray[i - middle] = array[i];
        }
        logger.log(Level.FINER, "Left array: "+Arrays.toString(leftArray));
        logger.log(Level.FINER, "Right array: "+Arrays.toString(rightArray));
        //recursive call to split array into smaller arrays of 1
        leftArray = getSortedArray(leftArray);
        rightArray = getSortedArray(rightArray);

        //merge arrays of 1 back
        return mergeArrays(array, leftArray, rightArray);

    }


    private int[] mergeArrays( int[] initialArray, int[] leftArray, int[] rightArray) {

        logger.log(Level.INFO, "Method has started");
        //counter for left and right
        int leftSize = initialArray.length / 2;
        int rightSize = initialArray.length - leftSize;
        logger.log(Level.INFO,"Starting first while loop");

        //init counters
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftSize && j < rightSize) {
            logger.log(Level.FINER, "While looping i: "+i+"j: "+j);
            if (leftArray[i] <= rightArray[j]) {
                logger.log(Level.FINEST, "Left Array smaller, adding to initialArray: "+leftArray[i]);
                initialArray[k++] = leftArray[i++];
            }
            else {
                logger.log(Level.FINEST, "Right Array smaller, adding to initialArray: "+rightArray[j]);
                initialArray[k++] = rightArray[j++];
            }
        }
        logger.log(Level.INFO,"Adding rest of items to initial array");
        while (i < leftSize) {
            initialArray[k++] = leftArray[i++];
        }
        while (j < rightSize) {
            initialArray[k++] = rightArray[j++];
        }
        return initialArray;
    }
}
