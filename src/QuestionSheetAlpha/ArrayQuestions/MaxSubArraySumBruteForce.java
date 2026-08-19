package QuestionSheetAlpha.ArrayQuestions;

public class MaxSubArraySumBruteForce {

    public static int maxSumOfSubArray(int [] arr){


        // use 0 not Integer,MIN_VALUE if we are doing sum

        int maxSum = 0;
        int SubArraySum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j ; k++) {
                    SubArraySum += arr[k];

                }
                maxSum=Math.max(maxSum,SubArraySum);
                SubArraySum = 0;

            }
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int [] arr = {-1,2,-2,1,2,3,-1,3};

        System.out.println(maxSumOfSubArray(arr));
        System.out.println(Integer.MIN_VALUE);


    }
}
