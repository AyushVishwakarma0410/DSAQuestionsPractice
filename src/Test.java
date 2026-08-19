import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class Test {


    
    public static void main(String[] args) {

//        long mod = 1000000000 + 7;
//
//        int sum = 0;
//
//        int [] nums = {1,2,-3,-4,0};
//
//        for (int i = 0; i < nums.length; i++) {
//            sum = nums[i] > 0 ? nums[i]+sum : sum;
//        }
//
//
//
//        System.out.println(15%mod);
        int [] nums = {4,0,-1,-2,3,1,-1};
        int [][] queries = {{3,1},{0,-2},{1,-1},{0,-2},{5,4},{6,-3},{6,-2},{2,-1}};

        System.out.println(maximumSumSubsequence(nums,queries));
    }

    /// worked for test cases but should fail on submit


    static long MOD = 1000000000 + 7;



    public static int maximumSumSubsequence(int[] nums, int[][] queries) {

        long TotalSum = 0;


// iterating queries
        for(int i = 0 ; i < queries.length; i++){
            int pos = queries[i][0];
            int val = queries[i][1];

            nums[pos] = val;
            long sum = 0;
// collecting sum
            boolean isSelected = false;
            for(int j = 0; j < nums.length; j++){
                if(!isSelected){

                    // Attempt : 2 -> cannot select two adjacent
                    // sum = nums[j] >0 &&  ? sum+nums[j]:sum + 0;
                    if(nums[j] > 0){
                        sum+=nums[j];
                        isSelected = true;
                    }
                }
                else{
                    isSelected = false;
                }
            }

            TotalSum += sum;

            System.out.println("Nums :" + Arrays.toString(nums));
            System.out.println("Total Sum :" + TotalSum);

        }



        return (int)(TotalSum % MOD);
    }
}
