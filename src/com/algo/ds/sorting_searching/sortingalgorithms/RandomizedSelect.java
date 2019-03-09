package com.algo.ds.sorting_searching.sortingalgorithms;

import java.util.Random;

public class RandomizedSelect<T extends Comparable<T>> {
    public T randomizedSelect(T[] arr, int rank){
        if(arr == null || arr.length == 0) return null;
        return randomizedSelectHelper(arr, rank, 0, arr.length-1);
    }

    private T randomizedSelectHelper(T[] arr, int rank, int left, int right){
        if(left == right) return arr[left];
        int pivotIndex = randomizedPartition(arr, left, right);
        int k = pivotIndex - left + 1;
        if(rank == k) return arr[pivotIndex];
        else if(rank < k) return randomizedSelectHelper(arr, rank, left, pivotIndex - 1);
        else return randomizedSelectHelper(arr, rank - k, pivotIndex+1, right);
    }

    private int randomizedPartition(T[] arr, int left, int right){
        Random rn = new Random();
        int i = rn.nextInt((right - left) + 1) + left;
        swap(arr, i, right);
        return partition(arr, left, right);
    }

    private int partition(T[] arr, int left, int right){
        T pivot = arr[right];
        int i = left - 1;
        for(int j = left; j < right - 1; j++){
            if(arr[j].compareTo(pivot) <= 0){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr,i+1, right);
        return i+1;
    }

    private void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
