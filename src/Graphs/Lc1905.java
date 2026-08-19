package Graphs;

import java.util.Arrays;

public class Lc1905 {
    public static void main(String[] args) {



        int [][] grid1 = {{1,1,1,0,0},
                          {0,1,1,1,1},
                          {0,0,0,0,0},
                          {1,0,0,0,0},
                          {1,1,0,1,1}};
        int [][] grid2 = {{1,1,1,0,0},
                          {0,0,1,1,1},
                           {0,1,0,0,0},
                            {1,0,1,1,0},
                            {0,1,0,1,0}};

        int ans = countSubIslands(grid1,grid2);

        ArrayPrint(grid1,grid2);

        System.out.println(ans);
    }

    public static void ArrayPrint(int [][] grid1, int [][] grid2){

        System.out.println("Grid 1 :");
        for (int i = 0; i < grid1.length; i++) {
            System.out.println(Arrays.toString(grid1[i]));
        }

        System.out.println("Grid 2 :");
        for (int i = 0; i < grid2.length; i++) {
            System.out.println(Arrays.toString(grid2[i]));
        }
    }


    public static int countSubIslands(int [][] grid1, int [][] grid2){

        int count = 0;


        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if(grid2[i][j]==1){

                    // is expansion completes
                    boolean [] flag = {true};
                    dfs(grid1,grid2,i,j,flag);
                    if(flag[0]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void dfs(int [][] grid1, int [][] grid2,int i, int j, boolean[]flag){

        if(i >= grid1.length || i < 0 || j >= grid1[i].length || j < 0){
            return;
        }

        // if already visited or no land present
        if(grid2[i][j]!=1){
            return;
        }

        if(grid1[i][j]!=1){
            flag[0] = false;
//            return;

            // if return is present here
            /*⚠️ Problem created

You stop DFS mid-island

So:

Some parts of the island remain 1 in grid2
Outer loop will hit them again
Same island gets processed multiple times
You may count it again → wrong answer*/
        }

        // mark visited only in 2nd grid
        grid2[i][j] = 2;


        dfs(grid1,grid2,i-1,j,flag);
        dfs(grid1,grid2,i+1,j,flag);
        dfs(grid1,grid2,i,j-1,flag);
        dfs(grid1,grid2,i,j+1,flag);

    }





    // took 3 hours, 80 percent close but made overcomplicated
//    public static int countSubIslands(int[][] grid1, int[][] grid2) {
//
//        int count = 0;
//
//        for (int i = 0; i < grid2.length; i++) {
//            for (int j = 0; j < grid2[i].length; j++) {
//
//                if(grid2[i][j]==1) {
//
//                    if(grid1[i][j]==1) {
//
//                        boolean [] expansionComplete = {true};
//
//                        System.out.println("i : "+i + ", j : "+j    );
//                        dfs(grid1, grid2, i, j,expansionComplete);
//                        if(expansionComplete[0])
//                            count++;
//
//                    }else {
//                        grid2[i][j] = 2;
//                    }
//                }
//            }
//        }
//
//        return count;
//    }
//
//    public static void dfs(int [][] grid1, int [][] grid2, int i, int j,boolean [] flag){
//
//        if(i >= grid1.length || i < 0 || j >= grid1[i].length || j < 0){
//            return;
//        }
//
//
//        // so basically this code got fucked up because i was marking grid2[i][j] as 2 in the dual for loop
//        // because of this, thing below condition wasnt getting triggered
//        // also it is overcomplicateed
//        if(grid1[i][j]!=1 && grid2[i][j]==1){
//            System.out.println("Whenever hit false :");
//            ArrayPrint(grid1,grid2);
//            flag[0] = false;
//        }else {
//            System.out.println("No hit ");
//        }
//
//
//
//        if(grid2[i][j]==1 && (grid1[i][j]==0 || grid1[i][j]==2)){
//            grid2[i][j] = 2;
//            return;
//        }
//
//        if(grid1[i][j]==0 || grid2[i][j]==0){
//            return;
//        }
//
//        if(grid1[i][j]==2 && grid2[i][j] == 2 ){
//            return;
//        }
//
//
//
//
//            grid1[i][j] = 2;
//            grid2[i][j] = 2;
//
//
//
//        dfs(grid1,grid2,i-1,j,flag);
//        dfs(grid1,grid2,i+1,j,flag);
//        dfs(grid1,grid2,i,j-1,flag);
//        dfs(grid1,grid2,i,j+1,flag);
//
//
//    }


    /// //////////////////////////////////////////////////

    // Standard version
    class Solution {

        public int countSubIslands(int[][] grid1, int[][] grid2) {

            int count = 0;

            for (int i = 0; i < grid2.length; i++) {
                for (int j = 0; j < grid2[0].length; j++) {

                    if (grid2[i][j] == 1) {

                        // if DFS returns true → valid sub-island
                        if (dfs(grid1, grid2, i, j)) {
                            count++;
                        }
                    }
                }
            }

            return count;
        }

        public boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {

            // boundary + water/visited
            if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] != 1) {
                return true;
            }

            // mark visited
            grid2[i][j] = 2;

            // check current cell
            boolean isValid = (grid1[i][j] == 1);

            // explore all directions
            boolean up = dfs(grid1, grid2, i - 1, j);
            boolean down = dfs(grid1, grid2, i + 1, j);
            boolean left = dfs(grid1, grid2, i, j - 1);
            boolean right = dfs(grid1, grid2, i, j + 1);

            // final result for this island
            return isValid && up && down && left && right;
        }
    }
}
