package com.algo.ds.sorting_searching.binarysearch.template2;

public class FindMinInRotatedArray {
    public static int findMinInRotatedArray(int[] arr){
        if(arr == null || arr.length == 0) return -1;
        return helper(arr, 0, arr.length - 1);
    }

    private static int helper(int[] arr, int start, int end){
        if(start == end) return arr[start];
        int mid = start + (end - start)/2;
        if(arr[mid] > arr[mid+1]) return arr[mid+1];
        else{
            if(arr[mid] < arr[end]) return helper(arr, start, mid);
            else return helper(arr, mid+1, end);
        }
    }

//    public static void main(String[] args) {
//        System.out.println(findMinInRotatedArray(new int[]{1,2}));
//    }

}
