package Graphs.TraversalsTechiques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// TYPE 3 -> EDGE LIST
// DECLARATION 5 -> source, weight, destination

public class Edge {

    int src;
    public int dest;
    int wt;
    public Edge(int src,int dest,int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    public static void main(String[] args) {


        // TYPE 1 -> MATRIX
        // DECLARATION 1
        int [][] matrix = new int[5][5];

        matrix[0][1] = 1;
        matrix[1][0] = 1;



        // TYPE 2 -> ADJACENCY LISTS
        // DECLARATION 2


        // DECLARATION 2 : src -> destination
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();

        // making lists
        for (int i = 0; i < 5; i++) {
            graph1.add(new ArrayList<>());
        }

        // making edges between nodes
        graph1.get(0).add(1);
        graph1.get(1).add(2);
        graph1.get(1).add(3);

        // graph so far
        /*

        0->1->2
           ↓
           3
         */


        // DECLARATION 3 -> limited edges, source -> destination

        ArrayList<Integer>[] graph2 = new ArrayList[5];

        for (int i = 0; i < 5; i++) {
            graph2[i] = new ArrayList<>();
        }

        graph2[0].add(1);
        graph2[1].add(2);



        // TYPE 4 -> HASHMAP
        // DECLARATION 5 -> mapping, key -> src and value -> destination

        Map<Integer, List<Integer>> map = new HashMap<>();

        // putting ArrayLists
        map.putIfAbsent(0,new ArrayList<>());
        map.putIfAbsent(1,new ArrayList<>());

        // putting values
        map.get(0).add(1);
        map.get(1).add(2);

        Map<String, List<String>> StringGraph = new HashMap<>();

        StringGraph.putIfAbsent("A", new ArrayList<>());
        StringGraph.get("A").add("B");




        // DECLARATION 6 -> grid based
        //Graph is not stored explicitly — neighbors generated dynamically.
        //
        //Used in:
        //
        //Grid problems
        //Word ladder
        //BFS state problems

        int[][] grid = new int[3][3];

        int r=0,c=0; // these will be grid[r][c]

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
        }
    }


    // DECLARATION 7
//    Matrix as Graph (Grid Graph)
//    Idea
//
//2D grid itself is the graph.
//
//    int[][] grid = {
//            {1, 1, 0},
//            {0, 1, 1}
//    };
//
//    Traversal defines edges.



    // DECLARATION 4 -> destination and weight

    class Pair{
        int node;
        int weight;
        Pair(int n, int w){
            node = n;
            weight = w;
        }
    }




}
