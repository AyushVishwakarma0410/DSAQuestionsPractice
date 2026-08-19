package Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

public class LC215 {
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));


//    }
//    public static int findKthLargest(int[] nums, int k) {
//
//        if(nums.length == 0 || k==0 || k > nums.length){
//            return -1;
//        }
//        if(nums.length == 1){
//            return nums[0];
//        }
//
//        Deque<Integer> q = new ArrayDeque<>();
//        for (int i = 0; i < nums.length; i++) {
//
//            if(q.isEmpty()){
//                q.add(nums[i]);
//            }
//            else if(q.peekFirst() < nums[i]){
//               q.addFirst(nums[i]);
//            }
//            else if(q.peekLast() > nums[i]){
//                q.addLast(nums[i]);
//            }else if(q.peekLast() <= nums[i]){
//
//                Stack<Integer> stack = new Stack<>();
//                while (q.peekLast() < nums[i]){
//                    stack.add(q.pollLast());
//                }
//                q.addLast(nums[i]);
//                while (!stack.isEmpty() && q.size() <= k){
//                    q.addLast(stack.pop());
//                }
//            }
//
//
//        }
//
//        int ans= 0;
//        int i = 0;
//        while (i < k){
//          ans =  q.pollFirst();
//            i++;
//        }
//
//        return  ans;
//
//    }
    }


    // Priority queue
    // when i will have enough time to spend, i will try to do it with deque even though the TC would be n2
    // Gpt, as i havent learnt about heap or priority queue.
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            // Keep only k elements in heap
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek(); // kth largest
    }
}
