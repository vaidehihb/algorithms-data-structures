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

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        LinkedListNode head = swapPairs(linkedList.getHead());
        printLinkedList(head);
    }

    public static void printLinkedList(LinkedListNode head){
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.getVal());
            sb.append("->");
            head = head.getNext();
        }
        System.out.println(sb.toString());
    }
}
