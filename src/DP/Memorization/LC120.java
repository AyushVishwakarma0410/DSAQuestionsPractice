package DP.Memorization;

import java.util.List;
import java.util.ArrayList;
public class LC120 {




    // self done
    // annoying
    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        int m = 4;

        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);

//        System.out.println(triangle.get(0).get(0));
        System.out.println(minimumTotal(triangle));


    }
    public static int minimumTotal(List<List<Integer>> triangle) {
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

        
        return solve(0,0,dp,m,triangle);

    }


    // row = i column = j
    public static int solve(int i, int j, List<List<Integer>> dp, int m,List<List<Integer>> triangle){


        if(i==m-1){
            return triangle.get(i).get(j);
        }
        if(j>triangle.get(i).size()){
            return Integer.MAX_VALUE;
        }

        if(dp.get(i).get(j)!=Integer.MAX_VALUE){
            return dp.get(i).get(j);
        }


        int ans =0;

        int choice1 = solve(i+1,j,dp,m,triangle);
        int choice2 = solve(i+1,j+1,dp,m,triangle);


        ans += Math.min(choice1,choice2);


        dp.get(i).set(j, ans+triangle.get(i).get(j));

//        for (int w = 0; w < dp.size(); w++) {
//            System.out.println(dp.get(w));
//        }


        return ans+triangle.get(i).get(j);
    }


}
