package Graphs.MST.DisjointSetUnion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC323 {



    ///  NO NEED FOR BUILDING GRAPH

    // self done

    public static void main(String[] args) {

        LC323 obj = new LC323();

        int n = 5;
        int edges[][] = {{0,1},{1,2},{2,3},{3,4}};


        System.out.println(obj.connectedComponents(edges,n));


    }

    int [] parent;
    int [] size;


    public int find(int x){

        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);

    }

    public void union(int a, int b){
        int pA = find(a);
        int pB = find(b);

        if(pA!=pB){

            if(size[pA] > size[pB]){
                parent[pB] = pA;
                size[pA] += size[pB];
            }
            else {
                parent[pA] = pB;
                size[pB] += size[pA];
            }

        }
    }

    public int connectedComponents(int [][] edges,int n){

        List<List<Integer>> graph = new ArrayList<>();

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }


        for (int i = 0; i  < n ; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int src = edges[i][0];
            int dest = edges[i][1];

            graph.get(src).add(dest);
            graph.get(dest).add(src);

            union(src,dest);

        }


        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < parent.length; i++){
            set.add(find(i));
        }




        return set.size();

    }
}
