package QuestionSheetAlpha.ArrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> findTriplet(int [] arr){
        int left;
        int right ;
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            left = i+1;
            right = arr.length-1;

            if(i > 0 && arr[i] == arr[i-1]) continue;

            while (left< right){
                if(-arr[i] == arr[left] + arr[right]){
                    list.add(Arrays.asList(arr[i], arr[left], arr[right]));

                left++;
                right--;

                while (left < right && arr[left]== arr[left-1]) left++;
                while (right > left && arr[right]== arr[right+1]) right--;
                }
                else if(-arr[i] > arr[left] + arr[right]){
                    left++;
                }
                else {
                    right--;
                }
            }


        }
        return list;
    }
    public static void main(String[] args) {
        int [] arr = {-1,0,1,2,-1,-4};
    }
}
