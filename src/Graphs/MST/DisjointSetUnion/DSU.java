package Graphs.MST.DisjointSetUnion;

public class DSU {
    public static void main(String[] args) {

    }

    class dsu{
        int [] parent;

        dsu(int n){
            parent = new int[n+1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

         int find(int x){
            while (parent[x] != x){
                x = parent[x];
            }
            return x;
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
