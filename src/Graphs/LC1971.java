package Graphs;

import java.util.ArrayList;
import Graphs.Edge;
public class LC1971 {

    static class Edge {

        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }

    public static void main(String[] args) {


        int[][] arr = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};

        System.out.println(validPath(6, arr, 0, 5));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {


        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new Edge(edges[i][0], edges[i][1]));
            graph[edges[i][1]].add(new Edge(edges[i][1], edges[i][0]));
        }

        return dfs(graph, source, new boolean[n], destination);


    }

    public static boolean dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis, int dest) {

        if (curr == dest) {
            return true;
        }
        vis[curr] = true;


        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if (!vis[e.dest]) {
               return dfs(graph, e.dest, vis, dest);
            }

        }


        return false;

    }
}