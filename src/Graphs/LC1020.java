package Graphs;

public class LC1020 {




    // 99 percent self done, just a bug which messed up the code,
    public static void main(String[] args) {
        int [][] grid = {{0,1,1,0,0}};

        System.out.println(numEnclaves(grid));
    }
    public static int numEnclaves(int[][] grid) {

        if(grid.length<=1 || grid[0].length<=1){
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int j = 0; j < m; j++) {
            if(grid[0][j]==1) exterminate(grid,0,j);
        }

        for (int i = 0; i < n; i++) {
            if(grid[i][0]==1) exterminate(grid,i,0);
        }

        for (int j = 0; j < m; j++) {
            if(grid[n-1][j]==1) exterminate(grid,n-1,j);
        }

        for (int i = 0; i < n; i++) {   // ✅ FIXED -> that 1 %
            if(grid[i][m-1]==1) exterminate(grid,i,m-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1){
                    count++;
                }
            }
        }

        return count;
    }

    public static void exterminate(int [][] grid, int i,int j){

        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0){
            return;
        }

        if(grid[i][j]==0 || grid[i][j]==2){
            return;
        }

        grid[i][j]=2;

        exterminate(grid,i-1,j);
        exterminate(grid,i+1,j);
        exterminate(grid,i,j+1);
        exterminate(grid,i,j-1);

    }

}
