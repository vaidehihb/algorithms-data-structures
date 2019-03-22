package com.algo.ds.design;

import java.util.Stack;

public class MaxStack{
    private Stack<Integer> stack;
    private int max;

    public MaxStack(){
        stack = new Stack<>();
        max = Integer.MIN_VALUE;
    }

    public Integer getMax(){
        if(stack.isEmpty()) return null;
        return max;
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(int val){
        if(stack.isEmpty()){
            max = val;
            stack.push(Integer.valueOf(val));
            return;
        }
        if(val <= max) stack.push(Integer.valueOf(val));
        else{
            stack.push(Integer.valueOf(2*val - max));
            max = val;
        }
    }

    public Integer pop(){
        if(stack.empty()){
            System.out.println("Empty stack");
            return null;
        }
        else{
            Integer t = stack.pop();
            if(t >= Integer.valueOf(max)){
                Integer prevMax = Integer.valueOf(max);
                max = 2*max - (int)t;
                return prevMax;
            }
            else return t;
        }
    }

    public Integer peek(){
        if(stack.empty()){
            System.out.println("Empty stack");
            return null;
        }
        Integer t = stack.peek();
        if((int)t > max) return Integer.valueOf(max);
        return t;
    }
}
