package DivideAndConqueor;

import java.util.Arrays;

public class QuickSort {

        public static void main(String[] args) {

        int [] arr = {1,3,0,4,5,2};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        }

    public static void quicksort(int [] arr, int si, int ei){

        if(si>=ei){
            return;
        }
        int idx = partition(arr,si,ei);
        quicksort(arr,si,idx-1);
        quicksort(arr,idx+1,ei);

    }

    public static int partition(int [] arr, int si, int ei){
        int pivot = arr[ei];
        int i = si-1;

        for(int j = si ; j <ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

}
