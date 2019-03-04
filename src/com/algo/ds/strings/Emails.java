package com.algo.ds.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Emails {
    public static String solution(String S, String c){
        String[] names = S.split(";");
        Map<String, Integer> freq = new HashMap<>();
        List<String> strings = new LinkedList<>();
        for(String s:names){
            String s1 = s.trim();
            String[] nameArr = s1.split("\\s+");
            String email = nameArr[0].toLowerCase().replaceAll("\\-", "") + "_" + nameArr[nameArr.length - 1].toLowerCase().replaceAll("\\-", "") + "@" + c.toLowerCase() + ".com";
            if(freq.containsKey(email)){
                freq.put(email, freq.get(email)+1);
                email = nameArr[0].toLowerCase().replaceAll("\\-", "") + "_" + nameArr[nameArr.length - 1].toLowerCase().replaceAll("\\-", "") + freq.get(email) + "@" + c.toLowerCase() + ".com";
            }
            else {
                freq.put(email, 1);
            }
            strings.add(email);
        }
        return String.join(", ", strings);
    }


}
