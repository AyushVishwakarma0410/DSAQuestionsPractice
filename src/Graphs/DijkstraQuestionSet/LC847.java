///  Graph bitMasking BFS
package Graphs.DijkstraQuestionSet;
import java.util.LinkedList;
import java.util.Queue;


public class LC847 {

    public static void main(String[] args) {

    }

    // I already saw the code my writing on my own

    static class Pair{

        int node;
        int mask;
        int dist;

        Pair(int n, int m, int d){
            node = n;
            mask = m;
            dist = d;
        }

    }


    public static int shortestPathLength(int[][] graph) {


        int n = graph.length;
        // suppose I have 4 nodes then 1 << 4 = 10000, then 1111
        int finalMask = (1 << n)-1;


        // suppose we have 2 nodes, then each node may have two choices:
        // visited or not visited
        /*
        *    00  01  10  11
        * 0  F   T   F   F
        * 1  F   F   F   T
        *
        * */

        boolean [][] vis = new boolean[n][1 << n];
        System.out.println(1 << n);


        Queue<Pair> Q = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            int mask = (1 << i);
            Q.add(new Pair(i,mask,0)); // remember q will have nodes with different masks, therefore
                                          // even if all the nodes are visited to be true, but they will have different masks, int visited array

            vis[i][mask] = true;
        }


        while (!Q.isEmpty()){

            Pair curr = Q.poll();

            if(curr.mask == finalMask){
                return curr.dist;
            }

            for (int neigh : graph[curr.node]){
                int newMask = curr.mask | (1 << neigh);

                if(!vis[neigh][newMask]){
                    vis[neigh][newMask] = true;

                    Q.offer(new Pair(neigh,newMask,curr.dist+1));
                }
            }
        }


        return -1;

    }


}
