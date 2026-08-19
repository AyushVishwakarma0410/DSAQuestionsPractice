package Graphs.DijkstraQuestionSet;

import java.util.*;

public class LC787_Dijkstra {
    public static void main(String[] args) {
        int n = 5;
        int [][] flights = {{1,0,5},{2,1,5},{3,0,2},{1,3,2},{4,1,1},{2,4,1}};
        int src = 2;
        int dest = 0;
        int k = 2;

        int ans = findCheapestPrice(n,flights,src,dest,k);

        System.out.println(ans);
    }

    static class Pair implements Comparable<Pair>{

        int node;
        int dist;
        int stops;

        Pair(int n, int d,int s){
            node = n;
            dist = d;
            stops = s;
        }


        @Override
        public int compareTo(Pair p){
            return Integer.compare(dist,p.dist);
        }


    }

    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;

        }
    }



    // unnecessary hassle
    /*import java.util.*;



Meaning of Dimensions
dist[node][f]

Interpret it as:

Part	Meaning
node	current node/city reached
f	how many flights(edges) were used to reach it





class Solution {

    static class Pair implements Comparable<Pair> {
        int node;
        int cost;
        int stops;

        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.cost, p.cost);
        }
    }

    static class Edge {
        int dest;
        int wt;

        Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Graph creation
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            graph[f[0]].add(new Edge(f[1], f[2]));
        }

        // dist[node][stops]
        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0, 0));

        dist[src][0] = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;

            // Destination reached
            if (node == dst) {
                return cost;
            }

            // Can't take more flights
            if (stops > k) {
                continue;
            }

            for (Edge e : graph[node]) {

                int next = e.dest;
                int newCost = cost + e.wt;

                // Relaxation using stops dimension
                if (newCost < dist[next][stops + 1]) {

                    dist[next][stops + 1] = newCost;

                    pq.add(new Pair(next, newCost, stops + 1));
                }
            }
        }

        return -1;
    }
}*/


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // graph declaration
        ArrayList<Edge>[] graph = new ArrayList[n];

        // graph initialization
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // putting values in graph
        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            graph[source].add(new Edge(source,dest,wt));
        }

        int res = Integer.MAX_VALUE;

        int [] dist = new int[n];
//        boolean[] vis = new boolean[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(src,0,-1));

        while (!q.isEmpty()){

            Pair curr = q.poll();
            int node = curr.node;

            System.out.println("Current Node :"+ curr.node);

            if(curr.node==dst){
                 res = Math.min(res, curr.dist);
                 continue;
            }

//            if(vis[node]){
//                continue;
//            }

//            vis[node]=true;
            curr.stops+=1;

            if(curr.stops > k){
                continue;
            }

            for(Edge e : graph[curr.node]){

                int u = e.src;
                int v = e.dest;
                if(dist[u] + e.wt < dist[v]){
                    dist[v] = dist[u]+e.wt;
                    q.add(new Pair(v,dist[v],curr.stops));
                }
            }

        }


        return res==Integer.MAX_VALUE?-1:res;


    }


}
