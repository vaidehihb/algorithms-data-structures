package com.algo.ds.data_structures.interfaces;

import java.util.Collection;
import java.util.List;

public interface IList<T> {
    public int add(T val);
    public int remove(T val);
    public void clear();
    public boolean contains(T val);
    public int size();
    public List<T> toList();
}
