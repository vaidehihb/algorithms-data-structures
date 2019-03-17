package com.algo.ds.dynamic_programming;

public class Fibonacci {
    public int fib(int n){
        if(n <= 1) return n;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i=2; i<=n; i++){
            memo[i] = memo[i-1]+memo[i-2];
        }
        return memo[n];
    }

    public int fibo(int n){
        if(n <= 1) return n;
        int a = 0;
        int b = 1;
        for (int i=2; i<=n; i++){
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }
}
