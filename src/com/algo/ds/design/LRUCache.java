package com.algo.ds.design;

import java.util.LinkedHashMap;
import java.util.Map;

//using LinkedHashMap
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int val){
        super.put(key, val);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
