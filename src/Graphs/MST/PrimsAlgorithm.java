package Graphs.MST;

import java.util.ArrayList;
import java.util.PriorityQueue;

import java.util.*;

public class PrimsAlgorithm {

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

        public int compareTo(Pair p) {
            return Integer.compare(this.dist, p.dist);
        }
    }

    public static int prims(ArrayList<Edge>[] graph, int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int minCost = 0;
        boolean[] vis = new boolean[V];

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (vis[curr.node]) continue;
            vis[curr.node] = true;

            minCost+= curr.dist;
            for(Edge e : graph[curr.node]){

                if(!vis[e.dest]){
                    pq.add(new Pair(e.dest, e.wt));
                }
            }


        }

        return minCost;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Graph:
        // 0 → 1 (2)
        // 0 → 2 (4)
        // 1 → 2 (1)
        // 1 → 3 (7)
        // 2 → 4 (3)
        // 3 → 4 (1)

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 4, 1));

        int src = 0;
    }
}