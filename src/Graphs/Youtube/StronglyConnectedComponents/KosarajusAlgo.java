package Graphs.Youtube.StronglyConnectedComponents;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgo {
    public static void main(String[] args) {

    }

    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }


    public static void kosarajuAlgo(ArrayList<Edge> [] graph, int V){
        // Step 1
        Stack<Integer> stack = new Stack<>();
        boolean [] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                topSort(graph,i,vis,stack);
            }
        }

        // step 2
        ArrayList<Edge>[] transpose =  new ArrayList[V];

        for (int i = 0; i < graph.length; i++) {
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j); // e.src -> e.dest
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }

        //  Step 3
        while (!stack.isEmpty()){
            int curr = stack.pop();
            if(!vis[curr]){
                DFS(transpose,curr,vis);
                System.out.println( );
            }
        }
    }



    public static void DFS(ArrayList<Edge> [] graph, int curr,boolean[] vis){
        vis[curr] = true;
        System.out.println(curr+" ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                DFS(graph,e.dest,vis);
            }
        }
    }



    // Topological sort
    public static void topSort(ArrayList<Edge> [] graph, int curr, boolean [] vis,Stack<Integer> stack){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                topSort(graph,e.dest,vis,stack);
            }
        }

        stack.push(curr);
    }


















}
