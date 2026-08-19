package QuestionSheetAlpha.ArrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static List<int[]> mergeIntervals(int [][] arr){

        // created a list for storing the answer, type -> int[] because int[] is object type and is acceptable
        // we can store arrays here which are of different sizes
        List<int[]> list = new ArrayList<>();

        // sorting arrays
        Arrays.sort(arr,Comparator.comparingInt(row->row[0]));

//        System.out.println(arr[0][0]);//1
//        System.out.println(arr[0][1]);//1
//
//        System.out.println(arr[1][0]);//2
//        System.out.println(arr[1][1]);//2
//
//        System.out.println(arr[2][0]);//3
//        System.out.println(arr[2][1]);//3
//
//        System.out.println(arr[3][0]);//4
//        System.out.println(arr[3][1]);//4

//        System.out.println(arr[4][0]);
//        System.out.println(arr[4][1]);


        // Since we have our first array, we have to add it, as obviously its the start
        list.add(arr[0]);
        for(int i = 1; i < arr.length;i++) {

            int [] last = list.getLast();
            int [] curr = arr[i];
            // for selecting the array
                if(last[1] < curr[0]){

                    list.add(curr);

                }
                // for making the overlap
                else {
                    last[1] = Math.max(last[1],curr[1]);
                }
        }
        return list;


    }

    static ArrayList<int[]> mergeOverlap(int[][] arr) {

        // Sort intervals based on start values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();
        res.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < arr.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = arr[i];

            // If current interval overlaps with the last merged interval,
            // merge them
            if (curr[0] <= last[1])
                last[1] = Math.max(last[1], curr[1]);
            else
                res.add(new int[]{curr[0], curr[1]});
        }

        return res;
    }


    public static void main(String[] args) {
        int[][] arr ={{1, 3}, {2, 4}, {6, 8}, {9, 10}};

         mergeIntervals(arr);
          ArrayList<int[]> res = mergeOverlap(arr);
        for (int[] interval : res)
            System.out.println(interval[0] + " " + interval[1]);




    }



}
