package com.algo.ds.recursion.linkedlist;

import com.algo.ds.data_structures.LinkedList;
import com.algo.ds.data_structures.LinkedListNode;
import com.algo.ds.misc.Utility;

import java.util.Arrays;

public class ReverseLinkedList {
    public static LinkedListNode reverseLinkedList(LinkedListNode head){
        if(head == null || head.getNext() == null) return head;
        LinkedListNode newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }
}
