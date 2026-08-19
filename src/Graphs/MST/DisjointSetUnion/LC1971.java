package Graphs.MST.DisjointSetUnion;

import java.util.ArrayList;
import java.util.List;

public class LC1971 {
    public static void main(String[] args) {


        // self done
        ///  NO NEED TO BUILD GRAPH


        int n = 6;
        int [][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int src = 0;
        int dest = 3;

        System.out.println(validPath(n,edges,src,dest));


    }

    static int [] parent;
    static int [] size;


    public static int find(int x){

        if(parent[x]==x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }


    public static void union(int a, int b){

        int pA = find(a);
        int pB = find(b);


        if(pA != pB){
            if(size[pA] < size[pB]){
                parent[pA] = pB;
                size[pB]+= size[pA];
            }else {
                parent[pB] = pA;
                size[pA] += size[pB];
            }

        }

    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {


        parent = new int[n];
        size = new int[n];


        for (int i = 0; i < n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < edges.length; i++) {

            int src = edges[i][0];
            int dest = edges[i][1];

            graph.get(src).add(dest);
            graph.get(dest).add(src);
            union(src,dest);

        }


       return find(source) == find(destination);




    }
}
