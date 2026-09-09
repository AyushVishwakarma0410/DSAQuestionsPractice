package DP.Tabulation;

public class LC115 {
    public static void main(String[] args) {

        String s = "rabbbit";

        String t = "rabbit";
        System.out.println(solve(s,t));
    }



    public static int solve(String s, String t){

        int n = s.length()+1;
        int m = t.length()+1;
        int [][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][t.length()] = 1;
        }

        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = t.length()-1;j >= 0 ; j--) {
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }


        return dp[0][0];

    }

}
