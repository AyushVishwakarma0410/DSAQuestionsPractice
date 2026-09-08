package DP.Tabulation;

import java.util.Arrays;

public class LC5 {
    public static void main(String[] args) {


        String s = "aacabdkacaa";


        System.out.println(longestPalindrome(s));
    }


//    public static boolean isPalindromeDP(String s, int i, int j, Boolean [][] dp){
//
//        if(i >= j){
//            return true;
//        }
//
//        if(dp[i][j]!=null){
//            return dp[i][j];
//        }
//
//        if(s.charAt(i)!=s.charAt(j)){
//            return dp[i][j] = false;
//        }
//
//        return dp[i][j] = isPalindromeDP(s,i+1,j-1,dp);
//
//    }
//




    public static String longestPalindrome(String s){

        boolean [][] dp = new boolean[s.length()][s.length()];


        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }


        int start = 0;
        int last = 0;


        for (int i = s.length()-1; i >= 0 ; i--){
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i)==s.charAt(j) && (i +1 > j-1 ||  dp[i+1][j-1])){
                    dp[i][j] = true;
                if(last - start+1 <= j-i+1){
                    last = j;
                    start = i;
                }

                }else {
                    dp[i][j] = false;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.println("Idx :"+ i + " " + Arrays.toString(dp[i]));
        }

        return s.substring(start,last+1);



    }





}
