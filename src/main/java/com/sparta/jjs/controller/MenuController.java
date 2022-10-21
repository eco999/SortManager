package com.sparta.jjs.controller;

import com.sparta.jjs.model.RandomArrayGenerator;
import com.sparta.jjs.model.SortFactory;
import com.sparta.jjs.model.sorts.Sortable;
import com.sparta.jjs.view.MenuView;

public class MenuController {

    MenuView menuView = new MenuView();

    public MenuController() {
        int arrayLength = menuView.getUserInputArrayLength();
        SORTER_TYPES chosenSort = menuView.getAlgorithmInput();
        int[] randomArray = RandomArrayGenerator.generateRandomArray(arrayLength);

        returnSortedArrayToView(chosenSort, randomArray);
    }

    private void returnSortedArrayToView(SORTER_TYPES chosenSort, int[] randomArray) {
        Sortable sorter = SortFactory.getSorter(chosenSort,randomArray);
        int[] sortedArray = sorter.getSortedArray(randomArray);
        menuView.displaySortedArray(sortedArray);
    }


}
