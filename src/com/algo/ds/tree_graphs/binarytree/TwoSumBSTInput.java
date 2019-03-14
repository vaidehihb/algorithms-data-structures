package com.algo.ds.tree_graphs.binarytree;

import com.algo.ds.data_structures.BinaryTree;
import com.algo.ds.data_structures.BinaryTreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBSTInput {
    public boolean twoSum(BinaryTreeNode<Integer> root, int target){
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, target);
    }

    private boolean dfs(BinaryTreeNode<Integer> root, Set<Integer> set, int target){
        if(root == null) return false;
        if(set.contains(target - root.getVal())) return true;
        set.add(root.getVal());
        return dfs(root.getLeft(), set, target) || dfs(root.getRight(), set, target);
    }

    public boolean twoSumWithoutHashMap(BinaryTreeNode<Integer> root, int target){
        return doesPartnerExist(root, root, target);
    }

    private BinaryTreeNode<Integer> doesExist(BinaryTreeNode<Integer> root, int target){
        if(root == null) return null;
        if(root.getVal() == target) return root;
        else if(root.getVal() < target) return doesExist(root.getRight(), target);
        else return doesExist(root.getLeft(), target);
    }

    private boolean doesPartnerExist(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> current, int target){
        if(current == null) return false;
        BinaryTreeNode<Integer> currentPartner = doesExist(root, target - current.getVal());
        if(currentPartner != null && currentPartner != current) return true;
        return doesPartnerExist(root, current.getLeft(), target) || doesPartnerExist(root, current.getRight(), target);
    }
}
