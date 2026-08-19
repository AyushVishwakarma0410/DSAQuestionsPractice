package Graphs.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1584_ {



    public static void main(String[] args) {




    }




    static class Pair implements Comparable<Pair>{

        // point idx
        int node;
        int cost;

        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }


        @Override
        public int compareTo(Pair p){
            return Integer.compare(cost,p.cost);
        }

    }


    // lazy prims

    public static int minCostConnectPoints(int[][] points) {

        int n = points.length;

//        int [] dist = new int[n];
//        Arrays.fill(dist,Integer.MAX_VALUE);

        boolean [] vis = new boolean[n];

        int minDist = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0));

        while (!q.isEmpty()){

            // pulling index of points array, here we are not directly using the points []
            // instead we are tracking indices one by one
            Pair curr = q.poll();


            int currNode = curr.node;

            // making index of points [] array to be visited
            if(vis[currNode]) continue;
            vis[currNode] = true;

            // adding the total distance
            minDist += curr.cost;


            // retrieving the points
            int x1 = points[currNode][0];
            int y1 = points[currNode][1];

            for (int i = 0; i < n; i++) {

                // retrieving the new points
                int x2 = points[i][0];
                int y2 = points[i][1];


                // if point no visited then adding the index to the q.
                if(!vis[i]){
                    int d =  Math.abs(x2-x1)+Math.abs(y2-y1);
                    q.add(new Pair(i,d));
                }

            }

        }

        return minDist;
    }




//
//    public static int minCostConnectPoints(int[][] points) {
//
//
//        int n = points.length;
//
//        boolean[] visited = new boolean[n];
//
//        int [] minDist = new int[n];
//
//        Arrays.fill(minDist,Integer.MAX_VALUE);
//
//        minDist[0] = 0;
//
//        int result = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            int u = -1;
//
//            for (int j = 0; j < n; j++) {
//
//                if(!visited[j] && (u==-1 || minDist[j] < minDist[u])){
//                    u = j;
//                }
//
//            }
//
//
//            visited[u]  = true;
//            result+= minDist[u];
//
//            int x1 = points[u][0];
//            int y1 = points[u][1];
//
//
//            for(int v = 0 ; v < n ; v++){
//
//                if(!visited[v]){
//                    int x2 = points[v][0];
//                    int y2 = points[v][1];
//
//                    int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
//
//                    minDist[v] = Math.min(minDist[v],dist);
//
//                }
//
//            }
//
//        }
//
//
//        return result;
//
//    }
}
