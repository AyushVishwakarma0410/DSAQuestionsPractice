package DP.Tabulation;

public class LongestRepeatingSubsequence {


    public static void main(String[] args) {
        String s = "axxzxy";

        System.out.println(foundSubsequence(s));
    }



    public static int foundSubsequence(String s){

        int n = s.length();

        int [][] dp = new int[n+1][n+1];

        for (int i = n-1; i >= 0 ; i--) {
            for(int j = n-1; j>= 0; j--){


                if(i != j && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }

            }
        }



        return dp[0][0];

    }
}
