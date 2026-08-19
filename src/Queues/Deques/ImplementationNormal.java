package Queues.Deques;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementationNormal {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        dq.add(2);
        System.out.println(dq);
        dq.remove();
        System.out.println(dq);

    }
}
