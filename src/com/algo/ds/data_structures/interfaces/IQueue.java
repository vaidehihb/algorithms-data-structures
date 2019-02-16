package com.algo.ds.data_structures.interfaces;

import java.util.Collection;
import java.util.Queue;

public interface IQueue<T> {
    public boolean offer(T val);
    public T poll();
    public T peek();
    public boolean remove(T val);
    public void clear();
    public boolean contains(T val);
    public int size();
    public boolean validate();
    public Queue<T> toQueue();
    public Collection<T> toCollection();
}
