package DP.Memorization;

import java.util.Arrays;

public class Q4HouseRobber {
    public static void main(String[] args) {
    }



    public int rob(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }


        int [] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        int ans = call(nums.length-1,dp,nums);

        return ans;
    }

    public static int call(int n, int [] dp, int [] nums){

        if(dp[n]!=-1){
            return dp[n];
        }


        return dp[n] = Math.max(call(n-1,dp,nums),nums[n]+call(n-2,dp,nums));

    }
}
