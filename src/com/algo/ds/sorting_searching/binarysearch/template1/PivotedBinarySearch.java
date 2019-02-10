package com.algo.ds.sorting_searching.binarysearch.template1;

import com.algo.ds.sorting_searching.binarysearch.template1.BinarySearch;

// binary search in rotated array
public class PivotedBinarySearch {
    public static int pivotedBinarySerach(int[] arr, int target){
        if(arr == null || arr.length  == 0) return -1;
        int n = arr.length;
        int pivot = findPivot(arr, 0,  n - 1);
        if(pivot == -1) return BinarySearch.binarySearch(arr, target, 0, n-1);
        if(arr[pivot] == target) return pivot;
        if(arr[0] > target) return BinarySearch.binarySearch(arr, target, pivot+1, n-1);
        return BinarySearch.binarySearch(arr, target, 0, pivot-1);
    }

    public static int findPivot(int[] arr, int low, int high){
        if(low > high) return -1;
        if(low == high) return low;

        int mid = low + (high - low)/2;
        if(mid < high && arr[mid] > arr[mid+1]) return mid;
        if(mid > low && arr[mid] < arr[mid-1]) return mid-1;
        if(arr[low] >= arr[mid]) return findPivot(arr, low, mid-1);
        return findPivot(arr, mid+1, high);
    }

    public static int pivotedBinarySerachWithoutPivotFinding(int[] arr, int target){
        if(arr == null || arr.length  == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] < arr[end]){
                if(target > arr[mid] && target <= arr[end]) start = mid + 1;
                else end = mid - 1;
            }
            else {
                if(arr[start] <= target && target < arr[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }
}
