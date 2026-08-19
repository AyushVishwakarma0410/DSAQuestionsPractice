package DP.Memorization;

public class LC1049 {
    public static void main(String[] args) {


         int [] arr = {31,26,33,21,40};

        System.out.println(lastStoneWeightII(arr));
    }
    public static int lastStoneWeightII(int[] stones) {

        int max = 0;
        for(int stone : stones){
            max+=stone;
        }

        int n = stones.length;

        Integer [][] dp = new Integer[n][max+1];


        return solve(stones,dp,0,0,max);
    }

    public static int solve(int [] stones, Integer [][] dp, int idx, int current, int remains){

        if(idx==stones.length-1){
            return Math.abs(remains-current);
        }

        if(dp[idx][current]!=null){
            return dp[idx][current];
        }

        int nA = stones[idx] + current;
        int nR = Math.abs(remains-stones[idx]);

        int call1 = solve(stones,dp,idx+1,nA,nR);
        int call2 = solve(stones,dp,idx+1,current,remains);

        return dp[idx][current] = Math.min(call1,call2);

    }

}
