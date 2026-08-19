package Sorting.SortingTwoDArrays;

import java.util.Arrays;
import java.util.Comparator;
public class Java7Sorting {

     static class sortingArray implements Comparator<int[]>{
         @Override
         public int compare(int [] a, int [] b){
             return a[0] - b[0];
         }



    }



    // remember
    /*
    a[0] = Integer.MAX_VALUE;
    b[0] = -1;


    will produce overflow
     */


    public static void main(String[] args) {
        int [][] arr = {{4,2},{1,3},{3,1},{2,4}};

        Arrays.sort(arr, new sortingArray());

        // Another way

        Arrays.sort(arr, new Comparator<int[]>(){
          @Override
          public int compare(int [] a, int []b){
              return a[1] - b[1];
          }
        });

        Print2DArray.printArray(arr);


        Arrays.sort(arr, (a,b)-> a[0]-b[0]);

    }
}
