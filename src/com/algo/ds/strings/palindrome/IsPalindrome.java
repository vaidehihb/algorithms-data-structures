package com.algo.ds.strings.palindrome;

public class IsPalindrome {
    public static boolean isPalindrome(String s){
        if(s == null || s.length() == 0 || s.trim().length() <= 1) return true;

        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }

        return true;
    }
}
