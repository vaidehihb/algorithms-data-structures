package com.algo.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInteger(String s){
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] charArray = s.toCharArray();
        int total = map.get(charArray[0]);
        int pre = map.get(charArray[0]);
        for(int i=1; i<charArray.length; i++){
            int curr = map.get(charArray[i]);
            if(curr <= pre) total += curr;
            else total = total + curr - 2 * pre;
            pre = curr;
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
