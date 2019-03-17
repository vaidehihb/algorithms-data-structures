package com.algo.ds.strings;

public class LowerCase {
    public String toLowerCase(String s){
        if(s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        for (int i=0; i<arr.length; i++) {
            if(arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] += 'a' - 'A';
            }
        }
        return new String(arr);
    }
}
