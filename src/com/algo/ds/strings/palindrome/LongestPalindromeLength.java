package com.algo.ds.strings.palindrome;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromeLength {
    public static int longestPalindromeLength(String s){
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                count++;
                set.remove(s.charAt(i));
            }
            else {
                set.add(s.charAt(i));
            }
        }
        if(set.isEmpty()) return count*2;
        else return count*2+1;
    }

    public static int longestPalindromeLength2(String s){
        if(s == null || s.length() == 0) return 0;
        int[] count = new int[128];

        for(char c:s.toCharArray()){
            count[c]++;
        }

        int length = 0;
        boolean odd = false;

        for (int i=0; i<128; i++){
            if(count[i] % 2 == 1) odd = true;
            length += (count[i]/2)*2;
        }

        if(odd) return ++length;
        else return length;
    }
}
