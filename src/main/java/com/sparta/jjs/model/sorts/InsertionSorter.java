package com.sparta.jjs.model.sorts;

import com.sparta.jjs.utility.logging.CustomLoggerConfiguration;
import com.sparta.jjs.utility.logging.LoggerSingleton;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class InsertionSorter implements Sortable{
    private static final Logger logger = LoggerSingleton.getSingleton().getLogger();


    @Override
    public int[] getSortedArray(int[] array) {
        return getInsertionSortedArray(array);
    }

    private int[] getInsertionSortedArray(int[] array) {
        logger.log(Level.INFO, "Method has started");
        logger.log(Level.INFO, "Using the following list: "+ Arrays.toString(array));
        for(int i = 1; i < array.length;i++)
        {
            logger.log(Level.FINE, "Outer loop iteration: "+ i);
            int value = array[i];
            int j = i;
            for(;j>0 && value <array[j-1];j--)
            {
                logger.log(Level.FINER, "Inner loop iteration: "+ j);
                logger.log(Level.FINEST, "Swap has been found, swapping "+array[i]+ "with "+array[j]);
                array[j] = array[j-1];
            }
            array[j] = value;
        }
        return array;
    }
}
