package com.sparta.jjs.model.sorts.binary_tree;

import com.sparta.jjs.model.sorts.Sortable;

public interface BinaryTree extends Sortable{
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(final int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

}
