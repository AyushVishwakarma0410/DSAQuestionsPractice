package SomeExtraQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class LC3069 {

    public static void main(String[] args) {
        int [] nums = {1,2,14,15};
        System.out.println(Arrays.toString(resultArray(nums)));
    }


    public static int[] resultArray(int[] nums) {


        // absolute brute force
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int n = nums.length;


        list1.add(nums[0]);
        list2.add(nums[1]);

        for(int i =2 ; i < n; i++){
            if(list1.get(list1.size()-1) > list2.get(list2.size()-1)){
                list1.add(nums[i]);
            }else{
                list2.add(nums[i]);
            }
        }


        int [] result = new int[n];
        int i;
        for(i = 0; i < list1.size();i++){

            result[i] = list1.get(i);
        }

        for(int j = 0; j < list2.size();j++){
            result[i] = list2.get(j);
            i++;
        }


        System.out.println("list 1 :" + list1);
        System.out.println("list 2 :" + list2);
        System.out.println(Arrays.toString(result));

        return result;

    }
}
