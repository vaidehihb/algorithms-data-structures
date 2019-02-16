package com.algo.ds.data_structures.interfaces;

public interface IStack<T> {
    public boolean push(T val);
    public T pop(T val);
    public T peek();
    public boolean remove(T val);

}
