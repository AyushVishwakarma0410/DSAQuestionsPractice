package Graphs.DijkstraQuestionSet;

import java.util.*;


// 95%

public class LC778 {
    public static void main(String[] args) {
        int [][] grid = {
                {0,1,2,3,4},
                {24,23,22,21,5},
                {12,13,14,15,16},
                {11,17,18,19,20},
                {10,9,8,7,6}
        };

        System.out.println(swimInWater(grid));
    }


    static class Pair implements Comparable<Pair>{

        int row;
        int col;
        int dist;

        Pair(int r, int c, int d){
            row = r;
            col = c;
            dist = d;
        }

        @Override
        public int compareTo(Pair p){

            return Integer.compare(this.dist, p.dist);

        }

    }


    public static int swimInWater(int[][] grid) {

        int n = grid.length;

//        int [][] dist = new int[n][n];

//         Filled whole array with max value
//        for (int [] d : dist){
//            Arrays.fill(d,Integer.MAX_VALUE);
//        }
//
//        dist[0][0] = 0;


        boolean[][] vis = new boolean[n][n];


//        int GlobalMaxValue = 0;

        int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.add(new Pair(0,0,grid[0][0])); // 3%

        while (!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.dist;

            if(vis[r][c]){
                continue;
            }

            vis[r][c] = true;


            if(r==n-1 && c == n-1){
                return d;
            }

            for (int [] dir : directions){
                int newR = dir[0] + r;
                int newC = dir[1] + c;

                if(newR >=0 && newC >= 0 && newR < n && newC < n){


                    int diff = Math.max(d, grid[newR][newC]); // 2 %
//                    dist[newR][newC] = diff;

//                    System.out.println("r , c :" + grid[r][c] + " newR, newC :"+ grid[newR][newC] );

                    q.add(new Pair(newR,newC,diff));





//                    System.out.println(diff);
                }


            }



        }



        return -1;



    }
}
