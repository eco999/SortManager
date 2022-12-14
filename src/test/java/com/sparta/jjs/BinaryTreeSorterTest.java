package com.sparta.jjs;

import com.sparta.jjs.model.sorts.binary_tree.BinaryTreeSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryTreeSorterTest {
    BinaryTreeSorter bst = new BinaryTreeSorter(0);

    @Test
    @DisplayName("Check that {2,0,-1,-2} returns {-2,-1,0,2}")
    void checkThatHighToLowReturnsLowToHigh()
    {
        Assertions.assertArrayEquals(new int[]{-2,-1,0,2}, bst.getSortedArray(new int[]{2,0,-1,-2}));
    }

    @Test
    @DisplayName("Check that {-2,-1,0,2} returns {-2,-1,0,2}")
    void checkThatLowToHighReturnsLowToHigh()
    {
        Assertions.assertArrayEquals(new int[]{-2,-1,0,2}, bst.getSortedArray(new int[]{-2,-1,0,2}));
    }

    @Test
    @DisplayName("Check that {-2,45,0,11,-9} returns {-9,-2,0,11,45}")
    void checkThatUnsortedReturnsSorted()
    {
        Assertions.assertArrayEquals(new int[]{-9,-2,0,11,45}, bst.getSortedArray(new int[]{-2,45,0,11,-9}));
    }

    @Test
    @DisplayName("Check that empty array returns root element")
    void checkThatEmptyArrayReturnsRoot()
    {
        Assertions.assertArrayEquals(new int[]{bst.getRootElement()}, bst.getSortedArray(new int[]{}));
    }
}
