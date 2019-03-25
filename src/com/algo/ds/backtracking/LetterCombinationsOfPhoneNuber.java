package com.algo.ds.backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfPhoneNuber {
    public List<String> letterCombinations(String digits){
        LinkedList<String> ans = new LinkedList<>();
        if(digits == null || digits.length() == 0) return ans;
        ans.add("");
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i=0; i<digits.length(); i++){
            int x = digits.charAt(i) - '0';
            while(ans.peek().length() == i){
                String t = ans.remove();
                for(char s:map[x].toCharArray()) ans.add(t+s);
            }
        }
        return ans;
    }
}
