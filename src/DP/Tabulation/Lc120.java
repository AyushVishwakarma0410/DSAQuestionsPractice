package DP.Tabulation;

import java.util.ArrayList;
import java.util.List;

public class Lc120 {


    // further optimization would be 1 D array of DP
    // self done
    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        int m = 4;

        List<Integer> l1 = new ArrayList<>();
        l1.add(-1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(-2);
        l2.add(-3);
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(6);
//        l3.add(5);
//        l3.add(7);
//        List<Integer> l4 = new ArrayList<>();
//        l4.add(4);
//        l4.add(1);
//        l4.add(8);
//        l4.add(3);

        triangle.add(l1);
        triangle.add(l2);
//        triangle.add(l3);
//        triangle.add(l4);

//        System.out.println(triangle.get(0).get(0));
        System.out.println(minimumTotal(triangle));



    }
    public static int minimumTotal(List<List<Integer>> triangle){
        // attempt 1
        // tabulation

        List<List<Integer>> dp = new ArrayList<>();
        int m = triangle.size();

        for(int i =0 ; i < m ; i++){

            int size = triangle.get(i).size();

            List<Integer> row = new ArrayList<>(size);

            for (int j = 0; j < size; j++) {
                row.add(Integer.MAX_VALUE);
            }

            dp.add(row);
        }

        dp.get(0).set(0,triangle.get(0).get(0));
        for (int i = 1; i < m; i++) {


            int size = triangle.get(i-1).size();



            for (int j = 0; j < triangle.size(); j++) {


                int choice1 = j < size ? dp.get(i-1).get(j) : Integer.MAX_VALUE;
                int choice2 = j-1 >= 0 ? dp.get(i-1).get(j-1):Integer.MAX_VALUE;
                int ans = triangle.get(i).get(j) + Math.min(choice1,choice2) ;
                dp.get(i).set(j,ans);
            }
        }



        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(m-1).size(); i++) {
            min = Math.min(min,dp.get(m-1).get(i));
        }
        return min;
    }



}
