package Graphs;
import java.util.*;


public class LC1136_ParallelCourses {
    public static void main(String[] args) {
        int n = 3;
        int [][] relations = {{1,3},{2,3}};

        System.out.println("OUTPUT : "+parallelCourses(n,relations));
    }

    public static int parallelCourses(int n, int [][] relations ){


        // graph
        List<Integer>[] graph = new ArrayList[n+1];

        int [] inDegree = new int[n+1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < relations.length; i++) {

            int src = relations[i][0];
            int dest = relations[i][1];

            graph[src].add(dest);

            inDegree[dest]++;

        }

        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        int nodeCount = 0;

        for (int i = 1; i < inDegree.length; i++) {
            if(inDegree[i]==0){
                q.add(i);
            }
        }



        while (!q.isEmpty()){

            int size = q.size();
            answer++;
            for (int i = 0; i < size ; i++) {

                int curr = q.poll();
                nodeCount++;
                for (int neigh : graph[curr]){
                    inDegree[neigh]--;
                    if(inDegree[neigh]==0){
                        q.add(neigh);
                    }
                }



            }

        }


        System.out.println("Node Count :"+ nodeCount);
        System.out.println("Answer :"+ answer);

        return nodeCount==n?answer:-1;
    }
}
