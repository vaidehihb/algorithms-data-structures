package com.algo.ds.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero {
    public List<List<Integer>> threeSumZero(int[] nums){
        if(nums == null || nums.length < 3) return null;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i == 0 || (i>0 && nums[i] != nums[i-1])){
                int low = i+1, high = nums.length - 1, sum = 0-nums[i];
                while (low<high){
                    if(nums[low]+nums[high] == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low<high && nums[low] == nums[low+1]) low++;
                        while (low<high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] < sum) low++;
                    else high--;
                }
            }
        }
        return res;
    }
}
