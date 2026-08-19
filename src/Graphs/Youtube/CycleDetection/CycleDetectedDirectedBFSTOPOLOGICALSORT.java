package Graphs.Youtube.CycleDetection;

import Graphs.TraversalsTechiques.Edge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class CycleDetectedDirectedBFSTOPOLOGICALSORT {
    boolean isCycleDirected(ArrayList<ArrayList<Edge>> graph, int V) {
        int[] indegree = new int[V];

        // calculate indegree
        for (int i = 0; i < V; i++) {
            for (Edge e : graph.get(i)) {
                indegree[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // push nodes with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (Edge e : graph.get(node)) {
                int neigh = e.dest;
                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }

        return count != V; // cycle if not all processed
    }
}
