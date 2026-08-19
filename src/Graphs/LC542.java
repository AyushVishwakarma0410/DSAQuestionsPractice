package Graphs;

import java.util.LinkedList;
import java.util.Queue;




//in 01 matrix, the distance is based on the past values of 1's mean while in rotten oranges the rotting process underways simutaneously

public class LC542 {
    public static void main(String[] args) {

    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        // Step 1: Add all 0s to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : directions) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && !vis[newRow][newCol]) {
                    mat[newRow][newCol] = mat[curr[0]][curr[1]] + 1;
                    vis[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

        return mat;
    }

}
