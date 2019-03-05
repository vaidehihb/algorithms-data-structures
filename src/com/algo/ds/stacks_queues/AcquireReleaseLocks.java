package com.algo.ds.stacks_queues;

import java.util.*;

public class AcquireReleaseLocks {
    static class Lock{
        String event;
        int num;

        public Lock(String event, int num) {
            this.event = event;
            this.num = num;
        }
    }

    public static int solution(List<String> events){
        Set<Integer> acquired = new HashSet<>();
        Stack<Lock> order = new Stack<>();
        for(String s:events){
            String[] event = s.split("\\s+");
            if(event[0].equals("ACQUIRE")) {
                if(acquired.contains(Integer.parseInt(event[1]))){
                    return Integer.parseInt(event[1]);
                }
                else{
                    order.push(new Lock(event[0], Integer.parseInt(event[1])));
                    acquired.add(Integer.parseInt(event[1]));
                }
            }
            else if(event[0].equals("RELEASE")){
                if(!acquired.contains(Integer.parseInt(event[1]))){
                    return Integer.parseInt(event[1]);
                }
                else{
                    Lock ev = order.pop();
                    if(!ev.event.equals("RELEASE") || ev.num != Integer.parseInt(event[1])){
                        return Integer.parseInt(event[1]);
                    }

                }
            }
        }
        return 0;
    }
}
