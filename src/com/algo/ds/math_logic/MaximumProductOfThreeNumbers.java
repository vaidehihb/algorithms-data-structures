package com.algo.ds.math_logic;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums){
        if(nums == null || nums.length < 3) return 0;
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > thirdMax){
                if(nums[i] > secondMax){
                    if(nums[i] > max){
                        thirdMax = secondMax;
                        secondMax = max;
                        max = nums[i];
                    }
                    else{
                        thirdMax = secondMax;
                        secondMax = nums[i];
                    }
                }
                else{
                    thirdMax = nums[i];
                }
            }

            if(nums[i] < secondMin){
                if(nums[i] < min){
                    secondMin = min;
                    min = nums[i];
                }
                else secondMin = nums[i];
            }
        }

        return Math.max(max * secondMax * thirdMax, max * min * secondMin);
    }
}
