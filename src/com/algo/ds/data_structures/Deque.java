package com.algo.ds.data_structures;

public class Deque<T> {
    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    // adds to tail
    public void add(){

    }

    // add at head
    public void addFirst(T val){

    }

    // add at tail
    public void addLast(T val){

    }

    // adds to tail
    public boolean offer(){
        return true;
    }

    // add at head
    public boolean offerFirst(T val){
        return true;
    }

    // add at tail
    public boolean offerLast(T val){
        return true;
    }

    // push to head
    public void push(T val){

    }

    // pop at head
    public T pop(T val){
        return null;
    }


}
