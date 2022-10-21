package com.sparta.jjs.model.sorts.binary_tree;

import com.sparta.jjs.utility.logging.CustomLoggerConfiguration;
import com.sparta.jjs.utility.logging.LoggerSingleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinaryTreeSorter implements BinaryTree{
    private static final Logger logger = LoggerSingleton.getSingleton().getLogger();

    //design decisions:
    //public methods for helping
    //private methods for using tree (hard work)

    //hiding the nodes - elements are the numbers in the nodes
    private final Node rootNode;

    //cant have a tree without a root node
    public BinaryTreeSorter(int element){
        this.rootNode = new Node(element);
    }



    public int[] getSortedArray(int[] array)  {

        addElements(array);
        array = SortInOrder();
        if(array[0] == -1)
        {
            logger.log(Level.WARNING, "Returned empty array");
            return null;
        }
        else
        {
            return array;
        }
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements()  {
        return returnNodeCount(rootNode);
    }

    @Override
    public void addElement(int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(int[] elements) {
        //will spam console and log so off until needs to be checked

        for (int element: elements) {
            logger.log(Level.FINE, "Adding element: "+element);
            addNodeToTree(rootNode,element);
        }
    }

    public boolean findElement(int element) {
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
    public int[] getSortedTreeAsc(){

        return SortInOrder();
    }


    private Node findNode(int element){

        Node node = rootNode;
        while (node != null)
        {
            if (element == node.getValue())
            {
                logger.log(Level.INFO, "Found node: "+node.getValue());
                return node;
            }
            if(element < node.getValue())
            {
                logger.log(Level.FINE, "Not found, checking left child");
                node = node.getLeftChild();
            }
            else if(element > node.getValue())
            {
                logger.log(Level.FINE, "Not found, checking right child");
                node = node.getRightChild();
            }
        }
        logger.log(Level.INFO, "Node not found at all");
        return null;
    }

    //add node to the tree
    private void addNodeToTree(Node node, int element){

        if(element < node.getValue()){ //I want to be left child
            logger.log(Level.INFO, "Element smaller than node");
            if(node.isLeftChildEmpty()){ //Is there room for me
                logger.log(Level.FINER, "Adding new node at left child");
                node.setLeftChild(new Node(element)); //I am now the left child
            }
            else {
                logger.log(Level.FINE, "Left child occupied, moving to left child");
                addNodeToTree(node.getLeftChild(), element);
            }
        }
        else if(element > node.getValue()){
            logger.log(Level.INFO, "Element larger than node");
            if(node.isRightChildEmpty()){
                logger.log(Level.FINER, "Adding new node at right child");
                node.setRightChild(new Node(element));
            }
            else {
                logger.log(Level.FINE, "Right child occupied, moving to left child");
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private int returnNodeCount(Node node){
        //off because recursive will spam console and log

        if(node == null)
        {
            logger.log(Level.FINER, "Reached end of branch, stopping condition met");
            return 0;
        }
        else
        {
            logger.log(Level.FINEST, "Recursive call to traverse");
            return 1 + returnNodeCount(node.getLeftChild()) + returnNodeCount(node.getRightChild());
        }
    }

    //display in order
    public int[] SortInOrder(){

        logger.log(Level.INFO,"Method started");
        ArrayList<Integer> tempList = new ArrayList<>();
        logger.log(Level.INFO, "Getting sorted items");
        int value = returnInOrder(rootNode,tempList);

        if(value != -1)
        {
            logger.log(Level.FINE, "Valid item added: "+value);
            tempList.add(value);
        }
        logger.log(Level.FINE, "Method completed, returning array"+
                Arrays.toString(tempList.stream().mapToInt(i -> i).toArray()));
        return tempList.stream().mapToInt(i -> i).toArray();
    }

    private int returnInOrder(Node tree, ArrayList<Integer> tempArray){

        if (tree != null)
        {
            logger.log(Level.FINEST, "Recursive call to leftChild");
            returnInOrder(tree.getLeftChild(),tempArray);
            logger.log(Level.FINER, "Adding to ArrayList: "+tree.getValue());
            tempArray.add(tree.getValue());
            logger.log(Level.FINEST, "Recursive call to rightChild");
            returnInOrder(tree.getRightChild(),tempArray);
        }
        logger.log(Level.WARNING, "Empty node, returning -1");
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
                logger.log(Level.INFO, "Found leftChild");
                return leftChild;
            }catch (NullPointerException e)
            {
                logger.log(Level.SEVERE, "ChildNotFoundException occured");
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
                logger.log(Level.INFO, "Found leftChild");
                return rightChild;
            }catch (NullPointerException e)
            {
                logger.log(Level.SEVERE, "ChildNotFoundException occured");
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
                logger.log(Level.INFO, "leftChild Empty");
                return true;
            }
            else {
                logger.log(Level.INFO, "leftChild not empty");
                return false;
            }
        }

        public boolean isRightChildEmpty()
        {

            if(rightChild == null){
                logger.log(Level.INFO, "rightChild Empty");
                return true;
            }
            else {
                logger.log(Level.INFO, "rightChild not empty");
                return false;
            }
        }
    }
}


