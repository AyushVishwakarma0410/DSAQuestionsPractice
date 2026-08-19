package Graphs;

import java.util.LinkedList;
import java.util.Queue;



// done in LC
// self done not difficult
public class LC1091 {
    public static void main(String[] args) {

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[0] = true;
        queue.offer(0);
        int pathLength = 0;

        return pathLength;
    }
}
