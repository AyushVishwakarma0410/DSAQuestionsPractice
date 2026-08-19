package DP.Memorization;


import java.util.Arrays;

public class LC740DeleteAndEarn {

    public static void main(String[] args) {


        int [] nums = {3,4,2};

        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int [] nums){

        if (nums.length == 0)
            return 0;


        int max = 0;

        for(int val : nums){
            max = Math.max(max,val);
        }

        int[] newArray = new int[max+1];

        for(int val : nums){
            newArray[val] += val;
        }

        int [] dp = new int[max+1];

        Arrays.fill(dp,-1);

        dp[0] = 0;
        if(max >= 1)
            dp[1] = Math.max(newArray[0],newArray[1]);
        return check(max,newArray,dp);

    }

    public static int check(int n,int [] nums, int [] dp){

        if(n==0 || n == 1){
            return dp[n];
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        return dp[n] = Math.max(check(n-1,nums,dp),check(n-2,nums,dp) + nums[n]);

    }
}
