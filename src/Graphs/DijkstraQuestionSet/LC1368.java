package Graphs.DijkstraQuestionSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC1368 {


    public static void main(String[] args) {

        int [][] grid = {
                {1,1,3},
                {3,2,2},
                {1,1,4}
        };

        System.out.println(minCost(grid));

    }
    static class Pair implements Comparable<Pair>{

        int r;
        int c;
        int w;

        Pair(int row,int col, int w){
            r = row;
            c = col;
            this.w = w;
        }

        @Override
        public int compareTo(Pair p){
            return Integer.compare(w,p.w);
        }

    }

    public static int minCost(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int [][] dist = new int[m][n];

        for (int[] d : dist){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        dist[0][0] = 0;


        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.add(new Pair(0,0,0));

        int [][] directions = {{0,0},{0,1},{0,-1},{1,0},{-1,0}};

        while (!q.isEmpty()){
            Pair curr = q.poll();

            int r = curr.r;
            int c = curr.c;
            int w = curr.w;

            if(r == m-1 && c == n -1){
                return w;
            }

            int currDirection = grid[r][c];

            if(curr.w > dist[curr.r][curr.c]){
                continue;
            }

            for (int i = 1 ; i <= 4; i++ ){

                int newR = directions[i][0] + r;
                int newC = directions[i][1] + c;

                if(newR >= 0 && newC >= 0 && newR < m && newC < n ){

                   int newW ;

                    if(currDirection != i){
                     newW = w+1;
//
//                        q.add(new Pair(newR,newC,w+1));
                    }else {
                        newW = w;
//                        q.add(new Pair(newR,newC,w));
                    }


                    if(newW < dist[newR][newC] ){
                        dist[newR][newC] = newW;
                        q.add(new Pair(newR,newC,newW));
                    }



                }

            }

        }



        return 0;

    }
}
