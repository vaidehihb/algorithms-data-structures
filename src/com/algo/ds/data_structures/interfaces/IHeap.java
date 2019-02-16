package com.algo.ds.data_structures.interfaces;

import java.util.Collection;

public interface IHeap<T> {
    public boolean add(T val);
    public T getHead();
    public T removeHead();
    public T remove(T val);
    public void clear();
    public boolean contains(T val);
    public int size();
    public boolean validate();
    public Collection<T> toCollection();
}
