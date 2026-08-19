package Queues;

import java.util.*;

public class LC994 {
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};

        System.out.println(orangesRotting(arr));

    }





    public static int orangesRotting(int[][] grid) {
            // lengths
            int rows  = grid.length;
            int cols = grid[0].length;

            // storing arrays
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;



        // This is storing pairs, which i was searching for
        // Adding all rotten oranges to the queue

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // new int [] {//values } creates a 1D array and stores values in pair

                // storing
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
                // counting fresh
                else if (grid[i][j]==1)
                        fresh++;
            }
        }

        // setting up directions,
        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // BFS
        while (!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++){
                int [] current = queue.poll();

                /// Moving forward in each direction -> array method
                ///  we also have manual if else and class object method as well
                for (int [] dir : directions){
                    // moving forward
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];

                    if(newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol]==1){

                        grid[newRow][newCol] = 2;
                        queue.add(new int[] {newRow,newCol});
                        fresh--;
                    }

                }

                // we could have done
                /*

                int row = current[0];
                int col = current[1];

                // Down
                if (row + 1 < rows && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.add(new int[]{row + 1, col});
                }

                // Up
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.add(new int[]{row - 1, col});
                }

                // Right
                if (col + 1 < cols && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.add(new int[]{row, col + 1});
                }

                // Left
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.add(new int[]{row, col - 1});
                }



                * */
            }
        }

        return fresh == 0 ? minutes : -1;







    }






























//    public static int orangesRotting(int[][] grid) {
//            List<List<Integer>> list = new ArrayList<>();
//
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if(grid[i][j]== 2){
//                    list.add(Arrays.asList(i,j));
//                }
//            }
//        }
//
//        int ans = 0;
//        for (int i = 0; i < list.size();i++){
//            int first = list.get(i).get(0);
//            int second = list.get(i).get(1);
//            ans = rot(grid,first,second,0);
//        }
//
//
//        /*  // much better
//        * for (List<Integer> pair : list) {
//        int first = pair.get(0);
//        int second = pair.get(1);
//
//        System.out.println(first + " " + second);
//}
//        *
//        *
//        *
//        *
//        * */
//
//        return ans ;
//    }
//DFS doesnt work
//    public static boolean rot(int[][] grid, int i, int j, int ans) {
//
//        if(i < 0 || i > grid.length || j < 0 || j > grid[0].length){
//            return false;
//        }
//
//        if(rot(grid,i+1,j+1,ans) || rot(grid,i-1,j-1,ans) || rot(grid,i-1,j+1,ans)||rot(grid,i,j+1,ans) || rot()){
//            ans = ans +1;
//        }
//





}