package DP.Memorization;

import java.util.Arrays;

public class LC343IntegerBreak {


    public static void main(String[] args) {


        int n = 8;

        System.out.println(integerBreak2(n));
    }
    public static int integerBreak2(int n){


        if(n<=2){
            return 1;
        }
        if(n==3){
            return 2;
        }

        int [] dp = new int[n+1];

        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        return solve(n,dp);


    }

    public static int solve(int n, int [] dp){

        // base cases
        if(n<=2){
            return n;
        }

        if(n==3){
            return 2;
        }

        // Return memoized result if already calculated
        if (dp[n] != -1) {
            return dp[n];
        }


        int ans = 0;
        for (int i = 1; i < n;i++){
            int num = n - i;
            int bestR = Math.max(num,solve(num,dp));
            ans = Math.max(bestR*i,ans);
        }

        return dp[n] = ans;
        
        
    }






    // only recursion self done

    public static int integerBreak(int n) {


        // base cases
        if(n<=2){
            return n;
        }
        if(n==3){
            return 2;
        }


        int ans = 0;
        for (int i = 1; i < n;i++){
            int num = n - i;
            ans = Math.max(integerBreak(num)*i,ans);
        }

        return ans;

    }

}
