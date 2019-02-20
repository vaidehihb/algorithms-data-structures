package com.algo.ds.linkedlist;

/*
*  List Partition
*  #twopointers
*/

import com.algo.ds.data_structures.LinkedList;
import com.algo.ds.data_structures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;

import static com.algo.ds.misc.Utility.printLinkedList;

public class PartitionList {
    public static LinkedListNode<Integer> partitionList(LinkedListNode<Integer> head, int pivot){
        if(head == null || head.getNext() == null) return head;
        LinkedListNode<Integer> p1 = null, p2 = null, start1 = null, start2 = null;
        while(head != null){
            if(head.getVal() < pivot){
                if(start1 == null){
                    start1 = head;
                    p1 = start1;
                }
                else{
                    p1.setNext(head);
                    p1 = p1.getNext();
                }
            }
            else{
                if(start2 == null){
                    start2 = head;
                    p2 = start2;
                }
                else{
                    p2.setNext(head);
                    p2 = p2.getNext();
                }
            }
            head = head.getNext();
        }
        if(p2 != null) p2.setNext(null);
        if(p1 != null) p1.setNext(start2);
        return start1 != null ? start1 : start2;
    }
}
