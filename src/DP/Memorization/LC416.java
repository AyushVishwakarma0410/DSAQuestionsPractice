package DP.Memorization;

import java.util.Arrays;

public class LC416 {
    public static void main(String[] args) {

        int [] nums = {1,5,11,5};

        System.out.println(canPartition(nums));
    }

//    public static boolean canPartition(int[] nums) {
//
//
//        int n = nums.length;
//        int max = 0;
//        int [] dp = new int[n];
////        Arrays.sort(nums);
//        for (int i = 0; i < n; i++) {
//            max+=nums[i];
//        }
//
//        for (int i = 0; i < n; i++) {
//            if(check(i,0,nums,max,dp)){
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public static boolean check(int curr,int sum,int [] nums,int max,int [] dp){
//        int n = nums.length;
//        if(dp[curr]!=0){
//            return false;
//        }
//        int val = nums[curr]+sum;
//        max -= nums[curr];
//        dp[curr] = max;
//        if(max==val){
//            return true;
//        }
//        for (int i = curr+1; i < n; i++) {
//
//            if(check(i,val,nums,max,dp)){
//                return true;
//            }
//        }
//        return false;
//    }


// attempt 2


//    public static boolean canPartition(int [] nums){
//        int n = nums.length;
//        int [] dp = new int[n];
//        int max = 0;
//
//        for(int v : nums){
//            max += v;
//        }
//
//        return check(nums,0,dp,0,max);
//
//    }
//
//    public static boolean check(int [] nums,int idx,int [] dp,int accumulated,int remains){
//
//        int nA = accumulated + nums[idx];
//        int nR = remains - nums[idx];
//
//        accumulated += nums[idx];
//        remains -= nums[idx];
//
//
//        if(accumulated==remains){
//            return true;
//        }
//
//        if(dp[idx]==accumulated){
//            return false;
//        }
//
//        dp[idx] = accumulated;
//
//
//            if(check(nums,idx+1,dp,accumulated,remains)){
//                return true;
//            }
//            if(check(nums,idx+1,dp,nA,nR)){
//                return true;
//            }
//
//
//
//        return false;
//    }
        public static boolean canPartition(int [] nums){
            int n = nums.length;
            int max = 0;

            for(int v : nums){
                max += v;
            }


            Boolean [][] dp = new Boolean[n][max+1];

            if(max % 2 != 0){
                return false;
            }

            return check(nums,0,dp,0,max);

        }

        public static boolean check(int [] nums, int idx, Boolean [][] dp,int sum,int remainingSum){
            if(sum==remainingSum){
                return true;
            }
            if(idx== nums.length) return false;

            if (dp[idx][sum] != null)
                return dp[idx][sum];

            int nA = sum + nums[idx];
            int nR = remainingSum - nums[idx];

            if(check(nums,idx+1,dp,sum,remainingSum)){
                dp[idx][sum] = true;
                return true;
            }
            if(check(nums,idx+1,dp,nA,nR)){
                dp[idx][sum] = true;
                return true;
            }


            dp[idx][sum] = false;

            return false;
        }
}
