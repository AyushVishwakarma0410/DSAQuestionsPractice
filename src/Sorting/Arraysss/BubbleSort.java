package Sorting.Arraysss;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int [] arr = {1,2};
        boolean swapped = false;

        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr.length; j++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
