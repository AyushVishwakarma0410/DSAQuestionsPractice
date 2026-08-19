package DP.Memorization;

import java.util.Arrays;

public class LC322CoinChange {

    public static void main(String[] args) {
        int [] nums = {3};
        int n = 2;

        System.out.println(solve(nums,n));
    }
    public static int solve(int [] nums,int amount){

        int n = nums.length;
        int [] dp = new int[amount+1];

        Arrays.fill(dp,Integer.MAX_VALUE-1);

        int ans = call(nums,dp,amount);
        return ans > amount ? -1 : ans;
    }

    public static int call(int [] nums, int [] dp, int amount){


        if(amount==0){
            return 0;
        }

        if(amount<0){
            return Integer.MAX_VALUE-1;
        }

        if(dp[amount]!=Integer.MAX_VALUE-1){
            return dp[amount];
        }

        int ans = Integer.MAX_VALUE-1;

        for (int i = 0; i < nums.length; i++) {
            int result = Math.min(ans, call(nums,dp, amount -nums[i]));

            if(result != Integer.MAX_VALUE-1){
                ans = Math.min(ans,result+1);
            }
        }


        return dp[amount] = ans;
    }

}
