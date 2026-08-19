package Graphs;
import java.util.Arrays;
public class LC785 {
    public static void main(String[] args) {

        int [][] graph = {{1,2},{1,3},{2,4}};


        boolean ans = isBipartite(graph);
        System.out.println(ans);
    }
    public static boolean isBipartite(int[][] graph) {
        int [] color = new int[graph.length];


        boolean [] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                if (!check(graph,vis, i,-1 , color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int [][] graph, boolean [] vis, int curr, int parent, int [] color){

        // 1 -> red , 2 -> blue
        vis[curr] = true;
        if(color[curr]==0){
            if( parent!=-1 && color[parent]==1){
                color[curr] = 2;
            }else {
                color[curr] = 1;
            }
        }


        for(int neigh : graph[curr]){

            if(vis[neigh] && parent!=neigh){
               if(color[neigh]==color[curr]){
                   return false;
               }
            }
            if(!vis[neigh]){
                if(!check(graph,vis,neigh,curr,color)){
                    return false;
                }
            }
        }

        return true;

    }
}



// bfs


/*
public static boolean isBipartite(int[][] graph) {
    int[] color = new int[graph.length]; // 0 = unvisited, 1 and -1 = colors

    for (int i = 0; i < graph.length; i++) {
        if (color[i] != 0) continue;

        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int neigh : graph[curr]) {
                if (color[neigh] == 0) {
                    color[neigh] = -color[curr];
                    q.add(neigh);
                } else if (color[neigh] == color[curr]) {
                    return false;
                }
            }
        }
    }
    return true;
}
 */
