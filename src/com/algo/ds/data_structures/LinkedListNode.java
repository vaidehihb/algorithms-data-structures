package com.algo.ds.data_structures;

public class LinkedListNode<T> {
    private T val;
    private LinkedListNode<T> next;

    public LinkedListNode(){
    }

    public LinkedListNode(T val){
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}
