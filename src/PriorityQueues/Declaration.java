package PriorityQueues;

import java.util.Collections;
import java.util.PriorityQueue;

public class Declaration {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        q.add(5);
        q.add(4);
        q.add(3);
        q.add(2);

        // by default asc order
        while (!q.isEmpty()){
            System.out.println(q.remove());
        }




        // for reverse logic
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        p.add(1);
        p.add(5);
        p.add(4);
        p.add(3);
        p.add(2);

        while (!p.isEmpty()){
            System.out.println(p.remove());
        }

    }
}
