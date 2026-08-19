package Graphs.Youtube.BridgeInGraph;

import Graphs.Edge;

import java.util.ArrayList;

public class TarjansAlgoForGetAP {
    public static void main(String[] args) {

    }


    public static void dfs(ArrayList<Edge>[]graph,int curr,int par,int [] dt,int [] low, boolean[] vis
                            ,int time,boolean [] ap){


        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;


        for (int i = 0; i < graph[i].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(par==neigh){
                continue;
            }
            else if(vis[neigh]){
                low[curr] = Math.min(low[curr],dt[neigh]);
            }
            else {
                dfs(graph,neigh,curr,dt,low,vis,time,ap);
                low[curr] = Math.min(low[curr],low[neigh]);
                if(dt[curr] <= low[neigh]&& par!=-1){
                    ap[curr] = true;
                }
                children++;
            }
        }

        if(par == -1 && children>1){
            ap[curr] = true;
        }

    }

    public static void getAP(ArrayList<Edge>[]graph,int V){
        int dt[] = new int[V];
        int lowDt[] = new int[V];
        int time = 0;
        boolean [] vis = new boolean[V];
        boolean [] ap = new boolean[V];


        for (int i = 0; i < V; i++) {

            if(!vis[i]){
                dfs(graph,i,-1,dt,lowDt,vis,time,ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if(ap[i]){
                System.out.println("Ap"+ i);
            }
        }
    }
}
