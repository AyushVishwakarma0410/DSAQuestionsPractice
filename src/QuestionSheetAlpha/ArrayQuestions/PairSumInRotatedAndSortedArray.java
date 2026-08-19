package QuestionSheetAlpha.ArrayQuestions;

import java.util.HashSet;

public class PairSumInRotatedAndSortedArray {




    // BRUTE FORCE TIME COMPLEXITY = O(N2) and SPACE COMPLEXITY = O(N2)
    public static boolean pairSum ( int [] arr, int target){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if(i==j){
                    continue;
                }
                if(arr[i]+arr[j]==target){
                    return true;
                }

            }
        }
        return false;
    }


    //SET CONTAINS METHOD
    public static boolean pairSumSetContains ( int [] arr, int target){
        int n = arr.length;

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            int compliment = target-arr[i];
            if(set.contains(compliment)){
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }


    // two pointers

    public static int findPivot(int [] arr){

        int left = 0;
        int right = arr.length-1;

        while (left <= right){
            int mid = left + (right-left )/2;

            // for mid returning
            if(mid  > left &&  arr[mid] < arr[mid-1]){
                return mid-1;
            }
            else if(mid < right &&  arr[mid] > arr[mid+1]){
                return mid;
            }

            // for search

            if(arr[mid] >= arr[left]){
                left= mid+1;
            }
            else {
                right = mid-1;
            }


        }

        return -1;
    }

    public static boolean pairSumTwoPointer(int [] arr, int target){

        int n = arr.length;
        int pivot = findPivot(arr);

        if (pivot == -1) {
            pivot = n - 1;
        }
        
        int start = (pivot+1)%n;
        int end = pivot;

        while (start!=end){

            if(arr[start] + arr[end] == target){
                return true;
            }
            if(arr[start]+ arr[end] < target){
                start = (start+1) % n;
            }else {
                end = (end - 1 + n) % n;
            }
        }
        return false;


    }




    public static void main(String[] args) {
        int [] arr = {11, 15, 6, 8, 9, 10};
        int target = 16;
//        System.out.println(pairSum(arr,target));
//        System.out.println(pairSumSetContains(arr,target));
        System.out.println(pairSumTwoPointer(arr,target));
    }
}
