package com.algo.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInteger(String s){
        if(s == null || s.length() == 0) return 0;
        int[] charMap = new int[91];
        charMap['I'] =  1;
        charMap['V'] = 5;
        charMap['X'] = 10;
        charMap['L'] = 50;
        charMap['C'] = 100;
        charMap['D'] = 500;
        charMap['M'] = 1000;
        char[] charArray = s.toCharArray();
        int total = 0;
        int next = 0;
        for(int i=s.length() - 1; i>=0; i--){
            int curr = charMap[s.charAt(i)];
            if(curr >= next){
                total += curr;
                next = curr;
            }
            else{
                total -= curr;
            }
        }
        return total;
    }

    public static int romanToInt(String s) {
        int num = 0;
        int n = s.length();

        for (int i = 0; i < n-1; i++) {
            int curr = map(s.charAt(i));
            int next = map(s.charAt(i+1));
            num = curr < next ? num - curr : num + curr;
        }

        num += map(s.charAt(n-1));

        return num;
    }

    private static int map(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
