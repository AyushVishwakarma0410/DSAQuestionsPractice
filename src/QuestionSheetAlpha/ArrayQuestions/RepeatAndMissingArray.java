package QuestionSheetAlpha.ArrayQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RepeatAndMissingArray {

    public static void swap(int []arr, int i , int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int [] missingAndRepeat(int []input){

        int repeatedNumber =0;
        int arraySum = 0;
        for( int num : input){
            arraySum += num;
        }
        int i = 0;
        while (i < input.length){
            int correct = input[i]-1;
            if(input[i] != input[correct]){
                swap(input,i,correct);
            }else {
                i++;
            }
        }

        // gemini code, i have done this question by my logic earlier sommewhere so i am not spending much time on this
        for (int j = 0; j < input.length; j++) {
            // If the value doesn't match the index+1, we found our answer
            if (input[j] != j + 1) {
                return new int[]{input[j], j + 1};
                // input[j] is the duplicate sitting in the wrong spot
                // j+1 is the number that SHOULD be there (the missing one)
            }
        }


        return new int[]{-1,-1};












        //
//        int [] arr = Arrays.stream(input).toArray();
//        int repeatedNumber=0;
//        int sum = 0;
//        int realSum =0;
//
//        for(int i : input){
//            sum += i;
//        }
//        for(int i = 0; i < arr.length;i++){
//            realSum = realSum + i+1;
//            if(arr[i] != i+1){
//                int idx = arr[i]-1;
//
//                swap(arr,i,idx );
//            }
//        }
//
//        for(int i = 0 ; i < arr.length;i++){
//
//            if(i >=1 && arr[i] == arr[i-1]){
//                repeatedNumber = arr[i];
//            }
//        }
//        int missingNumber = realSum -(sum-repeatedNumber);
//
//        return new int[]{repeatedNumber,missingNumber};


    }

    public static void main(String[] args) {


        int[] arr ={3, 1, 2, 5, 3};
        System.out.println(Arrays.toString(missingAndRepeat(arr)));
    }
}
