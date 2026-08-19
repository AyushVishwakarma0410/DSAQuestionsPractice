package Sorting.SortingTwoDArrays;

public class Sorting2DArrayUsingReferencesSelection {
    public static void main(String[] args) {


        int [][] arr = {{5,1},{4,2},{3,3},{2,4},{1,5}};

        Print2DArray.printArray(arr);

        for (int i = 0; i < arr.length; i++) {

            int last = arr.length - i - 1;

            int idx = getMax(arr,last);

            int [] temp = arr[last];
            arr[last] = arr[idx];
            arr[idx] = temp;

        }

        System.out.println("After :");

        Print2DArray.printArray(arr);

    }

    public static int getMax(int [][] arr, int last){

        int max = 0;

        for (int i = 0; i <= last; i++) {

            if(arr[i][0]>=arr[max][0]){
                max = i;
            }

        }

        return max;

    }
}
