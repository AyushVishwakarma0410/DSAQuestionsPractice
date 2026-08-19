package Graphs.Youtube;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void main(String[] args) {

    }
    // Directed Acyclic Graph(DAG) i.e. graph should be directed and should not have any cycles.
    // It is a linear order of vertices such that every directed edge u-> v the vertex u comes before v in the order.

    // Topological Sorting shows dependency

    public static void topologicalSortUtil(ArrayList<Edge>[]graph, int curr, boolean[] vis, Stack<Integer> stack){

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                topologicalSortUtil(graph,e.dest, vis,stack);
            }
        }

        stack.push(curr);
    }

    public static void topologicalSort(ArrayList<Edge> [] graph,int V){
        boolean [] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                topologicalSortUtil(graph,i,vis,stack);
            }
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
