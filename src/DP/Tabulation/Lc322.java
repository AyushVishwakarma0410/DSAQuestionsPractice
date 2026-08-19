package DP.Tabulation;
import java.util.Arrays;

public class Lc322 {
    public static void main(String[] args) {
        int [] coins = {186,419,83,408};
        int amount = 6249;
//        int ans = 0;
//        int n = coins.length;
//        for (int i = n-1; i >= 0 ; i--) {
//            while (coins[i] <= amount){
//                amount-=coins[i];
//                ans++;
//            }
//        }
//
//        if(amount==0){
//            System.out.println(ans);
//        }else {
//            System.out.println(-1);
//        }


        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {


        // freq of coins used to reach i
        int [] dp = new int[amount+1];

        Arrays.fill(dp,amount+1);
        dp[0]= 0;

        // for each amount from 0 to target amount
        for (int i = 1; i <= amount; i++) {

            // using each coin given in coins array
            for(int coin : coins){

                // if the given coin is smaller than the current amount (i)
             if(i - coin >= 0){
                 dp[i] = Math.min(dp[i],dp[i-coin]+1);
             }

            }
        }



        return dp[amount]> amount?-1:dp[amount];
    }


}
