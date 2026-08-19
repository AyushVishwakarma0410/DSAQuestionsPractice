package DP.Memorization;

public class LC62 {

    // attempt after long time, didnt remember clearly what to do
    // self done great attempt directly on leetcode
    public int uniquePaths(int m, int n) {

        Integer [][] dp = new Integer[m][n];

        return solve(0,0,dp,m,n);


    }

    public static int solve(int i, int j, Integer [][] dp,int m, int n){

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

        int ans = 0;

        int right = solve(i,j+1,dp,m,n);

        if(right!=0){
            ans+=right;
        }

        int down = solve(i+1,j,dp,m,n);

        if(down!=0){
            ans+= down;
        }

        return dp[i][j] = ans;

    }
}
