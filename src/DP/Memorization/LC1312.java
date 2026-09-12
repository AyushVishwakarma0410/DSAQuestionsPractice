package DP.Memorization;

import java.util.Arrays;

public class LC1312 {
    public static void main(String[] args) {

        String s = "leetcode";

        int [][] dp = new int[s.length()+1][s.length()+1];
        for (int [] d : dp)
            Arrays.fill(d,-1);
        System.out.println(minInsertions(s,0,s.length()-1,dp));

    }

    public static int minInsertions(String s,int i, int j,int [][] dp) {



        if(i > j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans;


        if(s.charAt(i) == s.charAt(j)){
            ans = minInsertions(s,i+1,j-1,dp);
        }
        else{
            ans = 1 + Math.min(minInsertions(s,i+1,j,dp),minInsertions(s,i,j-1,dp));
        }


        return dp[i][j] = ans;

    }

//    public static boolean isPalindrome(String s,int  i,int j){
//
//        while (i < j){
//            if(s.charAt(i)!=s.charAt(j)){
//               break;
//            }
//            i++;
//            j--;
//        }
//
//        return i > j;
//    }
}
