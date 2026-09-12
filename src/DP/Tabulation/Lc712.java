package DP.Tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Lc712 {

    public static void main(String[] args) {


        // self done

        String s = "delete";
        String s2 = "leet";

        System.out.println(minimumDeleteSum(s,s2));

    }


    public static int minimumDeleteSum(String s1, String s2){


        int [][] dp = new int[s1.length()+1][s2.length()+1  ];

        for (int [] d : dp){
            Arrays.fill(d,-1);
        }

        return  solve(s1,s2,0,0,dp);
    }


    public static int solve(String s1, String s2,int i ,int j,int [][] dp){

        if(i >= s1.length() && j >= s2.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }


        // added new base cases by gpt, because I was too focused on solving early

        //------------------------------------------------------------------------------------------------//
        if(i >= s1.length()){
            return s2.charAt(j) + solve(s1,s2,i,j+1,dp);
        }

        if( j >= s2.length()){
            return s1.charAt(i) + solve(s1,s2,i+1,j,dp);
        }

        //-------------------------------------------------------------------------------------------------//

        int sum ;
        if(s1.charAt(i)==s2.charAt(j)){
            sum = solve(s1,s2,i+1,j+1,dp);
        }
        else {
            sum =  Math.min(s1.charAt(i)+solve(s1,s2,i+1,j,dp), s2.charAt(j) + solve(s1,s2,i,j+1,dp));
        }

        return dp[i][j] =  sum;
    }






    // 39 min 24 seconds TLE //
//
//
//    public static void LCs(String s1,String s2, int [][] dp){
//        for (int i = 1; i <= s1.length(); i++) {
//            for (int j = 1; j <= s2.length(); j++) {
//
//                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                    dp[i][j] = 1 + dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//    }
//    public static int minimumDeleteSum(String s1, String s2) {
//
//        int[][] dp = new int[s1.length()+1][s2.length()+1];
//        LCs(s1,s2,dp);
//        List<String> LCSs = allLCS(s1, s2, s1.length(), s2.length(), dp);
//
//        System.out.println(LCSs);
//
//        int res = Integer.MAX_VALUE;
//
//        for(String ans : LCSs) {
//            int sum = 0;
//            int i = 0;
//            int j = 0;
//            int k = 0;
//
//            while (i < s1.length() && j < s2.length() && k < ans.length()) {
//
//                if (s1.charAt(i) == ans.charAt(k) && ans.charAt(k) == s2.charAt(j)) {
//                    i++;
//                    j++;
//                    k++;
//                } else if (s1.charAt(i) != ans.charAt(k) && s2.charAt(j) == ans.charAt(k)) {
//                    sum += s1.charAt(i);
//                    i++;
//                } else if (s2.charAt(j) != ans.charAt(k) && s1.charAt(i) == ans.charAt(k)) {
//                    sum += s2.charAt(j);
//                    j++;
//                } else {
//                    sum += s1.charAt(i);
//                    i++;
//                }
//
//            }
//
//            for (int l = i; l < s1.length(); l++) {
//                sum += s1.charAt(l);
//            }
//
//            for (int l = j; l < s2.length(); l++) {
//                sum += s2.charAt(l);
//            }
//
//            res = Math.min(sum,res);
//        }
//        return res;
//    }
//
//
//    public static List<String> allLCS(String s1, String s2,
//                                      int i, int j, int[][] dp) {
//
//        if (i == 0 || j == 0) {
//            List<String> base = new ArrayList<>();
//            base.add("");
//            return base;
//        }
//
//        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//
//            List<String> prev = allLCS(s1, s2, i - 1, j - 1, dp);
//
//            List<String> result = new ArrayList<>();
//
//            for (String str : prev) {
//                result.add(str + s1.charAt(i - 1));
//            }
//
//            return result;
//        }
//
//        List<String> result = new ArrayList<>();
//
//        if (dp[i - 1][j] == dp[i][j]) {
//            result.addAll(allLCS(s1, s2, i - 1, j, dp));
//        }
//
//        if (dp[i][j - 1] == dp[i][j]) {
//            result.addAll(allLCS(s1, s2, i, j - 1, dp));
//        }
//
//        return new ArrayList<>(new HashSet<>(result));
//    }
}
