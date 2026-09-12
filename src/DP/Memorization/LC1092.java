package DP.Memorization;

public class LC1092 {
    public static void main(String[] args) {


        String str1 = "aaaa";
        String str2 = "bbbb";



        // Self donr
        // reterived LCS from other file because I didn't want to waste time

        System.out.println(shortestCommonSupersequence(str1,str2));
    }


    // attempt 1
    public static String shortestCommonSupersequence(String str1, String str2) {


        String ans = lcs(str1,str2);
        StringBuilder sb = new StringBuilder();

        int i = 0; int j = 0; int k = 0;

        while (i < str1.length() && j < str2.length() && k < ans.length()){
            if(str1.charAt(i)==str2.charAt(j) && str2.charAt(j)==ans.charAt(k)){
                sb.append(str1.charAt(i));
                i++;
                j++;
                k++;
            }
            else if(str1.charAt(i)==ans.charAt(k) && str2.charAt(j)!=ans.charAt(k)){
                sb.append(str2.charAt(j));
                j++;
            }
            else if(str1.charAt(i)!=ans.charAt(k) && str2.charAt(j)==ans.charAt(k)){
                sb.append(str1.charAt(i));
                i++;
            }
            // In case nothing matches
            else {
                sb.append(str1.charAt(i));
                i++;
            }
        }


        sb.append(str1.substring(i));
        sb.append(str2.substring(j));


        return sb.toString();
    }


    public static String lcs(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // dp[i][j] = LCS(text1[i...], text2[j...])
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            if (text1.charAt(i) == text2.charAt(j)) {
                sb.append(text1.charAt(i));
                i++;
                j++;
            }
            else if (dp[i + 1][j] >= dp[i][j + 1]) {
                i++;
            }
            else {
                j++;
            }
        }

        return sb.toString();
    }

}
