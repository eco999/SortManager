package com.sparta.jjs.model;

import com.sparta.jjs.controller.SORTER_TYPES;
import com.sparta.jjs.model.sorts.BubbleSorter;
import com.sparta.jjs.model.sorts.InsertionSorter;
import com.sparta.jjs.model.sorts.MergeSorter;
import com.sparta.jjs.model.sorts.Sortable;
import com.sparta.jjs.model.sorts.binary_tree.BinaryTreeSorter;
import com.sparta.jjs.utility.logging.CustomLoggerConfiguration;
import com.sparta.jjs.utility.logging.LoggerSingleton;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SortFactory {
    private static final Logger logger = LoggerSingleton.getSingleton().getLogger();

    public static Sortable getSorter(SORTER_TYPES sortType, int[] randomArray)
    {

        logger.log(Level.INFO,"Method started with sort: "+sortType);
        return switch(sortType)
                {
                    case BUBBLE -> new BubbleSorter();
                    case MERGE -> new MergeSorter();
                    case BINARYTREE -> new BinaryTreeSorter(randomArray[0]);
                    case INSERTION -> new InsertionSorter();
                };
    }
}
