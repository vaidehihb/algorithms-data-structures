package com.algo.ds.sorting_searching.sortingalgorithms;

public class InsertionSort<T extends Comparable<T>> {
    public void insertionSort(T[] arr){
        if(arr == null || arr.length == 0) return;
        int n = arr.length;
        for(int i=1; i<n; i++){
            T key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j].compareTo(key) > 0){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    public void insertionSort(T[] arr, boolean desc){
        if(arr == null || arr.length == 0) return;
        int n = arr.length;
        for(int i=1; i<n; i++){
            T key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j].compareTo(key) < 0){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
}
