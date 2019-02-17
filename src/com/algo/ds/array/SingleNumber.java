package com.algo.ds.array;

public class SingleNumber {
    public static int singleNumber(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int first = nums[0];
        for(int i=1; i<nums.length; i++){
            first ^= nums[i];
        }
        return first;
    }
}
