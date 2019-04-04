package com.algo.ds.array;
// remove duplicates from sorted array, return new length, and make all unique elements lie in the beginning
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int j = 0;
        for(int i=1; i<nums.length; i++)
            if(nums[i] != nums[j]) nums[++j] = nums[i];

        return ++j;
    }
}
