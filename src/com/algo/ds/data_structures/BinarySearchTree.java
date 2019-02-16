package com.algo.ds.data_structures;

public class BinarySearchTree {
    public static boolean isValidBST(BinaryTreeNode<Integer> root){
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(BinaryTreeNode<Integer> root, int minValue, int maxValue){
        if(root == null) return true;
        if(root.getVal() <= minValue || root.getVal() >= maxValue) return false;
        return isValidBST(root.getLeft(), minValue, root.getVal()) && isValidBST(root.getRight(), root.getVal(), maxValue);
    }

    public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root, int val){
        if(root == null) return null;
        if(root.getVal() == val) return root;
        else if(root.getVal() > val) return searchInBST(root.getLeft(), val);
        else return searchInBST(root.getRight(), val);
    }

    public static BinaryTreeNode<Integer> insertInBST(BinaryTreeNode<Integer> root, int val) {
        if(root == null) {
            root = new BinaryTreeNode<>(val);
            return root;
        }
        insertBSTHelper(root, val);
        return root;
    }

    private static void insertBSTHelper(BinaryTreeNode<Integer> root, int val) {
        if(root.getVal() >= val){
            if(root.getLeft() != null) insertBSTHelper(root.getLeft(), val);
            else{
                root.setLeft(new BinaryTreeNode<>(val));
                return;
            }
        }
        else{
            if(root.getRight() != null) insertBSTHelper(root.getRight(), val);
            else{
                root.setRight(new BinaryTreeNode<>(val));
                return;
            }
        }
    }

    public static BinaryTreeNode<Integer> findMinInBST(BinaryTreeNode<Integer> root){
        BinaryTreeNode<Integer> current = root;
        while(current.getLeft() != null) current = current.getLeft();
        return current;
    }

    public static BinaryTreeNode<Integer> findMaxInBST(BinaryTreeNode<Integer> root){
        BinaryTreeNode<Integer> current = root;
        while(current.getRight() != null) current = current.getRight();
        return current;
    }

    public static BinaryTreeNode<Integer> inOrderSuccessor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node){
        if(root == null) return null;
        if(node.getRight() != null) return findMinInBST(node.getRight());
        BinaryTreeNode<Integer> successor = null;
        while(root != null){
            if(root.getVal() > node.getVal()){
                successor = root;
                root = root.getLeft();
            }
            else if(root.getVal() < node.getVal()){
                root = root.getRight();
            }
            else{
                break;
            }
        }
        return successor;
    }

    public static BinaryTreeNode<Integer> inOrderPredecessor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node){
        if(root == null) return null;
        if(node.getLeft() != null) return findMaxInBST(node.getLeft());
        BinaryTreeNode<Integer> predecessor = null;
        while(root != null){
            if(root.getVal() < node.getVal()){
                predecessor = root;
                root = root.getRight();
            }
            else if(root.getVal() > node.getVal()){
                root = root.getLeft();
            }
            else{
                break;
            }
        }
        return predecessor;
    }

    public static BinaryTreeNode<Integer> deleteFromBST(BinaryTreeNode<Integer> root, int val){
        if(root == null) return null;
        if(val < root.getVal()){
            root.setLeft(deleteFromBST(root.getLeft(), val));
        }
        else if(val > root.getVal()){
            root.setRight(deleteFromBST(root.getRight(), val));
        }
        else{
            if(root.getLeft() == null) return root.getRight();
            else if(root.getRight() == null) return root.getLeft();
            else{
                BinaryTreeNode<Integer> succ = findMinInBST(root.getRight());
                root.setVal(succ.getVal());
                root.setRight(deleteFromBST(succ, succ.getVal()));
            }
        }
        return root;
    }
}
