package DP.Memorization;

import java.util.Arrays;

public class MCM {


    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40};

        // 1. Create the DP table
        int[][] dp = new int[nums.length][nums.length];

        // 2. Initialize all values in the DP table to -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(MCM(nums, 0, nums.length - 1, dp));
    }

    public static int MCM(int [] nums,int start, int end,int [][] dp){
        if (start+1>=end){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }

        int product =Integer.MAX_VALUE;


        for (int i = start+1; i < end; i++) {
            int current = MCM(nums,start,i,dp)+(nums[start]*nums[i]*nums[end])+MCM(nums,i,end,dp);
            product = Math.min(product,current);
        }

        return  dp[start][end] = product;
    }
}
