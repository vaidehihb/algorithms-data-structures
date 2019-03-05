package com.algo.ds.sorting_searching.binarysearch.template1;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        if(arr == null || arr.length == 0) return -1;
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    public static int binarySearch(int[] arr, int target, int left, int right){
        if(arr == null || arr.length == 0) return -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
