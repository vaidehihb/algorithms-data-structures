package com.algo.ds.array;

import java.util.Arrays;

public class MaximumAbsoluteDifference {
    public int maxAbsoluteDiff(int[] arr){
        int maxDiff = 0;
        if(arr == null || arr.length <= 1) return maxDiff;
        Arrays.sort(arr);
        int[] newArr = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int i = -1;
        while (left <= right){
            newArr[++i] = arr[left++];
            newArr[++i] = arr[right--];
        }
        for(int j=0; j<newArr.length-1; j++){
            maxDiff += Math.abs(newArr[j+1] - newArr[j]);
        }
        maxDiff += Math.abs(newArr[newArr.length - 1] - newArr[0]);
        return maxDiff;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
