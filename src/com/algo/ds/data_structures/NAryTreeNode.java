package com.algo.ds.data_structures;

import java.util.List;

public class NAryTreeNode<T> {
    private T val;
    private List<NAryTreeNode<T>> children;

    public NAryTreeNode() {

    }

    public NAryTreeNode(T val) {
        this.val = val;
        this.children = null;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public List<NAryTreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<NAryTreeNode<T>> children) {
        this.children = children;
    }
}
