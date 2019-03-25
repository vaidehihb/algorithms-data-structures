package com.algo.ds.math_logic;

/* take number as string, reverse  it and add to original and check if it's palindrome.
* If not, repeat till # of iterations are 1000,
* or resulting number is greater than 4,294,967,295
*/
public class ReverseAndAdd {
    public long reverseAndAdd(String s){
        if(s == null || s.length() == 0) return Long.MIN_VALUE;
        long num = Long.parseLong(s);
        int count = 0;
        while (num <= 4294967295L && count <= 1000){
            count++;
            long reversed = reverse(num);
            num += reversed;
            if(isPalindrome(num)) return num;
        }
        return -1L;
    }

    private boolean isPalindrome(long num){
        return reverse(num) == num;
    }

    private long reverse(long num){
        long reversed = 0L;
        while (num > 0){
            reversed = reversed * 10 + num % 10;
            num = num/10;
        }
        return reversed;
    }
}
