package com.algo.ds.strings.anagrams;

public class MakeAnagram {
    public static int solution(String A, String C){
        int[] freq = new int[26];
        int edits = 0;
        for (char c:A.toLowerCase().toCharArray()){
            freq[c-'a']++;
        }
        for (char c:C.toLowerCase().toCharArray()){
            if(freq[c-'a'] > 0) freq[c-'a']--;
            else freq[c-'a']++;
        }
        for (int i:freq){
            edits += i;
        }
        return edits;
    }

    public static void main(String[] args) {
        System.out.println(solution("brain", "train"));
    }
}
