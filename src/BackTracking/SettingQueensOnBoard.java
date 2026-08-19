package BackTracking;

public class SettingQueensOnBoard {

    public static void nQueen(char [][] board,int row){


        if(row == board.length){
            System.out.println("Board Printing");
            print(board);
            return;

        }

        System.out.println("Loop");

        // Column loop
        for (int i = 0; i < board.length; i++) {
            board[row][i] = 'Q';
            // function call - put at one place, go to next row, comeback after making all possible placements.
            nQueen(board,row+1);
            // backtrack -> kill the queen
            board[row][i] = '.';
        }

    }

    public static void print(char [][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = 2 ;
        // put n =3 if you understood
        // put n < 15 && n > 5 if you want to have fun
        // put n >= 100 if you are evil
        char [][] board = new char[n][n];

        // initialize

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }


        // initially call with 0
        nQueen(board,0);

    }
}
