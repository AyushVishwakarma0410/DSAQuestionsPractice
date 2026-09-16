package DP.Memorization;

import java.util.Arrays;

public class LC546 {
    public static void main(String[] args) {

        int [] arr = {1,3,2,2,2,3,4 ,3,1};
        int [][] dp = new int[arr.length+1][arr.length+1];
        for (int [] d : dp)
            Arrays.fill(d,-1);
        int ans = (solve(arr,0,arr.length,dp));

        for (int [] d: dp){
            System.out.println(Arrays.toString(d));
        }
        System.out.println(ans);

    }

    public static int solve(int [] arr, int start,int end,int [][] dp){

        if(start+1 > end){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }

        System.out.println(end);
        int ans = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            int past = i-1;
            // the current element
            int curr = arr[i];

            // the freq of current element
            int freq = 1;

            while ( i < arr.length && arr[i]==curr ){
                i++;
                freq++;
            }

            System.out.println(ans);
            ans = Math.max(ans,(freq*freq)+solve(arr,i,end,dp)+solve(arr,start,past,dp));

        }


        return dp[start][end] =  ans;

    }
}
