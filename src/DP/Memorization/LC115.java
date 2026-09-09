package DP.Memorization;

import java.util.Arrays;
import java.util.HashMap;

public class LC115 {
    public static void main(String[] args) {


        String s = "rabbbit";

        String t = "rabbit";

//        System.out.println(solve(s,"rabbit",0,new StringBuilder()));


        System.out.println(numDistinct(s,t));
    }


    public static int numDistinct(String s, String t) {

        int [][] dp = new int[s.length()][t.length()];

        for(int [] d : dp)
            Arrays.fill(d,-1);

         int ans =  solve(s,t,0,0,dp);

         for (int [] d : dp){
             System.out.println(Arrays.toString(d));
         }
        return ans;
    }

    public static int solve(String s, String t, int i,int j,int [][] dp){


        if(j >= t.length()){
            return 1;
        }

        if(i >= s.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans;
        if(s.charAt(i)==t.charAt(j)){
            int take =  solve(s,t,i+1,j+1,dp);
            int doNot = solve(s,t,i+1,j,dp);

            ans = take+doNot;
        }
        else {
            ans = solve(s,t,i+1,j,dp);
        }

            return dp[i][j] = ans;
    }














    // BRUTE FORCE PASSED 46/66 -> almost 70% passed


//
//    public static int solve(String s, String t,int idx,StringBuilder sb){
//
//        if(idx >= s.length()){
//            if(sb.toString().equals(t))
//                return 1;
//            else
//                return 0;
//        }
//
//
//
//
//        StringBuilder New = sb.append(s.charAt(idx));
//
//        int take = solve(s,t,idx+1,New);
//        sb.deleteCharAt(sb.length()-1);
//        int skip = solve(s,t,idx+1,sb);
//
//
//
//        return   take+skip;
//
//    }
}
