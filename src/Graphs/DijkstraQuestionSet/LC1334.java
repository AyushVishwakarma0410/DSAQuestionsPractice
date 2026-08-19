package Graphs.DijkstraQuestionSet;

import java.util.Arrays;

public class LC1334 {




    // REDO
    // IMPORRTANT
    // Floyd Warshall and neigh count
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int max = Integer.MAX_VALUE;

        int [][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        for (int i = 0; i < edges.length; i++) {
            dist[edges[i][0]][edges[i][1]] = edges[i][2];
            dist[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][k] !=max && dist[k][j] != max && dist[i][k]+dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }


        int resultCity = -1;
        int minReachable = n;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if(i!=j && dist[i][j] <= distanceThreshold){
                    count++;
                }
            }

            if(count <= minReachable){
                minReachable = count;
                resultCity = i;
            }
        }

        return resultCity;
    }
}
