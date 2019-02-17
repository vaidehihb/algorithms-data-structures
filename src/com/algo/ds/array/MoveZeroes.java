package com.algo.ds.array;

public class MoveZeroes {
    public static void moveZeroes(int[] nums){
        if(nums == null || nums.length == 0) return;
        int insertIndex = 0;
        for (int i:nums){
            if(i != 0) nums[insertIndex++] = i;
        }

        while (insertIndex < nums.length){
            nums[insertIndex++] = 0;
        }
    }

    public static void moveZeroes2(int[] nums){
        if(nums == null || nums.length == 0) return;
        int insertIndex = 0;
        for (int i=0; i<nums.length; i++){
            if(nums[i] != 0) {
                int temp = nums[insertIndex];
                nums[insertIndex++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
