package Graphs;
import java.util.*;

public class LC2392 {
    public static void main(String[] args) {


    }



    // REDO
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

//        int [] inDegree = new int[k];
//
//        List<List<Integer>> rowGraph = buildGraph(rowConditions,k,inDegree);
//
//        List<Integer> rowCord = topologicalSort(rowGraph,inDegree);
//
//        List<List<Integer>> colGraph = buildGraph(colConditions,k,inDegree);
//
//        List<Integer> colCord = topologicalSort(colGraph,inDegree);
//
//        int [][] matrix = new int[k][k];

        int[] rowInDegree = new int[k + 1];
        int[] colInDegree = new int[k + 1];

        List<List<Integer>> rowGraph = buildGraph(rowConditions, k, rowInDegree);
        List<List<Integer>> colGraph = buildGraph(colConditions, k, colInDegree);

        List<Integer> rowOrder = topologicalSort(rowGraph, k);
        List<Integer> colOrder = topologicalSort(colGraph, k);



        // cycle check
        if (rowOrder.size() != k || colOrder.size() != k) {
            return new int[0][0];
        }

        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }

        int[][] matrix = new int[k][k];

        for (int num = 1; num <= k; num++) {
            matrix[rowPos[num]][colPos[num]] = num;
        }

        return matrix;

    }

    public static List<List<Integer>> buildGraph(int [][] cords,int k,int [] inDegree){

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= k; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < cords.length; i++) {
            graph.get(cords[i][0]).add(cords[i][1]);
            inDegree[cords[i][1]]++;
        }

        return graph;
    }

    public static  List<Integer> topologicalSort(List<List<Integer>> graph, int k){

        Stack<Integer> stack = new Stack<>();
        int [] vis = new int[k+1];

        for (int i = 1; i <= k; i++) {
            if(vis[i]==0){
               if(!dfs(graph,i,vis,stack))
                    return new ArrayList<>();
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            order.add(stack.pop()); // reverse order
        }
        return order;

    }

    public static boolean dfs(List<List<Integer>> graph, int curr, int [] vis, Stack<Integer> stack){

        vis[curr] = 1; // visiting

        for (int i = 0; i < graph.get(curr).size(); i++) {
            int neigh = graph.get(curr).get(i);

            if(vis[neigh]==1){
                return false; // cycle
            }

            if(vis[neigh]==0){
                if(!dfs(graph,neigh,vis,stack)){
                    return false;
                }
            }

        }

        vis[curr] = 2;
        stack.push(curr);
        return true;
    }
}
