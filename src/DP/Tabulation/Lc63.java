package DP.Tabulation;

public class Lc63 {


    // self done

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        System.out.println(uniquePaths(m,n));
    }
    public static int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;

                int one = 0;
                if(i-1 >= 0){
                    one = dp[i-1][j];
                }
                int two = 0;
                if(j-1 >= 0){
                    two = dp[i][j-1];
                }

                dp[i][j] = one + two;
            }
        }


        return dp[m-1][n-1];

    }
}
