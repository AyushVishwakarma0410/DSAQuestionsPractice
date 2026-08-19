package Graphs.TraversalsTechiques.AdjacencyMatrix;

import Graphs.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        int [][] arr = new int [4][4];
    }


    public static void bfs(int [][] graph, int start){

        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[graph.length];

        // usually it is nxn
        int n = graph[0].length;

        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()){

            // row
            int u = q.remove();
            System.out.println(u + " ");
            for (/*column*/int v = 0; v < n; v++) {

                if(graph[u][v]==1 && !vis[v]){
                    q.add(v);
                    vis[v] = true;
                }
            }
        }

    }

}
