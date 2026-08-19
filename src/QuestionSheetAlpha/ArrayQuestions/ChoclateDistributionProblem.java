package QuestionSheetAlpha.ArrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class ChoclateDistributionProblem {

    public static int chocolateDistribution(int [] arr, int m){



        // overcomplicated but still done it -> used gemini not proud on myself but i also mentioned where and what he has done
        Arrays.sort(arr);

        ArrayList<Integer> check = new ArrayList<>();

        for( int i = 0; i < m;i++){
            check.add(arr[i]);
        }


        int max = Collections.max(check);
        int min = Collections.min(check);


        int difference = max - min;

        int right = m;

        while (right < arr.length){
//            System.out.println(arr[left]); // gemini helped in here only i removed left variable and just used remove(0) method -> rest of this is mine
//            check.remove(check.get(0));
            check.remove(0);
            check.add(arr[right]);
            max = Collections.max(check);
            min = Collections.min(check);

            difference = Math.min(difference, max - min);


        right ++;
        }

        return difference;



    }


    public static int chocolateDistributionEfficientReal(int [] arr, int m ){

        // sort the array
        Arrays.sort(arr);

        int minDifference = Integer.MAX_VALUE;

        // i + m - 1 means get the element which is m position away from i , i.e. i + (m -1), here we subs 1 because m could become more than m.
        for( int i = 0; i + m - 1 < arr.length; i++){

            int difference = Math.abs(arr[i+m-1] - i);

            minDifference = Math.min(difference,minDifference);

        }

        return minDifference;




    }
    public static void main(String[] args) {

        int [] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 5;


        int ans = chocolateDistribution(arr,m);
        System.out.println(ans);
    }
}
