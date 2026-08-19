package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// 80 %
// minor adjustments in code but important for the question.

public class WallsAndGates {
    public static void main(String[] args) {

        // -1 -> obstacle
        // 0 -> gate

        int INF = Integer.MAX_VALUE;
        int[][] arr = {
                {0, -1, INF, INF},
                {INF, 0, INF, -1},
                {INF, INF, INF, -1}
        };


        steps(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void steps(int [][] arr){

        int max  =  Integer.MAX_VALUE;

        boolean[][] vis = new boolean[arr.length][arr[0].length];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < arr.length;i++){
            for (int j = 0; j < arr[0].length; j++) {

                if(arr[i][j] == 0) {
                    q.add(new int[]{i, j});
                    vis[i][j]=true;
                }
            }
        }


        int count = 0;
        while (!q.isEmpty()){


            int size = q.size();
            for (int i = 0; i < size ; i++) {
                int [] curr = q.poll();


                if(arr[curr[0]][curr[1]] == max){
                    arr[curr[0]][curr[1]] = count;
                }

            int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

            for(int[] dir : directions){

                int newR = curr[0] + dir[0];
                int newC = curr[1] + dir[1];

                if(newR >= 0 && newC >= 0 && newR < arr.length && newC < arr[0].length && !vis[newR][newC] && arr[newR][newC] != -1){
                    q.add(new int[]{newR,newC});
                    vis[newR][newC] = true;

                }

            }

        }
            count++;
        }

    }
}
