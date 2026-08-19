package DP.Tabulation;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {

        int n = 5;

        int [] dp = new int[n+1];



        // Former Answers
        dp[0] = 0;
        dp[1] = 1;

        // building answer based on past answers
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(Arrays.toString(dp));

    }



}
