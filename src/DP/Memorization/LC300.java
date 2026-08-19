package DP.Memorization;

public class LC300 {
    public static void main(String[] args) {

//10,9,2,5,3,7,101,18
        int [] nums = {0,1,0,3,2,3};

        System.out.println(lengthOfLIS(nums));

    }


    // attempt 1
//    public static int lengthOfLIS(int[] nums) {
//
//        int n = nums.length;
//
//        // Temporary array for observation
//        int [] ans = new int[n];
//        // Answer
//        int max = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            System.out.println("Current ( nums[i] ) :" + nums[i] + " idx :" +i);
//
//
//            int curr = nums[i];
//            System.out.println("curr :"+ curr+" ");
//            // last value observed
//            int lvO = 0;
//
//
//            int count = 1;
//            for (int j = i; j < n; j++) {
//
//
//                System.out.print("nums[j] :"+ nums[j] + " ");
//                // if current value and lvo is same, then skip
//                if(nums[j] == lvO){
//                    continue;
//                }
//
//                // if current value is greater than curr
//                if(nums[j] > curr){
//
//                    // if current value is smaller than last observed value
//                    if(nums[j] < lvO){
//                        max = Math.max(max,count);
//                        count=2;
//                        lvO = curr;
//                        System.out.println(" " + "Condition : nums[j] < lvO");
//                        System.out.println("lvo :" + lvO);
//                    }
//                    else if(nums[j] > lvO && lvO != curr){
//
//                        System.out.println("Condition : nums[j] > lvO and count value increased : " + count );
//                        count++;
//                        lvO = nums[j];
//                    }
//                }
//
//
//            }
//            max = Math.max(max,count);
//            ans[i] = count;
//            System.out.println();
//        }
//
//        System.out.println(Arrays.toString(ans));
//        return max;
//
//    }
//


    // attempt 2, took help
    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int [] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = function(i,dp,nums);
        }


        int max = 0 ;

        for (int v : dp){
            max = Math.max(v,max);
        }

        return max;
    }

    public static int function(int current, int [] dp, int [] nums){

        if (dp[current] != 0)
            return dp[current];

        int max = 0;
        for (int i = current+1; i < nums.length; i++) {
            if(nums[i] > nums[current]){

               int child = function(i,dp,nums);
                max = Math.max(child,max);
            }
        }

        return dp[current] = max+1;
    }
}
