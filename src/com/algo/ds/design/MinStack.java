package com.algo.ds.design;

import java.util.Stack;

public class MinStack{
    private Stack<Integer> stack;
    private int min;

    public MinStack(){
        stack = new Stack<>();
    }

    public int getMin(){
        return min;
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(int val){
        if(stack.empty()){
            min = val;
            stack.push(Integer.valueOf(val));
            return;
        }
        if(val >= min) stack.push(Integer.valueOf(val));
        else{
            stack.push(Integer.valueOf(2*val - min));
            min = val;
        }
    }

    public Integer pop(){
        if(stack.empty()){
            System.out.println("Empty stack");
            return null;
        }
        else{
            Integer t = stack.pop();
            if(t < Integer.valueOf(min)){
                Integer prevMin = Integer.valueOf(min);
                min = 2*min - (int)t;
                return prevMin;
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
        if((int)t < min) return Integer.valueOf(min);
        return t;
    }
}
