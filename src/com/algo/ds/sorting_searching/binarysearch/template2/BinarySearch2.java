package com.algo.ds.sorting_searching.binarysearch.template2;

public class BinarySearch2 {
    public static int binarySearch2(int[] arr, int target){
        if(arr == null || arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) start = mid + 1;
            else end = mid;
        }

        if(start != arr.length - 1 && arr[start] == target) return start;
        return -1;
    }
}
