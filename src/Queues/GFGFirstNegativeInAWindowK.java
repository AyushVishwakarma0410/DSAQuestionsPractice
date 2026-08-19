package Queues;
import java.util.*;


public class GFGFirstNegativeInAWindowK {

    public static void main(String[] args) {

        int [] arr = {-1};


        System.out.println(firstNegInt(arr,1));

    }

    // self done both no help
    // 1. brute
    // 2. optimized
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        // works but TC : O(n^2)
//
//        if(k==0 || arr.length==0){
//            return new ArrayList<>();
//        }
//        List<Integer> result = new ArrayList<>();
//        Queue<Integer> q ;
//        for (int i = 0; i < arr.length-k+1; i++) {
//            int ans = 0;
//            q = new LinkedList<>();
//            for (int j = i; j <k+i; j++) {
//                        q.offer(arr[j]);
//            }
//            while (!q.isEmpty()){
//                if(q.peek()< 0){
//                    ans = q.poll();
//                    break;
//                }
//                q.poll();
//            }
//            result.add(ans);
//
//        }
//
//        return result;

        if(arr.length == 0 || k == 0 || k > arr.length){
            return new ArrayList<>();
        }
        Queue<Integer> index = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                index.offer(i);
            }
        }
//        System.out.println(index);
        for (int i = 0; i < arr.length - k+1; i++) {

            // remove if out of range
            if(!index.isEmpty() && index.peek() < i){
              index.poll();
            }



            if (!index.isEmpty() && i <= index.peek()  &&  index.peek() < i+k){
                list.add(arr[index.peek()]);
            }else {
                list.add(0);
            }
        }



        return list;
    }

    ///  ======================== gpt ==================================

    // revision ke time pr samjh lena, i think its the same approach, this one just looks better
    static List<Integer> firstNegInt2(int arr[], int k) {

        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int i = 0, j = 0;

        while (j < arr.length) {

            // If current element is negative, add to queue
            if (arr[j] < 0) {
                q.offer(j);
            }

            // If window size is less than k
            if (j - i + 1 < k) {
                j++;
            }
            // If window size equals k
            else if (j - i + 1 == k) {

                // Remove indices out of window
                if (!q.isEmpty() && q.peek() < i) {
                    q.poll();
                }

                // Add result
                if (!q.isEmpty()) {
                    result.add(arr[q.peek()]);
                } else {
                    result.add(0);
                }

                i++;
                j++;
            }
        }

        return result;
    }
}
