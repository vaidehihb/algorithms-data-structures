package com.algo.ds.dynamic_programming;

public class ClimbingStairsMemoization {
    public static int climbStairsWithMemoization(int n){
        int[] memo = new int[n+1];
        return helper(memo, 0, n);
    }

    public static int helper(int[] memo, int i, int n){
        if(i > n) return 0;
        if(i == n) return 1;
        if(memo[i] > 0) return memo[i];
        memo[i] = helper(memo, i+1, n) + helper(memo, i+2, n);
        return memo[i];
    }
}
