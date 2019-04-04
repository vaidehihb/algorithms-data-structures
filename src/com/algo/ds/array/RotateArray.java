package com.algo.ds.array;

public class RotateArray {
    public void rotateLeft(int[] nums, int k){
        if(nums == null || nums.length < 2) return;
        int step = k%nums.length;
        reverse(nums,0,step-1);
        reverse(nums,step,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    public void rotateRight(int[] nums, int k){
        if(nums == null || nums.length < 2) return;
        int step = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,step-1);
        reverse(nums,step,nums.length-1);
    }

    private void reverse(int[] nums, int l, int r){
        while (l<r){
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}
