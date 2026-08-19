package Graphs.Youtube.CycleDetection;

import Graphs.TraversalsTechiques.Edge;

import java.util.*;

public class CycleDetectionDirectedGraphBFSByMe {


    static class State{
        int node;
        Set<Integer> rec;

        State(int node, Set<Integer> rec){
            this.node = node;
            this.rec = rec;

        }
    }
    public static void cycleDetectionDirectedBFS(ArrayList<Edge>[] graph) {

        int n = graph.length;

        Queue<State> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            Set<Integer> set = new HashSet<>();
            q.add(new State(i, set));
        }

        while (!q.isEmpty()) {

            State curr = q.poll();

            int node = curr.node;
            Set<Integer> currRec = curr.rec;

            currRec.add(node);

            for (Edge e : graph[node]) {

                if (currRec.contains(e.dest)) {

                    System.out.println("Contains Cycle");
                    return;
                }

                q.add(new State(e.dest,
                        new HashSet<>(currRec)));
            }
        }

        System.out.println("No Cycle");
    }
}
