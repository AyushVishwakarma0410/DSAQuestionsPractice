package DP.Memorization;

import java.util.Arrays;

public class Q7HouseRobber2 {


    public static void main(String[] args) {



    }


    public static int rob(int [] nums){


        int n = nums.length;
        int [] dp = new int[n];

        Arrays.fill(dp,-1);


        int ignoredFirst = robbed(nums,dp,n,1);
        Arrays.fill(dp,-1);
        int ignoredLast = robbed(nums,dp,n-1,0);

        return Math.max(ignoredFirst,ignoredLast);


    }

    public static int robbed(int [] nums,int [] dp,int end, int n){


        if(n>=end){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }



        int rob = nums[n] + robbed(nums,dp,end,n+2);
        int notRob = robbed(nums,dp,end,n+1);

        return dp[n] = Math.max(rob,notRob);

    }



}
