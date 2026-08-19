package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




// correct idea but wrong implementation
// had (N x M)^2 time complexity
// done by gpt



public class LC417 {
    public static void main(String[] args) {

        int [][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> ans = pacificAtlantic(heights);


        for (int i = 0; i < ans.size() ; i++) {
            System.out.print("{");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println("}");
        }

    }
//    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
//
//        boolean [][] pacific = new boolean[heights.length][heights[0].length];
//        boolean [][] atlantic = new boolean[heights.length][heights[0].length];
//
//
//        for (int i = 0; i < heights.length; i++) {
//            for (int j = 0; j < heights[i].length; j++) {
//                boolean[][] vis = new boolean[heights.length][heights[0].length];
//
//                find(heights,pacific,atlantic,i,j,i,j,vis);
//
//
//            }
//        }
//
//        List<List<Integer>> list = new ArrayList<>();
//
//        for (int i = 0; i < heights.length; i++) {
//
//            for (int j = 0; j < heights[i].length; j++) {
//                if(pacific[i][j] && atlantic[i][j]){
//                    List<Integer> ans = new ArrayList<>();
//                    ans.add(i);
//                    ans.add(j);
//                    list.add(new ArrayList<>(ans));
//                }
//            }
//        }
//
//        System.out.println("Pacific");
//        print(pacific);
//
//        System.out.println("Pacific");
//        print(atlantic);
//        return list;
//
//    }
//
//    public static void print(boolean [][] arr){
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//    }
//
//
//
//
//    public static void find(int [][] heights, boolean [][] pacific,boolean[][] atlantic,int i,int j,int p1, int p2,boolean[][]vis){
//
//        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length){
//            return;
//        }
//        if(vis[i][j]){
//            return;
//        }
//        vis[i][j] = true;
//
//        if(heights[i][j] > heights[p1][p2]){
//            return;
//        }
//
//        if(i == 0|| j == 0){
//            pacific[i][j]=true;
//        }
//        if(i == heights.length-1 || j == heights[0].length-1){
//            atlantic[i][j]=true;
//        }
//
//        if (pacific[i][j]){
//            pacific[p1][p2]=true;
//        }
//        if (atlantic[i][j]){
//            atlantic[p1][p2]=true;
//        }

//
//
//
//        find(heights,pacific,atlantic,i+1,j,i,j,vis);
//        find(heights,pacific,atlantic,i,j+1,i,j,vis);
//        find(heights,pacific,atlantic,i-1,j,i,j,vis);
//        find(heights,pacific,atlantic,i,j-1,i,j,vis);
//
//
//    }





      public static List<List<Integer>> pacificAtlantic(int[][] heights) {

            int R = heights.length;;
            int C = heights[0].length;

            boolean[][] pacific = new boolean[R][C];
            boolean[][] atlantic = new boolean[R][C];

            // pacific
          for (int i = 0; i < R; i++) {
              dfs(heights,pacific,i,0);
              dfs(heights,atlantic,i,C-1);
          }

          // atlantic
          for (int i = 0; i < C; i++) {
              dfs(heights,pacific,0,i);
              dfs(heights,atlantic,R-1,i);
          }

          List<List<Integer>> result = new ArrayList<>();
          for (int i = 0; i < R; i++) {
              for (int j = 0; j < C; j++) {
                  if (pacific[i][j] && atlantic[i][j]) {
                      result.add(Arrays.asList(i, j));
                  }
              }
          }

          return result;
      }

      public static void dfs(int [][] heights,boolean[][] reachable,int r,int c){
            reachable[r][c] = true;

            int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

            for (int [] dir : directions){
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                //1. check boundaries
                if(nextR < 0 || nextR >= heights.length || nextC < 0 || nextC >= heights[0].length){
                    continue;
                }

                //2. Check already visited to prevent infinite loop
                if(reachable[nextR][nextC]){
                    continue;
                }

                // 3. Only move uphill
                if(heights[nextR][nextC] >= heights[r][c]){
                    dfs(heights, reachable, nextR, nextC);
                }
            }
      }

}
