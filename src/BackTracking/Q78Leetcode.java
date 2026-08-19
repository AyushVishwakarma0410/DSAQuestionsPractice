package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Q78Leetcode {
    public static void main(String[] args) {
        String s = "abc";



    }


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        // total 2^n subsets
        test(nums,0, ans,res);

        return res;

    }
        public static void test(int [] arr, int idx, List<Integer> ans,List<List<Integer>> finalAnswer){


            if(idx == arr.length){

                // must add
                     finalAnswer.add(new ArrayList<>(ans)) ;

                return;
            }

            ans.add(arr[idx]);
            test(arr,idx+1,ans,finalAnswer);

            ans.removeLast();
            test(arr,idx+1,ans,finalAnswer);



        }
}
