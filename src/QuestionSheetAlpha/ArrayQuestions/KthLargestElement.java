package QuestionSheetAlpha.ArrayQuestions;

import java.util.Arrays;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {



        // wasted my afternoon on this ... absolute bullshit... literally question padhooo dhang seee




        //        if(nums.length ==1)return nums[0];
//        Arrays.sort(nums);
//        int count = 0;
//        for( int i = nums.length-1; i>=0;i--){
//            if(i==nums.length-1){
//                count++;
//
//            }
//            if(count==k){
//                return nums[i];
//            }
//            if (nums[i] != nums[i+1]){
//                count++;
//            }
//            if(count==k){
//                return nums[i];
//            }
//
//        }
//
//
//
//
//
//
//    return -1;



        // fucking solving like this


        Arrays.sort(nums);
        return nums[nums.length-k];
            // thatsss itt.. like what the fuckkk

        // all this time i was thinking that if there is a same number then do not freaking count it but still my logic wasnt matching at all
        // now lets see bekar understanding ke saath bhi galat answers aarhe kyuki code mera kuch is prakar hogaaa



    }


    // gemmini code, same as mine but sirf if else conditions sahi se lagai haii mene dhnag se ni lagai
    

    public static int findKthDistinctLargest(int[] nums, int k) {
        Arrays.sort(nums);

        int distinctCount = 0;
        // Start from end (Largest)
        for (int i = nums.length - 1; i >= 0; i--) {

            // If it's the last element OR different from the one to its right
            // We count it as a new distinct number
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                distinctCount++;
            }

            if (distinctCount == k) {
                return nums[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
            int [] arr ={4,3,2,1,5,6};
            // 1,2,3,4,5,6

        System.out.println(findKthLargest(arr,1));
    }
}
