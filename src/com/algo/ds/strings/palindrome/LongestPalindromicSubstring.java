package com.algo.ds.strings.palindrome;

public class LongestPalindromicSubstring {
    private static int low, high, maxLength;

    public static String longestPaindromicSubstring(String s){
        low = 0;
        maxLength = 0;
        if(s.length() < 2) {
            return s;
        }
        for(int i = 0; i<s.length(); i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(low, low + maxLength);
    }

    private static void extendPalindrome(String s, int l, int h){
        while(l >= 0 && h <s.length() && s.charAt(l) == s.charAt(h)){
            l--;
            h++;
        }

        if(maxLength < h-l-1){
            low = l+1;
            maxLength = h-l-1;
        }
    }
}
