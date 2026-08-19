//package Graphs;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class LC909 {
//    public static void main(String[] args) {
//        int[][] board =
//                {
//                        {-1, -1, -1, -1, -1, -1},
//                        {-1,-1,-1,-1,-1,-1},
//                        {-1,-1,-1,-1,-1,-1},
//                        {-1,35,-1,-1,13,-1},
//                        {-1,-1,-1,-1,-1,-1},
//                        {-1,15,-1,-1,-1,-1}
//                };
//
//        System.out.println(snakesAndLadders(board));
//    }
//
//
//    static class State{
//        int [] node;
//        boolean toRight;
//
//        public State(int [] node, boolean toRight){
//            this.node = node;
//            this.toRight = toRight;
//        }
//    }
//
//     very hard to do manually
//    public static int snakesAndLadders(int[][] board) {
//
//        int n = board.length;
//
//        Queue<State> q = new LinkedList<>();
//
//        int moves=0;
//
//        // added starting position
//        q.add(new State(new int[]{n-1,0},true));
//
//        while (!q.isEmpty()){
//
//            int size = q.size();
//            moves++;
//            for (int i = 0; i < size; i++) {
//
//
//                State currState = q.poll();
//
//                int [] curr = currState.node;
//                int row = curr[0];
//                int col = curr[1];
//
//                boolean toRight = currState.toRight;
//
//                // moves
//                for (int j = 1; j <= 6; j++) {
//
//                    // movement control
//                    if(col+j > n-1 || (row!=n-1 && col!=0)){
//                        row--;
//                        toRight = !toRight;
//                    }
//                    else {
//                        if(toRight){
//                            col++;
//                        }else {
//                            col--;
//                        }
//                    }
//                    if(row==0 && col==0){
//                        return moves;
//                    }
//
//                    if(board[row][col]!=-1){
//                        int value = board[row][col];
//                        q.add(boost(value,n));
//                    }
//
//                }
//                q.add(new State(new int[]{row,col},toRight));
//            }
//
//
//        }
//
//
//        return 0;
//
//    }
//
//    public static State boost(int value,int n){
//
//        int row = n - value/n;
//        int col = value%n;
//        boolean toRight = row%2 == 0?true : false;
//
//
//        return new State(new int[]{row,col},toRight);
//
//    }
//
//}

package Graphs;


import java.util.*;

public class LC909 {

    static class State {
        int row, col;

        State(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<State> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.offer(new State(n - 1, 0));
        visited[n - 1][0] = true;

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                State curr = q.poll();

                int num = getNumber(curr.row, curr.col, n);

                if (num == n * n) return moves;

                for (int dice = 1; dice <= 6; dice++) {
                    int nextNum = num + dice;
                    if (nextNum > n * n) break;

                    int[] nextPos = getCoordinates(nextNum, n);
                    int r = nextPos[0], c = nextPos[1];

                    // snake or ladder
                    if (board[r][c] != -1) {
                        nextPos = getCoordinates(board[r][c], n);
                        r = nextPos[0];
                        c = nextPos[1];
                    }

                    if (!visited[r][c]) {
                        visited[r][c] = true;
                        q.offer(new State(r, c));
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    // number -> (row, col)
    static int[] getCoordinates(int num, int n) {
        int r = (num - 1) / n;
        int c = (num - 1) % n;

        if (r % 2 == 1) c = n - 1 - c;

        r = n - 1 - r;
        return new int[]{r, c};
    }

    // (row, col) -> number
    static int getNumber(int row, int col, int n) {
        int r = n - 1 - row;

        if (r % 2 == 1) col = n - 1 - col;

        return r * n + col + 1;
    }
}
