package com.algo.ds.strings.palindrome;

public class ReverseString {
    public static String reverseString(String s){
//      return reverseString(s, 0, s.length() - 1);
        char[] charArray = s.toCharArray();
        reverseString(charArray, 0, s.length() - 1);
        return new String(charArray);
    }

    //iterative
    public static String reverseString(String s, int start, int end){
        if(s == null || s.length() <= 1) return s;
        char[] charArray = s.toCharArray();
        while(start < end){
            char temp = charArray[start];
            charArray[start++] = charArray[end];
            charArray[end--] = temp;
        }
        return new String(charArray);
    }

    //recursive
    public static void reverseString(char[] s, int start, int end){
        if(start >= end) return;

        char temp = s[start];
        s[start++] = s[end];
        s[end--] = temp;

        reverseString(s, start, end);
    }

}
