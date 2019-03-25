package com.algo.ds.strings;

public class AToI {
    public int atoi(String str){
        if(str == null || str.length() == 0) return 0;
        char[] s = str.trim().toCharArray();
        int res = 0;
        int sign = 1;
        for(int i=0; i<s.length; i++){
            if(i==0){
                if(s[i] == '-') sign = -1;
                else if(s[i] == '+') continue;
                else if(s[i] >= '0' && s[i] <= '9') res = res*10 + (s[i] - '0');
                else break;
            }
            else {
                if(s[i] >= '0' && s[i] <= '9'){
                    if(res >= Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && (s[i] - '0') > 7)) return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    else res = res*10 + (s[i] - '0');
                }
                else break;
            }
        }
        return sign * res;
    }
}
