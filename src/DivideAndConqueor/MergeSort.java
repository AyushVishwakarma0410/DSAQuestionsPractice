package DivideAndConqueor;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int si, int ei, int [] arr){


        //        int [] arr ={6,3,9,5,2,8};


        //base case
        if(si>=ei){
            return;
        }

        // calculate mid
        int mid = si+(ei-si)/2;

        //call mergeSort for left part
        mergeSort(si,mid,arr);

        //call mergeSort for right part
        mergeSort(mid+1,ei,arr);

        merge(arr,si,mid,ei);


    }
    public static void merge(int [] arr,int si, int mid, int ei){


        System.out.println("Call for :"+ si + " " + ei);
        // size of temporary array
        int [] temp = new int[ei-si+1];

        // iterator for left part
        int i = si;

        // iterator for right part
        int j = mid+1;

        // iterator for temp arr
        int k = 0;



        System.out.println("Before :"+ Arrays.toString(arr));
        while (i <= mid && j <= ei){

            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;

        }
        // left part remaining elements
        while (i <= mid){
            temp[k++] = arr[i++];
        }
        // right part remaining elements
        while (j <= ei){
            temp[k++] = arr[j++];
        }

        // copy them to original
        for(k=0, i = si; k < temp.length; k++,i++){
            arr[i] = temp[k];
        }


        System.out.println("After :" + Arrays.toString(arr));
    }


    public static void main(String[] args) {


        int [] arr ={6,5,4,3,2,1};
        mergeSort(0,arr.length-1,arr);
        System.out.println(Arrays.toString(arr));
    }
}
