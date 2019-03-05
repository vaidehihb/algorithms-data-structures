package com.algo.ds.data_structures;

public class HashSet<T> {
    class Bucket<T>{
        LinkedListNode<T> head = new LinkedListNode<>();
    }

    int size = 10000;
    Bucket<T>[] buckets = new Bucket[size];



}
