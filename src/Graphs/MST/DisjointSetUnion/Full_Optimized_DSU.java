package Graphs.MST.DisjointSetUnion;

public class Full_Optimized_DSU {

    class DSU{
        int [] parent ;
        int [] size ;

        DSU(int n){
            parent = new int[n+1];
            size = new int[n+1];
            for (int i = 0; i <=n ; i++) {
                parent[i] = i;
                size[i] = 1;
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
//                parent[pA] = pB;
                if(size[pA] < size[pB]){
                    parent[pA] = pB;
                    size[pB] += size[pA];
                }else {
                    parent[pB] = pA;
                    size[pA] += size[pB];
                }

            }
        }


    }


    public static void main(String[] args) {

    }


}
