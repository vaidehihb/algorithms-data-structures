package com.algo.ds.strings.substrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KLengthSubstringWithOneRepeatingChar {
    public List<String> getKLengthSubstringsWithOnrRepeatedChar(String s, int k){
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0 || k>s.length() || k<1) return res;
        Set<String> subStrings = new HashSet<>();
        for(int i=0; i<=s.length()-k;i++){
            subStrings.add(s.substring(i,i+k));
        }
        for (String a: subStrings) {
            if(containsOneRepeatedChar(a)) res.add(a);
        }

        return res;
    }

    private boolean containsOneRepeatedChar(String s){
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        int count = 0;
        int count2 = 0;
        for(int i:freq){
            if(i == 2) count++;
            if(i > 2) count2++;
        }
        return count == 1 && count2 == 0;
    }
}
