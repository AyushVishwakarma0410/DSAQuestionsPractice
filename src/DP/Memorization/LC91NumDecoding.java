package DP.Memorization;

import java.util.Arrays;

public class LC91NumDecoding {
    public static void main(String[] args) {


        String s = "12";
        int [] dp = new int[s.length()+1];

        Arrays.fill(dp,-1);
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        };
        System.out.println(numDecodings(s,dp,2));

    }



    // forward recursion is literally iterative approach
    public static int numDecodings(String s, int [] dp, int idx){

        if(idx > s.length()){
            return dp[s.length()];
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int current = 0;

        int oneDigit = s.charAt(idx - 1) - '0';

        if (oneDigit != 0) {
            current += dp[idx - 1];
        }

        int twoDigit = Integer.parseInt(s.substring(idx - 2, idx));

        if (twoDigit >= 10 && twoDigit <= 26) {
            current += dp[idx - 2];
        }

        dp[idx] = current;
        return numDecodings(s,dp,idx+1);

    }

    public static int numDecoding(String s, int [] dp, int n){


        if(n==0){
            return 1;
        }

        if(n==1){
            if(s.charAt(0)-'0'==0){
                return dp[1] = 0;
            }
        }

        if(dp[n]!=-1){
            return dp[n];
        }




        int current = 0;
        int oneDigit = s.charAt(n - 1) - '0';

        if (oneDigit != 0) {
            current += numDecodings(s,dp,n-1);
        }

        int twoDigit = Integer.parseInt(s.substring(n - 2, n));

        if (twoDigit >= 10 && twoDigit <= 26) {
            current += numDecodings(s,dp,n-2);
        }




        return dp[n] = current;


    }
}
