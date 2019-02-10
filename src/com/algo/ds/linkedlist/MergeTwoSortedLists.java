package com.algo.ds.linkedlist;

import com.algo.ds.data_structures.LinkedList;
import com.algo.ds.data_structures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;

import static com.algo.ds.misc.Utility.printLinkedList;

public class MergeTwoSortedLists {

    public static LinkedListNode<Integer> mergeSortedLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2){

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        LinkedListNode<Integer> head = new LinkedListNode<>(0);
        LinkedListNode<Integer> current = head;

        while(l1 != null && l2 != null){
            if(l1.getVal() > l2.getVal()) {
                current.setNext(l2);
                l2 = l2.getNext();
            }
            else{
                current.setNext(l1);
                l1 = l1.getNext();
            }
            current = current.getNext();

        }
        if(l1 != null) current.setNext(l1);
        else if(l2 != null) current.setNext(l2);

        return head.getNext();
    }

//    public static void main(String[] args) {
//        Integer[] arr2 = new Integer[]{1,3,5,7,9};
//        Integer[] arr1 = new Integer[]{2,4,6,8,10};
//        LinkedList<Integer> list1 = new LinkedList<>(new ArrayList<>(Arrays.asList(arr1)));
//        LinkedList<Integer> list2 = new LinkedList<>(new ArrayList<>(Arrays.asList(arr2)));
//        LinkedListNode<Integer> newHead = mergeSortedLists(list1.getHead(), list2.getHead());
//        printLinkedList(newHead);
//    }
}
