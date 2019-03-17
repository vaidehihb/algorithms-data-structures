package com.algo.ds.array;

public class SegregateEvenOddNumbers {
    public void segregateEvenOddNumbers(int[] arr){
        if(arr == null || arr.length <= 1) return;

        int j = -1;
        for(int i=0; i<arr.length; i++){
            if((arr[i] & 1) == 0) {
                j++;
                swap(arr, i, j);
            }
        }
    }

    public void segregateEvenOdd(int[] arr){
        if(arr == null || arr.length <= 1) return;

        int left = 0, right = arr.length - 1;
        while (left < right){
            while(arr[left] % 2 == 0 && left < arr.length) left++;
            while(arr[right] % 2 == 1 && right >= 0) right--;
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
