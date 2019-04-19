package com.algo.ds.linkedlist;

import com.algo.ds.data_structures.LinkedListNode;


public class BackwardsPrint {
    public void printBackwards(LinkedListNode<Integer> head){
        if(head == null) return;
        printBackwards(head.getNext());
        System.out.println(head.getVal());
    }

    public void printBackwardsIterative(LinkedListNode<Integer> head){
        if(head == null) return;
        int length = 1;
        LinkedListNode<Integer> node = head;
        while(node.getNext() != null) {
            node = node.getNext();
            length++;
        }
        node = head;
        for(int i=length; i>=1; i--){
            int count = i;
            while(count > 1){
                node = node.getNext();
                count--;
            }
            System.out.println(node.getVal());
            node = head;
        }
    }
}
