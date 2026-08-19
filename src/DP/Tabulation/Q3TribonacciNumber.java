package DP.Tabulation;

import java.util.Arrays;

public class Q3TribonacciNumber {

    public static void main(String[] args) {

        int n = 5;

        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);


        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }


        System.out.println("Answer :"+ dp[n]);
    }


}
