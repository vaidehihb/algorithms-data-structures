package com.algo.ds.math_logic;

public class Fibonacci {
    public int fibonacci(int n){
        if(n <= 1) return n;
        int a = 0;
        int b = 1;
        for(int i=2; i<= n; i++){
            int c = a+b;
            a = b;
            b = c;
        }
        return b;
    }

}
