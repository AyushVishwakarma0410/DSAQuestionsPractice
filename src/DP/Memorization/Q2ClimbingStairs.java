package DP.Memorization;

import java.util.Arrays;

public class Q2ClimbingStairs {


    public static void main(String[] args) {

        int [] dp = new int[6];
        Arrays.fill(dp,-1);
        System.out.println(climbingStairs(5,dp));
    }


    public static int climbingStairs(int n, int [] dp){

        if(n==0 || n==1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = climbingStairs(n-1,dp) + climbingStairs(n-2,dp);
    }
}
