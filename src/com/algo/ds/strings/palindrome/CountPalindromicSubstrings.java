package com.algo.ds.strings.palindrome;

public class CountPalindromicSubstrings {
    private static int count = 0;
    public static int countPaindromicSubstring(String s){
        if(s.length() < 2) {
            return 1;
        }
        for(int i = 0; i<s.length(); i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return count;
    }

    private static void extendPalindrome(String s, int l, int h){
        while(l >= 0 && h <s.length() && s.charAt(l) == s.charAt(h)){
            l--;
            h++;
            count++;
        }
    }
}
