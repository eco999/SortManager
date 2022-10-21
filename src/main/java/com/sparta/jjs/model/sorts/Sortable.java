package com.sparta.jjs.model.sorts;

import com.sparta.jjs.model.sorts.binary_tree.ChildNotFoundException;

public interface Sortable {
    int[] getSortedArray(int[] array) throws ChildNotFoundException;
}
