package Sorting.SortingTwoDArrays;

public class Sorting2DArrayUsingSelectionSort {

    public static void main(String[] args) {

        int [][] arr ={{5,6},
                {2,3},
                {1,2},
                {3,4},

        };


        Print2DArray.printArray(arr);

        for (int i = 0; i < arr.length; i++) {


            // The index we want to swap with.
            int last = arr.length - i - 1;
            // Index of Max element
            int idxOfMax = getMax(arr,last);
            swap(arr,last,idxOfMax);

        }

        System.out.println("After Sorting :");
        Print2DArray.printArray(arr);
    }

    public static void swap(int [][] arr, int first, int last){

        int temp0 = arr[first][0];
        int temp1 = arr[first][1];

        arr[first][0] = arr[last][0];
        arr[first][1] = arr[last][1];

        arr[last][0] = temp0;
        arr[last][1] = temp1;

    }

    public static int getMax(int [][] arr,int last){

        int max = 0;
        for (int i = 1; i <= last; i++) {

            if(arr[i][0] >= arr[max][0]){
                max = i;
            }

        }


        return max;
    }
}
