package Recursion;

public class Recursion6 {
    public static void main(String[] args) {

        int [] arr = {2,1,2,3,3,4,8,7,5,0,2,1};
        int ans = firstOccurrence(arr,0,0);
        System.out.println(ans);
    }
    public static int firstOccurrence(int []arr,int key,int i){

            if(i==arr.length){
                return -1;
            }

            if(arr[i]==key){
                return i;
            }

            return firstOccurrence(arr,key,i+1);



    }
}
