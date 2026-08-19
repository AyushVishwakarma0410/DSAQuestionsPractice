package ArraysAplha;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximunSubArraySumUsingPrefix {
    public static void main(String[] args) {
        int [] arr = {1,-2,6,-1,3};

        int [] prefixSum = new int[arr.length];
        int sum = 0;
        for( int i = 0; i < arr.length;i++){
            sum = sum + arr[i];
            prefixSum[i] = sum;
        }
        int maxSum =0;
        int currentSum = 0;
        for(int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++) {
                currentSum = i==0?prefixSum[j] : prefixSum[j] - prefixSum[i-1];

                maxSum=Math.max(currentSum,maxSum);
            }


        }
        System.out.println(maxSum);
    }
}
