package Graphs.Youtube.CycleDetection;
import java.util.ArrayList;


public class CycleDetectionUndirectedGraphDFS {
    public static void main(String[] args) {


        // number of vertices
        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);


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
            graph[i] = new ArrayList<Edge>();
        }


        // the list present at arr[0] should add :
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,1));

        // the list present at arr[1] should add :
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));

        // the list present at arr[2] should add :
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        // the list present at arr[3] should add :
        graph[3].add(new Edge(3,2));

        // the list present at arr[4] should add :
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));


        // the list present at arr[5] should add :
        graph[5].add(new Edge(5,4));


    }


    /// ========================================================================///


    public static boolean isCycleUndirected(ArrayList<Edge>[] graph,boolean [] visited, int curr, int par){
        // making current Vertex visited
        visited[curr] = true;

        // getting all the elements from the arraylist at the position of vertex in the array
        for (int i = 0; i < graph[curr].size(); i++) {

            // Getting all edges i.e. example 1-----2 here ------ is the edge
            Edge e = graph[curr].get(i);


            // Condition 1
            if(visited[e.dest] && par!=e.dest){
                return true;
            }

            // Condition 2
            // Do nothing

            // Condition 3
            else if(!visited[e.dest]){
                if(isCycleUndirected(graph,visited,e.dest,curr)){
                    return true;
                }
            }

        }
        return false;
    }

}
