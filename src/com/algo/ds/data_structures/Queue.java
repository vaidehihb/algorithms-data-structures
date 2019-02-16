package com.algo.ds.data_structures;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private T front, rear, size;
    private int capacity;
    private T[] data;

    public Queue(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[this.capacity];

    }



}
