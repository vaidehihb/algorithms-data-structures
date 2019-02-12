package com.algo.ds.sorting_searching.binarysearch.template3;

public class BinarySearch3 {
    public static int binarysearch3(int[] arr, int target){
        if(arr == null || arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        while(start+1 < end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) start = mid;
            else end = mid;
        }

        if(arr[start] == target) return start;
        if(arr[end] == target) return end;
        return -1;
    }

//    public static void main(String[] args) {
//        System.out.println(binarysearch3(new int[]{1,2,3,4,5,6}, 5));
//    }
}
