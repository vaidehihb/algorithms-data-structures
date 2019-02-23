package com.algo.ds.sorting_searching.sortingalgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r){
        if(l>=r) return;
        int m = l + (r-l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }

    private static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i<n1; i++){
            left[i] = arr[l+i];
        }
        for(int i = 0; i<n2; i++){
            right[i] = arr[m+1+i];
        }
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(left[i] < right[j]) {
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
