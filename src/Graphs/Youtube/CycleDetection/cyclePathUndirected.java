package Graphs.Youtube.CycleDetection;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class cyclePathUndirected {
    public static void main(String[] args) {

        int n = 4; // number of nodes

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // initialize graph
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges (undirected)
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 1); // this edge creates the cycle

        // print graph
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " -> " + graph.get(i));
        }

        boolean [] vis = new boolean[n+1];
        int[] parent = new int[n + 1];

        System.out.println(hasCycleDFS(graph,1,vis,-1,parent));
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static boolean hasCycleDFS(ArrayList<ArrayList<Integer>> graph,
                                      int curr, boolean[] vis, int parent, int[] par) {

        vis[curr] = true;

        for (int nei : graph.get(curr)) {
            if (!vis[nei]) {
                par[nei] = curr;

                if (hasCycleDFS(graph, nei, vis, curr, par)) return true;

            } else if (nei != parent) {
                // cycle found → reconstruct path
                printCycle(curr, nei, par);
                return true;
            }
        }

        return false;
    }
    public static void printCycle(int curr, int nei, int[] parent) {
        ArrayList<Integer> path = new ArrayList<>();

        int temp = curr;
        path.add(nei);

        while (temp != nei) {
            path.add(temp);
            temp = parent[temp];
        }

        path.add(nei); // complete cycle

        System.out.println(path);
    }
}