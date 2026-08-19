package DP.Memorization;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {

        int n = 5;
        // always take +1.
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        int ans = fibonacci(n,dp);

        System.out.println(ans);

//        System.out.println(Arrays.toString(dp));
    }
    public static int fibonacci(int n,int [] dp ){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        return dp[n] = fibonacci(n-1,dp) + fibonacci(n-2,dp);
    }

}
