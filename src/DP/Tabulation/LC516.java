package DP.Tabulation;

import java.util.Arrays;

public class LC516 {

    public static void main(String[] args) {

        String s = "bbbab";

        System.out.println(longestPalindromeSubseq(s));




    }


    // have some issues, must redo and figure out what is happening, might do tomorrow
    // hmm day2 ... hmmmm ... kinda shit
    // might visit few days later
    // hmm.. day 3

    // the way i was looking at tabulation is not correct

/*
This is the mental model I want you to use

Whenever you finish recursion, write this:

Current state: (state variables)

Dependencies:
1.
2.
3.

Then convert every dependency into a directional requirement.
     */

    public static int longestPalindromeSubseq(String s) {

        int n = s.length();
        int [][] dp = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }




//
//        for (int i = 0; i < n; i++) {
//            for (int j  = n-1; j >= 0 ; j--) {
//                if(s.charAt(i)==s.charAt(j)) {
//                    dp[i][j] = 1 + dp[i-1][j+1] ;
//                }
//                else {
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]);
//                }
//            }
//        }






        return dp[n-1][0];


    }


}
