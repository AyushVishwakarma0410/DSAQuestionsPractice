package DP.Memorization;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {


        int [] arr = {1,2,3,4,5};

        int [][] dp = new int[arr.length][arr.length];

        for (int [] d : dp){
            Arrays.fill(d,-1);
        }

        System.out.println(MCM(arr,0,arr.length-1,dp));

        for (int [] d : dp){
            System.out.println(Arrays.toString(d));
        }

        System.out.println(MCMTabulation(arr));

    }

    public static int MCM(int [] arr, int start, int end,int [][] dp){

        if(start+1 >= end ){
            return 0;
        }


        if(dp[start][end]!=-1){
            return dp[start][end];
        }

        int ans = Integer.MAX_VALUE;

        // we put range division in this
        for (int i = start+1 ; i < end; i++ ){
            int curr = arr[start] * arr[i] * arr[end];
            ans = Math.min(ans,curr + MCM(arr,start,i,dp) + MCM(arr,i,end,dp));
        }

        return dp[start][end] = ans;
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
