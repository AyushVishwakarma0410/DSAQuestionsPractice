package Graphs;

import java.util.Arrays;

public class Lc733 {
    public static void main(String[] args) {

        int [][] arr = {{0,0,0},{0,0,0}};

        floodFill(arr,1,0,2);

        for (int i = 0; i < arr.length; i++) {
            System.out.println( Arrays.toString(arr[i]));
        }


    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {


        int getTarget = image[sr][sc];
        fill(image,sr,sc,color,getTarget);

        return image;
    }

    public static void fill(int [][] arr, int i, int j, int color,int target){

        if(i < 0 || i >=arr.length || j < 0 ||j >= arr[0].length){
            return;
        }

        if(arr[i][j] !=target ||  arr[i][j]==color){
            return;
        }

        if(arr[i][j] == target){
            arr[i][j] = color;
        }

        fill(arr,i+1,j,color,target);

        fill(arr,i,j+1,color,target);

        fill(arr,i-1,j,color,target);

        fill(arr,i,j-1,color,target);



    }




}
