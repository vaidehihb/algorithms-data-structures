package com.algo.ds.bit_manipulation;

public class SumOfTwoIntegers {
    // sum without using '+' or '-'
    public static int sumOfTwoIntegers(int a, int b){
        return b == 0 ? a : sumOfTwoIntegers(a^b, (a&b) << 1);
    }
}
