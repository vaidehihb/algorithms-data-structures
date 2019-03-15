package com.algo.ds.array;

public class ProductOfArrayExceptItself {
    public int[] productExceptItself(int[] arr){
        if(arr == null || arr.length <= 1) return arr;
        int n = arr.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i<n; i++){
            res[i] = res[i-1] * arr[i-1];
        }
        int right = 1;
        for(int i=n-1; i>=0; i--){
            res[i] *= right;
            right *= arr[i];
        }
        return res;
    }
}
