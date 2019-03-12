package com.algo.ds.tree_graphs.binarytree;

import com.algo.ds.data_structures.BinaryTree;
import com.algo.ds.data_structures.BinaryTreeNode;

public class BSTFromSortedArray<T extends Comparable<T>> {
    public BinaryTreeNode<T> constructBinaryTree(T[] arr){
        if(arr == null || arr.length == 0) return null;
        return constructHelper(arr, 0, arr.length-1);
    }

    private BinaryTreeNode<T> constructHelper(T[] arr, int left, int right){
        if(left <= right) {
            int mid = left + (right - left)/2;
            BinaryTreeNode<T> root = new BinaryTreeNode<>(arr[mid]);
            root.setLeft(constructHelper(arr, left, mid - 1));
            root.setRight(constructHelper(arr, mid + 1, right));
            return root;
        }
        return null;
    }

}
