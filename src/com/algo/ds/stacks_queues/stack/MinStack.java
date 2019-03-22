package com.algo.ds.stacks_queues.stack;

import java.util.Stack;

public class MinStack{
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x){
        if(stack.empty()){
            min = x;
            stack.push(x);
            System.out.println("Number inserted : " + x);
            return;
        }
        if(x < min){
            stack.push(2*x - min);
            min = x;
        }
        else stack.push(x);
        System.out.println("Number inserted : " + x);
    }

    public void pop(){
        if(stack.empty()){
            System.out.println("Empty stack");
            return;
        }
        System.out.print("Top element removed : ");
        int t = stack.pop();
        if(t < min){
            System.out.print(min);
            min = 2*min - t;
        }
        else System.out.print(t);
        System.out.println();
    }

    public void peek(){
        if(stack.empty()){
            System.out.println("stack empty");
        }
        Integer t = stack.peek();
        System.out.print("Top element : ");
        if (t < min)
            System.out.print(min);
        else System.out.print(t);
        System.out.println();
    }

    public boolean empty(){
        return stack.empty();
    }

    public void getMin(){
        if(stack.empty()) System.out.println("Empty stack");
        else System.out.println("Min element : " + min);
    }
}
