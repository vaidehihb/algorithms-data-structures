package com.algo.ds.tree_graphs.n_ary_tree;

import com.algo.ds.data_structures.LinkedListNode;
import com.algo.ds.data_structures.NAryTree;
import com.algo.ds.data_structures.NAryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class DirectoryListing<T> {

    public NAryTreeNode<String> buildDirectory(){
        NAryTreeNode<String> root = new NAryTreeNode<>("Root");
        List<NAryTreeNode<String>> rootChildren = new ArrayList<>();
        rootChildren.add(new NAryTreeNode<>("Level1"));
        rootChildren.add(new NAryTreeNode<>("Level2"));
        rootChildren.add(new NAryTreeNode<>("Level3"));
        root.setChildren(rootChildren);
        List<NAryTreeNode<String>> level1Children = new ArrayList<>();
        List<NAryTreeNode<String>> level2Children = new ArrayList<>();
        List<NAryTreeNode<String>> level3Children = new ArrayList<>();
        level1Children.add(new NAryTreeNode<>("Level11"));
        level1Children.add(new NAryTreeNode<>("Level12"));
        level1Children.add(new NAryTreeNode<>("Level13"));

        level2Children.add(new NAryTreeNode<>("Level21"));
        level2Children.add(new NAryTreeNode<>("Level22"));
        level2Children.add(new NAryTreeNode<>("Level23"));

        level3Children.add(new NAryTreeNode<>("Level31"));
        level3Children.add(new NAryTreeNode<>("Level32"));
        level3Children.add(new NAryTreeNode<>("Level33"));

        root.getChildren().get(0).setChildren(level1Children);
        root.getChildren().get(1).setChildren(level2Children);
        root.getChildren().get(2).setChildren(level3Children);

        List<NAryTreeNode<String>> level11Children = new ArrayList<>();
        level11Children.add(new NAryTreeNode<>("Level111"));
        level11Children.add(new NAryTreeNode<>("Level112"));

        root.getChildren().get(0).getChildren().get(0).setChildren(level11Children);

        return root;
    }

    public void printDirectory(NAryTreeNode<T> root){
        printHelper(root, 0);
    }

    private void printHelper(NAryTreeNode<T> root, int level){
        if(root == null) return;
        if(level > 0) {
            String out = "";
            if(level > 1){
                out += getIndentation(level);
            }
            out += root.getVal();
            System.out.println(out);
        }
        if(root.getChildren() != null){
            for(NAryTreeNode<T> child: root.getChildren())
            printHelper(child, level+1);
        }
    }

    public void printLeaves(NAryTreeNode<T> root){
        printLeavesHelper(root, 0);
    }

    private void printLeavesHelper(NAryTreeNode<T> root, int level){
        if(root == null) return;
        if(root.getChildren() == null) {
            System.out.println(getIndentation(level) + root.getVal());
            return;
        }
        else {
            for(NAryTreeNode<T> child : root.getChildren()){
                printLeavesHelper(child, level+1);
            }
        }
    }

    public void printLevel(NAryTreeNode<T> root, int level){
        printLevelHelper(root, 0, level);
    }

    private void printLevelHelper(NAryTreeNode<T> root, int depth, int level){
        if(root == null) return;
        if(depth == level) {
            System.out.println(root.getVal());
            return;
        }
        if(root.getChildren() != null){
            for(NAryTreeNode<T> child: root.getChildren()){
                printLevelHelper(child, depth+1, level);
            }
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
                allPathsHelper(child, path + root.getVal() + "->", paths);
            }
        }
    }

    private String getIndentation(int level){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=level; i++){
            sb.append("\t");
        }
        return sb.toString();
    }

}
