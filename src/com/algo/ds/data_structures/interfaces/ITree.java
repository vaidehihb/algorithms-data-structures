package com.algo.ds.data_structures.interfaces;

import java.util.Collection;

public interface ITree<T> {
    public boolean insert(T val);
    public T delete(T val);
    public void clear();
    public boolean contains(T val);
    public int size();
    public boolean validate();
    public Collection<T> toCollection();

}
