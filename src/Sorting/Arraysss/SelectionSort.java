package Sorting.Arraysss;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {5,4,3,2,2,2,1};

        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        
    }

    // get max element then place it to its appropriate place

    public static void selectionSort(int [] arr){

        for (int i = 0; i < arr.length; i++) {

            int last = arr.length-i-1;

            int maxIndex = getMaxIdx(arr,last);

            swap(arr,maxIndex,last);

        }


    }


    public static int getMaxIdx(int [] arr,int end){

        int max = 0;
        for (int i = 1; i <= end; i++) {

            if(arr[i] >= arr[max]){
                max = i;
            }
        }

        System.out.println(arr[max]);


        return max;
    }

    public static void swap(int [] arr, int start, int end){

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
