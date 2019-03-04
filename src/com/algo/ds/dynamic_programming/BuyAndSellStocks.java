package com.algo.ds.dynamic_programming;

public class BuyAndSellStocks {
    public static int maxProfit(int[] prices){
        if(prices == null || prices.length == 0) return 0;
        int maxProfit = 0, localProfit = 0;

        for(int i=0; i<prices.length-1; i++){
            localProfit = Math.max(0, localProfit+prices[i+1]-prices[i]);
            maxProfit = Math.max(localProfit, maxProfit);
        }
        return maxProfit;
    }
}
