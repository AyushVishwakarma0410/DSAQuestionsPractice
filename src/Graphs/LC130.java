package Graphs;

import java.util.ArrayList;
import java.util.List;

public class LC130 {
    public static void main(String[] args) {

    }




    // new thing learned -> boolean[] flag = new boolean[1];
    // for reference as boolean flag will be a pass by value,which is changed and used locally and will not present any result when passed around.


    public void solve(char[][] board){

        boolean [][] vis = new boolean[board.length][board[0].length];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 'O' && !vis[i][j]) {
                    boolean [] touchedBoundary = new boolean[1];
                    List<int[]> list = new ArrayList<>();
                    dfs(board, i, j, touchedBoundary, list, vis);

                    if (!touchedBoundary[0]) {
                        for (int[] cell : list) {
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                }
            }
        }

        

    }
    
    public static void dfs(char[][] board, int r, int c, boolean[] touchedBoundary,List<int[]> list,boolean[][]vis){
        vis[r][c] = true;

        int n = board.length;
        int m = board[0].length;

        list.add(new int[]{r, c});

        if(r ==0 || c == 0 || r == n-1 || c == m-1){
            touchedBoundary[0] = true;
        }

        int [] dr = {-1,0,1,0};
        int [] dc = {0,1,0,-1};

        for (int k = 0; k < 4;k++){
            int nr = r +dr[k];
            int nc = c + dc[k];

            // for next call
            if(nr >= 0 && nc >= 0 && nr < n && nc < m && board[nr][nc] == 'O' && !vis[nr][nc]){
                    dfs(board,nr,nc,touchedBoundary,list,vis);
            }
        }



        
    }

    // well i tried so many things though. Naah i am lazy i guess ( overcooked myself)
//
//    public void solve(char[][] board) {
//        ArrayList<int []> list= new ArrayList<>();
//        boolean[][] vis = new boolean[board.length][board[0].length];
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if(board[i][j]=='O'){
//                    dfs(board,vis,i,j,list);
//
//
//                    list = new ArrayList<>();
//                }
//            }
//        }
//
//    }
//
//    public static void dfs(char [][] board, boolean[][]vis, int i, int j, ArrayList<int[]> list){
//
//
//
//        vis[i][j]=true;
//        list.add(new int[]{i,j});
//
//
//        if(i + 1< board.length &&  board[i+1][j]=='O' && !vis[i+1][j]){
//            dfs(board,vis,i+1,j,list);
//        }
//        if(j+1 < board[0].length && board[i][j+1]=='O' && !vis[i][j+1]){
//            dfs(board,vis,i,j+1,list);
//        }
//        if(i-1 >= 0 && board[i-1][j]=='O' && !vis[i-1][j]){
//            dfs(board,vis,i-1,j,list);
//        }
//        if(j-1 >= 0  && board[i][j-1]=='O' && !vis[i][j-1]){
//            dfs(board,vis,i,j-1,list);
//        }
//
//
//    }

















    // optmized
//    public void solve(char[][] board) {
//        if (board == null || board.length == 0) return;
//        int n = board.length;
//        int m = board[0].length;
//
//        // 1. Check first and last columns
//        for (int i = 0; i < n; i++) {
//            if (board[i][0] == 'O') dfs(board, i, 0);
//            if (board[i][m - 1] == 'O') dfs(board, i, m - 1);
//        }
//
//        // 2. Check first and last rows
//        for (int j = 0; j < m; j++) {
//            if (board[0][j] == 'O') dfs(board, 0, j);
//            if (board[n - 1][j] == 'O') dfs(board, n - 1, j);
//        }
//
//        // 3. Final transformation
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (board[i][j] == 'O') {
//                    board[i][j] = 'X'; // Captured
//                } else if (board[i][j] == '#') {
//                    board[i][j] = 'O'; // Escaped
//                }
//            }
//        }
//    }
//
//    private void dfs(char[][] board, int r, int c) {
//        // Standard boundary and 'O' check
//        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
//            return;
//        }
//
//        // Mark as visited/safe by changing the character itself (saves memory vs boolean[][] vis)
//        board[r][c] = '#';
//
//        dfs(board, r + 1, c);
//        dfs(board, r - 1, c);
//        dfs(board, r, c + 1);
//        dfs(board, r, c - 1);
//    }
}
