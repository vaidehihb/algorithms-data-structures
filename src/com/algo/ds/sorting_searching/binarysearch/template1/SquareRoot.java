package com.algo.ds.sorting_searching.binarysearch.template1;

public class SquareRoot {
    public static int sqrt(int x){
        if(x <= 0) return x;
        if(x == 1) return 1;
        int start = 1;
        int end = x;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(x/mid == mid) return mid;
            else if(x/mid > mid) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }
}
