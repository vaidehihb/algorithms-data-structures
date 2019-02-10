package com.algo.ds.sorting_searching.binarysearch.template2;

public class FirstBadVersion {
    private static int badVersion;

    static {
        badVersion = 6;
    }

    public static int getBadVersion(){
        return FirstBadVersion.badVersion;
    }

    public static int firstBadVersion(int n){
        return versionHelper(1,n);
    }

    public static int versionHelper(int start, int end){
        while(start < end){
            int mid = start + (end-start)/2;
            if(!isBadVersion(mid)){
                start = mid+1;
            }
            else end = mid;
        }
        return start;
    }

    public static boolean isBadVersion(int number){
        return (number >= getBadVersion());
    }

}
