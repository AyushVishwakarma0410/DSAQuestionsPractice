package QuestionSheetAlpha.ArrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestConcatenationNumber {



    public static String largestConcatNumber(int [] arr){


        String[] numbers = new String[arr.length];
        int i = 0;

        for( int num : arr){
            numbers[i] = Integer.toString(num);
            i++;
        }
        Arrays.sort(numbers,(a,b)->(b+a).compareTo(a+b));

        if (numbers[0].equals("0")) {
            return "0";
        }
        StringBuilder answer= new StringBuilder();
        for(String s : numbers){
            answer.append(s);
        }

        return answer.toString();



    }


    public static void main(String[] args) {
        int [] arr = {97,8,32,10,5};
       String s =  largestConcatNumber(arr);

        System.out.println(s);

    }
}
