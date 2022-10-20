package com.sparta.jjs.Sorts.binary_tree;

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

    public static void getSortedArray(int[] randomArray) {
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
        return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return new int[0];
    }

    @Override
    public int[] getSortedTreeDesc() {
        return new int[0];
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

}


