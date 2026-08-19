package PriorityQueues;

import java.util.PriorityQueue;

public class QConnectNRopes {
    public static void main(String[] args) {

        int [] ropes = {2,3,3,4,6};

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++) {
            q.add(ropes[i]);
        }

        int cost = 0;
        while (q.size() > 1){
            int min = q.remove();
            int min2 = q.remove();
            cost+= min + min2;
            q.add(min + min2);
        }

        System.out.println(cost);
    }

}
