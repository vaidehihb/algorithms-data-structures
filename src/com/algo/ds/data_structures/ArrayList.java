package com.algo.ds.data_structures;

public class ArrayList<T> {
    private Object[] data;
    private int size = 0;
    private static final int maxCapacity = 10;

    public ArrayList() {
        this(maxCapacity);
    }

    public ArrayList(int length) {
        this.data = new Object[length];
    }

    public void add(T t){
        validateCapacity();
        data[size++] = t;
    }

    public void validateCapacity(){
        if(size < data.length){ return;}
        resize();
    }

    public void resize(){
        Object[] temp = new Object[size*2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public T get(int index){
        if(index >= size){
            throw new IllegalArgumentException("Index out of bound");
        }
        return (T)data[index];
    }

    public boolean contains(T t){
        if(firstIndexOf(t) > -1)
            return  true;
        return false;
    }

    public int firstIndexOf(T t){
        int index = -1;
        for(int i=0; i<size; i++){
            if(data[i].equals(t)){
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(T t){
        int index = -1;
        for(int i=0; i<size; i++){
            if(data[i].equals(t)){
                index = i;
            }
        }
        return index;
    }

    public int remove(T t){
        int index = -1;
        for(int i=0; i<size; i++){
            if(data[i].equals(t)){
                index = i;
                data[index] = null;
                break;
            }
        }
        if(index != -1){
            int temp = index;
            while(temp < size){
                data[temp] = data[temp + 1];
                data[temp + 1] = null;
                temp++;
            }
            size--;
        }
        return index;
    }

    public T remove(int index){
        if(index >= size){
            throw new IllegalArgumentException("Index out of bound");
        }
        T t = (T)data[index];
        data[index] = null;
        while (index < size) {
            data[index] = data[index + 1];
            data[index + 1] = null;
            index++;
        }
        size--;
        return t;
    }
}
