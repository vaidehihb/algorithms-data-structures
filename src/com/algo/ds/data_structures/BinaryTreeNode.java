package com.algo.ds.data_structures;

public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {
    private T val;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }


    public void printTree(){
        printTreeHelper(this, 0, null);
    }

    private void printTreeHelper(BinaryTreeNode<T> root, int level, BinaryTreeNode<T> parent){
        if(root == null) return;
        System.out.println("Node : " + root.getVal().toString() + ", Parent : " + (parent != null ? parent.getVal().toString() : "") + ", level : " + level);
        printTreeHelper(root.getLeft(), level + 1, root);
        printTreeHelper(root.getRight(), level + 1, root);
    }

    @Override
    public int compareTo(BinaryTreeNode<T> o) {
        return this.getVal().compareTo(o.getVal());
    }
}
