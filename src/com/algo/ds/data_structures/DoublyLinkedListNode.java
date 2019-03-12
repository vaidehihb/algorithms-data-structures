package com.algo.ds.data_structures;

public class DoublyLinkedListNode<T> {
    private T val;
    private DoublyLinkedListNode<T> prev;
    private DoublyLinkedListNode<T> next;

    public DoublyLinkedListNode(T val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }
}
