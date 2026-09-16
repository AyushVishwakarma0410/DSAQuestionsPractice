package DP.Memorization;

import java.util.Arrays;

public class LC312 {
    public static void main(String[] args) {

        int [] arr = new int[]{3,1,5,8};
        int [] updated = new int[arr.length+2];
        updated[0] = 1;
        updated[updated.length-1] = 1;
        for (int i = 1; i < updated.length-1;i++){
            updated[i] = arr[i-1];
        }


        System.out.println(maxCoins(updated));
    }

    public static int maxCoins(int[] nums) {

        int [][] dp = new int[nums.length][nums.length];

        for (int [] d : dp)
            Arrays.fill(d,-1);
        return solve(nums,0,nums.length-1,dp);
    }


    public static int solve(int [] nums, int start, int end,int [][] dp){

        if(start+1 >= end){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }


        int ans = Integer.MIN_VALUE;
        for (int i = start+1; i < end;i++){

            ans = Math.max(ans,solve(nums,start,i,dp)+(nums[start]*nums[i]*nums[end])+solve(nums,i,end,dp));

        }


        return dp[start][end] = ans;
    }

}
