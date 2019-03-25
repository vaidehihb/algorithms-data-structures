package com.algo.ds.strings;

public class Panagram {
    public boolean checkPanagram(String s){
        if(s == null || s.length() == 0) return false;
        boolean[] mark = new boolean[26];
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index) >= 'A' && s.charAt(index) <= 'Z')
                mark[s.charAt(index) - 'A'] = true;
            else if (s.charAt(index) >= 'a' && s.charAt(index) <= 'z')
                mark[s.charAt(index) - 'a'] = true;
            index++;
        }
        for (boolean b:mark){
            if(!b) return false;
        }
        return true;
    }
}
