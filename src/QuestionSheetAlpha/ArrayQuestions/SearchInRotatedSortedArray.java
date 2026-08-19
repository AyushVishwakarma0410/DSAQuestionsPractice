package QuestionSheetAlpha.ArrayQuestions;

public class SearchInRotatedSortedArray {



    public static int binarySearch(int [] arr,int left, int right,  int target){

        while (left <= right){
            int mid  = left + (right-left)/2;

            if(arr[mid] == target){
                return mid;
            }
            else if (arr[mid] > target){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }


        return -1;
    }


    public static int findPivot (int [] arr){
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            int mid = left + (right- left)/2;

            if(mid < right && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(mid > left && arr[mid-1] > arr[mid]){
                return mid - 1 ;
            }
            if(arr[mid] <= arr[left]){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }

       }
        return -1;

    }
    public static int search(int [] arr, int target){

            int pivot = findPivot(arr);

            if(pivot==-1) return binarySearch(arr,0,arr.length-1,target);

            int searchLeft = binarySearch(arr,0,pivot,target);

            int searchRight = binarySearch(arr,pivot+1, arr.length-1, target);

            return searchLeft == -1?(searchRight) : searchLeft;


    }

    public static void main(String[] args) {
        System.out.println(search(new int [] {6,7,1,2,3,4,5},2));
    }
}
