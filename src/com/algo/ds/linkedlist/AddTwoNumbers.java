package com.algo.ds.linkedlist;

import com.algo.ds.data_structures.LinkedList;
import com.algo.ds.data_structures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static com.algo.ds.misc.Utility.printLinkedList;

public class AddTwoNumbers {
    // using stack
    public static LinkedListNode<Integer> addTwoNumbers(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null) {
            s1.push(l1.getVal());
            l1 = l1.getNext();
        }
        while(l2 != null) {
            s2.push(l2.getVal());
            l2 = l2.getNext();
        }
        LinkedListNode<Integer> node = new LinkedListNode<>(1);
        int sum = 0;
        while(!s1.empty() || !s2.empty()){
            if(!s1.empty()) sum += s1.pop();
            if(!s2.empty()) sum += s2.pop();
            node.setVal(sum%10);
            LinkedListNode<Integer> head = new LinkedListNode<>(sum/10);
            head.setNext(node);
            node = head;
            sum /= 10;
        }

        return node.getVal() == 0 ? node.getNext() : node;

    }

//    // using recursion
//    public static LinkedListNode<Integer> addTwoNumbersRec(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2){
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//
//    }

}
