package com.algo.ds.strings.anagrams;

import java.util.*;

public class GroupAnagrams {
    //using Hashmap and Sort
    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs == null || strs.length == 0) return null;
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s:strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String newKey = new String(charArray);
            anagrams.putIfAbsent(newKey, new ArrayList<>());
            anagrams.get(newKey).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }
}
