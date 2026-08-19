package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LCRottenOranges {
    public static void main(String[] args) {
        int [][] arr=  {{2,1,1},{1,1,0},{0,1,1}};

    }

    public static int rotten(int [][] arr){

        Queue<int[]> q = new LinkedList<>();

        int min  = 0;
        int fresh = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                else if(arr[i][j]==1){
                    fresh++;
                }
            }
        }

        int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};


        while (!q.isEmpty() && fresh >0) {


            min++;
            int size = q.size();

            for (int i = 0; i < size; i++) {

                int [] curr = q.remove();

                for(int [] dir : directions){
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    if(newRow >= 0 && newCol >= 0 && newRow <arr.length && newCol < arr[0].length && arr[newRow][newCol]==1 ){
                        arr[newRow][newCol] = 2;
                        fresh--;
                        // add new Rotten oranges in q
                        q.add(new int[]{newRow,newCol});

                    }
                }

            }
        }

        return fresh == 0 ? min : -1;
    }
}
