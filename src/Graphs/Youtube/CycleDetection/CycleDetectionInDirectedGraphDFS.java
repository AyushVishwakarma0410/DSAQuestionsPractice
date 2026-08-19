package Graphs.Youtube.CycleDetection;

import java.util.ArrayList;





// To detect a cycle in directed graph, if a path is started from a node
// then that node SHOULD BE visited again
// If we reach a point where there is no path from a node in the current path
// we will backtrack and search another neighbours and build a new path
// if found an edge which caused cycle then we can return boolean value of the edge itself







public class CycleDetectionInDirectedGraphDFS {
    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge> [] graph = new ArrayList[V];




        // incase we have different components
        boolean [] vis = new boolean[V];
        boolean [] rec = new boolean[V];



        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                System.out.println(isCycleDirected(graph,vis,0,rec));
            }
        }


        // otw just call isCycleDirected

    }

    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        //  etc.


    }




    /// ========================================================================///


    public static boolean isCycleDirected(ArrayList<Edge>[] graph, boolean [] vis, int curr, boolean [] rec){


        // here rec[] is a stack array as checking in stack takes O(n) complexity
        vis[curr] = true;
        rec[curr] = true;


        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            // Cycle condition
            if(rec[e.dest]){
                return true;
            }
            else if(!vis[e.dest]){
                if(isCycleDirected(graph,vis,e.dest,rec)){
                    return true;
                }
            }


        }
        rec[curr] = false;
        return false;

    }


}
