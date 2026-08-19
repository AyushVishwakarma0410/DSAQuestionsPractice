package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class LC346 {

        // self done, no help
    static class MovingAverage {
        Queue<Integer> q = new LinkedList<>();
        int size;

        MovingAverage(int size) {
            this.size = size;
        }

        double lastSum = 0;

        double next(int val) {

            if(size ==0){
                return 0;
            }
            // Add new values
            q.add(val);

            // if size becomes greater
            if(!q.isEmpty() && q.size() > size){
                lastSum-= q.poll();
            }

            // calculate sum
            lastSum += val;

            //calculate avg
            return lastSum/q.size();

        }

    }


    public static void main(String[] args) {
        MovingAverage mvg = new MovingAverage(3);
        System.out.println(mvg.next(1));
        System.out.println(mvg.next(10));
        System.out.println(mvg.next(3));
        System.out.println(mvg.next(5));
//        System.out.println(mvg.next(1));

    }
}