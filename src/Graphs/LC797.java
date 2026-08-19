package Graphs;

import java.util.ArrayList;

public class LC797 {

    // self done -> solved in 29 min
    // woke up early
    public static void main(String[] args) {



        int [][] arr ={{1,2},{3},{3},{}};

        makeGraph(arr);

    }

    public static ArrayList<ArrayList<Integer>>  makeGraph(int [][] graph){
        int V = graph.length;


        // declaration
        ArrayList<Edge>[] graphs = new ArrayList[V];

        // initialization

        for (int i = 0; i< graph.length;i++){
            graphs[i] = new ArrayList<>();
        }

        // putting values in graph
        for (int i = 0; i < graph.length; i++){
            for (int j = 0; j < graph[i].length; j++) {
                graphs[i].add(new Edge(i,graph[i][j],0));
            }
        }



        // final answer
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Tracking ans
        ArrayList<Integer> ans = new ArrayList<>();


        // call
        find(graphs,res,ans,new boolean[V],0,V-1);

        for (ArrayList<Integer> a : res){
            System.out.println(a);
        }

        return res;
    }

    public static void find(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans, boolean [] vis, int src,int dest){



        ans.add(src);
        // double check
        vis[src] = true;
        if (src == dest){
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e  = graph[src].get(i);

            if(!vis[e.dest]){
                vis[e.dest] = true;
                find(graph,res,ans,vis,e.dest,dest);
                ans.removeLast();
                vis[e.dest] = false;
            }
        }



    }


}
