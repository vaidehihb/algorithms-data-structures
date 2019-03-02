package com.algo.ds.sorting_searching.sortingalgorithms;

import com.algo.ds.data_structures.MaxHeap;
import com.algo.ds.data_structures.MinHeap;

public class HeapSort<T extends Comparable<T>> {
    public T[] heapSort(T[] arr){
        if(arr.length <= 1 || arr == null) return arr;
        MinHeap<T> heap = new MinHeap<>(arr);
        for(int i=1; i<=arr.length; i++){
            arr[i-1] = heap.deleteMin();
        }
        return arr;
    }

    public T[] heapSort(T[] arr, String order){
        if(arr.length <= 1 || arr == null) return arr;
        MaxHeap<T> heap = new MaxHeap<>(arr);
        for(int i=1; i<=arr.length; i++){
            arr[i-1] = heap.deleteMax();
        }
        return arr;
    }
}
