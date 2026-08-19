package Graphs.MST;

import java.util.ArrayList;
import java.util.PriorityQueue;

// redo

/*
LeetCode 1135, Imagine you are a network
engineer tasked with connecting $N$ cities (labeled from $1$ to $N$) with highways.
You are given a 2D array called connections, where each element is a triplet: connections[i] = [city1,
city2, cost]. This represents a bidirectional highway that can be built between city1 and city2 for
a specific cost.Your goal is to return the minimum cost to connect all $N$ cities such that there is
a path (direct or indirect) between any two cities.The CatchIf it is physically impossible to connect
all the cities together with the given highways (i.e., the graph is disconnected into separate,
unreachable islands), you must return -1.


Conceptual ExampleLet's look at a concrete
scenario:Input:$N = 3$ (Cities 1, 2, and 3)connections = [[1, 2, 5], [1, 3, 6], [2, 3, 1]]
Step-by-Step Analysis:We have three possible roads we can build:City 1 to City 2 for
a cost of 5City 1 to City 3 for a cost of 6City 2 to City 3 for a cost of 1If we pick the road
 between 2 and 3 (cost 1), and the road between 1 and 2 (cost 5), all three cities are connected
 ($1 \leftrightarrow 2 \leftrightarrow 3$).Total minimum cost = $1 + 5 = 6$.Output: 6
 */


public class LC1135 {
    public static void main(String[] args) {

    }

    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w){
            src = s;
            dest = d;
            wt = w;
        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p){
            return Integer.compare(this.cost, p.cost);
        }
    }




    //Input: Number of cities $n$ and a 2D array of connections where connections[i] = [cityA, cityB, cost].
    public static int minimumCost(int [][] connections,int n){

        ArrayList<Edge>[] graph = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < connections.length; i++) {

            int u = connections[i][0];
            int v = connections[i][1];
            int w = connections[i][2];

            graph[u].add(new Edge(u,v,w));
            graph[v].add(new Edge(v,u,w));
        }


        PriorityQueue<Pair> q = new PriorityQueue<>();
        int minCost = 0;
        int vertexCount = 0; // tracking if all cities are visited or not
        boolean [] vis = new boolean[n+1];

        q.add(new Pair(1,0));

        while (!q.isEmpty()){

            Pair curr = q.poll();

            if(vis[curr.node]) continue;
            vis[curr.node] = true;

            minCost += curr.cost;
            vertexCount++;
            for (int i = 0; i < graph[curr.node].size(); i++) {
                Edge e = graph[curr.node].get(i);

                if(!vis[e.dest]){
                    q.add(new Pair(e.dest,e.wt));
                }

            }

        }


        return vertexCount ==n?minCost : -1;

    }
}
