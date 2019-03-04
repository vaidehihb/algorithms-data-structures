package com.algo.ds.array;

public class MaximumSubArraySum {
    public static int maxSubarraySum(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        int local = arr[0], max = arr[0];
        for(int i=1; i<arr.length; i++){
            local = Math.max(arr[i], local+arr[i]);
            max = Math.max(local, max);
        }
        return max;
    }

    public static int maxSubarraySumDivideAndConquer(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        return maxSubarraySum(arr, 0, arr.length - 1);
    }

    private static int maxSubarraySum(int[] arr, int l, int r){
        if(l == r) return arr[l];
        int m = l+(r-l)/2;
        return Math.max(Math.max(maxSubarraySum(arr, l, m), maxSubarraySum(arr, m+1, r)), maxCrossingSum(arr, l, m, r));
    }

    private static int maxCrossingSum(int[] arr, int l, int m, int r){
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i=m; i>=l; i--){
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i=m+1; i<=r; i++){
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
