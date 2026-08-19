package DP.Tabulation;

import java.util.Arrays;

public class LC62 {
    public static void main(String[] args) {


        int [][] grid = {
                {1,2},
                {1,1}
        };

        System.out.println(minPathSum(grid));
    }





    public static int minPathSum(int[][] grid) {


        // attempt 1 failed due to ---
        // self done

        // attempt 2
        // passed
        // 100% self done

        int m = grid.length;
        int n = grid[0].length;
        Integer [][] dp = new Integer[m][n];
        dp[0][0] = grid[0][0];


        for(int i = 0; i< m;i++){
            for (int j = 0; j < n; j++) {
                // if starting point
                if(i==0 && j== 0){
                    continue;
                }



                int one ;
                if(i -1 >= 0){
                     one = dp[i-1][j];
                }else {
                    one = Integer.MAX_VALUE;
                }
                int two = 0;
                if(j - 1 >= 0){
                    two += dp[i][j-1];
                }else { // I missed this line
                    two = Integer.MAX_VALUE;
                }


                for (Integer [] d : dp){
                    System.out.println(Arrays.toString(d));
                }

                dp[i][j] = grid[i][j] +  Math.min(one,two);

            }
        }

        for (Integer [] d : dp){
            System.out.println(Arrays.toString(d));
        }
        return dp[m-1][n-1];


    }

}
