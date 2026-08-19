package DP.Tabulation;

public class Q2ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(climbingStairs(4));

    }
    public static int climbingStairs(int n){


        if(n <= 1){
            return 1;
        }


        int [] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1; // this line throws error

        for(int i =2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }

}
