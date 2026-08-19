package QuestionSheetAlpha.ArrayQuestions;

import java.util.Arrays;

public class KthSmallestElement {
    public static int kthSmallest(int [] arr,int k){
        Arrays.sort(arr);
        return arr[k-1];

        // check the QuickSelect algorithm for better answer

    }

    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};
        int k = 2;
        System.out.println(kthSmallest(arr,k));
    }
}
