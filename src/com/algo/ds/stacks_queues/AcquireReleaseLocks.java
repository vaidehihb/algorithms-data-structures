package com.algo.ds.stacks_queues;

import java.util.*;

// return 0 if no violation, N+1 if dangling locks, case index number if release not acquired locks, acquire already acquired locks or mess up order
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
        for(int i=0; i<events.size(); i++){
            String[] event = events.get(i).split("\\s+");
            if(event[0].equals("ACQUIRE")) {
                if(acquired.contains(Integer.parseInt(event[1]))){
                    return i+1;
                }
                else{
                    order.push(new Lock(event[0], Integer.parseInt(event[1])));
                    acquired.add(Integer.parseInt(event[1]));
                }
            }
            else if(event[0].equals("RELEASE")){
                if(!acquired.contains(Integer.parseInt(event[1]))){
                    return i+1;
                }
                else{
                    Lock ev = order.pop();
                    if(!ev.event.equals("ACQUIRE") || ev.num != Integer.parseInt(event[1])){
                        return i+1;
                    }
                    else if(ev.event.equals("ACQUIRE") && ev.num == Integer.parseInt(event[1])){
                        acquired.remove(Integer.parseInt(event[1]));
                    }
                }
            }
        }
        if(!acquired.isEmpty() || !order.empty()) return events.size() + 1;
        return 0;
    }
}
