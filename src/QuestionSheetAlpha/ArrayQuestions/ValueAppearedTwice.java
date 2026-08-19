package QuestionSheetAlpha.ArrayQuestions;

import java.util.*;

public class ValueAppearedTwice {
    public static void main(String[] args) {

        int [] arr;
        arr = new int[]{1, 2, 3, 45, 1};

        // brute force
//
//        Arrays.sort(arr);
//
//
//        for (int i = 1; i < arr.length; i++) {
//
//
//            if(arr[i]==arr[i-1]){
//                System.out.println("Duplicate found");
//                break;
//            }
//
//
//        }


        // hashmap

//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        for (int num : arr){
//            map.put(num, map.getOrDefault(num,0)+1);
//        }
//
//        for(int key : map.keySet()){
//            if(map.get(key) >1){
//                System.out.println("Duplicates");
//                return;
//            }
//        }




        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            if(set.contains(arr[i])){
                System.out.println("Duplicates");
                return;
            }
            set.add(arr[i]);

        }
    }
}
