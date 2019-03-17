package com.algo.ds.strings;

public class UpperCase {
    public String toUpperCase(String s){
        if(s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        for (int i=0; i<arr.length; i++) {
            if(arr[i] >= 'a' && arr[i] <= 'z'){
                arr[i] += 'A' - 'a';
            }
        }
        return new String(arr);
    }
}
