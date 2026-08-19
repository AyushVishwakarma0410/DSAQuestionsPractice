package DP.Memorization;

import java.util.Arrays;

public class LC64 {
    public static void main(String[] args) {

        int [][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(grid));


    }

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Integer [][] dp = new Integer[m][n];



        int ans = solve(grid,0,0,dp);
        return ans;
    }

    public static int solve(int [][] grid, int i, int j, Integer [][] dp){


        int m = grid.length;
        int n = grid[0].length;

        if (i == m-1 && j == n-1)
            return grid[i][j];

        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }



        return dp[i][j] = grid[i][j] + Math.min(solve(grid,i+1,j,dp),solve(grid,i,j+1,dp));





        // PLAN BEFORE WRITING ANYTHINGGGGGG
//        int m = grid.length;
//        int n = grid[0].length;
//
//
//
//        if(i==m-1 && j == n-1){
//            return curr+grid[m-1][n-1];
//        }
//
//        if(i >= m ){
//            return -1;
//        }
//        if(j >= n){
//            return -1;
//        }
//
//        curr += grid[i][j];
//
//        int right = solve(grid,curr,i,j+1,dp);
//        int down = solve(grid,curr,i+1,j,dp);
//
//        if(right < 0){
//            return curr + down;
//        }
//        else if( down < 0){
//            return curr + right;
//        }
//
//
//        return curr+Math.min(down,right);
    }
}
