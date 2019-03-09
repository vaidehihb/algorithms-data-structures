package com.algo.ds.sorting_searching.sortingalgorithms;

public class QuickSort<T extends Comparable<T>> {
    public void quickSort(T[] arr){
        if(arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(T[] arr, boolean desc){
        if(arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1, desc);
    }

    public void quickSort(T[] arr, int low, int high){
        if(low >= high) return;
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot-1);
        quickSort(arr, pivot+1, high);
    }

    public void quickSort(T[] arr, int low, int high, boolean desc){
        if(low >= high) return;
        int pivot = partition(arr, low, high, desc);
        quickSort(arr, low, pivot-1);
        quickSort(arr, pivot+1, high);
    }

    public int partition(T[] arr, int low, int high){
        T pivot = arr[high];
        int i = low - 1;
        for(int j = low; j<high; j++){
            if(arr[j].compareTo(pivot) <= 0){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    public int partition(T[] arr, int low, int high, boolean desc){
        T pivot = arr[high];
        int i = low - 1;
        for(int j = low; j<high; j++){
            if(arr[j].compareTo(pivot) > 0){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}