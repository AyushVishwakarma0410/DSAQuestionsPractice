package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1HasPath {
    public static void main(String[] args) {


        int [][] arr ={{1,2},{3,4}};

        for (int i = 0; i < arr.length; i++) {

            int [] a = arr[i];

        }


    }

    // here 4th parameter dest is the target node
    // e.dest is the edge connected node to the current


    // DFS
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, boolean[] visited,int dest){
        if(src==dest){
            return true;
        }

        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            if(!visited[e.dest] && hasPath(graph,e.dest,visited,dest)){
                return true;
            }
        }
        return false;
    }


    // BFS
    public static boolean hasPath(ArrayList<Edge>[] graph,int src, int dest){


        Queue<Integer> q = new LinkedList<>();

        boolean [] vis = new boolean[graph.length];

        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()){

            int curr = q.remove();

            if(curr == dest){
                return true;
            }

                for (int i = 0; i < graph[curr].size(); i++) {

                    Edge e = graph[curr].get(i);

                    if(!vis[e.dest]) {
                        q.add(e.dest);
                    }

                    vis[curr] = true;

                }






        }


        return false;


    }

}
