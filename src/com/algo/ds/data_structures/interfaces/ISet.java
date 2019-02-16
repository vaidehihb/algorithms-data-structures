package com.algo.ds.data_structures.interfaces;

import java.util.Collection;
import java.util.Set;

public interface ISet<T> {
    public boolean add(T val);
    public boolean remove(T val);
    public void clear();
    public boolean contains(T val);
    public int size();
    public boolean validate();
    public Set<T> toSet();
    public Collection<T> toCollection();

}
