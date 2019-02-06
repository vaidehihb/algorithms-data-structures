package com.algo.ds.recursion.strings;

public class ReverseString {
    public static char[] reverseString(char[] s) {
        if(s.length <= 1){
            return s;
        }
        helper(s, 0, s.length - 1);
        return s;
    }

    public static void helper(char[] s, int start, int end){
        if(start >= end) return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper(s, ++start, --end);
    }
}
