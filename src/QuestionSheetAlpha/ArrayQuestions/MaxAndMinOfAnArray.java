package QuestionSheetAlpha.ArrayQuestions;

import java.util.Arrays;

public class MaxAndMinOfAnArray {

    // Question 1 : Maximum and minimum element of an array.
    public static int[] maxAndMin(int [] arr){
        if(arr == null){
            return new int[]{};
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            int current = arr[i];
            if(max < current){
                max =current;
            }
            if(min > current){
                min = current;
            }
        }

        return new int[]{min,max};

    }

    public static void main(String[] args) {

        int [] arr = {-12,-4,1,5,-2,0,4,54,123,0};
        System.out.println(Arrays.toString(maxAndMin(arr)));

    }
}
