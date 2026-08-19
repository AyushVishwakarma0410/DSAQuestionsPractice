package BackTracking;

public class NQueenOnlyOneTime {

    public static boolean nQueen(char [][] board, int row){
        // base
        if(row ==  board.length){
//            printboard(board);
            count ++;
            return true;
        }


        // column loop
        for (int j = 0; j < board.length; j++) {

            if(isSafe(board,row,j)) {
                board[row][j] = 'Q';

                // Only one solution is needed so we will return if a solution is found
                if(nQueen(board, row + 1)){
                    return true;
                }; // function call
                board[row][j] = 'X'; // backtracking step
            }

        }

        // if false check again
    return false;
    }

    static int count = 0;
    static void printboard(char[][] board){

        System.out.println("--------------------------chessBoard--------------------------------");
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+  " ");
            }
            System.out.println( );
        }
    }

    public static boolean isSafe(char[][] board, int row, int col){
        // vertical up
        for(int i = row-1; i >=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // diagonally left up
        for (int i = row-1, j = col-1; i >= 0 && j >= 0 ; i--, j--) {

            if(board[i][j]=='Q'){
                return false;
            }



        }
        // diagonally right up
        for (int i = row-1, j = col+1; i >= 0 && j <board.length ; i--, j++) {

            if(board[i][j]=='Q'){
                return false;
            }

        }

        return true;

    }





    public static void main(String[] args) {

        int n = 10;
        char[][]board = new char[n][n];

        // initialzie
        for(int i = 0;i< n;i++ ){
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }



        if(nQueen(board,0)){
            printboard(board);
        }
        System.out.println(count);

    }
}
