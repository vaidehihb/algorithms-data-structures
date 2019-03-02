package com.algo.ds.data_structures;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class MinHeap<T extends Comparable<T>> {
    private int capacity;
    private int size;
    private T[] heap;

    public MinHeap() {
        this(2);
    }

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = (T[]) new Comparable[this.capacity + 1];
    }

    public MinHeap(T[] arr) {
        size = arr.length;
        heap = (T[]) new Comparable[arr.length+1];
        System.arraycopy(arr,0,heap,1, arr.length);
        buildHeap();
    }

    private boolean hasParent(int k){
        return k>1;
    }

    private int getParentIndex(int k){
        return k/2;
    }

    private boolean hasLeftChild(int k){
        return getLeftChildIndex(k) <= size;
    }

    private int getLeftChildIndex(int k){
        return 2*k;
    }

    private boolean hasRightChild(int k){
        return getRightChildIndex(k) <= size;
    }

    private int getRightChildIndex(int k){
        return 2*k+1;
    }

    private boolean isLeaf(int k){
        if(!hasLeftChild(k) && !hasRightChild(k)) return true;
        return false;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void swap(int k, int j){
        T tmp = heap[k];
        heap[k] = heap[j];
        heap[j] = tmp;
    }


    private void buildHeap(){
        for(int i = size/2; i>0; i--){
            minHeapify(i);
        }
    }

    private void minHeapify(int k){
        if(!isLeaf(k)){
            int left = getLeftChildIndex(k);
            int right = getRightChildIndex(k);
            if(heap[k].compareTo(heap[left]) > 0 || (hasRightChild(k) && heap[k].compareTo(heap[right]) > 0)){
                if(hasRightChild(k) && heap[right].compareTo(heap[left]) < 0){
                    swap(k, right);
                    minHeapify(right);
                }
                else{
                    swap(k, left);
                    minHeapify(left);
                }
            }
        }
    }

    private void perlocateUp(int k){
        int ind = k;
        while(hasParent(ind) && heap[ind].compareTo(heap[getParentIndex(ind)]) < 0){
            swap(ind, getParentIndex(ind));
            ind = getParentIndex(ind);
        }
    }

    public void insert(T data){
        if(size >= heap.length - 1) resize();
        heap[++size] = data;
        perlocateUp(size);
    }

    public void decreseKey(int k, T val){
        if(k <= size){
            if(val.compareTo(heap[k]) > 0) throw new RuntimeException("Key greater than original");
            heap[k] = val;
            perlocateUp(k);
        }
    }

    public T deleteMin(){
        return remove(1);
    }

    public T remove(int k){
        if(k>size || isEmpty()) throw new RuntimeException();
        T removed = heap[k];
        heap[k] = heap[size--];
        minHeapify(k);
        return removed;
    }

    private void resize(){
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    @Override
    public String toString(){
        String heapStr = "";
        for(int k = 1; k <= size; k++) heapStr += heap[k] + " ";
        return heapStr;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            if (hasParent(i) || i==1) System.out.print(" PARENT : " + heap[i]);
            if (hasLeftChild(i)) System.out.print(" LEFT CHILD : " + heap[2 * i]);
            if (hasRightChild(i)) System.out.print(" RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }
}
