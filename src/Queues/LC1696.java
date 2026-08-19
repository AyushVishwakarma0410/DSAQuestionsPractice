package Queues;





//
//
// DO AFTER COMPLETING DP
//
//
//


import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

public class LC1696 {
    public static void main(String[] args) {
        int [] arr = {1,-1,-2,4,-7,3};
        System.out.println(maxResult((arr),2));
    }

/*nums = [10, -5, -2, 4, 0, 3]
k = 3*/
        public static int maxResult(int[] nums, int k) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];

            Deque<Integer> dq = new ArrayDeque<>();
            dq.offer(0);

            for (int i = 1; i < n; i++) {

                // Remove indices outside window
                while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                                        // 0 < 2 - 3 = 0 < -1? false
                                        // 2 < 3 -3 0 < 0 ? false
                                        // 3 < 4 - 3 ? true
                                        // 4 < 5-3 ? false
                    dq.pollFirst();
                }

                // Best previous score
                dp[i] = nums[i] + dp[dq.peekFirst()];
//                dp [10,5,8,14,14,17]

                // Maintain decreasing dp values
                while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                                        // 10 <= 5 -? false
                                        // 5  <= 8 ? True
                                        // 8 <= 14 ? True
                                        // 14 <= 14 ? True -> dq is empty
                    dq.pollLast();
                }

                dq.offerLast(i); // dq never empty because we add 4 in dq
            }

            return dp[n - 1];
        }
        //    public static int maxResult(int[] nums, int k) {
//
//        if(nums.length==0){
//            return 0;
//        }
//
//        if(nums.length == 1 ){
//            return nums[0];
//        }
//
//        int sum = nums[0];
//
//        Queue<Integer> q = new LinkedList<>();
//
//        for (int i = 1; i < nums.length ; i++) {
//            q.add(nums[i]);
//        }
//        int i = 0;
//        int min = Integer.MIN_VALUE;
//        int currentMax = min;
//        boolean picked = false;
//        while (!q.isEmpty()){
//
//            if(q.size() == 1){
//                if(picked)
//                    sum += currentMax;
//                sum += q.poll();
//                break;
//            }
//
//
//            if(q.peek() >= currentMax){
//                currentMax = q.peek();
//                picked = true;
//            }
//
//            i++;
//
//            if(i >= k){
//                sum = sum + currentMax;
//                currentMax = min;
//                i = 0;
//                picked = false;
//            }
//
//
//            q.poll();
//
//        }
//
//        return sum;
//
//    }

}
