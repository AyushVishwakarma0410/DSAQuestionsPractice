package DP.Memorization;

public class LC152MaximumProductSubarray {
    public static void main(String[] args) {
        int [] nums = {2,-5,-2,-4,3};
//
//        int cont = nums[0];
//        int prevH = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//
//
//            int currentNumber = nums[i];
//
//            int current = cont==0 ? currentNumber : currentNumber * cont;
//            prevH = Math.max(prevH,Math.max(current,currentNumber));
//            cont = current;
//        }
//
//
//
//        System.out.println(Math.max(cont,prevH));





        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] < 0){
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i],min * nums[i]);

            ans = Math.min(ans,max);
        }

        

    }
//
//    The algorithm is maintaining these invariants after processing every index i:
//
//    max = Maximum product of a subarray ending at i
//    min = Minimum product of a subarray ending at i
//    ans = Maximum product seen anywhere from 0...i
//
//    Then at the next index (i + 1), you ask:
//
//    To compute max
//
//    Can I get a larger product by:
//
//    Starting a brand new subarray here?
//    current
//
//            or
//
//    Extending the previous maximum?
//    previousMax × current
//
//            or
//
//    Extending the previous minimum? (because a negative may flip)
//    previousMin × current
//
//    Whichever is largest becomes the new max.
//
//            Similarly, min asks exactly the same question, except it chooses the smallest result.



}
