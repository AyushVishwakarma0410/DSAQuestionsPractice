package Graphs;

import java.util.*;

public class Test{


    public static void main(String[] args) {





        int [][] s = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        System.out.println(lc200(s));
    }

    public static int lc200(int [][] matrix) {

        boolean [] vis = new boolean[matrix.length];

        int ans = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==1 && !vis[j]) {
                    solve(matrix, i, vis);
                    ans++;
                }
            }
        }


        return ans;

    }
    public static void solve(int [][] matrix, int i, boolean [] vis){

        vis[i] = true;
        for (int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j]==1 && !vis[j]){
                solve(matrix,j,vis);
            }
        }


    }
}