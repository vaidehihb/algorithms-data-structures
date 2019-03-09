package com.algo.ds.sorting_searching.sortingalgorithms;

public class SelectionSort<T extends Comparable<T>> {
    public void selectionSort(T[] arr){
        int minIndex, j, i;
        for(i=0; i<arr.length-1; i++){
            j = i+1;
            minIndex = i;
            while(j < arr.length){
                if(arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
                j++;
            }
            swap(arr, i, minIndex);
        }
    }

    public void selectionSort(T[] arr, boolean desc){
        int maxIndex, j, i;
        for(i=0; i<arr.length-1; i++){
            j = i+1;
            maxIndex = i;
            while(j < arr.length){
                if(arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
                j++;
            }
            swap(arr, i, maxIndex);
        }
    }

    private void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
