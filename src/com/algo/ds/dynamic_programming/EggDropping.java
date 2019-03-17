package com.algo.ds.dynamic_programming;

public class EggDropping {
    // very slow
    public int minimumEggDrops(int eggs, int floors){
        if(eggs == 1 || floors == 1 || floors == 0) return floors;
        int minimum = Integer.MAX_VALUE;
        for(int i=1; i<floors; i++){
            minimum = Math.min(minimum, 1+Math.max(minimumEggDrops(eggs-1, i-1), minimumEggDrops(eggs, floors-i)));
        }
        return minimum;
    }

    public int minimumEggDropsDP(int eggs, int floors){
        if(eggs == 1 || floors <= 1) return floors;
        int[][] drops = new int[eggs+1][floors+1];
        for(int i=0; i<=eggs; i++) {
            drops[i][0] = 0;
            drops[i][1] = 1;
        }
        for(int i=0; i<=floors; i++) {
            drops[1][i] = i;
            drops[0][i] = 0;
        }
        for(int i=2; i<=eggs; i++){
            for(int j=2; j<=floors; j++){
                drops[i][j] = Integer.MAX_VALUE;
                for(int k=1; k<=j; k++){
                    drops[i][j] = Math.min(drops[i][j], 1+Math.max(drops[i-1][k-1], drops[i][j-k]));
                }
            }
        }
        return drops[eggs][floors];
    }
}
