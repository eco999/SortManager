package com.sparta.jjs.model.sorts;

import com.sparta.jjs.utility.logging.CustomLoggerConfiguration;
import com.sparta.jjs.utility.logging.LoggerSingleton;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSorter implements Sortable
{
    private static final Logger logger = LoggerSingleton.getSingleton().getLogger();

    @Override
    public int[] getSortedArray(int[] array) {
        return getBubbleSortedArray(array);
    }

    private int[] getBubbleSortedArray(int[] array)
    {

        logger.log(Level.INFO, "Method has started");
        logger.log(Level.INFO, "Using the following list: "+ Arrays.toString(array));
        //loop through entire array
        for (int i=0;i<array.length;i++)
        {
            logger.log(Level.FINE, "Outer loop iteration: "+ i);
            //loop through array from after i to the end
            for (int j=i+1;j<array.length;j++)
            {
                logger.log(Level.FINER, "Inner loop iteration: "+ j);
                //if j smaller than i
                if (array[j] < array[i])
                {
                    logger.log(Level.FINEST, "Swap has been found, swapping "+array[i]+ "with "+array[j]);
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
