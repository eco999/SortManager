package com.sparta.jjs.model.sorts.binary_tree;

import java.util.ArrayList;

public class BinaryTreeSorter implements BinaryTree{

    //design decisions:
    //public methods for helping
    //private methods for using tree (hard work)

    //hiding the nodes - elements are the numbers in the nodes
    private final Node rootNode;

    //cant have a tree without a root node
    public BinaryTreeSorter(int element){
        this.rootNode = new Node(element);
    }



    public int[] getSortedArray(int[] array) {
        addElements(array);
        return SortInOrder();
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return returnNodeCount(rootNode);
    }

    @Override
    public void addElement(int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(int[] elements) {
        for (int element: elements) {
            addNodeToTree(rootNode,element);
        }
    }

    public boolean findElement(int element)
    {
        Node node = findNode(element);
        if (node != null)
        {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        return findNode(element).getLeftChild().getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return findNode(element).getRightChild().getValue();
    }

    @Override
    public int[] getSortedTreeAsc() {

        return SortInOrder();
    }


    private Node findNode(int element)
    {
        Node node = rootNode;
        while (node != null)
        {
            if (element == node.getValue())
            {
                return node;
            }
            if(element < node.getValue())
            {
                node = node.getLeftChild();
            }
            else if(element > node.getValue())
            {
                node = node.getRightChild();
            }
        }
        return null;
    }

    //add node to the tree
    private void addNodeToTree(Node node, int element){
        if(element < node.getValue()){ //I want to be left child
            if(node.isLeftChildEmpty()){ //Is there room for me
                node.setLeftChild(new Node(element)); //I am now the left child
            }
            else {
                addNodeToTree(node.getLeftChild(), element);
            }
        }
        else if(element > node.getValue()){
            if(node.isRightChildEmpty()){
                node.setRightChild(new Node(element));
            }
            else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private int returnNodeCount(Node node)
    {
        if(node == null)
        {
            return 0;
        }
        else
        {
            return 1 + returnNodeCount(node.getLeftChild()) + returnNodeCount(node.getRightChild());
        }
    }

    //display in order
    public int[] SortInOrder()
    {
        ArrayList<Integer> tempList = new ArrayList<>();
        int value = returnInOrder(rootNode,tempList);

        if(value != -1)
        {
            tempList.add(value);
        }
        return tempList.stream().mapToInt(i -> i).toArray();

    }

    private int returnInOrder(Node tree, ArrayList<Integer> tempArray)
    {
        if (tree != null)
        {
            returnInOrder(tree.getLeftChild(),tempArray);
            tempArray.add(tree.getValue());
            returnInOrder(tree.getRightChild(),tempArray);
        }
        return -1;
    }


    public static class Node {
        private final int value;
        //Object type so can be null e.g. if no left child exists
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() throws ChildNotFoundException{
            /*if(leftChild == null)
            {
                throw new ChildNotFoundException();
            }
            return leftChild;*/
            try{
                return leftChild;
            }catch (NullPointerException e)
            {
                throw new ChildNotFoundException();
            }

        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() throws ChildNotFoundException{
            /*if(rightChild == null)
            {
                throw new ChildNotFoundException();
            }
            return rightChild;*/

            try{
                return rightChild;
            }catch (NullPointerException e)
            {
                throw new ChildNotFoundException();
            }
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean isLeftChildEmpty()
        {
            if (leftChild == null)
            {
                return true;
            }
            else {
                return false;
            }
        }

        public boolean isRightChildEmpty()
        {
            if(rightChild == null){
                return true;
            }
            else {
                return false;
            }
        }
    }
}


