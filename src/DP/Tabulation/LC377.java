package DP.Tabulation;

import java.util.Arrays;

public class LC377 {
    public static void main(String[] args) {


        int [] nums = {1,2,3};
        int target = 4;

        System.out.println(combinationSum4(nums,target));

    }

    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;

        // number of ways to reach i
        int [] dp = new int[target+1];

        dp[0] = 1;

        // each individual number
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if(i - num >= 0)
                    dp[i] += dp[i - num];
            }


        }

        System.out.println(Arrays.toString(dp));
        return dp[target];

    }
}
