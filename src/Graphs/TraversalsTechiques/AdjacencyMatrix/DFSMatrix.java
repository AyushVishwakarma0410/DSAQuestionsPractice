package Graphs.TraversalsTechiques.AdjacencyMatrix;


public class DFSMatrix {

    public static void dfs(int[][] graph, int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");

        int n = graph.length;

        // scan full row
        for (int v = 0; v < n; v++) {
            if (graph[u][v] == 1 && !visited[v]) {
                dfs(graph, v, visited);
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

        boolean[] visited = new boolean[graph.length];
        dfs(graph, 0, visited);
    }
}
