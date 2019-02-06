package com.algo.ds.data_structures;

import java.util.List;

public class LinkedList<T> {
    private LinkedListNode<T> head;
    private int count;

    public LinkedList(T val) {
        this.head = new LinkedListNode<>(val);
        this.count = 1;
    }

    public LinkedList(List<T> values) {
        if(!values.isEmpty()){
            setHead(new LinkedListNode<>(values.get(0)));
            setCount(1);
        }
        for(int i=1; i<values.size(); i++){
            addAtEnd(new LinkedListNode<>(values.get(i)));
        }
    }

    public LinkedListNode<T> getHead() {
        return head;
    }

    public void setHead(LinkedListNode<T> head) {
        this.head = head;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add(LinkedListNode<T> node){
        node.setNext(this.getHead());
        this.setHead(node);
        this.setCount(this.count + 1);
    }

    public void addAtEnd(LinkedListNode<T> node){
        if(count == 0) add(node);
        else{
            addAtIndex(node, count+1);
        }
    }

    public int addAtIndex(LinkedListNode<T> node, int index){
        if(index > this.count+1){
            return -1;
        }
        else{
            LinkedListNode<T> dummy = traverse(index);
            if(dummy.getNext() == null){
                dummy.setNext(node);
            }
            else{
                node.setNext(dummy.getNext());
                dummy.setNext(node);
            }
        }
        this.setCount(this.count + 1);
        return this.count;
    }

    public LinkedListNode deleteAt(int index){
        LinkedListNode deletedNode;
        if(index > this.count){
            return null;
        }
        else if(index == 1){
            deletedNode = this.getHead();
            this.setHead(this.head.getNext());
        }
        else{
            LinkedListNode<T> dummy = traverse(index);
            deletedNode = dummy.getNext();
            dummy.setNext(dummy.getNext().getNext());
        }
        this.setCount(this.count - 1);
        return deletedNode;
    }

    private LinkedListNode<T> traverse(int index) {
        LinkedListNode<T> dummy = new LinkedListNode<>();
        dummy.setNext(this.head);
        while(dummy.getNext() != null && index > 1){
            dummy = dummy.getNext();
            index--;
        }
        return dummy;
    }

    public LinkedListNode delete(LinkedListNode<T> node){
        int index = find(node);
        if(index == -1)
            return null;
        return deleteAt(index);
    }

    public int find(LinkedListNode<T> node){
        LinkedListNode<T> dummy = this.head;
        int index = 1;

        while(dummy != null){
            if(dummy.equals(node)){
                return index;
            }
            else{
                dummy = dummy.getNext();
                index++;
            }
        }
        return -1;
    }

    public LinkedListNode find(int index){
        if(index > this.count){
            return null;
        }
        else if(index == 1){
            return this.getHead();
        }
        else {
            LinkedListNode<T> dummy = traverse(index);
            return dummy.getNext();
        }
    }

    public LinkedListNode reverse(){
        if(this.head == null || this.head.getNext() == null){
            return head;
        }
        LinkedListNode<T> previous = null, current = this.head;
        while(current!= null){
            LinkedListNode<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        this.setHead(previous);
        return this.getHead();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        LinkedListNode<T> dummy = this.getHead();
        if(this.getHead() == null){
            return sb.toString();
        }
        while(dummy != null){
            sb.append(dummy.getVal());
            sb.append("->");
            dummy = dummy.getNext();
        }
        return sb.toString();
    }
}
