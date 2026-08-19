package QuestionSheetAlpha.ArrayQuestions;

public class MaxiMumSubArraySum {
    // prefix sum



    public static int maxSum(int [] arr){

        int [] prefix = new int[arr.length];
        int idx = 0;
        int Sum=0;
        for( int num : arr){

            Sum += num;
            prefix[idx]= Sum;
            idx++;
        }

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for( int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length;j++){
                if(i == 0){
                    sum = prefix[j];
                }
                else {
                    sum = prefix[j] - prefix[i-1];
                }
                maxSum = Math.max(sum,maxSum);
            }
        }

        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(maxSum(new int[] {-1,2,3,4,5}));
    }
}
