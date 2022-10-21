package com.sparta.jjs.model;

import com.sparta.jjs.controller.SORTER_TYPES;
import com.sparta.jjs.model.sorts.BubbleSorter;
import com.sparta.jjs.model.sorts.InsertionSorter;
import com.sparta.jjs.model.sorts.MergeSorter;
import com.sparta.jjs.model.sorts.Sortable;
import com.sparta.jjs.model.sorts.binary_tree.BinaryTreeSorter;

public class SortFactory {
    public static Sortable getSorter(SORTER_TYPES sortType, int[] randomArray)
    {
        return switch(sortType)
                {
                    case BUBBLE -> new BubbleSorter();
                    case MERGE -> new MergeSorter();
                    case BINARYTREE -> new BinaryTreeSorter(randomArray[0]);
                    case INSERTION -> new InsertionSorter();
                };
    }
}
