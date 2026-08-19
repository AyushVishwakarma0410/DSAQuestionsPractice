package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

// self done
public class LC329 {
    public static void main(String[] args) {
        int [][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }
    public static int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // store values
        int [][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int trav = dfs(matrix,i,j,dp,-1,-1);
                dp[i][j] = trav;
                max = Math.max(trav,max);
            }
        }

        return max;

    }


    public static int dfs(int [][] matrix, int i, int j, int [][] dp,int pi, int pj){



        if(i < 0 || j < 0){
            return 0;
        }

        if(i >= matrix.length || j >= matrix[0].length){
            return 0;
        }

        if(pi != -1 && pj != -1 && matrix[i][j] <= matrix[pi][pj]){
            return 0;
        }

        if(dp[i][j]!=0){
            return dp[i][j];
        }



        int up = dfs(matrix,i-1,j,dp,i,j);
        int down = dfs(matrix,i+1,j,dp,i,j);
        int left = dfs(matrix,i,j-1,dp,i,j);
        int right = dfs(matrix,i,j+1,dp,i,j);

        int best = Math.max(Math.max(up,right),Math.max(down,left));

        dp[i][j] = best+1;

        return dp[i][j];
    }


    public static int longestIncreasingPath2(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;


        int [][] outDegree = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        int [][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        for (int i = 0; i < m ; i++) {

            for (int j = 0; j < n ; j++) {

                int outD = 0;


                // calculate outdegree
                for (int [] dir : directions){

                    int newR = i + dir[0];
                    int newC = i + dir[1];

                    if(newR >= 0 && newR < m && newC >= 0 && newC < n ){

                        if(matrix[newR][newC] > matrix[i][j]){
                            outD++;
                        }

                    }

                }

                outDegree[i][j] = outD;
                if(outD==0){
                    q.add(new int[]{i,j});
                }


            }
        }






        int len = 0;
        while (!q.isEmpty()){

            int size = q.size();


            len++;
            for (int i = 0 ; i < size; i++ ) {


                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {

                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR >= 0 && newC >= 0 && newR < m && newC < n) {
                        outDegree[newR][newC]--;

                        if (outDegree[newR][newC] == 0) {
                            q.add(new int[]{newR, newC});
                        }
                    }
                }
            }


        }


        return len;
    }

}
