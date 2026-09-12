package DP.Memorization;

import java.util.*;

public class LC1143 {

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(longestCommonSubsequence(text1,text2));

    }


    // took help


    public static int longestCommonSubsequence(String text1, String text2){

        Integer [][] dp = new Integer[text1.length()][text2.length()];


        int ans =  lcs(text1,text2,0,0,dp);


        for (Integer [] d : dp){
            System.out.println(Arrays.toString(d));
        }

        return ans;

    }

    public static int lcs(String text1, String text2, int i, int j, Integer [][] dp){

        if(i==text1.length() || j == text2.length()){
            return 0;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        int ans ;
        if(text1.charAt(i)==text2.charAt(j)){
            ans = 1 + lcs(text1,text2,i+1,j+1,dp);
        }else {
            ans = Math.max(lcs(text1,text2,i,j+1,dp), lcs(text1,text2,i+1,j,dp));
        }


        return dp[i][j] = ans;




    }













    //
//
//
//    public static int longestCommonSubsequence(String text1, String text2) {
//
//        if(text1.isEmpty() || text2.isEmpty()){
//            return 0;
//        }
//
//        Map<Integer,Set<String>> dp = new HashMap<>();
//
//
//        Set<String> set = new HashSet<>();
//
//
//
//        StringBuilder ans = new StringBuilder();
//
//
//
//        LCS(text1,0,set,ans,dp);
//        LCS2(text2,0,set,ans);
//
//        System.out.println(dp);
//
//
//        int ANSWER = longest;
//        longest = 0;
//        return ANSWER;
//
//    }
//
//    public static void LCS(String text1,int len, Set<String> res,StringBuilder ans,Map<Integer,Set<String>> dp){
//
//        if(len == text1.length()){
//            res.add(new String(ans));
//            if(!ans.isEmpty())
//                ans.deleteCharAt(ans.length()-1);
//            return;
//
//        }
//
//
//        // should retrieve all substrings saved at len
//        if(dp.containsKey(len)){
//            res.addAll(dp.get(len));
//            return;
//        }
//
//
//        LCS(text1,len+1,res,ans.append(text1.charAt(len)),dp);
//
//        dp.put(len,res);
//
////        LCS(text1,len+1,res,ans,dp);
//
//
//
//        dp.put(len,res);
//
//        System.out.println(len);
//        System.out.println(dp.get(len));
//
//    }
//
//    static int longest = 0;
//
//    public static void LCS2(String text1,int len, Set<String> res,StringBuilder ans){
//
//
//
//
//
//        if(len == text1.length()){
//
//            if(res.contains(new String(ans)))
//                longest = Math.max(longest,ans.length());
//            if(!ans.isEmpty())
//                ans.deleteCharAt(ans.length()-1);
//            return;
//        }
//
//
//
//        LCS2(text1,len+1,res,ans.append(text1.charAt(len)));
//        LCS2(text1,len+1,res,ans);
//    }
//
//
//
//
//
//
//
//
//








    // attempt 2 but failed due to order constraint.

    //    public static int longestCommonSubsequence(String text1, String text2){
//
//        // text1 pointer
//        int i = 0;
//
//        // text2 pointer
//        int j = 0;
//
//        char [] text1Arr = text1.toCharArray();
//        Arrays.sort(text1Arr);
//
////        System.out.println(Arrays.toString(text1Arr));
//        char [] text2Arr = text2.toCharArray();
//        Arrays.sort(text2Arr);
//
////        System.out.println(Arrays.toString(text2Arr));
//        StringBuilder ans = new StringBuilder();
//
//        while (i< text1.length() && j < text2.length()){
//
//            if(text1Arr[i] == text2Arr[j]){
//                ans.append(text1Arr[i]);
//                i++;
//                j++;
//            }
//            else {
//
//                if(text1Arr[i] < text2Arr[j]) {
//                    i++;
//                }else {
//                    j++;
//                }
//
//            }
//
//        }
//
//
//
//
//        return ans.length();
//    }
//


    // TLE ofcourse

//     public static int longestCommonSubsequence(String text1, String text2) {
//
//        if(text1.isEmpty() || text2.isEmpty()){
//            return 0;
//        }
//
//        Set<String> set = new HashSet<>();
//
//
//
//        StringBuilder ans = new StringBuilder();
//
//
//
//        LCS(text1,0,set,ans);
//        LCS2(text2,0,set,ans);
//
//
//
//        int ANSWER = longest;
//        longest = 0;
//         return ANSWER;
//
//    }
//
//    // wild backtracking
//
//    public static void LCS(String text1,int len, Set<String> res,StringBuilder ans){
//
//        if(len == text1.length()){
//            res.add(new String(ans));
//            if(!ans.isEmpty())
//                ans.deleteCharAt(ans.length()-1);
//            return;
//        }
//
//        LCS(text1,len+1,res,ans.append(text1.charAt(len)));
//        LCS(text1,len+1,res,ans);
//
//
//    }
//
//    static int longest = 0;
//
//    public static void LCS2(String text1,int len, Set<String> res,StringBuilder ans){
//
//
//
//
//
//        if(len == text1.length()){
//
//            if(res.contains(new String(ans)))
//                longest = Math.max(longest,ans.length());
//            if(!ans.isEmpty())
//                ans.deleteCharAt(ans.length()-1);
//            return;
//        }
//
//
//
//        LCS2(text1,len+1,res,ans.append(text1.charAt(len)));
//        LCS2(text1,len+1,res,ans);
//    }


}
