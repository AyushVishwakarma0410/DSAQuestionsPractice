package DP.Tabulation;

import java.util.Arrays;

public class LC97 {
    public static void main(String[] args) {


        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        System.out.println(isInterleave(s1,s2,s3));
    }


    public static boolean isInterleave(String s1, String s2, String s3) {



        Boolean [][] dp = new Boolean[s1.length()+1][s2.length()+1];

        Boolean ans = solve(s1,s2,s3,0,0,dp);

        return ans;
    }

    public static boolean solve(String s1, String s2, String s3, int i, int j,Boolean [][] dp){

        int k = i+j;

        if(k==s3.length()){
            return true;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        boolean call1 = false;
        boolean call2 = false;
        if(i < s1.length() && s1.charAt(i)==s3.charAt(k) )
            call1 = solve(s1,s2,s3,i+1,j,dp);
        if(j < s2.length() && s2.charAt(j)==s3.charAt(k)) {
            call2 = solve(s1, s2, s3, i, j + 1, dp);
        }

        return dp[i][j] =  call1 || call2;

    }






//    public static boolean isInterleave(String s1, String s2, String s3) {
//
//        if(s1.length() + s2.length() != s3.length()){
//            return false;
//        }
//
//
//        // pointer for s1
//        int i = 0;
//        // pointer for s2
//        int j = 0;
//        // pointer for s3
//        int k = 0;
//
//
//
//        while (i < s1.length() && j < s2.length()){
//
//            int previ = -1;
//            int prevj = -1;
//
//
//            if(s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k)) {
//                previ = i;
//                prevj = j;
//                while (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k)) {
//                    i++;
//                    j++;
//                    k++;
//                }
//                if (i == s1.length() || s1.charAt(i) != s3.charAt(k)) {
//                    j = prevj;
//                } else if (j==s2.length() || s2.charAt(j) != s3.charAt(k)) {
//                    i = previ;
//                }
//            }
//            else {
//                if (s1.charAt(i) == s3.charAt(k)) {
//                    i++;
//                    k++;
//                } else if (s2.charAt(j) == s3.charAt(k)) {
//                    j++;
//                    k++;
//                }
//            }
//
//
//
//        }
//
//        while (i < s1.length() && s1.charAt(i) == s3.charAt(k)){
//            i++;
//            k++;
//        }
//        System.out.println(s2.charAt(j) +" " + s3.charAt(k));
//        while (j < s2.length() && s2.charAt(j) == s3.charAt(k)){
//            j++;
//            k++;
//        }
//
//
//        return k==s3.length();
//    }
}
