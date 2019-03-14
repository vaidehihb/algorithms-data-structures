package com.algo.ds.sorting_searching.binarysearch.template2;

// two sum in sorted array, indices are not 0-based
public class TwoSumSortedArray {
    public int[] twoSum(int[] arr, int target){
        if(arr == null || arr.length <= 1) return null;
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) return new int[]{left+1, right+1};
            else if(sum < target) left++;
            else right--;
        }
        return null;
    }
}