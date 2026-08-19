package Graphs.DijkstraQuestionSet;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1631 {
    public static void main(String[] args) {
        int [][] heights = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };

        System.out.println(minimumEffortPath(heights));
    }

    static class Pair implements Comparable<Pair> {
        int[] node;
        int dist;

        Pair(int[] n, int d) {
            node = n;
            dist = d;
        }

        public int compareTo(Pair p) {
            return Integer.compare(this.dist, p.dist);
        }
    }
    public static int minimumEffortPath(int[][] heights) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int m = heights.length;
        int n = heights[0].length;
        int [][] dist = new int[m][n];

        for(int [] d : dist){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        
        dist[0][0] = 0;

        int [][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

//        boolean[][] vis = new boolean[m][n];

        pq.add(new Pair(new int[]{0,0},0));



        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            int [] node = curr.node;
            int row = node[0];
            int col = node[1];

            if (row == m - 1 && col == n - 1) {
                return curr.dist;
            }

//            if(vis[row][col]){
//                continue;
//            }

            // this line is present because, if we have two paths reaching a same node with different time intervals
            // then the one with greater effort can be purged,
            // suppose we go to 1,1 with 5, and later we went to 1,1 with 3, so dist[1][1] will be 3,
            // 1,1 with 5 is polled, then due to the updated value of dist[1][1] with 3 we will not process any further.
            if (curr.dist > dist[row][col]) continue;


//            vis[row][col] = true;

            for (int [] dir : directions){
                int newR = row+dir[0];
                int newC = col+dir[1];

                if(newR >= 0 && newC >= 0 && newR<m && newC<n) {
//                    int diff = Math.abs(heights[row][col] - heights[newR][newC]);
//                    if (diff < dist[newR][newC]) {
//                        dist[newR][newC] = diff;
//
//                        pq.add(new Pair(new int[]{newR, newC}, diff));
//                        if (newR == m - 1 && newC == n - 1) {
//                            ans = Math.min(ans, heights[newR][newC]);
//                        }
//                    }
                    int diff = Math.abs(heights[row][col] - heights[newR][newC]);
                    int newEffort = Math.max(curr.dist, diff);

                    if (newEffort < dist[newR][newC]) {
                        dist[newR][newC] = newEffort;
                        pq.add(new Pair(new int[]{newR, newC}, newEffort));
                    }
                }

            }

        }

        return 0;

    }
}
