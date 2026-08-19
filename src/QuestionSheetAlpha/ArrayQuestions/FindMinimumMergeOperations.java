package QuestionSheetAlpha.ArrayQuestions;

public class FindMinimumMergeOperations {

    public static int makeArrayPalindrome(int [] arr){

        int length = arr.length;

        int left = 0;
        int right = length-1;
        int operations = 0;


        while (left < right){
            if(arr[left]==arr[right]){
                left++;
                right--;
            }
            else if(arr[left] > arr[right]){
                arr[right-1] = arr[right]+arr[right-1];
                operations++;
                right--;
            }
            else
            {
                arr[left+1] = arr[left]+arr[left+1];
                operations++;
                left++;
            }


        }



//        if(length/2!=0){
//
//            int left = length/2;
//            int right = left + 1;
//
//            while (left > -1 && right < arr.length){
//
//                if(left-1 > 0 && right+1 < arr.length && arr[left]!=arr[right]){
//                    result[]
//                }
//
//                left--;
//                right++;
//            }
//        }else {
//
//            int left = length/2,right = length/2;
//
//            if(arr[left] != arr[right]){
//
//            }
//
//            left--;
//            right++;
//
//
//
//        }

    return operations;
    }

    public static void main(String[] args) {

        int [] arr = {1,9,1};
        System.out.println(makeArrayPalindrome(arr));

    }
}
