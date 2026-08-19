package Graphs.TraversalsTechiques.AdjacencyList;

import java.util.ArrayList;
import Graphs.TraversalsTechiques.Edge;
public class DFS {
    public static void main(String[] args) {

    }

    public static void dfs(ArrayList<Edge>[] graph,int curr, boolean[] vis){


        System.out.print(curr+" ");
        vis[curr] = true;


        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }

        }


    }
}
