//  I was feeling so lazy to do this question
// Therefore I used GPT
// Done with graphs for now .. I just cannot continue
// I will go slow from here, more practice questions and contest participation
// Going to learn new topics but that will be slow af.
//class Solution {
//
//    int[] parent;
//    int[] size;
//
//    public boolean validTree(int n, int[][] edges) {
//
//        if (edges.length != n - 1) {
//            return false;
//        }
//
//        parent = new int[n];
//        size = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//            size[i] = 1;
//        }
//
//        for (int[] edge : edges) {
//
//            int a = edge[0];
//            int b = edge[1];
//
//            if (find(a) == find(b)) {
//                return false; // cycle detected
//            }
//
//            union(a, b);
//        }
//
//        return true;
//    }
//
//    int find(int x) {
//        if (parent[x] == x) return x;
//        return parent[x] = find(parent[x]);
//    }
//
//    void union(int a, int b) {
//
//        int pa = find(a);
//        int pb = find(b);
//
//        if (pa == pb) return;
//
//        if (size[pa] > size[pb]) {
//            parent[pb] = pa;
//            size[pa] += size[pb];
//        } else {
//            parent[pa] = pb;
//            size[pb] += size[pa];
//        }
//    }
//}
//
////package Graphs.MST.DisjointSetUnion;
////
////public class Lc261 {
////    public static void main(String[] args) {
////
////    }
////    public static boolean sol(int n, int [][] edges){
////
////
////        boolean [] vis = new boolean[n];
////
////        return dfs(edges,0,vis,-1);
////
////
////
////    }
////
////    public static boolean dfs(int [][] edges, int curr, boolean [] vis,int parent ){
////        vis[0] = true;
////
////        for (int i = 0; i < edges[curr].length;i++){
////
////            int dest = edges[curr][1];
////
////
////
////            if(!vis[dest]){
////
////            }
////
////        }
////
////
////    }
////}
