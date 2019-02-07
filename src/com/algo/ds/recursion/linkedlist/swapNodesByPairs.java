package com.algo.ds.recursion.linkedlist;

import com.algo.ds.data_structures.LinkedListNode;
import com.algo.ds.data_structures.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class swapNodesByPairs {
    public static LinkedListNode swapPairs(LinkedListNode head) {
        if(head == null || head.getNext() == null){
            return head;
        }

        LinkedListNode nextHead = head.getNext().getNext();
        LinkedListNode currentHead = head.getNext();
        currentHead.setNext(head);
        head.setNext(swapPairs(nextHead));
        return currentHead;
    }
}
