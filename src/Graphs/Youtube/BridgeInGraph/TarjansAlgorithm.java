package Graphs.Youtube.BridgeInGraph;

import Graphs.Edge;

import java.util.ArrayList;

public class TarjansAlgorithm {
    public static void main(String[] args) {

    }
    public static void getBridge(ArrayList<Edge> [] graph, int V){
        int [] dt = new int[V];
        int [] lowDt = new int[V];
        int time = 0;
        boolean[]vis = new boolean[V];

        for (int i = 0; i < V; i++) {
         if(!vis[i]){
             dfs(graph,i,vis,dt,lowDt,time,-1);
         }
        }
    }

    public static void dfs(ArrayList<Edge> [] graph, int curr,boolean [] vis, int[] dt,int [] lowDt,int time, int par ){
            vis[curr] = true;

            dt[curr] = lowDt[curr] = ++time;


        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Case 1
            if(e.dest==par){
                continue;
            }
            // Case 2
            else if (!vis[e.dest]) {
                dfs(graph,e.dest,vis,dt,lowDt,time,curr);
                lowDt[curr] = Math.min(lowDt[curr],lowDt[e.dest]);
                if(dt[curr] < lowDt[e.dest]){
                    System.out.println("Bridge is :"+ curr + "----" + e.dest);
                }
            }

            // Case 3
            else {
                lowDt[curr] = Math.min(lowDt[curr], dt[e.dest]);
            }

        }
    }
}
