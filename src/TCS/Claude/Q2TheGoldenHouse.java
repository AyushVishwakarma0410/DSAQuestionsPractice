package TCS.Claude;

import java.util.Arrays;

public class Q2TheGoldenHouse {
    public static void main(String[] args) {


        int [] arr = {1,2,3,4,5};
        int k = 14;
        System.out.println(Arrays.toString(range(arr,k)));
    }

    public static int[] range(int [] arr,int coins){


        if(arr.length == 0){
            return new int[]{-1,-1};
        }

        int sum = 0;
        int start = 0;
        int [] res = {-1,-1};

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            while (sum > coins){
                sum -= arr[start];
                start++;
            }

            if(sum==coins){
                res[0] = start+1;
                res[1] = i+1;
                break;
            }


        }

        return res;

    }
}
