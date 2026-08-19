package BackTracking;

import java.util.Arrays;

public class BackTrackingInArrays {
    public static void main(String[] args) {
        int [] arr = new int[5];
        modifyArr(arr,0,1);
        System.out.println(Arrays.toString(arr));
    }
    public static void modifyArr(int [] arr, int i, int val){

        // basecase
        if(i==arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }

        //recursion
        arr[i] = val; // function calling step
        modifyArr(arr,i+1,val+1);

        // backtracking step - always in unwinding step
        arr[i] = arr[i]-2;

    }


}
