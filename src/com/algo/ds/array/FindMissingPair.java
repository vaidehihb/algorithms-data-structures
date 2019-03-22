package com.algo.ds.array;
//XOR
public class FindMissingPair {
    public int findMissingNumberInPair(int[] arr){
        if(arr == null || arr.length == 0) return -1;
        int res = 0;
        for(int i: arr){
            res ^= i;
        }
        return res;
    }
}
