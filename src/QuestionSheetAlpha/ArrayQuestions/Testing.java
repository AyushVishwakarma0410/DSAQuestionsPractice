package QuestionSheetAlpha.ArrayQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Testing {


    public static void main(String[] args) {
        Integer [] arr = {1,10,2,54,3,76,146,-12543,-1,4,5,54};

        Arrays.sort(arr);






        for(int num : arr){
            System.out.print(num);
            System.out.print(" ");
        }


        Arrays.sort(arr,(a,b)-> b-a );

//
//        Arrays.sort(arr, (a,b)->{
//            if(a%2==0 && b%2!=0 ) return -1;
//            if(a%2!=0 && b%2==0 ) return 1;
//
//            return a-b;
//
//        });

        System.out.println(Arrays.toString(arr));

        // sorting of Strings

        String[] words = {"apple", "fig", "banana"};
        // "Sort these words based on their LENGTH"
        Arrays.sort(words,((a,b )-> a.length()-b.length()));



        // String are compared int lexographical order, that means character by character comparsion will be done
        String[] numbers = {"34","12","1","54","21","124","76","87"};
        Arrays.sort(numbers,(a,b)->a.compareTo(b));
            String s =  Arrays.toString(numbers);
        System.out.println(s);

        String[] num = {"30","3","123","3012","12","43","14"};

        Arrays.sort(num,(a,b)-> (b+a).compareTo(a+b));

        s = Arrays.toString(num);

        System.out.println(s);
    }




























//        public static List<int[]> ActivitySelection(int[][] arr){
//
//            // edge case -> empty condition
//            if(arr.length==0) return new ArrayList<>();
//
//
//
//            // Sorting array by end time
//            Arrays.sort(arr, Comparator.comparingInt(row-> row[1]));
//
//            // For answer arraylist for storing arrays of different sizes but in our case it will be constant
//            ArrayList<int[]> list = new ArrayList<>();
//
//            // Always add the first element.
//            list.add(arr[0]);
//
//            // get the end time of 1st activity
//            int EndTime = arr[0][1];
//
//            //check start with 1
//            for (int i = 1; i < arr.length; i++) {
//                // used <= because 1-3 3-4 like situation can occur
//                if(EndTime <= arr[i][0]){
//                    list.add(arr[i]);
//                    EndTime = arr[i][1];
//
//                }
//            }
//
//
//
//            return list;
//
            
            
//        }
}
