package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC1162 {
    public static void main(String[] args) {
            int [][] arr = {
                    {0,0,0},
                    {0,0,0},
                    {0,0,0}
            };

        System.out.println(maxDistance(arr));
    }



    // 2 testcases failed, only

    // 0 0 0 0
    // 0 0 0 0
    // 0 0 0 0

    // nvm solved it self done 100%
    // just put edge cases in if else we have to return -1 though


    public static int maxDistance(int[][] grid) {

        if(grid==null || grid.length==0){
            return 0;
        }


        boolean[][] vis = new boolean[grid.length][grid.length];

        int zeroCount =0;
        int landCount =0;

        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                    landCount++;
                }
                else {
                    zeroCount++;
                }
            }
        }

        if(landCount==0 || zeroCount==-1){
            return -1;
        }


        int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        int count = 0;
        int lastCount = 0;
        while (!q.isEmpty()){

            int size = q.size();


            for (int i = 0; i < size; i++) {

                int [] curr = q.poll();
                if(grid[curr[0]][curr[1]] == 0){
                    grid[curr[0]][curr[1]] = count;
                    lastCount = count;
                    zeroCount--;
                }

                // early return
                if(zeroCount==0){
                    return lastCount;
                }

                for (int [] dir : directions){
                    int newR = curr[0] + dir[0];
                    int newC = curr[1] + dir[1];

                    if(newR>=0 && newC >=0 && newR < grid.length && newC < grid.length && !vis[newR][newC]){
                        q.add(new int[]{newR,newC});
                        vis[newR][newC] = true;
                    }
                }

            }
            count++;

        }
        return lastCount;
    }
}
