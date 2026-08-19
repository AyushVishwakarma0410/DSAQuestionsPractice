package Graphs.DijkstraQuestionSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


// REDO
public class LC2203 {
    public static void main(String[] args) {

    }

    public static long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {

        long max = Long.MAX_VALUE;
        // Graph creation
        ArrayList<Edge> [] rev = new ArrayList[n];
        ArrayList<Edge> [] graph = buildGraph(edges,n,rev);
        // shortest distance from src1/src2 to dest
        long [] dist1 = Dijkstra(graph,src1);
        long [] dist2 = Dijkstra(graph,src2);
        long [] distDest = Dijkstra(rev,dest);

        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(dist2[i] != max && dist1[i] != max && distDest[i]!=max){
                min = Math.min(min,dist1[i]+dist2[i]+distDest[i]);
            }
        }

        return min == Long.MAX_VALUE ? -1 : min;

    }

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair>{

        int node;
        long dist;

        Pair(int n, long d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p){
            return Long.compare(dist,p.dist);
        }
    }


    public static ArrayList<Edge>[] buildGraph (int [][] edges,int n,ArrayList<Edge> [] rev){


        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
            rev[edges[i][1]].add(new Edge(edges[i][1],edges[i][0],edges[i][2]));
        }

        return graph;
    }

    public static long[] Dijkstra(ArrayList<Edge>[] graph,int src){

        int n = graph.length;
        long [] dist = new long[n];
        PriorityQueue<Pair> q = new PriorityQueue<>();

        Arrays.fill(dist,Long.MAX_VALUE);

        dist[src] = 0;

        boolean [] vis = new boolean[n];

        q.add(new Pair(src,0));

        while (!q.isEmpty()){
            Pair curr = q.poll();

            if(vis[curr.node]){
                continue;
            }
            vis[curr.node] = true;

            for (Edge e : graph[curr.node]){

                int u = e.src;
                int v = e.dest;

                if(dist[u]+e.wt < dist[v]){
                    dist[v] = dist[u]+e.wt;
                    q.add(new Pair(v,dist[v]));
                }

            }
        }

        return dist;
    }


}

