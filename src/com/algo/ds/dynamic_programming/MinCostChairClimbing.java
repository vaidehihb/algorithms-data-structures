package com.algo.ds.dynamic_programming;

public class MinCostChairClimbing {
    // dp
    public static int minCostChairClimb(int[] cost){
        if(cost == null || cost.length == 0) return 0;
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<dp.length; i++){
            dp[i] = Math.min(cost[i-2]+dp[i-2], cost[i-1]+dp[i-1]);
        }

        return Math.min(cost[cost.length-2]+dp[dp.length-2], cost[cost.length-1]+dp[dp.length-1]);
    }

    // fibonacci
    public static int minCostChairClimb2(int[] cost){
        if(cost == null || cost.length == 0) return 0;
        int f1 = 0, f2 = 0;
        for (int i = 2; i < cost.length; i++){
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

}
