package Sorting.SortingTwoDArrays;

public class Print2DArray {
    public static void printArray(int [][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(" i :"+ i + " j :"+ j + " = " + arr[i][j] + " ");
            }
            System.out.println();
        }



    }
}
