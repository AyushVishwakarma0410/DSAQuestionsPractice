package QuestionSheetAlpha.ArrayQuestions;

import java.util.Arrays;

public class NextPermutations {

    public static void swap(int [] arr, int last, int counter){

        int temp = arr[last];
        arr[last] = arr[counter];
        arr[counter] = temp;

    }
/*
    public static void nextPer(int [] arr){
        boolean flag = false;

        // if length is 1 no need
        if(arr.length == 1){
            return;
        }
        // last index of the array
        int last = arr.length-1;
        // counter index to set the range later from end
        int counter = last-1;

        while (last > 0){
            if(counter >= 0 && arr[last] > arr[counter]){
                swap(arr,last, counter);
                break;
            }
            if(last-1 == counter){
                counter = counter-1;
                last = arr.length-1;
                continue;
            }
            last= last-1;
            if(counter==-1){
                break;
            }
        }

        // ye mene khud se likhi thi line but ye kaam ni kregi kyuki 1 2 3 ke case mai, ye sort ni krega as counter +1 = 1 and last = 1 therefore remove this condition
//        if(counter + 1 != last){
//            Arrays.sort(arr, counter+1,arr.length);
//        }

        Arrays.sort(arr, counter+1,arr.length);



    }
*/



    public static void next(int[] arr){
        int i = arr.length-2;
        while ( i >= 0 && arr[i]>=arr[i+1]){
            i--;
        }
        if(i >= 0){
           int j=arr.length-1;

            while (arr[j]<=arr[i]){
                j--;
            }

            swap(arr,i,j);
        }

        Arrays.sort(arr,i+1,arr.length);

    }
    public static void main(String[] args) {
        int [] arr= {2,3,1};
        // 1 3 5 4 2
        // 1 3 2
        // 3 2 1
//        nextPer(arr);
        System.out.println(Arrays.toString(arr));
    }
}
