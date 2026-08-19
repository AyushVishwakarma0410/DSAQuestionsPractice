package Graphs.DijkstraQuestionSet;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lc743 {
    public static void main(String[] args) {

        int [][] times = {{2,1,1},{2,3,1},{3,4,1}};

        int n = 4;
        int k = 2;


        System.out.println(networkDelayTime(times,n,k));
    }




     static class Pair implements Comparable<Pair>{
        int node;
        int dest;

        Pair(int n, int d){
            node = n;
            dest = d;
        }

        @Override
         public int compareTo(Pair p){
            return Integer.compare(this.dest,p.dest);
        }

    }

    public static int networkDelayTime(int[][] times, int n, int k) {


        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int [] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dist[k] = 0;

        boolean[] vis = new boolean[n+1];

        pq.add(new Pair(k,0));

        while (!pq.isEmpty()){

            Pair curr = pq.poll();

            if(vis[curr.node]){
                continue;
            }
            vis[curr.node] = true;

            for (int [] edge : times ){
                int src = edge[0];
                int dest = edge[1];
                int wt = edge[2];

                if(dist[src]+wt < dist[dest]) {
                    dist[dest] = dist[src] + wt;
                    pq.add(new Pair(dest, dist[dest]));
                }
            }




        }

        int time = 0;
        for (int i = 0; i < dist.length; i++) {
            time = Math.max(time,dist[i]);
        }

        return time;
    }

}
