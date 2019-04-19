package com.algo.ds.strings;

public class CountAndSay {
    public String countAndSay(int n){
        String s = "1";
        for(int i=1; i<n; i++){
            s = countIndex(s);
        }
        return s;
    }

    private String countIndex(String s){
        int count = 1;
        char c = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == c) count++;
            else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}
