package Graphs.Youtube.MinimumSpanningTreeMST;



import java.util.ArrayList;
import java.util.PriorityQueue;



// E log E
public class PrimsAlgorithm {
    public static void main(String[] args) {

    }

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }


    static class Pair implements Comparable<Pair>{
        int node;
        int cost;
         public Pair(int n,int c){
             node = n;
             cost = c;
         }

        @Override
         public int compareTo(Pair p2){
             return this.cost - p2.cost; // ascending order
         }


    }
    public static void primsAlgo(ArrayList<Edge> []graph, int V){

        PriorityQueue<Pair> q = new PriorityQueue<>();// non mst
        boolean[] vis = new boolean[V]; // mst

        q.add(new Pair(0,0));

        int mstCost = 0;

        while (!q.isEmpty()){
            Pair curr = q.remove();

            if(!vis[curr.node]){
                vis[curr.node] = true;
                mstCost+= curr.cost;


                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        q.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }


        System.out.println("minimum Cost of MST :"+ mstCost);

    }
}
