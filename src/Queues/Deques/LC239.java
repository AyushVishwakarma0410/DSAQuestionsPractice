package Queues.Deques;

import java.util.ArrayDeque;
import java.util.Deque;


public class LC239 {
    public static void main(String[] args) {

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {

        // keeping all the large elements only.
        //  removing only when a new element is greater than previous one
        Deque<Integer> q = new ArrayDeque<>();

        // result array
        int [] res = new int[nums.length-k+1];

        int resultIdx = 0;

        // making window
        for (int i = 0; i < k; i++) {


            // since we are going to compare elements of queue and keeping only larger ones
            // we are going to add first element so that we can have something to compare with

            // in simple words, agar right mai element bada hai, usko prioritize kro aur queue khali kro
            // but agar chote hain too unko queue mai dalte raho unko mt htao
            // agar max element most left mai aagya hai, usko hta do

            if(q.isEmpty()){
                q.addFirst(i);
                continue;
            }

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            q.addLast(i);

        }



        res[resultIdx++] = nums[q.peekFirst()];
        // finding max element for each window .
        // adding only the largest value inside the q
        // removing the element which are outside
        for (int i = k; i < nums.length ; i++) {



            if(!q.isEmpty() && q.peekFirst() <=  i -k ){
                q.pollFirst();
            }

            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]){
                q.pollLast();
             }
            q.addLast(i);

            res[resultIdx++] = nums[q.peekFirst()];


        }

        return res;
    }

}
