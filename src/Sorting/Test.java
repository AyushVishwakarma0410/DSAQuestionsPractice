package Sorting;

import java.util.Arrays;
import java.util.Comparator;
public class Test {

    static class sortArray implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){

                return b-a;

        }


    }


    public static void main(String[] args) {

        int [][] arr = {{1,5},{2,4},{3,3},{4,2},{5,1}};



        Integer [] arr2 = {5,4,4,3,2,1};

        Arrays.sort(arr2, (a,b)->Integer.compare(b,a));

        System.out.println( Arrays.toString(arr2));




    }
}
