package Graphs.TraversalsTechiques.AdjacencyMatrix;


import java.util.*;

public class BFSMatrix {

    public static void bfs(int[][] graph, int start) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            // scan full row
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };

        bfs(graph, 0);
    }
}
