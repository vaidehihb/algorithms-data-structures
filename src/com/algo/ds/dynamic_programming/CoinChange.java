package com.algo.ds.dynamic_programming;

public class CoinChange {
    public int coinChange(int[] coins, int amount){
        if(coins == null || coins.length == 0) return -1;
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<=amount;i++) dp[i] = Integer.MAX_VALUE;
        for(int i=1; i<=amount; i++){
            for (int j=0; j<coins.length; j++){
                if(i >= coins[j]){
                    if(dp[i-coins[j]] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], (1+dp[i-coins[j]]));
                }
            }
        }
        if(dp[amount] != Integer.MAX_VALUE) return dp[amount];
        return -1;
    }
}
