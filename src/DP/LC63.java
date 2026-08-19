package DP;

public class LC63 {


    // attempt 2
    // no help
    // self done
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1){
            return 0;
        }


        Integer [][] dp = new Integer[m][n];

        return solve(0,0,dp,m,n,obstacleGrid);
    }

    public static int solve(int i, int j, Integer [][] dp,int m, int n,int [][] obstacleGrid){

        if(i==m-1 && j == n-1){
            return 1;
        }

        if(i == m){
            return 0;
        }

        if(j == n){
            return 0;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(obstacleGrid[i][j]==1){
            return 0;
        }

        int ans = 0;

        int right = solve(i,j+1,dp,m,n,obstacleGrid);

        if(right!=0){
            ans+=right;
        }

        int down = solve(i+1,j,dp,m,n,obstacleGrid);

        if(down!=0){
            ans+= down;
        }

        return dp[i][j] = ans;

    }
}
