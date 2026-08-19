package Sorting.Arraysss;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {


        int [] arr ={5,4,1,2,3};
        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int [] arr){


        // kind of reverse Sorting approach sorting algorithm as compared to bubble sort

        for (int i = 0; i < arr.length; i++) {

            for (int j = i+1; j < arr.length && j > 0; j--){
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                }else {
                    break;
                }
            }
        }


    }
    public static void swap(int [] arr, int start, int end){

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
