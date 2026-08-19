package Queues.Deques;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackUsingDeque {
    public static void main(String[] args) {

    }
    static class stack{
        Deque<Integer> dq = new ArrayDeque<>();

        void add(int val){
            dq.addLast(val);
        }
        int remove(){
           return dq.removeLast();
        }
        int peek(){
           return dq.getLast();
        }

    }

}
