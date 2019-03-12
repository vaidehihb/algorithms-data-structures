package com.algo.ds.tree_graphs.binarytree;

import com.algo.ds.data_structures.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTree<T extends Comparable<T>> {
    public BinaryTreeNode<T> constructFromPostOrderInOrder(T[] inorder, T[] postorder){
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<T,Integer> inorderMap = new HashMap<>();
        int n = inorder.length;
        for(int i=0; i<n; i++)
            inorderMap.put(inorder[i], i);
        return constructPostOrderHelper(inorder, postorder, 0, inorder.length - 1, n-1, inorderMap);
    }

    private BinaryTreeNode<T> constructPostOrderHelper(T[] inorder, T[] preorder, int inStart, int inEnd, int postEnd, Map<T,Integer> inorderMap){
        if(inStart > inEnd) return null;
        BinaryTreeNode<T> root = new BinaryTreeNode<>(preorder[postEnd]);
        int rootIndex = inorderMap.get(preorder[postEnd]);
        root.setLeft(constructPreOrderHelper(inorder, preorder, inStart, rootIndex-1, postEnd-inEnd+rootIndex - 1, inorderMap));
        root.setRight(constructPreOrderHelper(inorder, preorder, rootIndex+1, inEnd, postEnd-1, inorderMap));
        return root;
    }

    public BinaryTreeNode<T> constructFromPreOrderInOrder(T[] inorder, T[] preorder){
        if(inorder == null || preorder == null || inorder.length != preorder.length) return null;
        Map<T,Integer> inorderMap = new HashMap<>();
        int n = inorder.length;
        for(int i=0; i<n; i++)
            inorderMap.put(inorder[i], i);
        return constructPreOrderHelper(inorder, preorder, 0, inorder.length - 1, 0, inorderMap);
    }

    private BinaryTreeNode<T> constructPreOrderHelper(T[] inorder, T[] preorder, int inStart, int inEnd, int preStart, Map<T,Integer> inorderMap){
        if(inStart > inEnd) return null;
        BinaryTreeNode<T> root = new BinaryTreeNode<>(preorder[preStart]);
        int rootIndex = inorderMap.get(preorder[preStart]);
        root.setLeft(constructPreOrderHelper(inorder, preorder, inStart, rootIndex-1, preStart+1, inorderMap));
        root.setRight(constructPreOrderHelper(inorder, preorder, rootIndex+1, inEnd, preStart+rootIndex-inStart+1, inorderMap));
        return root;
    }
}
