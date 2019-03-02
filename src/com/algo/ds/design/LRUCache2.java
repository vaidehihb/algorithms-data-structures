package com.algo.ds.design;

import com.algo.ds.data_structures.HashMap;
import com.algo.ds.data_structures.HashSet;

import java.util.Map;

//using hashmap and doubly
public class LRUCache2 {
    class DLinkedNode{
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private DLinkedNode head, tail;
    private int size;
    private int capacity;
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();

    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = (DLinkedNode) cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val){
        DLinkedNode node = (DLinkedNode) cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.val = val;
            newNode.key = key;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;
            if(size > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            node.val = val;
            moveToHead(node);
        }

    }
}
