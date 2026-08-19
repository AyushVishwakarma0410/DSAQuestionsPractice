package Sorting.SortingTwoDArrays;

public class Sorting2DArrayUsingReferencesBubbleSorting {
    public static void main(String[] args) {


        int [][] arr ={{1,5},{3,4},{4,3}};



        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j][1] > arr[j+1][1]){
                    int[] temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }



        }

        Print2DArray.printArray(arr);
    }
}
