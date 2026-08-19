package Graphs.MST;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class LC1168 {

    public static void main(String[] args) {

    }


    // self done 99%


    static class Edge {
        int src, dest, wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node, dist;

        Pair(int n, int d) {
            node = n;
            dist = d;
        }


        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.dist, p.dist);
        }
    }


    public static int optimizedWaterDistribution(int n,int [] wells, int [][] pipes){

        ArrayList<Edge>[] graph = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < pipes.length; i++) {

            int u = pipes[i][0];
            int v = pipes[i][1];
            int w = pipes[i][2];

            graph[u].add(new Edge(u,v,w));
            graph[v].add(new Edge(v,u,w));
        }

        for (int i = 1; i <= wells.length; i++) {  // 1% fogot, didnt put =
            graph[0].add(new Edge(0,i,wells[i-1]));
            graph[i].add(new Edge(i,0,wells[i-1]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.add(new Pair(0,0));

        int minCost = 0;
        boolean[] vis = new boolean[n+1];

        while (!q.isEmpty()){

            Pair curr = q.poll();

            if(vis[curr.node]) continue;
            vis[curr.node] = true;
            minCost+= curr.dist;


            for (Edge e : graph[curr.node]){

                if(!vis[e.dest]){
                    q.add(new Pair(e.dest,e.wt));
                }

            }


        }

        return minCost;

    }


}
