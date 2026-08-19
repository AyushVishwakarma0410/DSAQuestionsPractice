package Graphs.Youtube;


// InDegree -> number of edges directed towards the node
// outDegree -> number of edges directed from the node

// A direct Acyclic graph has at least one vertex with in-degree 0 and one vertex with out-degree 0.
// i.e. the longest path
// no visited array required.
// because initially we only add nodes with inDegree = 0


import java.util.*;

public class KahnsAlgorithm {

    public List<Integer> topoSort(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];

        // Build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with in-degree 0
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return result;
    }

    // Cycle detection
    public boolean hasCycle(int n, int[][] edges) {
        List<Integer> topo = topoSort(n, edges);
        return topo.size() != n;
    }
}
