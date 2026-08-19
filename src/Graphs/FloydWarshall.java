package Graphs;

public class FloydWarshall {

    static final int INF = 99999;

    public static void floydWarshall(int[][] dist, int V) {

        // k = intermediate vertex
        for (int k = 0; k < V; k++) {

            // i = source
            for (int i = 0; i < V; i++) {

                // j = destination
                for (int j = 0; j < V; j++) {

                    // Relax through k
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {

                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist, V);
    }

    static void printSolution(int[][] dist, int V) {

        System.out.println("Shortest distance matrix:");

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int V = 4;

        int[][] graph = {
                {0,   3, INF, 8},
                {INF, 0,   2, INF},
                {INF, INF, 0,   1},
                {4, INF, INF, 0}
        };

        floydWarshall(graph, V);
    }
}
