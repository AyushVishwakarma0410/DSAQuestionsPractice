package DP.Memorization;

import java.util.ArrayList;
import java.util.Arrays;

public class LC5 {
    public static void main(String[] args) {


        String s = "aaa";


        String [][] dp = new String[s.length()+1][s.length()+1];
        Boolean [][] dp2 = new Boolean[s.length()][s.length()];

        longestPalindrome(s,0,s.length(),dp,dp2);


        for (String [] d : dp){
            System.out.println(Arrays.toString(d));
        }
        System.out.println("BOOLEAN :");

        for (Boolean [] b : dp2){
            System.out.println(Arrays.toString(b));
        }




    }



    public static boolean isPalindromeDP(String s, int i, int j, Boolean [][] dp){

        if(i >= j){
            return true;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(s.charAt(i)!=s.charAt(j)){
            return dp[i][j] = false;
        }

        return dp[i][j] = isPalindromeDP(s,i+1,j-1,dp);

    }



    public static boolean isPalindrome(String s, int i, int j){


        while (i <= j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }

        return i > j;
    }

    public static String longestPalindrome(String s,int i, int j,String [][] dp,Boolean [][] dp2){

        if( i > j){
            return "";
        }


        if(dp[i][j]!=null){
            return dp[i][j];
        }
//        if(isPalindrome(s,i,j-1)){
//                return dp[i][j] = s.substring(i,j);
//        }

        if(isPalindromeDP(s,i,j-1,dp2)){
            return dp[i][j] = s.substring(i,j);
        }

        String iPush = longestPalindrome(s,i+1,j,dp,dp2);
        String jPush = longestPalindrome(s,i,j-1,dp,dp2);


        if(jPush.length() >= iPush.length()){
            return dp[i][j] =  jPush;
        }else {
            return dp[i][j] = iPush;
        }
    }
}
