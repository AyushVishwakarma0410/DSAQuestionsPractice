package DP.Memorization;

import java.util.Arrays;

public class LC132 {
    public static void main(String[] args) {


        String s = "cabababcbc";



        System.out.println(minCut(s));
    }

    public static int minCut(String s) {

        int [][] dp = new int[s.length()+1][s.length()+1];


        for (int [] d : dp)
            Arrays.fill(d,-1);
        return solve(s,0,s.length(),dp);
    }
    public static int solve(String s,int start,int end,int [][] dp){

        if(start > end){
            return 0;
        }


        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        int ans ;

            if(isPalindrome(s,start,end-1)){
                ans = 0;
            }else {
                int min = Integer.MAX_VALUE;
                for (int k = start; k < end;k++){
                    if(isPalindrome(s,start,k))
                        min = Math.min(min,solve(s,k+1,end,dp));
                }
                ans = 1 + min;
            }

        return dp[start][end] = ans;


    }



    public static boolean isPalindrome(String s, int l, int r){

        while (l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;

    }
}
