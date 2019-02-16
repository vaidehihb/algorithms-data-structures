package com.algo.ds.data_structures.interfaces;

import java.util.Map;

public interface IMap<K,V> {
    public V put(K key, V val);
    public V get(K key);
    public V remove(K key);
    public void clear();
    public boolean contains(K key);
    public int size();
    public boolean validate();
    public Map<K,V> toMap();
}
