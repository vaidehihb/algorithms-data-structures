package com.algo.ds.tree_graphs.n_ary_tree;

import java.util.ArrayList;

public class Node implements Comparable<Node>{
    private int value;
    private ArrayList<Node> children;
    private int subtreeCount;
    private int sum;
    private boolean isParent;

    public Node(){
        children = new ArrayList<Node>();
        this.isParent = false;
        this.subtreeCount = 1;
    }

    public Node(int value) {
        this.value = value;
        this.children = new ArrayList<Node>();
        this.sum = value;
        this.isParent = false;
        this.subtreeCount = 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public int getSubtreeCount() {
        return subtreeCount;
    }

    public void setSubtreeCount(int subtreeCount) {
        this.subtreeCount = subtreeCount;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.getSum()/(double) this.getSubtreeCount(), o.getSum()/(double) o.getSubtreeCount());
    }
}


