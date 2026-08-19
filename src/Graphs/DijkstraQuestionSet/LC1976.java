package Graphs.DijkstraQuestionSet;
import java.util.*;


public class LC1976 {
    public static void main(String[] args) {

        int n = 7;
        int [][] roads = {
                {0,6,7},
                {0,1,2},
                {1,2,3},
                {1,3,3},
                {6,3,3},
                {3,5,1},
                {6,5,1},
                {2,5,1},
                {0,4,5},
                {4,6,2}
        };

        int ans = countPaths(n,roads);
        System.out.println(ans);



    }

    static class Edge{
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static long MOD = (int)1e9+7;
    static class Pair implements Comparable<Pair>{
        int node;
        long time;

        Pair(int n, long t){
            node = n;
            time = t;
        }

        @Override
        public int compareTo(Pair p){
            return Long.compare(time,p.time);
        }

    }

    public static int countPaths(int n, int[][] roads) {


        // Graph construction
        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            graph[u].add(new Edge(u,v,w));
            graph[v].add(new Edge(v,u,w));
        }

        // Distance array
        long [] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);

        long [] ways = new long[n];

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0));
        dist[0] = 0;
        ways[0] = 1;

        while (!q.isEmpty()){
            Pair curr = q.poll();

            // optimization condition ( avoiding vis array)
            if(curr.time > dist[curr.node]){
                continue;
            }
            for(Edge e: graph[curr.node]){

                int u = e.src;
                int v = e.dest;
                int edgeT = e.weight;

                if(dist[u]+edgeT < dist[v]){
                    dist[v] = dist[u]+edgeT;
                    ways[v] = ways[u];
                    q.add(new Pair(v,dist[u]+edgeT));
                }else if(dist[u] + edgeT == dist[v]){
                    ways[v] = (ways[v]+ways[u]) % MOD;
                }

            }
        }

        return (int)(ways[n-1] % MOD);

    }
}
