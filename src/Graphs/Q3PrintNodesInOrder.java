package Graphs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
public class Q3PrintNodesInOrder {
    public static void main(String[] args) {

        ArrayList<Edge>[] graph = new ArrayList[6];


        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,5));
        graph[1].add(new Edge(1,2,5));
        graph[2].add(new Edge(2,3,5));
        graph[3].add(new Edge(3,0,5));

        BFS(graph);
        DFS(graph,0,new boolean[graph.length]);
    }

    public static void BFS(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();

        boolean[] vis = new boolean[graph.length];

        vis[0] = true;
        q.add(0);
        while (!q.isEmpty()){

            int curr = q.remove();
            vis[curr] = true;
            System.out.println(curr);
            for (int i = 0; i < graph[curr].size(); i++) {

                Edge e = graph[curr].get(i);

                if(!vis[e.dest]){
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }

        }
    }

    public static void DFS(ArrayList<Edge>[] graph,int curr, boolean[] vis){

        System.out.println(curr+" ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                DFS(graph,e.dest,vis);
            }


        }
    }


    public static void DFSLevelWise(ArrayList<Edge>[] graph, int curr, boolean[] vis, int level, ArrayList<ArrayList<Integer>> levels) {

        vis[curr] = true;

        // Ensure the levels list has enough sublists
        if (levels.size() <= level) {
            levels.add(new ArrayList<>());
        }

        // Add current node to its level
        levels.get(level).add(curr);

        // Recur for neighbors
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                DFSLevelWise(graph, e.dest, vis, level + 1, levels);
            }
        }
    }
}
