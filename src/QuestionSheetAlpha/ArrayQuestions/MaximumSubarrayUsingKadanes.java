package QuestionSheetAlpha.ArrayQuestions;

import java.util.Arrays;

public class MaximumSubarrayUsingKadanes {

    public static int kadane(int [] arr){

        int cs = 0;
        boolean flag = false;



        int negMax = Integer.MIN_VALUE;

        for( int num : arr){

            if(num > 0){
                flag = true;
                break;
            }
            negMax = Math.max(negMax,num);
        }

        // if flag is false, array consists only negatives, return maximum negative.
        if(!flag) return negMax;

        int maxSum = 0;
        for( int i = 0 ; i < arr.length ; i++){

           cs = arr[i] + cs;
           if(cs < 0){
               cs = 0;
           }

           maxSum =  Math.max(cs,maxSum );
        }

        return maxSum;


    }



    public static void main(String[] args) {

        int result = kadane(new int[] {-1,2,-1,4,5});
        System.out.println(result);

    }
}
