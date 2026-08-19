package DP.Tabulation;

import java.util.Arrays;

public class Q4HouseRobber {

    public static void main(String[] args) {

        int [] nums = new int[5];
        int n = nums.length;
        int [] dp = new int[n+1];

        Arrays.fill(dp,-1);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }

//        return dp[n-1];
    }

}/*
def rob(nums):
    prev1 = 0 # Represents dp[i-1]
    prev2 = 0 # Represents dp[i-2]

    for num in nums:
        # The formula in action:
        current = max(prev1, num + prev2)

        # Slide our two variables forward
        prev2 = prev1
        prev1 = current

    return prev1
*/