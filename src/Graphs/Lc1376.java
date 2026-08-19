package Graphs;

import java.util.ArrayList;

public class Lc1376 {
    public static void main(String[] args) {


        int [] manager ={2, 3, -1, 2, 3, 4};
        int [] time = {1, 2, 1, 1, 3, 4};

        System.out.println(numOfMinutes(manager.length,2,manager,time));


    }
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if(manager[i]!=-1){
                graph.get(manager[i]).add(i);
            }
        }

        return dfs(graph,headID,informTime);


    }

    public static int dfs(ArrayList<ArrayList<Integer>> graph,int src,int [] informTime){
        int maxTime = 0;

        if(graph.get(src).isEmpty()){
            return 0;
        }

        int current = informTime[src];

        for (int i = 0; i < graph.get(src).size(); i++) {

            maxTime = Math.max(maxTime,dfs(graph,graph.get(src).get(i),informTime));

        }
        return maxTime+current;
    }




}
