package com.algo.ds.data_structures;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    private List<T> inOrderTraversal;
    private List<T> preOrderTraversal;
    private List<T> postOrderTraversal;
    private List<List<T>> levelOrderTraversal;
    private int maxHeight;

    public BinaryTree(BinaryTreeNode<T> root){
        this.root = root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    // bottom up approach : maxHeight
    public int maxHeight(BinaryTreeNode<T> node){
        if(node == null) return 0;
        this.maxHeight =  1 + Math.max(maxHeight(node.getLeft()), maxHeight(node.getRight()));
        return this.maxHeight;
    }

    // top down approach : maxHeight
    public void maxHeight(BinaryTreeNode<T> node, int depth){
        if(node == null) return;
        if(node.getLeft() == null && node.getRight() == null) maxHeight = Math.max(maxHeight, depth);
        maxHeight(node.getLeft(), depth+1);
        maxHeight(node.getRight(), depth+1);
    }

    public List<T> preOrderTraversal(BinaryTreeNode<T> node){
        preOrderHelper(node);
        return this.preOrderTraversal;
    }

    private void preOrderHelper(BinaryTreeNode<T> node) {
        if(node == null) return;
        this.preOrderTraversal.add(node.getVal());
        preOrderHelper(node.getLeft());
        preOrderHelper(node.getRight());
    }

    public List<T> inOrderTraversal(BinaryTreeNode<T> node){
        inOrderHelper(node);
        return this.inOrderTraversal;
    }

    private void inOrderHelper(BinaryTreeNode<T> node) {
        if(node == null) return;
        preOrderHelper(node.getLeft());
        this.inOrderTraversal.add(node.getVal());
        inOrderHelper(node.getRight());
    }

    public List<T> postOrderTraversal(BinaryTreeNode<T> node){
        postOrderHelper(node);
        return this.postOrderTraversal;
    }

    private void postOrderHelper(BinaryTreeNode<T> node) {
        if(node == null) return;
        postOrderHelper(node.getLeft());
        postOrderHelper(node.getRight());
        this.postOrderTraversal.add(node.getVal());

    }

    public List<List<T>> levelOrderTraversal(BinaryTreeNode<T> node){
        levelOrderHelper(node,0);
        return this.levelOrderTraversal;
    }

    private void levelOrderHelper(BinaryTreeNode<T> node, int level){
        if(node == null) return;
        if(this.levelOrderTraversal.size() <= level){
            this.levelOrderTraversal.add(new ArrayList<>());
        }
        this.levelOrderTraversal.get(level).add(node.getVal());
        levelOrderHelper(node.getLeft(), level+1);
        levelOrderHelper(node.getRight(), level+1);
    }

    public boolean isSymmetric(BinaryTreeNode<T> node){
        if(node == null) return true;
        return isSymmetricHelper(node.getLeft(), node.getRight());
    }

    private boolean isSymmetricHelper(BinaryTreeNode<T> left, BinaryTreeNode<T> right){
        if(left == null || right == null) return left == right;
        if(left.getVal() != right.getVal()) return false;
        return isSymmetricHelper(left.getLeft(), right.getRight()) && isSymmetricHelper(left.getRight(), right.getLeft());
    }

    public boolean pathSum(BinaryTreeNode<Integer> node, int sum){
        return pathSumHelper(node, 0, sum);
    }

    private boolean pathSumHelper(BinaryTreeNode<Integer> node, int localSum, int sum){
        if(node == null) return false;
        if(node.getLeft() == null && root.getRight() == null) return localSum + node.getVal() == sum;

        return pathSumHelper(node.getLeft(), localSum + node.getVal(), sum) || pathSumHelper(node.getRight(), localSum + node.getVal(), sum);
    }


}
