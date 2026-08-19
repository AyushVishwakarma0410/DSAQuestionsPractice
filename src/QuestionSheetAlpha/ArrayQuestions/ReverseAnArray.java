package QuestionSheetAlpha.ArrayQuestions;

import java.util.Arrays;

public class ReverseAnArray {

    public static void reverseArray(int [] arr){

        int j = arr.length-1;
        int i = 0;

        while (j >= i){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
            i++;
        }
    }


    public static void main(String[] args) {

            int [] arr = {1,2,3,4,5,6};
            reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
