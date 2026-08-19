package Graphs.MST.DisjointSetUnion;

public class Optimized_DSU {

    class DSU{
        int [] parent;

        DSU(int n){
            parent = new int[n+1];

            for (int i = 0; i <= n ; i++) {
                parent[i] = i;
            }
        }

        int find(int x){

            if(parent[x] == x){
                return x;
            }

            return parent[x] = find(parent[x]);

        }
        void union(int a,int b){
            int pA = find(a);
            int pB = find(b);

            if(pA != pB){
                parent[pA] = pB;
            }
        }

    }
}
