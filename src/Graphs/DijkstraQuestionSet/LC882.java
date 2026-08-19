///  A new Pattern Dijkstra’s Algorithm on a Subdivided Graph.






///  GEMINI

//public int reachableNodes(int[][] edges, int maxMoves, int n) {
//    // 1. Build Adjacency List
//    List<int[]>[] adj = new ArrayList[n];
//    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
//    for (int[] e : edges) {
//        adj[e[0]].add(new int[]{e[1], e[2]});
//        adj[e[1]].add(new int[]{e[0], e[2]});
//    }
//
//    // 2. Dijkstra to find max moves remaining at each node
//    // pq stores {remaining_moves, node}
//    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
//    pq.add(new int[]{maxMoves, 0});
//
//    // dist[i] will store the max moves we had when reaching node i
//    int[] dist = new int[n];
//    Arrays.fill(dist, -1);
//
//    int totalReachable = 0;
//
//    while (!pq.isEmpty()) {
//        int[] curr = pq.poll();
//        int moves = curr[0];
//        int u = curr[1];
//
//        if (dist[u] != -1) continue; // Already visited with more/equal moves
//
//        dist[u] = moves;
//        totalReachable++; // Count the original node
//
//        for (int[] neighbor : adj[u]) {
//            int v = neighbor[0];
//            int weight = neighbor[1];
//            int remainingAfterEdge = moves - weight - 1;
//
//            if (remainingAfterEdge >= 0 && dist[v] == -1) {
//                pq.add(new int[]{remainingAfterEdge, v});
//            }
//        }
//    }
//
//    // 3. Count subdivided nodes on edges
//    for (int[] e : edges) {
//        int u = e[0], v = e[1], w = e[2];
//        // Reach from u: if u was reached, moves = dist[u]
//        int reachU = dist[u] == -1 ? 0 : dist[u];
//        // Reach from v: if v was reached, moves = dist[v]
//        int reachV = dist[v] == -1 ? 0 : dist[v];
//
//        totalReachable += Math.min(w, reachU + reachV);
//    }
//
//    return totalReachable;
//}


//package Graphs;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//public class LC882 {
//    public static void main(String[] args) {
//
//        int [][] edges = {{0,1,10},{0,2,1},{1,2,2}};
//        int maxMoves = 6;
//        int n = 3;
//
//        System.out.println(reachableNodes(edges,maxMoves,n));
//
//
//
//
//    }
//
//    static class Edge{
//        int src;
//        int dest;
//        int wt;
//        Edge(int s, int d, int w){
//            src = s;
//            dest = d;
//            wt = w;
//        }
//    }
//
//
//    static class State implements Comparable<State>{
//        int node;
//        int leftMoves;
//        int nodeVisit;
//        int parent;
//
//        State(int n, int w,int nw,int parent){
//            node = n;
//            leftMoves = w;
//            nodeVisit = nw;
//            this.parent = parent;
//
//        }
//
//        @Override
//        public int compareTo(State s){
//            return Integer.compare(leftMoves,s.leftMoves);
//        }
//    }
//
//    public static int reachableNodes(int[][] edges, int maxMoves, int n) {
//
//        ArrayList<Edge>[] graph = new ArrayList[n];
//
//        boolean [] vis = new boolean[n];
//
//
//        for (int i = 0; i < n; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < edges.length; i++) {
//            int src = edges[i][0];
//            int dest = edges[i][1];
//            int wt = edges[i][2];
//            graph[src].add(new Edge(src,dest,wt));
//        }
//
//        PriorityQueue<State> q = new PriorityQueue<>();
//
//        q.add(new State(0,0,1,-1));
//        vis[0] = true;
//
//        int ans = 0;
//        int maxNodeVisit = 0;
//
//        while (!q.isEmpty()){
//
//            State curr = q.poll();
//
//            int moves = curr.leftMoves;
//            int node = curr.node;
//            int nw = curr.nodeVisit;
//            vis[node] = true;
//
//            if(moves==maxMoves){
//                if(nw > maxNodeVisit){
//                    maxNodeVisit = nw;
//                    ans = Math.max(moves,ans);
//                }
//            }
//
//
//            for (Edge neigh : graph[node]){
//                int dest = neigh.dest;
//                int EdgeWeight = neigh.wt;
//
//                if(dest!=curr.parent) {
//                    if (EdgeWeight + 1 > moves) {
//                        ans += moves;
//                    } else if (EdgeWeight + 1 < moves) {
//                        if (!vis[dest])
//                            q.add(new State(dest, moves - (EdgeWeight + 1), ans+nw + EdgeWeight + 1, node));
//                    }
//                }
//            }
//
//        }
//
//        return ans;
//
//    }
//}
