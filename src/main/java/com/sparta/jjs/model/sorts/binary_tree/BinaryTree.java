package com.sparta.jjs.model.sorts.binary_tree;

import com.sparta.jjs.model.sorts.Sortable;

public interface BinaryTree extends Sortable{
    int getRootElement();

    int getNumberOfElements() throws ChildNotFoundException;

    void addElement(int element) throws ChildNotFoundException;

    void addElements(final int[] elements) throws ChildNotFoundException;

    boolean findElement(int value) throws ChildNotFoundException;

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc() throws ChildNotFoundException;

}
