package Recursion;

public class Recursion5 {


    public static void main(String[] args) {


        int [] arr = {1,2,3,4, 5,6};

        System.out.println(checkIfSorted(arr,0));
    }


    public static boolean checkIfSorted(int [] arr,int n){

        if(n==arr.length-1){
            return true;
        }


        if(arr[n] > arr[n+1]){
            return false;
        }

         return checkIfSorted(arr,n+1);


    }



}
