package DP.Tabulation;

public class LC583 {
    public static void main(String[] args) {


        String s1 = "leetcode";
        String s2 = "etco";

        System.out.println(minDistance(s1,s2));
    }
    public static int minDistance(String word1, String word2) {


        int ans = lcs(word1,word2);
//        System.out.println(ans);
        int m = word1.length()-ans;
//        System.out.println(m);
        int n=word2.length()-ans;
//        System.out.println(n);
        return m+n;


    }

    public static int lcs(String text1, String text2) {




        int m = text1.length();
        int n = text2.length();


        int [][] dp = new int[m+1][n+1];

        for (int i = m-1; i >= 0 ; i--) {
            for (int j = n-1; j >= 0 ; j--) {

                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }

            }
        }


        return dp[0][0];
    }
}
