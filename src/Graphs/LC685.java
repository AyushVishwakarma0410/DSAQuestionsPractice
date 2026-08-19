// its kinda mehh


//package Graphs;
//
//public class LC685 {
//    public int[] findRedundantDirectedConnection(int[][] edges) {
//        int n = edges.length;
//
//        int[] parent = new int[n + 1];
//        int[] edge1 = null, edge2 = null;
//
//        // Step 1: check two parents
//        for (int[] edge : edges) {
//            int u = edge[0], v = edge[1];
//
//            if (parent[v] == 0) {
//                parent[v] = u;
//            } else {
//                edge1 = new int[]{parent[v], v};
//                edge2 = new int[]{u, v};
//                edge[1] = 0; // mark invalid
//            }
//        }
//
//        // Union-Find
//        int[] uf = new int[n + 1];
//        for (int i = 1; i <= n; i++) uf[i] = i;
//
//        for (int[] edge : edges) {
//            if (edge[1] == 0) continue;
//
//            int u = edge[0], v = edge[1];
//
//            int pu = find(uf, u);
//            int pv = find(uf, v);
//
//            if (pu == pv) {
//                if (edge1 == null) return edge;
//                return edge1;
//            }
//
//            uf[pv] = pu;
//        }
//
//        return edge2;
//    }
//
//    private int find(int[] uf, int x) {
//        if (uf[x] != x) {
//            uf[x] = find(uf, uf[x]);
//        }
//        return uf[x];
//    }
//}




// mehh 2
/*
import java.util.*;

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] cand1 = null, cand2 = null;

        // Step 1: Find if any node has two parents
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                // Node v has two parents!
                cand1 = new int[]{parent[v], v};
                cand2 = new int[]{u, v};
                // "Mute" the current edge for now
                edge[1] = 0;
            }
        }

        // Step 2: Use DFS to check for cycles
        int[] ancestors = new int[n + 1];
        for (int i = 1; i <= n; i++) ancestors[i] = i;

        // Note: For pure DFS cycle detection in directed graphs,
        // we use a recursion stack or a modified DSU for speed.
        // Here's the cycle check logic:
        if (hasCycle(edges, n)) {
            // If we muted cand2 and still have a cycle, cand1 is the culprit
            return cand1 == null ? findCycleEdge(edges, n) : cand1;
        }

        // No cycle found after muting cand2? cand2 was the problem.
        return cand2;
    }

    private boolean hasCycle(int[][] edges, int n) {
        // Standard DFS cycle detection
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        int[] inDegree = new int[n + 1];

        for (int[] edge : edges) {
            if (edge[1] == 0) continue; // Skip the muted edge
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        // Using Kahn's algorithm (BFS-based DFS logic) to find cycles
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) if (inDegree[i] == 0) q.add(i);

        int visitedCount = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            visitedCount++;
            for (int v : adj.get(u)) {
                if (--inDegree[v] == 0) q.add(v);
            }
        }
        return visitedCount != n;
    }

    private int[] findCycleEdge(int[][] edges, int n) {
        // Logic to return the last edge that completes a cycle
        // (Similar to Redundant Connection I logic)
        return new int[]{0,0}; // Simplified for example
    }
}

*/