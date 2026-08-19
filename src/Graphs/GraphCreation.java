package Graphs;

import java.util.ArrayList;

public class GraphCreation {
    public static void main(String[] args) {
        // Step 1: define number of vertices in the graph
        int V = 5;
        // Step 2: Create Adjacency list - Array of ArrayList
        ArrayList<Edge>[] graph = new ArrayList[V]; // null -> empty arrayList


        // putting empty arraylists
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }


        /*
            5
        0---------1
                 / \
              1 /   \ 3
               /     \
              2-------3
              |   1
            2 |
              |
              4


         */

        // vertex 0
        graph[0].add(new Edge(0,1,5));

        // vertex 1
        graph[1].add(new Edge(1,0,5));

        graph[1].add(new Edge(1,2,1));

        graph[1].add(new Edge(1,3,3));

        // vertex 2

        graph[2].add(new Edge(2,1,1));

        graph[2].add(new Edge(2,3,1));

        graph[2].add(new Edge(2,4,2));

        // vertex 3
        graph[3].add(new Edge(3,1,3));

        graph[3].add(new Edge(3,2,1));

        // vertex 4
        graph[4].add(new Edge(4,2,2));


        // Store information of a vertex's neighbours
        // lets take the vertex 2
        for (int i = 0; i < graph[2].size();i++){
            Edge e = graph[2].get(i);

            System.out.println(e.dest);
        }

    }
}
