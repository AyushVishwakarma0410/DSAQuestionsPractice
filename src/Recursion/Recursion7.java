package Recursion;

public class Recursion7 {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,66,54,4,3,2,6,2,3,3,4,5451,1};

        System.out.println(lastOccurrence(arr, 2, arr.length-1));
        System.out.println( arr[10]);

    }

    // by my own logic (optimal)
    public static int lastOccurrence(int[] arr,int key,int n){
        if(n==-1){
            return -1;
        }
        if(arr[n]==key){
            return n;
        }
        return lastOccurrence(arr,key,n-1);
    }


    // by apna college
    public static int lo(int [] arr, int key, int n){
        if(n==arr.length) {
            return -1;
        }
        int isFound = lo(arr,key,n+1);

        if(isFound==-1 && arr[n] == key){
            return n;
        }

        return isFound;
    }
}
