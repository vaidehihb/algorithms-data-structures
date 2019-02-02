package com.algo.ds.strings.palindrome;

public class MakeValidPalindrome {
    public static boolean makeValidPalindrome(String s){
        if(s==null || s.trim().length() <= 1) return true;
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return isValidPalindrome(s, start, end - 1) || isValidPalindrome(s, start+1, end);
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isValidPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
