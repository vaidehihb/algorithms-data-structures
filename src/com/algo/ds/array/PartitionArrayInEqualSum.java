package com.algo.ds.array;

public class PartitionArrayInEqualSum {
    public boolean canKPartsEqualSum(int[] A, int k){
        if(A == null || A.length == 0 || k == 0) return false;
        int sum = 0;
        for(int i:A){
            sum += i;
        }
        if(sum % k != 0) return false;
        int count = 0;
        int target = sum / k;
        int local = 0;
        for(int i=0; i<A.length; i++){
            local += A[i];
            if(local == target) {
                count++;
                local = 0;
            }
        }
        return count == k;
    }
}
