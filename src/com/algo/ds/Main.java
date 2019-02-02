package com.algo.ds;


import com.algo.ds.strings.palindrome.CountPalindromicSubstrings;
import com.algo.ds.strings.palindrome.IsPalindrome;
import com.algo.ds.strings.palindrome.LongestPalindromicSubstring;
import com.algo.ds.strings.palindrome.MakeValidPalindrome;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(IsPalindrome.isPalindrome(""));
        System.out.println(MakeValidPalindrome.makeValidPalindrome("abacaab"));
        System.out.println(CountPalindromicSubstrings.countPaindromicSubstring("aaa"));
        System.out.println(LongestPalindromicSubstring.longestPaindromicSubstring("c"));
    }
}