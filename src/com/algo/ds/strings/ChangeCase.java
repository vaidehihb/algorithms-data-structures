package com.algo.ds.strings;

public class ChangeCase {
    public String changeCase(String s){
        if(s == null || s.length() == 0) return s;
        char[] arr = s.toCharArray();
        for (int i=0; i<arr.length; i++) {
            if(arr[i] >= 'a' && arr[i] <= 'z'){
                arr[i] += 'A' - 'a';
            }
            else if(arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] += 'a' - 'A';
            }
        }
        return new String(arr);
    }
}
