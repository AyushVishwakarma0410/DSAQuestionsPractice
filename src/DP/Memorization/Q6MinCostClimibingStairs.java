package DP.Memorization;

import java.util.Arrays;

public class Q6MinCostClimibingStairs {

    public static void main(String[] args) {


        System.out.println(climbingMinCostRecursion(new int[]{10,15,20},0,0,Integer.MAX_VALUE));
    }


    // some self done bullshit I have done, first I did recursion then I added DP, It may be the right way
    public static int climbingMinCostRecursion(int [] nums, int n, int ans,int min){


        int [] dp = new int[nums.length+1];

        Arrays.fill(dp,-1);
        int val1 = call(nums,1,dp);


        int val2 = call(nums,0,dp);


        return Math.min(val1,val2);
    }



    // revised many times but always get confused, therefore
    // Dp is nothing, just saving answers
    // we do recursion, we find every possible solution
    // and we return back the smallest sum.
    public static int call(int [] nums, int n, int [] dp){

        if(n>=nums.length){
            return 0;
        }

        if(dp[n]!=-1){

            return dp[n];
        }

        int val1 = nums[n] + call(nums,n+1,dp);
        int val2 = nums[n] + call(nums,n+2,dp);


        return dp[n] = Math.min(val1,val2);


    }

}
