package com.algo.ds.sorting_searching.binarysearch.template1;

public class SumOfTwoSquares {
    public boolean isSquareSum(int n){
        if(n < 0) return false;
        if(n <= 1) return true;
        int left = 0;
        int right = (int) Math.sqrt(n);
        int sum = 0;
        while(left <= right){
            sum = left * left + right * right;
            if(sum == n) return true;
            else if(sum < n) left++;
            else right--;
        }
        return false;
    }
}
