package Graphs;

import java.util.Arrays;

public class LC547 {
    public static void main(String[] args) {

        int [][] cities = {{1,0,1},{0,1,0},{1,0,1}};

        findCircleNum(cities);

    }




    // By gpt learned that, think a little longeer


//    Important Insight for number of islands and number of provinces
//
//    Even though both use a matrix, they are conceptually different:
//
//    In Islands:
//    grid[i][j] is actual data at position (i, j)
//    In Provinces:
//    matrix[i][j] is relationship between i and j, not a position in space







        public static int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            int provinces = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    provinces++;
                    dfs(isConnected, visited, i);
                }
            }

            System.out.println(provinces);
            return provinces;
        }

        public static void dfs(int[][] isConnected, boolean[] visited, int city) {
            visited[city] = true;

            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[city][j] == 1 && !visited[j]) {
                    dfs(isConnected, visited, j);
                }
            }
        }
    }


    // I tried to use same trick but failed


    ///  ==============================================================================///

    // For this question we have to check if a connected city is connected to some other city or not in order to make a province.
    // Now that means, if a visited is connected, then we have to check if that city is connected to some other city or not
    // we have to call DFS on such cities.

//    public static int findCircleNum(int[][] isConnected) {
//
//        int provinces = 0;
//
//        for (int i = 0; i < isConnected.length; i++) {
//            for (int j = 0; j < isConnected[0].length; j++) {
//
//                if(isConnected[i][j]==1){
//                    provinces++;
//                    connectedCities(isConnected,i,j);
//
//                }
//
//
//
//            }
//        }
//
//        System.out.println(provinces);
//        return provinces;
//
//    }
//
//    public static void connectedCities(int [][] arr,int i,int j){
//
//        if(i >= arr.length || j >= arr.length){
//            return;
//        }
//        if(i < 0 || j < 0){
//            return;
//        }
//        if(arr[i][j]==0 || arr[i][j] == 2){
//            return;
//        }
//
//
//
//
//        if(arr[i][j] == 1){
//            arr[i][j] = 2;
//        }
//
//        connectedCities(arr, i+1, j);
//
//        connectedCities(arr, i-1, j);
//
//        connectedCities(arr, i, j+1);
//
//        connectedCities(arr, i, j-1);
//    }

