package Recursion;

public class Q1 {
    public static void main(String[] args) {


        int [] arr = {3,2,4,5,6,2,7,2,2};
        int num = 2;

        System.out.println( occurrences(arr,num));
    }
    public static int occurrences(int [] n,int key){
        int i = 0;
        int count = 0;
       return count(n,i,key,count);

    }
    public static int count( int [] arr, int itr, int key,int count){
        if(itr == arr.length){
            return count;
        }

        if (arr[itr]==key) {
            count++;

            System.out.println(itr);
        }
        itr++;
        return count(arr,itr,key,count);
    }
}
