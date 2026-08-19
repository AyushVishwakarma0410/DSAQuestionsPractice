package DP;

public class LC494 {
    public static void main(String[] args) {


        int [] nums = {1,1,1,1,1};
        int target = 3;

        System.out.println(findTargetSumWays(nums,target));
    }


    public static int findTargetSumWays(int [] nums, int target){

        int sum = 0;

        for (int val : nums){
            sum+=val;
        }

        Integer [][] dp = new Integer[nums.length][sum+sum+1];


        return function(nums,target,0,0,dp,sum);

    }

    public static int function(int [] nums,int target,int idx,int curr,Integer [][] dp,int offset){

        if(idx== nums.length){
            return curr==target?1 : 0;
        }


        if(dp[idx][curr+offset]!=null){
            return dp[idx][curr+offset];
        }

        int sum1 = function(nums,target,idx+1,curr+nums[idx],dp, offset);
        int sum2 = function(nums,target,idx+1,curr-nums[idx],dp, offset);

        dp[idx][curr+offset] = sum1 + sum2;
        return dp[idx][curr+offset] = sum1 + sum2;
    }









    










    // losing info
//     public static int TargetSum(int []nums, int target){
//
//
//
//
//
//        int sum = 0;
//
//        for (int val : nums){
//            sum+=val;
//        }
//
//         Boolean [][] dp = new Boolean[nums.length][2*sum+1 ];
//        int start1 = function(nums,target,1,nums[0],dp);
//        int start2 = function(nums,target,1,-nums[0],dp);
//
//        return start1+start2;
//     }
//
//     public static int function(int [] nums, int target, int idx, int curr,Boolean [][] dp){
//
//        if(idx>=nums.length-1){
//            if(curr==target){
//                return 1;
//            }
//            else {
//                return 0;
//            }
//        }
//
//        if(dp[idx][curr]!=null){
//            return dp[idx][curr]?1:0;
//        }
//
//        int sum1 = function(nums,target,idx+1,curr+nums[idx],dp);
//        if(sum1!=0){
//            dp[idx][curr] = true;
//        }
//        int sum2 = function(nums,target,idx+1,curr-nums[idx],dp);
//         if(sum2!=0){
//             dp[idx][curr] = true;
//         }
//
//        return sum1+sum2;
//
//    }
}
//if(idx >= nums.length){
//        return 0;
//        }
//
//
//
//int val1 = curr + nums[idx];
//int val2 = curr - nums[idx];
//
//         if(idx== nums.length-1){
//int reached = 0;
//reached += val1 == target? 1: 0;
//reached += val2 == target ? 1 :0;
//
//        return reached;
//         }
//
//int next1 = function(nums,target,idx+1,val1);
//int next2 = function(nums,target,idx+1,val2);
//
//
//
//        return next1+next2;
