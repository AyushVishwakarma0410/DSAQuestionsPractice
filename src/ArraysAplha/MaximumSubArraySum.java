package ArraysAplha;

public class MaximumSubArraySum {
    public static void main(String[] args) {


        int [] arr = {1,-2,6,-1,3};
        int sumOfEachSubarray = 0;
        int maxSum = 0;
        for( int i = 0; i < arr.length;i++){
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    sumOfEachSubarray = sumOfEachSubarray + arr[k];
                }
                System.out.println(sumOfEachSubarray);
                if(maxSum < sumOfEachSubarray)
                    maxSum = sumOfEachSubarray;
                sumOfEachSubarray = 0;
            }
        }
        System.out.println("maxSum :"+ maxSum);
    }
}
