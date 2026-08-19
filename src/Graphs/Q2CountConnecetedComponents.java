package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q2CountConnecetedComponents {
    public static void main(String[] args) {

        int V =6;
        ArrayList<Edge> [] graph = new ArrayList[V];

        System.out.println("Individual Components");

        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[1].add(new Edge(1,0,1));  // if undirected
        graph[2].add(new Edge(2,3,1));
        graph[3].add(new Edge(3,2,1));
        System.out.println("Connected Components (BFS): " + countConnectedComponents(graph));
        System.out.println("Connected Components (DFS): " + countComponentsDFS(graph));

    }

    public static int countConnectedComponents(ArrayList<Edge> [] graph){
        
        
        boolean [] vis = new boolean[graph.length];
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                count++;


                Queue<Integer> q = new LinkedList<>();

                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {

                        Edge e = graph[curr].get(j);

                        if (!vis[e.dest]) {
                            q.add(e.dest);
                            vis[e.dest] = true;
                        }
                    }
                }

            }


        }
            return count;
    }
    
    public static int countComponentsDFS(ArrayList<Edge>[] graph){

        int count = 0;
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {

            if(!vis[i]){
                count++;
                DFS(graph,vis,i);
            }

        }
        return count;
    }

    public static void DFS(ArrayList<Edge>[] graph,boolean[] vis,int curr){

        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest])
                DFS(graph,vis,e.dest);
        }


    }

}
