package DP.Memorization;

public class LC377CombinationSum4 {

    public static void main(String[] args) {

        int [] nums = {1,2,3};
        int target = 4;


        Integer [][] dp = new Integer[nums.length][target+1];
        System.out.println(combinationSum4(nums,target,0,dp));

    }



    public static int combinationSum4(int[] nums, int target,int idx,Integer[][] dp) {

        if(idx >= nums.length){
            return 0;
        }

        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }

        if(dp[idx][target]!=null){
            return dp[idx][target];
        }


        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(target-nums[i]>=0)
                ans+= combinationSum4(nums,target-nums[i],i,dp);
        }


        return dp[idx][target] = ans;



    }






    // recursion -> TLE

//    public static int combinationSum4(int[] nums, int target,int idx) {
//
//        if(target==0){
//            return 1;
//        }
//        if(target<0){
//            return 0;
//        }
//
//        int ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(target-nums[i]>=0)
//                ans+= combinationSum4(nums,target-nums[i],idx+1);
//        }
//
//
//        return ans;
//
//
//
//    }
//

}
