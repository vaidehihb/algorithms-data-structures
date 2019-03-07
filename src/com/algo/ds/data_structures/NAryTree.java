package com.algo.ds.data_structures;

import java.util.ArrayList;
import java.util.List;

public class NAryTree<T> {
    public int maxHeight(NAryTreeNode<T> root){
        if(root == null) return 0;
        int depth = 0;
        if(root.getChildren() != null){
            for(NAryTreeNode<T> child: root.getChildren()){
                depth = Math.max(depth, maxHeight(child));
            }
        }

        return depth + 1;
    }

    public List<T> preOrderTraversal(NAryTreeNode<T> root){
        List<T> preOrderTraversal = new ArrayList<>();
        preOrderHelper(root, preOrderTraversal);
        return preOrderTraversal;
    }

    private void preOrderHelper(NAryTreeNode<T> root, List<T> preOrderTraversal) {
        if(root == null) return;
        preOrderTraversal.add(root.getVal());
        for(NAryTreeNode<T> child: root.getChildren()){
            preOrderHelper(child, preOrderTraversal);
        }
    }

    public List<T> postOrderTraversal(NAryTreeNode<T> root){
        List<T> postOrderHelper = new ArrayList<>();
        postOrderHelper(root, postOrderHelper);
        return postOrderHelper;
    }

    private void postOrderHelper(NAryTreeNode<T> root, List<T> postOrderHelper) {
        if(root == null) return;
        for(NAryTreeNode<T> child: root.getChildren()){
            postOrderHelper(child, postOrderHelper);
        }
        postOrderHelper.add(root.getVal());
    }

    public List<List<T>> levelOrderTraversal(NAryTreeNode<T> root){
        List<List<T>> levelOrderTraversal = new ArrayList<>();
        levelOrderHelper(root, levelOrderTraversal, 0);
        return levelOrderTraversal;
    }

    private void levelOrderHelper(NAryTreeNode<T> root, List<List<T>> levelOrderTraversal, int level) {
        if(root == null) return;
        if(levelOrderTraversal.size() <= level) levelOrderTraversal.add(new ArrayList<>());
        levelOrderTraversal.get(level).add(root.getVal());
        for(NAryTreeNode<T> child: root.getChildren()){
            levelOrderHelper(child, levelOrderTraversal, level+1);
        }
    }

    public List<String> printAllPaths(NAryTreeNode<T> root){
        List<String> paths = new ArrayList<>();
        if(root != null) allPathsHelper(root, "", paths);
        return paths;
    }

    private void allPathsHelper(NAryTreeNode<T> root, String path, List<String> paths){
        if(root.getChildren() == null) paths.add(path + root.getVal());
        if(root.getChildren() != null){
            for (NAryTreeNode<T> child: root.getChildren()) {
                allPathsHelper(child, path + child.getVal() + "->", paths);
            }
        }
    }
}
