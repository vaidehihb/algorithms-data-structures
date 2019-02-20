package com.algo.ds.dynamic_programming;

public class ArithmeticSlices {
    public static int numberOfArithmeticslices(int[] nums){
        int count = 0, sum = 0;
        for(int i=2; i<nums.length; i++){
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]){
                sum += ++count;
            }
            else count = 0;
        }
        return sum;
    }
}
