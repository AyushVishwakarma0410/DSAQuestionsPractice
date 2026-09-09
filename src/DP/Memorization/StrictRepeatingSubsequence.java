

// GPT does not take input properly it is an idiotic model sometimes

//package DP.Memorization;
//
//public class StrictRepeatingSubsequence {
//    public static void main(String[] args) {
//
//
//        System.out.println(function1("aaa"));
//    }
//    public static int function1 (String s){
//
//        int n = s.length();
//
//        Integer [][] dp = new Integer[n][n];
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(i != j && s.charAt(i)==s.charAt(j))
//                    ans = Math.max(ans,function2(s,i,j,dp));
//            }
//        }
//
//
//        return ans;
//    }
//
//    public static int function2(String s, int i, int j, Integer [][] dp){
//
//        if(i >= s.length() || j >= s.length()){
//            return 0;
//        }
//
//        int ans;
//
//        if(dp[i][j]!=null){
//            return dp[i][j];
//        }
//
//        if( i!=j &&  s.charAt(i)==s.charAt(j)){
//            ans =1+  function2(s,i+1,j+1,dp);
//        }
//        else {
//            ans = Math.max(function2(s,i+1,j,dp),function2(s,i,j+1,dp));
//        }
//
//
//        return dp[i][j] = ans;
//
//
//    }
//}
