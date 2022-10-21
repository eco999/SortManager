package com.sparta.jjs.model.sorts.binary_tree;

//Does this need to be checked? If so, don't use RunTimeException
public class ChildNotFoundException extends RuntimeException {
    @Override
    public String getMessage(){
        return "This node does not have a child";
    }
}
