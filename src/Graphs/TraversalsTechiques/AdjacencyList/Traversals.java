package Graphs.TraversalsTechiques.AdjacencyList;

import Graphs.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
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

        BFSInGraph(graph);
        DFSInGraph(graph,0,new boolean[graph.length]);
    }

    public static void BFSInGraph(ArrayList<Edge>[] graph){

        // as usual for level order or BFS traversal q
        Queue<Integer> q = new LinkedList<>();
        // a visited array to mark nodes as visited or not
        boolean [] visited = new boolean[graph.length];

        // as usual adding the src to q
        q.add(0);

        while (!q.isEmpty()){
            int curr = q.remove();


            // if node not visited, then visit current
            if(!visited[curr]){
                // printing node value
                System.out.println(curr+" ");
                // marking it as visited
                visited[curr] = true;


                // traversing all the edges
                for (int i = 0; i < graph[curr].size(); i++) {

                    // take edge
                    Edge e = graph[curr].get(i);

                    // add neighbours to list


                    if(!visited[e.dest]) {
                        q.add(e.dest);
                        visited[e.dest] = true;
                    }
                }



            }
        }
    }

    public static void DFSInGraph(ArrayList<Edge>[] graph,int curr,boolean[] visited){

        // print current
        System.out.println(curr+" ");
        visited[curr]= true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.dest]){
                DFSInGraph(graph,e.dest,visited);
            }
        }
    }

}
