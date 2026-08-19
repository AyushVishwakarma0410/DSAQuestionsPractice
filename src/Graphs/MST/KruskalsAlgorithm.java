package Graphs.MST;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class KruskalsAlgorithm {

    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src, int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }


    public static ArrayList<Edge>[] buildGraph(int [][] edges, int V){

            // building graphh codeee

        return null;
    }

    static int [] parent;
    static int [] size;

    static int find(int x){

        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        int pA = find(a);
        int pB = find(b);

        if(pA != pB){
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

    public static int mst(int [][] edges,int n){

        ArrayList<Edge> edgesList = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            edgesList.add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
        }


        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Collections.sort(edgesList, (a,b) -> a.wt - b.wt);

        int mstCost= 0;
        int edgeUsed = 0;

        for (int i = 0; i < edgesList.size() && edgeUsed!= n-1; i++) {

            Edge e = edgesList.get(i);

                int u = e.src;
                int v = e.dest;

                if(find(u) != find(v)){
                    union(u,v);
                    mstCost += e.wt;
                    edgeUsed++;
                }
        }


        return mstCost;
    }
}
