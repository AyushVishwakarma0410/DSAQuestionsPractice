package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC210 {
    public static void main(String[] args) {

        int [][] n = {{1,0},{2,0},{3,1},{3,2}};

        System.out.println(Arrays.toString(findOrder(4,n)));

    }
    static class Edge{
        int dest;
        Edge(int dest){
            this.dest = dest;
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {


        // graph creation
        ArrayList<Edge>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(new Edge(prerequisites[i][0]));
        }

        // BFS
        int [] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for(Edge e : graph[i]){
                inDegree[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses ; i++){
            if(inDegree[i]==0)
                q.add(i);
        }

        int count = 0;

        int [] ans = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;
            count++;
            for (Edge e : graph[node]){
                int neigh = e.dest;
                inDegree[neigh]--;
                if(inDegree[neigh]==0){
                    q.add(neigh);
                }
            }

        }

        System.out.println("NC :"+ numCourses + ", count "+ count );

        if(numCourses == count){
            return ans;
        }
        else {
            return new int[]{};
        }

    }
}
