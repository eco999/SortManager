package com.sparta.jjs.Sorts.binary_tree;

public class BinaryTree {
    //design decisions:
    //public methods for helping
    //private methods for using tree (hard work)

    //hiding the nodes - elements are the numbers in the nodes
    private final Node rootNode;

    //cant have a tree without a root node
    public BinaryTree(int element){
        this.rootNode = new Node(element);
    }

    public void addElementToTree(int element){
        addNodeToTree(rootNode, element);
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
}
