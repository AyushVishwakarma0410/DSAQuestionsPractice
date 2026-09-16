package DP.Tabulation;

import java.util.Arrays;

public class MCMTabulation {

    public static void main(String[] args) {
    }
    public static int MCMTabulation(int [] arr){



        int [][] dp = new int[arr.length][arr.length];

        // because >2 will all be zero as per the base case
        // i = start
        for (int i = arr.length-1; i >= 0; i--) {
            // j = end
            for (int j = i+2; j < arr.length; j++) {

                // works if I put here... but not when I globally place value
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    int curr = arr[i]*arr[k]*arr[j];
                    curr = dp[i][k] + dp[k][j] + curr;
                    dp[i][j] = Math.min(dp[i][j],curr);
                }


            }
        }


        for (int [] d : dp){
            System.out.println(Arrays.toString(d));
        }



        return 0;

    }
}
