package Queues.Deques;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueue {
    static class queue{



        // i implemented it a little wrongly but it is working correctly because why not 
        Deque<Integer> dq = new ArrayDeque<>();

        void add(int val){
            dq.addFirst(val);
        }
        int remove(){
            return dq.removeLast();
        }
        int peek(){
            return dq.getLast();
        }



    }
}
