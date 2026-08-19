package AdvancePatterns;

public class HollowRectangle {
    public static void main(String[] args) {
        int totRows = 5;
        int totCols = 4;

        for( int i = 1; i <= totRows; i++ ){
            for(int j = 1; j <= totCols;j++){
                if(i == 1|| j == 1|| i == totRows || j == totCols){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
