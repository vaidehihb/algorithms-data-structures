package com.algo.ds.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import com.algo.ds.sorting_searching.binarysearch.template1.*;

public class ArrayIntersection {
    // Using Hashset
    public static int[] findIntersection(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0) return nums1;
        if(nums2 == null || nums2.length == 0) return nums2;
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int i: nums1){
            set.add(i);
        }

        for (int i:nums2){
            if(set.contains(i)){
                intersection.add(i);
            }
        }

        int[] result = new int[intersection.size()];
        int j = 0;
        for(int i:intersection){
            result[j++] = i;
        }
        return result;
    }

    // using sorting and two pointers
    public static int[] findIntersection1(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0) return nums1;
        if(nums2 == null || nums2.length == 0) return nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        Set<Integer> intersection = new HashSet<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else {
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[intersection.size()];
        i = 0;
        for(int k : intersection){
            result[i++] = k;
        }
        return result;
    }

    // using sort and binary search
    public static int[] findIntersection2(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0) return nums1;
        if(nums2 == null || nums2.length == 0) return nums2;
        if(nums2.length > nums1.length) return findIntersection2(nums2, nums1);
        Set<Integer> intersection = new HashSet<>();

        Arrays.sort(nums2);
        for(int num: nums1)
            if(BinarySearch.binarySearch(nums2, num) > -1) intersection.add(num);

        int[] result = new int[intersection.size()];
        int j = 0;
        for (int i: intersection) {
            result[j++] = i;
        }
        return result;
    }

    //using boolean array
    public static int[] findIntersection3(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0) return nums1;
        if(nums2 == null || nums2.length == 0) return nums2;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i: nums1){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        boolean[] exists = new boolean[max-min+1];

        for(int i:nums1){
            exists[i-min] = true;
        }

        int[] reault = new int[nums2.length];
        int idx = 0;

        for (int i: nums2){
            if(i >= min && i <= max && exists[i-min]) {
                reault[idx++] = i;
                exists[i-min] = false;
            }
        }

        return Arrays.copyOf(reault, idx);

    }

    public static void main(String[] args) {
        int[] res = findIntersection3(new int[]{5,6,6,7,8,8,9}, new int[]{5,6,9});
        for (int i:res)
            System.out.println(i);
    }
}
