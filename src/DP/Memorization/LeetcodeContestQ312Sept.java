package DP.Memorization;

import java.util.Arrays;

public class LeetcodeContestQ312Sept {

    public static void main(String[] args) {


        int n = 33;

        System.out.println(minDays(n));


    }

    public static int minDays(int n) {


        if(n==2){
            return 3;
        }
        if(n==1 || n==0){
            return n;
        }

        int [][][] dp = new int[n+n][n+n][n+n];

        for (int [][] d : dp) {
            for (int[] d1 : d)
                Arrays.fill(d1, -1);
        }

        int ans = solve(0,0,n,1,dp);

        return ans;
    }

    public static int solve(int idx, int currentSum, int n,int streak,int [][][] dp){
        if(currentSum == n){
            return idx;
        }

        if(idx == n+n || currentSum > n){
            return Integer.MAX_VALUE;
        }


        if(dp[idx][currentSum][streak]!=-1){
            return dp[idx][currentSum][streak];
        }


        // take current streak value
        int taken = solve(idx+1,currentSum+streak,n,streak+1,dp);
        // skip current streak value and reset
        int skip = solve(idx+1,currentSum,n,1,dp);

        return dp[idx][currentSum][streak] = Math.min(taken,skip);
    }


}
