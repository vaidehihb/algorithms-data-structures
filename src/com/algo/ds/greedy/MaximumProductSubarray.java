package com.algo.ds.greedy;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums){
        if(nums.length == 0 || nums == null) return 1;
        if(nums.length == 1) return nums[0];
        int localMax = nums[0], localMin = nums[0], max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] < 0){
                int temp = localMax;
                localMax = localMin;
                localMin = temp;
            }
            localMax = Math.max(localMax*nums[i], nums[i]);
            localMin = Math.min(localMin*nums[i], nums[i]);
            max = Math.max(max, localMax);
        }
        return max;
    }
}
