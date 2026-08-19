package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LC207 {
    public static void main(String[] args) {

        int [][] n = {{1,0}};

        System.out.println(canFinish(2,n));

    }

    // self done
    // might try bfs someday, but its already done in 210 so no need

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph1.add(new ArrayList<>());
        }


        for (int i = 0; i < prerequisites.length; i++) {

            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];

            graph1.get(src).add(dest);
        }


        // incase we have different components
        boolean [] vis = new boolean[numCourses];
        boolean [] rec = new boolean[numCourses];


        for (int i = 0; i < numCourses; i++) {
            if(isCycle(graph1,i,vis,rec)){
                return true;
            }
        }

        return false;

    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> graph,int curr, boolean [] vis, boolean [] rec){

        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph.get(curr).size(); i++) {
            int edge = graph.get(curr).get(i);

            if(rec[edge]){
                return true;
            }
            else if(!vis[edge]){
                if(isCycle(graph,edge,vis,rec)){
                    return true;
                }
            }

        }

        rec[curr] = false;

        return false;

    }

}
