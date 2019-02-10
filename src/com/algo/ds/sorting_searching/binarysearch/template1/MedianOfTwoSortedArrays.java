package com.algo.ds.sorting_searching.binarysearch.template1;

public class MedianOfTwoSortedArrays {
    public static double findMedianOfTwoSortedArrays(int[] arr1, int[] arr2){
        if(arr1.length > arr2.length) return findMedianOfTwoSortedArrays(arr2, arr1);
        int l1 = arr1.length;
        int l2 = arr2.length;

        int start = 0;
        int end = l1;
        while(start <= end){
            int pivot1 = (start + end)/2;
            int pivot2 = ((l1+l2+1)/2) - pivot1;

            int maxLeft1 = getPartitionMaxIndex(arr1, pivot1);
            int minRight1 = getPartitionMinIndex(arr1, pivot1);

            int maxLeft2 = getPartitionMaxIndex(arr2, pivot2);
            int minRight2 = getPartitionMinIndex(arr2, pivot2);

            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if((l1 + l2) % 2 == 0){
                    return (double) ((Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))/2);
                }
                else{
                    return (double) Math.max(maxLeft1, maxLeft2);
                }
            }else if(maxLeft1 > minRight2){
                end = pivot1 - 1;
            }
            else{
                start = pivot1 + 1;
            }

        }
        throw new IllegalArgumentException();
    }

    private static int getPartitionMinIndex(int[] arr, int pivot) {
        return (pivot == arr.length) ? Integer.MAX_VALUE : arr[pivot];
    }

    private static int getPartitionMaxIndex(int[] arr, int pivot) {
        return (pivot == 0) ? Integer.MIN_VALUE : arr[pivot-1];
    }

}
