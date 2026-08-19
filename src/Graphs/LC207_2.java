package Graphs;
import java.util.*;
public class LC207_2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        // self done
        // kahns algorithm


// graph creation
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph1.add(new ArrayList<>());
        }


        int [] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {

            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];

            graph1.get(src).add(dest);
            indegree[dest]++;
        }


        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }

//        List<Integer> list = new ArrayList<>();
            int count = 0;

        while (!q.isEmpty()){
            int u = q.poll();
//                list.add(u);
            count++;
            for(int v : graph1.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }

        ///  I dont need the list of elements traversed, I only need if all of them are traversed
//        return list.size() == numCourses;
        return count==numCourses;
    }

}
