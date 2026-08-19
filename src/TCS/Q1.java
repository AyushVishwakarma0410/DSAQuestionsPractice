package TCS;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static void main(String[] args) {
        int [] arr ={5,3,7,14,18,1,18,4,8,3};

        int K = 15;

        // find continuous subarray Sum = k

        int [] prefix = new int[arr.length];

        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1]+ arr[i];
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length ; j++) {

                int sum;
                if(i==0) sum = prefix[j];
                else sum = prefix[j] - prefix[i-1];

                if (sum == K) {
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }



        // 2nd approach
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - K)) {
                int start = map.get(sum - K) + 1;
                System.out.println((start + 1) + " " + (i + 1));
                return;
            }

            map.putIfAbsent(sum, i);
        }

    }
}
