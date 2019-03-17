package com.algo.ds.strings;

import java.util.HashSet;
import java.util.Set;

public class FindStringDuplicates {
    public boolean findDuplicateCharacters(String s){
        if(s == null || s.length() <= 1) return false;
        Set<Character> chars = new HashSet<>();
        for (char c:s.toCharArray()) {
            if(chars.contains(c)) return true;
            chars.add(c);
        }
        return false;
    }

    public boolean findDuplicates(String s){
        if(s == null || s.length() <= 1) return false;
        boolean[] arr = new boolean[256];
        for (char c: s.toCharArray()) {
            if(arr[c]) return true;
            arr[c] = true;
        }
        return false;
    }
}
