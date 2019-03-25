package com.algo.ds.dynamic_programming;

import java.util.Arrays;

// number of ways
public class CoinChange2 {
    public int change(int[] coins, int amount){
        if(amount == 0) return 1;
        if(coins == null || coins.length == 0) return 0;
        int[] ways = new int[amount + 1];
        ways[0] = 1;
        for(int coin:coins) {
            for (int i=coin; i<= amount; i++) ways[i] += ways[i-coin];
        }
        return ways[amount];
    }
}
