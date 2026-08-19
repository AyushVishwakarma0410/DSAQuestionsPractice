package Graphs;
import java.util.*;



// I need broader thinking
// I am not thinking widely




// Hmmm REDO

// topological sort




//Core Idea (Big Picture)
//
//You are trying to find:
//
//root(s) of Minimum Height Trees
//
//Instead of trying every root, we do:
//
//remove leaves layer by layer until 1 or 2 nodes remain
//
//Those remaining nodes are the answer.


public class LC310 {
    public static void main(String[] args) {
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        int n = 6;

        System.out.println(findMinHeightTrees(n, edges));

    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {


        // graph
        List<Integer>[] graph = new ArrayList[n];

        // inDegree
        int[] Degree = new int[n];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {

            int src = edges[i][0];
            int dest = edges[i][1];

            graph[src].add(dest);
            graph[dest].add(src);

            Degree[src]++;
            Degree[dest]++;

        }


        Queue<Integer> q = new LinkedList<>();


        // Degree for leaf nodes will be 1
        for (int i = 0; i < n; i++) {
            if (Degree[i] == 1) {
                q.add(i);
            }
        }


        while (n > 2) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int curr = q.poll();
                n--;
                for (int neigh : graph[curr]) {

                    Degree[neigh]--;
                    if (Degree[neigh] == 1) {
                        q.add(neigh);
                    }

                }
            }

        }


        return new ArrayList<>(q);
    }

//
//    // This one will call TLE since I am checking height for each node.
//
//    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
//
//        // graph
//        List<Integer>[] graph = new ArrayList[n];
//
//
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < edges.length; i++) {
//
//            int src = edges[i][0];
//            int dest = edges[i][1];
//
//            graph[src].add(dest);
//            graph[dest].add(src);
//
//        }
//
//
//        int minHeight = Integer.MAX_VALUE;
//
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < graph.length; i++) {
//
//            int height = -1;
//            Queue<Integer> q = new LinkedList<>();
//            boolean [] vis = new boolean[n];
//
//            q.add(i);
//            vis[i] = true;
//
//
//            while (!q.isEmpty()){
//
//                int size = q.size();
//                height++;
//                for (int j = 0; j < size ; j++) {
//
//                    int curr = q.poll();
//
//                    for (int neigh : graph[curr]) {
//                        if (!vis[neigh]) {
//                            q.add(neigh);
//                            vis[neigh]= true;
//                        }
//
//
//                    }
//                }
//
//            }
//
//
//            if(minHeight > height){
//                minHeight = height;
//                res.clear();
//                res.add(i);
//            }else if(height == minHeight) {
//                res.add(i);
//            }
//
//
//
//        }
//
//
//
//
//        return res;
//
//    }
    }