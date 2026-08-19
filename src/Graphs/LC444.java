package Graphs;

import java.util.*;


public class LC444 {
    public static void main(String[] args) {

    }



    // it's almost done -> small fixes
    // learned that, topological sort has multiple uses
    // the number of nodes which are added in the q can give us the information that
    // do we have multiple topological orders or not
    public static boolean sequenceReconstruction(int [] nums, int[][] sequences){

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <=nums.length;i++){
            graph.add(new ArrayList<>());
        }

        int [] inDegree = new int[nums.length+1];

        for (int i = 0 ; i < sequences.length ; i++) {
            graph.get(sequences[i][0]).add(sequences[i][1]);
            inDegree[sequences[i][1]]++;
        }

//        int [] ans = new int[nums.length];



        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= inDegree.length; i++) {
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        int idx = 0;


        while (!q.isEmpty()){


            if(q.size() > 1){
                return false;
            }

            int curr = q.poll();
//            ans[idx++] = curr;

            if(nums[idx]!= curr){
                return false;
            }
            idx++;

            for (int i = 0; i < graph.get(curr).size(); i++) {

                int neigh = inDegree[graph.get(curr).get(i)];
                inDegree[neigh]--;

                 if(neigh==0){
                    q.add(neigh);
                }
            }
        }

//        idx = 0;
//        while (idx < nums.length){
//            if(nums[idx]!=ans[idx]){
//                return false;
//            }
//
//            idx++;



        return true;

    }
}



///  CORRECT VERSION might use in revision

/*
import java.util.*;

public class LC444 {

    public static boolean sequenceReconstruction(int[] nums, int[][] sequences){

        int n = nums.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];

        // build graph correctly
        for (int[] seq : sequences) {
            for (int i = 0; i < seq.length - 1; i++) {
                graph.get(seq[i]).add(seq[i + 1]);
                inDegree[seq[i + 1]]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int idx = 0;

        while (!q.isEmpty()) {

            if (q.size() > 1) return false;

            int curr = q.poll();

            if (idx >= n || nums[idx] != curr) return false;
            idx++;

            for (int neigh : graph.get(curr)) {
                inDegree[neigh]--;

                if (inDegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }

        return idx == n;
    }
}
 */
