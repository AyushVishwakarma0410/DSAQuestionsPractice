package Graphs;

import java.util.*;


// This is pattern 5 State simulation or . STATE GRAPH / CONFIGURATION BFS (⚠️ HARD)





//🧠 Key Takeaway (Very Important)
//
//👉 Always use immutable types (String) for:
//
//HashSet
//HashMap keys
//BFS states








public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        // Step 1: Convert 2D board to string
        String start = boardToString(board);
        String target = "123450";

        // Step 2: Define neighbors for each index
        int[][] neighbors = {
                {1, 3},      // index 0
                {0, 2, 4},   // index 1
                {1, 5},      // index 2
                {0, 4},      // index 3
                {1, 3, 5},   // index 4
                {2, 4}       // index 5
        };

        // Step 3: BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int moves = 0;

        // Step 4: BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                // Step 5: Check if solved
                if (curr.equals(target)) return moves;

                // Step 6: Find '0' position
                int zeroIndex = curr.indexOf('0');

                // Step 7: Try all swaps
                for (int neighbor : neighbors[zeroIndex]) {
                    String next = swap(curr, zeroIndex, neighbor);

                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            moves++; // Step 8: Increase level
        }

        return -1; // not solvable
    }

    // Convert board to string
    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    // Swap characters in string
    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}