package com.algo.ds.data_structures;

import java.util.NoSuchElementException;

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
    public void add(T val){
        addLast(val);
    }

    // add at head
    public void addFirst(T val){
        try {
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(val);
            if(size == 0) {
                head = newNode;
                tail = newNode;
            }
            else {
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }
            size++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // add at tail
    public void addLast(T val){
        try {
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(val);
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setPrev(tail);
                tail.setNext(newNode);
                tail = newNode;
            }
            size++;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // adds to tail
    public boolean offer(T val){
        return offerLast(val);
    }

    // add at head
    public boolean offerFirst(T val){
        try {
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(val);
            if(size == 0) {
                head = newNode;
                tail = newNode;
            }
            else {
                newNode.setNext(tail);
                head.setPrev(newNode);
                head = newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // add at tail
    public boolean offerLast(T val){
        try {
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(val);
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.setPrev(tail);
                tail.setNext(newNode);
                tail = newNode;
            }
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // push to head
    public void push(T val){
        addFirst(val);
    }

    // pop at head
    public T pop(){
        return pollFirst();
    }

    // remove first
    public void removeFirst(){
        if(size != 0){
            head = head.getNext();
            if(head != null) head.setPrev(null);
            if(--size == 0) tail = null;
            return;
        }
        throw new NoSuchElementException("No element to remove");
    }

    // remove last
    public void removeLast(){
        if(size != 0){
            tail = tail.getPrev();
            if(tail != null) tail.setNext(null);
            if(--size == 0) head = null;
            return;
        }
        throw new NoSuchElementException("No element to remove");
    }

    // poll(remove head)
    public T poll(){
        return pollFirst();
    }

    // poll first
    public T pollFirst(){
        if(size != 0){
            DoublyLinkedListNode<T> removed = head;
            head = head.getNext();
            if(head != null) head.setPrev(null);
            if(--size == 0) tail = null;
            return removed.getVal();
        }
        else {
            return null;
        }
    }

    // poll last
    public T pollLast(){
        if(size != 0){
            DoublyLinkedListNode<T> removed = head;
            tail = tail.getPrev();
            if(tail != null) tail.setNext(null);
            if(--size == 0) head = null;
            return removed.getVal();
        }
        else {
            return null;
        }
    }

    // peek head
    public T peek(){
        return peekFirst();
    }

    // peek head
    public T peekFirst(){
        if(size != 0) {
            return head.getVal();
        }
        else {
            return null;
        }
    }

    // peek tail
    public T peekLast(){
        if(size != 0) {
            return tail.getVal();
        }
        else {
            return null;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString(){
        if(size != 0){
            StringBuilder sb = new StringBuilder();
            DoublyLinkedListNode<T> temp = head;
            while(temp != null){
                sb.append(temp.getVal());
                sb.append("->");
                temp = temp.getNext();
            }
            return sb.toString();
        }
        return null;
    }
}
