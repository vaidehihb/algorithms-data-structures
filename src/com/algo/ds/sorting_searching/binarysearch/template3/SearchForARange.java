package com.algo.ds.sorting_searching.binarysearch.template3;

public class SearchForARange {
    public static int[] searchRange(int[] arr, int target){
        if(arr == null || arr.length == 0) return new int[]{-1,-1};
        int start = findLowerBound(arr, target, 0, arr.length - 1);
        if(start == arr.length || arr[start] != target) return new int[]{-1,-1};
        return new int[]{start, findLowerBound(arr, target+1, start, arr.length) - 1};
    }

    private static int findLowerBound(int[] arr, int target, int low, int high){
        if(low == high) return low;
        int mid = low + (high-low)/2;
        if(arr[mid]<target) return findLowerBound(arr, target, mid+1, high);
        else return findLowerBound(arr, target, low, mid);
    }

//    public static void main(String[] args) {
//        int[] arr = searchRange(new int[]{7}, 7);
//        System.out.println(arr[0] + "," + arr[1]);
//    }
}
