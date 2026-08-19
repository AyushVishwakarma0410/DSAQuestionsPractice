package Graphs.Youtube.CycleDetection;

import Graphs.TraversalsTechiques.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectedUndirectedBFS {
    boolean isCycleUndirected(ArrayList<ArrayList<Edge>> graph, int V) {
        boolean[] vis = new boolean[V];

        for (int start = 0; start < V; start++) {
            if (!vis[start]) {
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{start, -1}); // {node, parent}
                vis[start] = true;

                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    int node = curr[0];
                    int parent = curr[1];

                    for (Edge e : graph.get(node)) {
                        int neigh = e.dest;

                        if (!vis[neigh]) {
                            vis[neigh] = true;
                            q.add(new int[]{neigh, node});
                        }
                        else if (neigh != parent) {
                            return true; // cycle
                        }
                    }
                }
            }
        }
        return false;
    }
}
