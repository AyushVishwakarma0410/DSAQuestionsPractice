package Graphs.TraversalsTechiques.AdjacencyList;


import Graphs.TraversalsTechiques.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {


        int V = 6;
        ArrayList<Edge> [] graph = new ArrayList[V];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0,1,4));
        graph[0].add(new Edge(0,4,5));
        graph[0].add(new Edge(0,5,5));

        // 1
        graph[1].add(new Edge(1,2,5));
        graph[1].add(new Edge(1,3,5));
        graph[1].add(new Edge(1,4,4));

        // 2
        graph[2].add(new Edge(2,0,5));


        bfs(graph);

    }

    public static void bfs(ArrayList<Edge>[] graph){

        boolean [] vis = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(0); vis[0] = true;

        while (!q.isEmpty()) {

            int curr = q.poll();
            System.out.println(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                if (!vis[e.dest]) {
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }

        }


    }

}
