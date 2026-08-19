package QuestionSheetAlpha.ArrayQuestions;

import java.util.Arrays;

public class productOfArrayExceptSelf {

    public  static int[] productExceptSelf(int[] nums) {


        // basically a prefix product method rather than prefix sum, in which 2 separate arrays are formed and their values are stored, debug to understand
        int [] answer = new int[nums.length];
        int [] left = new int [nums.length];
        int [] right = new int[nums.length];

        // always considering the past products not the targeted one
        left[0] = 1;
        for(int i = 1; i < nums.length;i++){
            left[i] = left[i-1] * nums[i-1];
        }

        // always considering the past products and not considering the current number
        right[nums.length-1] = 1;
        for(int j = nums.length-2; j >= 0;j--){
            right[j] = right[j+1] * nums[j+1];
        }

        // multiplying values
        for( int i = 0; i < nums.length;i++){
            answer[i] = left[i]*right[i];
        }







//            // brute force, correct logic but will fail constraints
//            int product = 1;
//               boolean flag = false;
//            int [] answer = new int[nums.length];
//
//
//            for(int i =0; i < nums.length ;i++){
//                for(int j = 0; j < nums.length;j++){
//                    if(j == i){
//                        continue;
//                    }
//                    product *= nums[j];
//                }
//                answer[i] = product;
//                product = 1;
//
//            }
//





            //            for(int i : nums){
//                if(i==0){
//                    flag= true;
//                    continue;
//                }
//                product *= i;
//            }
//            int [] answer = new int [nums.length];
//            for(int i =0; i < nums.length; i++){
//                if(flag) {
//                    if (nums[i] != 0) {
//                        answer[i] = 0;
//                    } else {
//                        answer[i] = product;
//                    }
//                    continue;
//                }
//                answer[i] = product/nums[i];
//            }
            return answer;
    }



    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        System.out.println(Arrays.toString( productExceptSelf(arr)));
    }
}
