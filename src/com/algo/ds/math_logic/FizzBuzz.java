package com.algo.ds.math_logic;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n){
        List<String> result = new ArrayList<>();
        int i3 = 3, i5 = 5;
        for(int i=1; i<=n; i++){
            i3--;
            i5--;
            if(i3 == 0 && i5 == 0) {
                i3 = 3;
                i5 = 5;
                result.add("FizzBuzz");
            }
            else if(i3 == 0){
                i3 = 3;
                result.add("Fizz");
            }
            else if(i5 == 0){
                i5 = 5;
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
