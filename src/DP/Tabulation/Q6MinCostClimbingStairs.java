package DP.Tabulation;

import java.util.Arrays;


/*Dynamic Programming is an optimization technique, not a separate family of algorithms. It solves problems by breaking them into overlapping subproblems and storing their answers so each subproblem is solved only once. It can be implemented using recursion with memoization (top-down) or iteration with tabulation (bottom-up).*/
public class Q6MinCostClimbingStairs {


    public static void main(String[] args) {



        int [] nums = {10,15,20};
        int n = nums.length;
        int [] dp = new int[n+2];

        for (int i = n-1; i >= 0; i--){
            dp[i] = nums[i] + Math.min(dp[i+1],dp[i+2]);
        }

        System.out.println(Math.min(dp[0],dp[1]));


        System.out.println(climbingStairs(nums));
    }

    public static int climbingStairs(int []nums){



        int n = nums.length;
        if(n==0 || n==1){
            return 0;
        }

        int [] dp = new int[n+1];

        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < n ; i++) {
            dp[i] = Math.min(dp[i-1]+nums[i],dp[i-2]+nums[i]);
        }


        return Math.min(dp[n-1],dp[n-2]);

    }
}
