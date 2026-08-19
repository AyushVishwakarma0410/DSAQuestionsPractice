package DP.Tabulation;

public class LC740DeleteAndEarn {

    public static void main(String[] args) {

        int [] nums = {0};

        System.out.println(deleteAndEarn(nums));


    }

    public static int deleteAndEarn(int [] nums){

        if (nums.length == 0)
            return 0;


        int max = 0;

        for(int val : nums){
            max = Math.max(max,val);
        }

        int[] newArray = new int[max+1];

        for(int val : nums){
            newArray[val] += val;
        }

        int [] dp = new int[max+1];
        dp[0] = nums[0];
        if(max >=1)
            dp[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < newArray.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+newArray[i]);
        }


        return dp[max];


    }


}
