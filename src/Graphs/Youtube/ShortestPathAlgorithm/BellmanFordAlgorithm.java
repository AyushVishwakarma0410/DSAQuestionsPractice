package Graphs.Youtube.ShortestPathAlgorithm;

import java.util.ArrayList;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {

    }


    // Works for both +ve and -ve weights
    // Dynamic Programming weights
    // More TC compared to Dijkstra.




    public static void bellman(ArrayList<Dijkstra.Edge> [] graph, int src, int V){
        int dist[] = new int[V];

        for (int i = 0; i < V; i++) {
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int k = 0; k < V-1; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Dijkstra.Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    if(dist[u] != Integer.MAX_VALUE/*Error check Condition */ &&  dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }



        // bellman ford fails at negative weight cycles

        // Checking -weight
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Dijkstra.Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;

                if(dist[u] != Integer.MAX_VALUE/*Error check Condition */ &&  dist[u] + e.wt < dist[v]){
                    System.out.println("Negative weight cycle!!!");
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]+" ");
        }
        System.out.println();

    }
}
