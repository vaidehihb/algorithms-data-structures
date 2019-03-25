package com.algo.ds.strings;

import com.algo.ds.math_logic.ReverseAndAdd;

public class ReverseOrderOfWords {
    public String reverseOrder(String s){
        if(s == null || s.length() == 0) return s;
        int index = s.length() - 1;
        int start = index + 1, end = index + 1;
        StringBuilder sb = new StringBuilder();
        while(index >= 0){
            if(s.charAt(index) == ' '){
                start = index + 1;
                while (start != end) sb.append(s.charAt(start++));
                sb.append(" ");
                end = index;
            }
            index--;
        }
        start = 0;
        while (start != end) sb.append(s.charAt(start++));

        return sb.toString().trim();
    }
}
