package com.algo.ds.sorting_searching.sortingalgorithms;

public class MergeSort<T extends Comparable<T>> {
    public void mergeSort(T[] arr){
        if(arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(T[] arr, boolean desc){
        if(arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1, desc);
    }

    public void mergeSort(T[] arr, int l, int r){
        if(l>=r) return;
        int m = l + (r-l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }

    public void mergeSort(T[] arr, int l, int r, boolean desc){
        if(l>=r) return;
        int m = l + (r-l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r, desc);
    }

    private void merge(T[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r - m;

        T[] left = (T[]) new Comparable[n1];
        T[] right = (T[]) new Comparable[n2];

        for(int i = 0; i<n1; i++){
            left[i] = arr[l+i];
        }
        for(int i = 0; i<n2; i++){
            right[i] = arr[m+1+i];
        }
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i].compareTo(right[j]) < 0) {
                arr[k] = left[i++];
            }
            else {
                arr[k] = right[j++];
            }
            k++;
        }
        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2){
            arr[k++] = right[j++];
        }
    }

    private void merge(T[] arr, int l, int m, int r, boolean desc){
        int n1 = m-l+1;
        int n2 = r - m;

        T[] left = (T[]) new Comparable[n1];
        T[] right = (T[]) new Comparable[n2];

        for(int i = 0; i<n1; i++){
            left[i] = arr[l+i];
        }
        for(int i = 0; i<n2; i++){
            right[i] = arr[m+1+i];
        }
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i].compareTo(right[j]) >= 0) {
                arr[k] = left[i++];
            }
            else {
                arr[k] = right[j++];
            }
            k++;
        }
        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2){
            arr[k++] = right[j++];
        }
    }
}
