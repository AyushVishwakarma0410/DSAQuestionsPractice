package PriorityQueues;

import java.util.Collections;
import java.util.PriorityQueue;

public class QSlidingWindowMaximum {
    public static void main(String[] args) {


        int[] arr = {1, 3, -1, -3, 5};

        PriorityQueue<Pair> p = new PriorityQueue<>();
        int k = 3;
        int [] res = new int[arr.length-k+1];

        // Window 1
        for (int i = 0; i < k ; i++) {
            p.add(new Pair(arr[i],i));
        }

        res[0] = p.peek().num;

        for (int i = k; i < arr.length ; i++) {
            while (!p.isEmpty() && p.peek().idx <= (i-k)){
                p.poll();
            }
            p.add(new Pair(arr[i],i));
            res[i-k+1] = p.peek().num;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]+ " ");
        }

    }




    static class Pair implements Comparable<Pair>{
        int num;
        int idx;
        Pair(int num, int idx){
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2){
            return Integer.compare(p2.num, this.num); // max-heap behavior
        }
    }









    // worked but little inefficient
//    public static int[] slidingWindowMax(int [] arr,int k){
//        if(arr.length==0){
//            return null;
//        }
//        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (int i = 0; i < k; i++) {
//            q.add(arr[i]);
//        }
//
//        int [] ans = new int[arr.length-k+1];
//
//        ans[0] = q.peek();
//        for (int i = k; i < arr.length;i++){
//            q.remove(arr[i-k]);
//            q.add(arr[i]);
//            ans[i-k+1] = q.peek();
//        }
//
//        return ans;
//    }
}
