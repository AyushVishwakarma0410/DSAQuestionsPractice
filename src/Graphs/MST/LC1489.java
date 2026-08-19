//package Graphs.MST;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//
//public class LC1489 {
//    public static void main(String[] args) {
//
//    }
//
//    static class Edge{
//        int src;
//        int dest;
//        int wt;
//        Edge(int src, int dest,int wt){
//            this.src = src;
//            this.dest = dest;
//            this.wt = wt;
//        }
//    }
//
//    static int [] parent;
//    static int [] size;
//
//    static int find(int x){
//
//        if(x==parent[x]){
//            return x;
//        }
//
//        return parent[x] = find(parent[x]);
//    }
//
//    static void union(int a, int b){
//    int pA = find(a);
//    int pB = find(b);
//
//    if(pA!=pB){
//        if(size[pA] > size[pB]){
//            parent[pB] = pA;
//            size[pA] += size[pB];
//        }
//        else {
//            parent[pA] = pB;
//            size[pB] += size[pA];
//        }
//    }
//    }
//
//    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
//
//        ArrayList<Edge> edgesList = new ArrayList<>();
//
//        for (int i = 0; i < edges.length; i++) {
//            edgesList.add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
//            // NO EXTRA EDGE NEEDED FOR KRUSKALS
////            edgesList.add(new Edge(edges[i][1],edges[i][0],edges[i][2]));
//        }
//
//        ArrayList<int []> usedEdge  = new ArrayList<>();
//
//        parent = new int[n];
//        size = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            parent[i] = i;
//            size[i] = 1;
//        }
//
//        Collections.sort(edgesList,(a,b)->a.wt - b.wt);
//
//        int edgeUsed = 0;
//        int minCost = 0;
//
//        for (int i = 0; i < edgesList.size() && edgeUsed!=n-1; i++) {
//
//            Edge e = edgesList.get(i);
//
//            int u = e.src;
//            int v = e.dest;
//
//            if(find(u) != find(v)){
//                union(u,v);
//                minCost+= e.wt;
//                usedEdge.add(new int[]{u,v,e.wt});
//                edgeUsed++;
//            }
//
//        }
//
//
//        List<Integer> critical = new ArrayList<>();
//        List<Integer> psuedo = new ArrayList<>();
//
//
//        for (int i = 0; i < usedEdge.size(); i++) {
//
//            int src = usedEdge.get(i)[0];
//            int dest = usedEdge.get(i)[1];
//
//            for (int j = 0; j < n; j++) {
//                parent[j] = j;
//                size[j] = 1;
//            }
//            edgeUsed = 0;
//
//
//            int checkCost = 0;
//            for (int j = 0; j < edgesList.size() && edgeUsed!=n-1; j++) {
//
//                Edge e = edgesList.get(j);
//
//                int u = e.src;
//                int v = e.dest;
//                if(u==src && v == dest){
//                    continue;
//                }
//
//                if(find(u) != find(v)){
//
//
//                    if(u!=src && v != dest) {
//                        union(u,v);
//                        checkCost+= e.wt;
//                        edgeUsed++;
//                    }
//                }
//
//
//            }
//
//            if(edgeUsed==n-1){
//                psuedo.add(src,dest);
//                if(checkCost > minCost){
//                    critical.add(src,dest);
//                } else {
//                    psuedo.add(src,dest);
//                }
//            }
//
//
//        }
//
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(critical);
//        res.add(psuedo);
//
//
//        return res;
//    }
//
//
//
//
//
//}


package Graphs.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1489 {
    public static void main(String[] args) {
        // Test block can go here
    }

    static class Edge {
        int src;
        int dest;
        int wt;
        int index; // Track original index

        Edge(int src, int dest, int wt, int index) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
            this.index = index;
        }
    }

    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA != pB) {
            if (size[pA] > size[pB]) {
                parent[pB] = pA;
                size[pA] += size[pB];
            } else {
                parent[pA] = pB;
                size[pB] += size[pA];
            }
            return true;
        }
        return false;
    }

    // Helper to build MST with options to skip an edge or force-include an edge
    private static int buildMST(int n, List<Edge> edgesList, int skipEdgeIdx, int forceEdgeIdx) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int mstWeight = 0;
        int edgesCount = 0;

        // 1. If forcing an edge, add it first
        if (forceEdgeIdx != -1) {
            Edge e = edgesList.stream().filter(edge -> edge.index == forceEdgeIdx).findFirst().get();
            union(e.src, e.dest);
            mstWeight += e.wt;
            edgesCount++;
        }

        // 2. Build the rest of the MST
        for (Edge e : edgesList) {
            if (e.index == skipEdgeIdx) continue;

            if (union(e.src, e.dest)) {
                mstWeight += e.wt;
                edgesCount++;
                if (edgesCount == n - 1) break;
            }
        }

        // If we couldn't connect the entire graph, return "infinity"
        return (edgesCount == n - 1) ? mstWeight : Integer.MAX_VALUE;
    }

    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Edge> edgesList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            edgesList.add(new Edge(edges[i][0], edges[i][1], edges[i][2], i));
        }

        // Sort by weight
        Collections.sort(edgesList, (a, b) -> a.wt - b.wt);

        // Find standard MST cost
        int minCost = buildMST(n, edgesList, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        // Check every single edge
        for (int i = 0; i < edges.length; i++) {
            // Check if critical: Skip it, see if cost increases
            int costWithoutEdge = buildMST(n, edgesList, i, -1);
            if (costWithoutEdge > minCost) {
                critical.add(i);
            } else {
                // Check if pseudo-critical: Force it, see if cost remains optimal
                int costWithEdge = buildMST(n, edgesList, -1, i);
                if (costWithEdge == minCost) {
                    pseudo.add(i);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pseudo);
        return res;
    }
}