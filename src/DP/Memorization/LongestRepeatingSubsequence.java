package DP.Memorization;

import java.util.Arrays;
import java.util.HashMap;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {

        HashMap<String,Integer> map = new HashMap<>();

        String s = "axxzxy";

        int [][] dp = new int[s.length()][s.length()];
        for (int [] d : dp)
            Arrays.fill(d,-1);
//        subsequence(s,0,new StringBuilder(),map,new boolean[s.length()]);
//        System.out.println(map);

        int ans = foundSubsequence(s,0,0,dp);

        for (int [] d : dp){
            System.out.println(Arrays.toString(d));
        }
        System.out.println(ans);

    }


    public static int foundSubsequence(String s, int i, int j, int  [][] dp){

        if(i>=s.length() || j >= s.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans;

        if(i != j && s.charAt(i) ==s.charAt(j)){
            ans = foundSubsequence(s,i+1,j+1,dp)+1;
        }
        else {
            ans = Math.max(foundSubsequence(s,i+1,j, dp),foundSubsequence(s,i,j+1, dp));
        }

        return dp[i][j] = ans;

    }




//    public static void subsequence(String s, int idx,StringBuilder sb, HashMap<String,Integer> map,boolean []visited){
//
//        if(idx >= s.length()){
//
//
//            String currentString = sb.toString();
//            if(!map.containsKey(currentString))
//                map.put(currentString, map.getOrDefault(currentString, 0) + 1);
//            else
//                map.put(currentString,map.get(currentString)+1);
//            return;
//        }
//
//
//
//        StringBuilder curr = sb.append(s.charAt(idx));
//
//
//
//        subsequence(s,idx+1,curr,map,visited);
//        sb.deleteCharAt(sb.length()-1);
//        subsequence(s,idx+1,sb,map,visited);
//
//    }
}
