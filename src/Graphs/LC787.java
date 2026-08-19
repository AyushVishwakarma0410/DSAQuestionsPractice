package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// jugaad version
// 95% as i didnt knew how to hold path information so i learned that
public class LC787 {
    public static void main(String[] args) {
        int n = 4;
        int [][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dest = 2;
        int k = 0;

        int ans = findCheapestPrice(n,flights,src,dest,k);

        System.out.println(ans);
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

    static class State{
        int node;
        int cost;

        public State(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        k+=1;
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




        int totalWt = Integer.MAX_VALUE;

        int stops = -1;


        // BFS
        Queue<State> q = new LinkedList<>();
        // visited

        int [][] vis = new int[n][2];

        q.add(new State(src,0));
        vis[src][1] = 0;

        while (!q.isEmpty()){
            int size = q.size();

            stops++;


            for (int i = 0; i < size; i++) {
                State curr = q.poll();
                if(curr.node==dst){
                    totalWt  = Math.min(vis[curr.node][1],totalWt);
                    continue;
                }
                if(k==stops){
                    continue;
                }
                System.out.println(graph[curr.node].size());
                for (int j = 0; j < graph[curr.node].size(); j++) {

                    Edge e = graph[curr.node].get(j);


                    int currWt = curr.cost+e.wt;

                    if(vis[e.dest][1] > currWt || ( vis[e.dest][1]==0 && e.dest!=src)){
                        vis[e.dest][0] = e.dest;
                        vis[e.dest][1] = currWt;
                        q.add(new State(e.dest,currWt));
                    }

                }


            }
        }

        return totalWt;
    }
}



// GPT standard version

/*
public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    ArrayList<Edge>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

    for (int[] f : flights) {
        graph[f[0]].add(new Edge(f[0], f[1], f[2]));
    }

    Queue<State> q = new LinkedList<>();
    q.add(new State(src, 0, 0));

    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    while (!q.isEmpty()) {
        State curr = q.poll();

        if (curr.stops > k) continue;

        for (Edge e : graph[curr.node]) {
            int newCost = curr.cost + e.wt;

            if (newCost < dist[e.dest]) {
                dist[e.dest] = newCost;
                q.add(new State(e.dest, newCost, curr.stops + 1));
            }
        }
    }

    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
}*/