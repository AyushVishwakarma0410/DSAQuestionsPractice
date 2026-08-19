package Graphs.DijkstraQuestionSet;

import java.util.Arrays;
import java.util.PriorityQueue;



// Self done - 100 %

public class LC2290 {
    public static void main(String[] args) {

        int[][] grid = {{0, 1, 1},
                {1, 1, 0}, {1, 1, 0}
        };


        System.out.println(minimumObstacles(grid));

    }

    static class Pair implements Comparable<Pair>{

        int r;
        int c;
        int load;

        Pair(int row,int col, int w){
            r = row;
            c = col;
            load = w;
        }

        @Override
        public int compareTo(Pair p){
            return Integer.compare(load,p.load);
        }

    }

    public static int minimumObstacles(int[][] grid) {


        // row
        int m = grid.length;
        // column
        int n = grid[0].length;
        // distance array for dijkstra
        int [][] dist = new int[m][n];
        for(int [] d : dist){
            Arrays.fill(d,Integer.MAX_VALUE);
        }

        dist[0][0] = 0;


        // Priority Queue for Dijkstra
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0,grid[0][0]));

        int [][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while (!q.isEmpty()){

            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int l = curr.load;

            if (l > dist[r][c]) continue;


            if(r==m-1 && c==n-1){
                return l;
            }

            for (int [] dir : directions){

                int newR = r + dir[0];
                int newC = c + dir[1];

                if(newR >= 0 && newR < m && newC >= 0 && newC < n){

                    int newLoad = l + grid[newR][newC];


                    if( newLoad  < dist[newR][newC]){
                        dist[newR][newC] = newLoad;
                        q.add(new Pair(newR,newC,newLoad));
                    }


                }

            }


        }


        return 0;
    }
}
