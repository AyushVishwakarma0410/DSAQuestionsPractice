package Graphs;

public class LC695 {
    public static void main(String[] args) {
            int [][] rr = {{1,1,0,0,0},
                    {1,1,0,0,0},
                    {0,0,0,1,1},
                    {0,0,0,1,1}};

        System.out.println(maxAreaOfIsland(rr));
    }

    //hmmmmmm.... ( reaction during revision)

    public static int maxAreaOfIsland(int[][] grid) {


        int max = 0;
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max,dfs(grid,i,j,vis));
            }
        }
        return max;

    }

    public static int dfs(int [][] grid,int i,int j,boolean [][]vis){


        // out of bounds check
        if(i >= grid.length || j >= grid[0].length ){
            return 0;
        }
        if(i < 0 || j <0){
            return 0;
        }


        // visit check
        if(vis[i][j]){
            return 0;
        }


        // no area check
        if(grid[i][j]==0){
            return 0;
        }
        vis[i][j] = true;



        int up = dfs(grid,i+1,j,vis);

        int right  = dfs(grid,i,j+1,vis);

        int down = dfs(grid,i-1,j,vis);

        int left = dfs(grid,i,j-1,vis);


        return up + down + left + right + 1;


    }
}
