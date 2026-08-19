package Graphs;

public class LC463 {
    public static void main(String[] args) {

        int [][] grid = {{1,0}};
        System.out.println(islandPerimeter(grid));
    }
    public static int islandPerimeter(int[][] grid) {

        int Perim = 0;

        if(grid==null || grid.length==0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1)
                    Perim = perim(grid,i,j);
            }
        }
        return Perim;
    }
    public static int perim(int [][] grid, int i, int j){


        if(i < 0|| i >= grid.length || j < 0 || j >= grid[0].length){
            return 1;
        }
        if(grid[i][j]==0){
            return 1;
        }
        if(grid[i][j]==2){
            return 0;
        }

        grid[i][j] = 2;

        int up = perim(grid,i-1,j);
        int down = perim(grid,i+1,j);
        int left = perim(grid,i,j-1);
        int right = perim(grid,i,j+1);

        return up+left+right+down;
    }
}
