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

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] arr = {1,2,3,4,5,6,7};
        r.rotateRight(arr, 3);
        for (int i:arr) System.out.println(i);
    }
}
