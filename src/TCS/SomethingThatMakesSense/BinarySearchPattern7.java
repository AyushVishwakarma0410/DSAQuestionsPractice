package TCS.SomethingThatMakesSense;

public class BinarySearchPattern7 {
    public static void main(String[] args) {

    }


    /*
    Problem: Given an array nums and an integer m, split the array into m non-empty continuous
    subarrays such that the largest sum among these subarrays is minimized.
     */




    //m = subarrays to form
    public static int SplitArray(int [] arr,int m){



        // minimum max value
        int min = 0;
        // maximum possible value
        int max = 0;



        for (int num : arr){

            min = Math.max(num,min);
            max += num;

        }

        while (min <= max){

            int mid = ( min + max )/2;

            if(isPossible(arr,mid,m)){
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }


        }

        return min;
    }

    public static boolean isPossible(int [] arr,int allowed,int m){

        int currentSum = 0;
        int subArrays = 1;

        for (int num : arr) {
            if (currentSum + num <= allowed)
                currentSum += num;
            else {
                subArrays++;
                currentSum = num;

            }
        }

        return subArrays <= m;
    }
}
