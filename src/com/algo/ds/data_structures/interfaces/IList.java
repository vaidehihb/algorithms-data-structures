package com.algo.ds.data_structures.interfaces;

import java.util.Collection;
import java.util.List;

public interface IList<T> {
    public boolean add(T val);
    public boolean remove(T val);
    public void clear();
    public boolean contains(T val);
    public int size();
    public List<T> toList();
    public Collection<T> toCollection();
}
