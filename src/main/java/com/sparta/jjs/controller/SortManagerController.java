package com.sparta.jjs.controller;

import com.sparta.jjs.model.RandomArrayGenerator;
import com.sparta.jjs.model.SortFactory;
import com.sparta.jjs.model.sorts.Sortable;
import com.sparta.jjs.view.MenuView;

public class SortManagerController {

    MenuView menuView = new MenuView();

    public SortManagerController() {
        initialiseProgram();
    }

    private void initialiseProgram() {
        int algorithmCount = menuView.getAlgorithmInputAmount();
        int arrayLength = menuView.getUserInputArrayLength();
        int[] randomArray = RandomArrayGenerator.generateRandomArray(arrayLength);
        menuView.displayArray(randomArray);

        compareMultipleAlgorithms(algorithmCount, randomArray);

    }

    private void returnSortedArrayToView(SORTER_TYPES chosenSort, int[] randomArray) {
        Sortable sorter = SortFactory.getSorter(chosenSort,randomArray);
        long startTime = System.nanoTime();
        int[] sortedArray = sorter.getSortedArray(randomArray);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        menuView.displayArray(sortedArray, timeTaken, chosenSort);
    }

    private void compareMultipleAlgorithms(int algorithmCount, int[] randomArray)
    {

        SORTER_TYPES[] sortList = new SORTER_TYPES[algorithmCount];

        for(int i = 0;i<algorithmCount;i++)
        {
            SORTER_TYPES chosenSort = menuView.getAlgorithmInput();
            sortList[i] = chosenSort;
        }
        for(SORTER_TYPES chosenSortItem : sortList)
        {
           returnSortedArrayToView(chosenSortItem, randomArray.clone());
        }
    }


}
