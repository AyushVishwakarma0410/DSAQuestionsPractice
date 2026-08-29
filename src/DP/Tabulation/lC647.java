package DP.Tabulation;

import DP.Memorization.PalindromeCheckUsingDP;

public class lC647 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(solve(s));
    }

    public static boolean palindrome(String s, int i, int j){

        while (i <= j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static int solve(String s){

        int [][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                int current = palindrome(s,i,j) ?1 : 0;
                dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] + current;
            }
        }


        return dp[0][s.length()-1];

    }
}
