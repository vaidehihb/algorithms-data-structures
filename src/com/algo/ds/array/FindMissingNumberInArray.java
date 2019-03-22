package com.algo.ds.array;

// array numbers are in range 1 to n
public class FindMissingNumberInArray {
    public int findMissingNumber(int[] arr, int k){
        int num = 0;
        for(int i = 1; i<=k; i++){
            num ^= i;
        }
        for(int i=0; i<arr.length; i++){
            num ^= arr[i];
        }
        return num;
    }

    public int findMissingNumberUsingAddition(int[] arr, int k){
        int sum = (k*(k+1))/2;
        for(int i: arr){
            sum -= i;
        }
        return sum;
    }
}
