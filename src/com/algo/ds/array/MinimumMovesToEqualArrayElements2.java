package com.algo.ds.array;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements2 {
    public int minMoves2(int[] arr){
        if(arr == null || arr.length <= 1) return 0;
        Arrays.sort(arr);
        int moves = 0;
        int l = 0, r = arr.length - 1;
        while (l < r){
            moves += arr[r--] - arr[l++];
        }
        return moves;
    }
}
