package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC1129 {


    // 55 % self done, graph formation is done by me, logic was not so close
    // I am running out of time so pacing things up, spend 2 hours total on this question

    // redo important
    // and please use pen paper
    public static void main(String[] args) {


        int n = 3;
        int [][] redEdges = {{0,1}};
        int [][] blueEdges = {{1,2}};


        int [] ans = shortestAlternatingPaths(n,redEdges,blueEdges);

        System.out.println(Arrays.toString(ans));
    }


    public static class Edge{
        int src;
        int dest;
       public boolean red;
        public Edge(int src, int dest,boolean isRed){
            this.src = src;
            this.dest = dest;
            this.red = isRed;
        }

    }

    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < redEdges.length; i++) {
            graph[redEdges[i][0]].add(new Edge(redEdges[i][0],redEdges[i][1],true));
        }

        for (int i = 0; i < blueEdges.length;i++){
            graph[blueEdges[i][0]].add(new Edge(blueEdges[i][0],blueEdges[i][1],false));
        }

        int [] ans = new int[n];


        Queue<int []> q = new LinkedList<>();
        boolean[][]vis = new boolean[n][2];


        // marking starting positions
        q.add(new int[]{0,0});// last was blue
        q.add(new int[]{0,1});// last was red


        vis[0][0] = true;
        vis[0][1] = true;

        // filling the arrays with -1, crucial , somehow done by me
        Arrays.fill(ans,-1);


        int dist = 0;

        // BFS
        while (!q.isEmpty()){

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int [] curr = q.poll();
                int node = curr[0];
                int lastColor = curr[1];

                // set answer if firs time visited
                if(ans[node]==-1){
                    ans[node] = dist;
                }

                for (Edge e: graph[node]){
                    // 1 -> red , 0-> blue
                    int color = e.red?1:0;

                    // alternate color
                    if(color != lastColor && !vis[e.dest][color]){
                        vis[e.dest][color] = true;
                        q.add(new int[]{e.dest, color});
                    }
                }
            }
            dist++;


        }

        return ans;
    }

}
