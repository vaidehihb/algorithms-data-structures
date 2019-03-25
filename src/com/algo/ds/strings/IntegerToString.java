package com.algo.ds.strings;

public class IntegerToString {
    public String integerToString(int num){
        if(num == 0) return "Zero";
        String[] ones = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens1 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] hundred = {"Hundred"};
        String[] overHundred = {"", "Thousand", "Million", "Billion"};

        int[] digits = new int[12];
        int n = 0;
        while(num > 0){
            digits[n++] = num%10;
            num /= 10;
        }
        int groups = (n-1)/3 + 1;
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        for(int i=groups-1; i>=0; i--){
            for(int j=2; j>=0; j--){
                pos = i*3 + j;
                if(j == 2 && digits[pos] != 0){
                    sb.append(ones[digits[pos] - 1]);
                    sb.append(" ");
                    sb.append(hundred[0]);
                    sb.append(" ");
                }
                if(j == 1 && digits[pos] != 0){
                    if(digits[pos] == 1){
                        sb.append(tens1[digits[pos-1]]);
                        sb.append(" ");
                        break;
                    }
                    else{
                        sb.append(tens[digits[pos]-2]);
                        sb.append(" ");
                    }
                }
                if(j == 0 && digits[pos] != 0){
                    sb.append(ones[digits[pos]-1]);
                    sb.append(" ");
                }
            }
            if(digits[pos] + digits[pos+1] + digits[pos+2] != 0){
                sb.append(overHundred[i]);
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }
}
