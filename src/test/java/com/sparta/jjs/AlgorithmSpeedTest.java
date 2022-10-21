package com.sparta.jjs;

import com.sparta.jjs.model.RandomArrayGenerator;
import com.sparta.jjs.model.sorts.BubbleSorter;
import com.sparta.jjs.model.sorts.InsertionSorter;
import com.sparta.jjs.model.sorts.MergeSorter;
import com.sparta.jjs.model.sorts.Sortable;
import com.sparta.jjs.model.sorts.binary_tree.BinaryTreeSorter;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class AlgorithmSpeedTest {

    int[] randomArray = RandomArrayGenerator.generateRandomArray(50);

    @Test
    public void testBubbleSorter()
    {
        int[] tempArray = randomArray.clone();
        Sortable sorter = new BubbleSorter();
        long startTime = System.nanoTime();
        int[] sortedArray = sorter.getSortedArray(tempArray);
        long endTime = System.nanoTime();
        System.out.println("Time taken: "+ (endTime-startTime));
    }

    @Test
    public void testMergeSorter()
    {
        int[] tempArray = randomArray.clone();
        Sortable sorter = new MergeSorter();
        long startTime = System.nanoTime();
        int[] sortedArray = sorter.getSortedArray(tempArray);
        long endTime = System.nanoTime();
        System.out.println("Time taken: "+ (endTime-startTime));
    }

    @Test
    public void testBinaryTreeSorter()
    {
        int[] tempArray = randomArray.clone();
        Sortable sorter = new BinaryTreeSorter(tempArray[0]);
        long startTime = System.nanoTime();
        int[] sortedArray = sorter.getSortedArray(tempArray);
        long endTime = System.nanoTime();

        System.out.println("Time taken: "+ (endTime-startTime));
    }

    @Test
    public void testInsertionSorter()
    {
        int[] tempArray = randomArray.clone();
        Sortable sorter = new InsertionSorter();
        long startTime = System.nanoTime();
        int[] sortedArray = sorter.getSortedArray(tempArray);
        long endTime = System.nanoTime();
        System.out.println("Time taken: "+ (endTime-startTime));
    }

}
