package com.algo.ds.sorting_searching.binarysearch.template2;

public class findPeakElement {
    public static int findPeakElement(int[] arr){
        if(arr == null || arr.length == 0) return -1;
        return helper(arr, 0, arr.length-1);
    }

    private static int helper(int[] arr, int start, int end){
        if(start == end) return start;
        int mid = start + (end-start)/2;
        if(arr[mid] > arr[mid + 1]) return helper(arr,0, mid);
        else return helper(arr, mid+1, end);
    }

//    public static void main(String[] args) {
//        System.out.println(findPeakElement(new int[]{1,2,3,4,2,1,5,3}));
//    }
}
