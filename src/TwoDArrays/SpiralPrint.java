package TwoDArrays;

import java.util.Arrays;

public class SpiralPrint {



    // need some change but oky for square matrices
    static void spiralPrint(int [][] arr){

        int startRow = 0;
        int endRow = arr.length-1;
        int startCol = 0;
        int endCol = arr.length-1;
     while (startRow <= endRow && startCol <= endCol){
         // left to right
         for( int j = startCol; j <= endCol; j++){
             System.out.println(arr[startRow][j]+" ");
         }

         // up to down
         for (int i = startRow+1; i <= endRow ; i++) {
             System.out.println(arr[i][endCol]+" ");
         }

         // right to left
         for( int i = endCol-1; i >= startCol;i--){
             if(startCol==endCol){
                 break;
             }
             System.out.println(arr[endRow][i]+" ");
         }

         // botttom to up
         for( int i = endRow-1; i >= startRow+1; i--){
             System.out.println(arr[i][startCol]+" ");
         }


         startRow++;
         endRow--;
         startCol++;
         endCol--;

     }

    }
    public static void main(String[] args) {


        int [][] arr = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};

        spiralPrint(arr);
    }
}
