package Graphs;

// GPT MAIN CHAT 100 Graph questions
// Revised
import java.util.*;
////
public class LC1466 {
    public static void main(String[] args) {
////
        int[][] c = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int n = 6;
        System.out.println(minReorder(n, c));
////
    }
//

public static int minReorder(int n, int[][] connections) {

    ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }

    for (int i = 0; i < connections.length; i++) {

        int u = connections[i][0];
        int v = connections[i][1];

        // real way
        graph.get(u).add(new int[] { v, 1 });
        // reversed way
        graph.get(v).add(new int[] { u, 0 });

    }
    boolean[] vis = new boolean[n];


    int counts = dfs(graph, 0, vis);



    return counts;

}

    public static int dfs(ArrayList<ArrayList<int[]>> graph, int curr, boolean[] vis) {

        vis[curr] = true;

        int c=0;
        for (int[] neigh : graph.get(curr)) {
            int dest = neigh[0];
            int nodeTy = neigh[1];

            if (!vis[dest]) {

                c += nodeTy+dfs(graph, dest, vis);
            }
        }

        return c;

    }


    ////
    ////     static class Edge{
    ////        int dest;
    ////        boolean reach0;
    ////        Edge(int dest, boolean reach0){
    ////            this.dest = dest;
    ////            this.reach0 = reach0;
    ////        }
    ////    }
    ////    public static int minReorder(int n  , int[][] connections) {
    ////
    ////        ArrayList<Edge>[] graph = new ArrayList[n];
    ////
    ////        Set<Integer> set = new HashSet<>();
    ////        for (int i = 0; i < n; i++) {
    ////            graph[i] = new ArrayList<>();
    ////        }
    ////
    ////        Queue<Integer> q = new LinkedList<>();
    ////        q.add(0);
    ////        set.add(0);
    ////
    ////        for (int i = 0; i < connections.length; i++) {
    ////            if(connections[i][1]==0) {
    ////                graph[connections[i][0]].add(new Edge(connections[i][1], true));
    ////                q.add(connections[i][0]);
    ////                set.add(connections[i][0]);
    ////            }
    ////            else
    ////              graph[connections[i][0]].add(new Edge(connections[i][1],false));
    ////        }
    ////        int count = 0;
    ////
    ////        while (!q.isEmpty()){
    ////            int size = q.size();
    ////
    ////            for (int i = 0; i < size; i++) {
    ////                int curr = q.poll();
    ////                if(!set.contains(graph[curr].get(0).dest)) {
    ////                    q.add(graph[curr].getFirst().dest);
    ////                    graph[curr].getFirst().reach0 = true;
    ////                    count++;
    ////                }
    ////            }
    ////        }
    ////        // second bfs - adding those elements which did not get visited.
    ////        for (int i = 0; i < n ; i++){
    ////            if(!set.contains(i)){
    ////                q.add(i);
    ////            }
    ////        }
    ////
    ////
    ////        while (!q.isEmpty()){
    ////            int curr = q.poll();
    ////
//            for (int i = 0; i < graph[curr].size(); i++) {
////
////            }
////
////
////        }
////
////
////
////
////        return count;
////    }
////}
//
//
//
//
//
// // solution
//public static int minReorder(int n, int[][] connections) {
//    List<int[]>[] graph = new ArrayList[n];
//
//    for (int i = 0; i < n; i++) {
//        graph[i] = new ArrayList<>();
//    }
//
//    // Build graph
//    for (int[] c : connections) {
//        int u = c[0], v = c[1];
//        graph[u].add(new int[]{v, 1}); // original direction (needs reversal)
//        graph[v].add(new int[]{u, 0}); // reverse direction (correct)
//    }
//
//    boolean[] visited = new boolean[n];
//    Queue<Integer> q = new LinkedList<>();
//    q.add(0);
//    visited[0] = true;
//
//    int count = 0;
//
//    while (!q.isEmpty()) {
//        int curr = q.poll();
//
//        for (int[] neighbor : graph[curr]) {
//            int next = neighbor[0];
//            int cost = neighbor[1];
//
//            if (!visited[next]) {
//                visited[next] = true;
//                count += cost;
//                q.add(next);
//            }
//        }
//    }
//
//    return count;


}