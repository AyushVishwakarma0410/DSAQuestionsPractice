package DP.Tabulation;

import java.util.Arrays;

public class Q7HouseRobber2 {
    public static void main(String[] args) {


        // self done
        int [] nums = {2,7,9,3,1,4};



        int n = nums.length;
//
//        if(n==0) return 0;
//
//        if(n==1) return nums[0];
//
//        if(n==2) return Math.max(nums[0],nums[1]);


        int [] dp = new int[n+1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length-1; i++) {

            dp[i] = Math.max(dp[i-1],nums[i]+ dp[i-2]);

        }

        int ignoredLast = dp[n-2];

        
        dp = new int[n];

        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-1],nums[n-2]);

        for (int i = n-3; i >= 1; i--) {
            dp[i] = Math.max(dp[i+1],nums[i]+dp[i+2]);
        }

        int ignoredFirst = dp[1];

        System.out.println(Arrays.toString(dp));

//        return Math.max(ignoredFirst,ignoredLast);
    }
}
