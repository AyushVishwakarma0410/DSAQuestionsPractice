
// went messy
// wrong way







// method 1 : DFS maintain states across the nodes.
///  HINT : Use a separate int array

// method 2 : BFS make reverse graph and count out degrees.







///🔁 Cycle + Node Classification + DFS Memo (Dynamic Programming)

/*
✅ Correct mental model
Pick a node
Explore all paths using DFS
If you hit:
cycle → unsafe
unsafe node → unsafe
Only if every path succeeds → mark safe
Cache result using color[]
*/





// self wrote 
package Graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC802{

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int [] color = new int[graph.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if(dfs(graph,i,color)){
                list.add(i);
            }
        }


        return list;
    }


    public static boolean dfs(int [][] graph, int curr,int [] color){
        
        
        // color -> 1-> visiting, 2-> safe



        // check if node is safe or not
        // if stuck in visiting then return false;
        if(color[curr]!=0){
            return color[curr]==2;
        }

        color[curr] = 1;

        for (int neigh = 0; neigh < graph[curr].length; neigh++) {

            // if not visited then cycle is detected
            if(color[graph[curr][neigh]]==1){
                return false;
            }

            // if neighbours have a cycle current node is also failed
            if(!dfs(graph,graph[curr][neigh],color)){
                return false;
            }

        }



        // safe
        color[curr] = 2;
        return true;
        
    }
}



//package Graphs;
//import java.util.*;
//
//
//public class LC802 {
//    public static void main(String[] args) {
//
//
//        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
//
//        System.out.println(eventualSafeNodes(graph));
//    }
//
//
//    public static List<Integer> eventualSafeNodes(int[][] graph) {
//
//        boolean [] vis = new boolean[graph.length];
//        boolean [] rec = new boolean[graph.length];
//        List<Integer> list = new ArrayList<>();
//        Set<Integer> terminals = new HashSet<>();
//
//        for (int i = 0; i < graph.length; i++) {
//            if(graph[i].length==0)
//                terminals.add(i);
//        }
//
//        for (int i = 0; i < graph.length; i++) {
//            if(!vis[i]) {
//                isCycleDFS(graph, i, vis, rec, list, terminals);
//            }
//        }
//
//        list.sort(Comparator.comparingInt(a -> a));
//
//
//
//        return list;
//    }
//
//    public static boolean isCycleDFS(int [][] graph, int curr, boolean [] vis, boolean [] rec, List<Integer> ans,Set<Integer> terminals){
//        vis[curr] = true;
//        rec[curr] = true;
////        System.out.println(terminals);
//        if(terminals.contains(curr)){
//            return false;
//        }
//
//        for (int val : graph[curr]){
//            if(rec[val]){
////                ans.removeLast();
//                return true;
//            }
//            if(!vis[val]){
//                ans.add(val);
//                if(isCycleDFS(graph, val, vis, rec, ans,terminals)){
//                    ans.removeLast();
//                }
//            }
//        }
//        rec[curr] = false;
//        return false;
//    }
//
//
//}
