package Graphs;

import java.util.*;

public class Test{
    public static void main(String[] args) {

    }


    public boolean isBipartite(int[][] graph) {

        int [] color = new int[graph.length];


        for (int i = 0 ; i < graph.length ; i++){

            if(color[i]==0){
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;
            while (!q.isEmpty()){
                int curr = q.poll();

                for (int neigh : graph[curr]){
                    if(color[neigh] == 0){
                        color[neigh] = -color[curr];
                        q.add(neigh);
                    }
                    else if(color[neigh]==color[curr]){
                        return false;
                    }
                }

            }

        }

        return true;





    }

}