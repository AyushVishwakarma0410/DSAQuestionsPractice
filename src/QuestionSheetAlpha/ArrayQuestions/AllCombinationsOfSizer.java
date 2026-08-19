package QuestionSheetAlpha.ArrayQuestions;

import java.util.HashSet;
import java.util.Set;


public class AllCombinationsOfSizer {

    public static void combinationsOfr(int [] arr, int r ){
        int n = arr.length;
        // gemini
        int[] indices = new int[r];

        for (int i = 0; i < r; i++) {
            indices[i] = i;
        }

        while (true){
            for (int i = 0; i < r; i++) {
                System.out.print(arr[indices[i]] + " ");
            }
            System.out.println();
            int i = r - 1;
            while (i >= 0 && indices[i] == n - r + i) {
                i--;
            }
            if (i < 0) {
                break;
            }

            indices[i]++;
            for (int j = i + 1; j < r; j++) {
                indices[j] = indices[j - 1] + 1;
            }
        }



    }


    public static void main(String[] args) {
            int [] arr ={1,2,3,4,5};
            int r = 3;
            combinationsOfr(arr,r);
    }
}




//

//
//            // for number which we have to print after jointed numbers
//            for (int k = i+r-1; k < arr.length; k++) {
//
//                // looping jointed numbers
//                int looper = 0;
//                int j = i;
//                while (looper < r-1) {
//
//                    System.out.print(arr[j]+" ");
//                    j++;
//                    looper++;
//                }
//                System.out.println(arr[k]);
//
//            }
//
//
//
//
//
//
//
//
//            System.out.println();
