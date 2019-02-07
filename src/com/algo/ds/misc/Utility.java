package com.algo.ds.misc;

import com.algo.ds.data_structures.LinkedListNode;

public class Utility{
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
