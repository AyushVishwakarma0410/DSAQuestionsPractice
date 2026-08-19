package Graphs;

import java.util.*;

import java.util.*;

public class REDUNDANTCONNECTION2 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];
        int[] cand1 = null, cand2 = null;

        // Step 1: detect two parents
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                cand1 = new int[]{parent[v], v};
                cand2 = new int[]{u, v};
                edge[1] = 0; // mute second edge
            }
        }

        // Step 2: build graph (excluding muted edge)
        List<List<Integer>> adj = buildGraph(edges, n);

        // Step 3: detect cycle
        if (hasCycle(adj, n)) {
            if (cand1 != null) {
                return cand1;
            }
            return findCycleEdge(edges, n);
        }

        // No cycle → second edge is wrong
        return cand2;
    }

    // Build adjacency list
    private List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            if (e[1] == 0) continue;
            adj.get(e[0]).add(e[1]);
        }

        return adj;
    }

    // Cycle detection using DFS + coloring
    private boolean hasCycle(List<List<Integer>> adj, int n) {
        int[] color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && dfsCycle(i, adj, color)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsCycle(int node, List<List<Integer>> adj, int[] color) {
        color[node] = 1;

        for (int neigh : adj.get(node)) {
            if (color[neigh] == 1) return true;
            if (color[neigh] == 0 && dfsCycle(neigh, adj, color)) return true;
        }

        color[node] = 2;
        return false;
    }

    // Find the edge that creates a cycle (LC 684 style)
    private int[] findCycleEdge(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            boolean[] vis = new boolean[n + 1];
            if (dfsPath(adj, u, v, vis)) {
                return edge;
            }

            adj.get(u).add(v);
        }

        return new int[0];
    }

    // Check if path exists from src → dest
    private boolean dfsPath(List<List<Integer>> adj, int src, int dest, boolean[] vis) {
        if (src == dest) return true;

        vis[src] = true;

        for (int neigh : adj.get(src)) {
            if (!vis[neigh] && dfsPath(adj, neigh, dest, vis)) {
                return true;
            }
        }

        return false;
    }
}
