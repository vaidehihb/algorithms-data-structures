package com.algo.ds.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] arr, int target){
        if(arr == null || arr.length <= 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(target - arr[i])) return new int[] {i, map.get(target - arr[i])};
            else map.put(arr[i], i);
        }
        return null;
    }
}
