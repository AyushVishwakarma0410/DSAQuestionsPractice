package QuestionSheetAlpha.ArrayQuestions;

public class MaximumProductSubArray {

    public static int maxProduct(int[] nums) {
            int maxSoFar = nums[0];
            int minSoFar = nums[0];
            int result = maxSoFar;

            for(int i = 1; i < nums.length; i++){
                int current = nums[i];

                if( current < 0){
                    int temp = maxSoFar;
                    maxSoFar = minSoFar;
                    minSoFar = temp;
                }

                maxSoFar = Math.max(current, maxSoFar * current);
                minSoFar = Math.min(current, minSoFar * current);

                result = Math.max(maxSoFar, result);
            }

            return result;

    }

    public static void main(String[] args) {
        int [] arr ={2,3,-2,4};

        System.out.println( maxProduct(arr));
    }
}
