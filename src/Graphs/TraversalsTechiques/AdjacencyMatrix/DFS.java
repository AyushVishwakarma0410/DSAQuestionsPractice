package Graphs.TraversalsTechiques.AdjacencyMatrix;

public class DFS {
    public static void main(String[] args) {

    }

    public static void dfs(int [][] graph, int curr, boolean [] vis){

        System.out.println(curr+" ");
        vis[curr] = true;

        for (int v = 0; v < graph.length; v++) {

            if(graph[curr][v] == 1 && !vis[v])
                dfs(graph,v,vis);
        }

    }
}
