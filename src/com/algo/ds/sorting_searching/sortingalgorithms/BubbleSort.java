package com.algo.ds.sorting_searching.sortingalgorithms;

public class BubbleSort<T extends Comparable<T>> {
    public void bubbleSort(T[] arr){
        for(int i=0; i<arr.length - 1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j].compareTo(arr[j+1]) > 0){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public void bubbleSort(T[] arr, boolean desc){
        for(int i=0; i<arr.length - 1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j].compareTo(arr[j+1]) < 0){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

