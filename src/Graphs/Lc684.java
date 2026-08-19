// HMMMM ... have to be done by building graph and cycle detection simultaneously










//  SELF WROTE ( not my idea )


package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Lc684{
    public static void main(String[] args) {
        int [][] ans = {{1,2},{1,3},{2,3}};

        System.out.println(Arrays.toString(findRedundantConnection(ans)));

    }

    // self wrote - not my idea
    // simultaneous graph construction with cycle detection
    public static int [] findRedundantConnection(int [][] edges){

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            boolean[] vis = new boolean[edges.length+1];

            if(dfs(graph,edges[i][0],edges[i][1],vis)){
                return edges[i];
            }

            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);


        }


        return new int[0];

    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, int dest, boolean [] vis){
        if(src==dest){
            return true;
        }

        vis[src] = true;

        for (int neigh : graph.get(src)){
            if(!vis[neigh]){
                if(dfs(graph,neigh,dest,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}
//
//
//
//
//

//package Graphs;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Lc684 {
//    public static void main(String[] args) {
//
//        int [][] ans = {{1,2},{1,3},{2,3}};
//
//        System.out.println(Arrays.toString(findRedundantConnection(ans)));
//
//    }
//    public static int[] findRedundantConnection(int[][] edges) {
//
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//
//
//        for (int i = 0; i < edges.length+1; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//
//
//        for (int i = 0; i < edges.length; i++) {
//            graph.get(edges[i][0]).add(edges[i][1]);
//            graph.get(edges[i][1]).add(edges[i][0]);
//        }
//
//        boolean [] vis = new boolean[graph.size()];
//        for (int i = 1; i < graph.size(); i++) {
//            if(!vis[i]) {
//                int[] ans = dfs(graph, i, -1, vis);
//                if (ans.length != 0) {
//                    return ans;
//                }
//            }
//
//        }
//
//        return new int[]{};
//
//    }
//
//    public static int [] dfs (ArrayList<ArrayList<Integer>> graph, int curr,int parent,boolean [] vis){
//        vis[curr] = true;
//
//
//        for(int i : graph.get(curr)){
//            if(vis[i] && parent!=i){
//                return new int[]{i,curr};
//            }
//            else if(!vis[i]){
//               int [] ans =  dfs(graph,i,curr,vis);
//               if(ans.length!= 0){
//                   return ans;
//               }
//            }
//        }
//
//
//        return new int [] {};
//    }
//
//}
