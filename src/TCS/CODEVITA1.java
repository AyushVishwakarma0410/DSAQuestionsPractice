package TCS;

import java.util.ArrayList;

public class CODEVITA1 {
    public static void main(String[] args) {

    }

    public static int solve(int [][] grid){

        int m = grid.length;
        int n = grid[0].length;
        int [] front = {0,1};
        int [] back = {0,0};
        int [] front2 = {1,0};



        return Math.max(call(grid,front,back,new boolean[m][n],new boolean[m][n],true),call(grid,front2,back,new boolean[m][n],new boolean[m][n],false));

    }

    public static int call(int [][] grid, int [] front, int [] back, boolean[][] visitedFront, boolean [][] visitedBack, boolean horizontal){

        // ends
        int m = grid.length;
        int n = grid[0].length;

// Destination reached
        if ((front[0] == m - 1 && front[1] == n - 1) ||
                (back[0] == m - 1 && back[1] == n - 1)) {
            return 0;
        }


// Front out of bounds
        if (front[0] < 0 || front[0] >= m ||
                front[1] < 0 || front[1] >= n) {
            return Integer.MAX_VALUE - 1;
        }


// Back out of bounds
        if (back[0] < 0 || back[0] >= m ||
                back[1] < 0 || back[1] >= n) {
            return Integer.MAX_VALUE - 1;
        }


        // State already visited
        if (visitedFront[front[0]][front[1]] &&
                visitedBack[back[0]][back[1]]) {
            return Integer.MAX_VALUE - 1;
        }

        visitedFront[front[0]][front[1]] = true;
        visitedBack[back[0]][back[1]] = true;
        // directions
        int [][] directions = {

                // idx 0,1 for front, 2,3 for back
                {1,0,1,0},
                {0,1,0,1},
                {-1,0,-1,0},
                {0,-1,0,-1},
        };

        int ans = Integer.MAX_VALUE-1;

//        int RotateSpace = canRotate(grid,front,back,horizontal);

        int [][] rotationMovements = {
                // Fronts
                {-1,-1},
                {1,-1},
                // Backs
                {1,1},
                {-1,1}
        };


        ArrayList<int []> newIndicies = new ArrayList<>();

        for (int [] move: rotationMovements){
            int newR = front[0]+move[0];
            int newC = front[1]+move[1];
            if(newR >= 0 && newC >= 0 && newR < m && newC < n && grid[newR][newC]!=1){
                newIndicies.add(new int[]{newR,newC});
            }
        }

        // Without Rotation movement

        for(int [] dir : directions){

            int newRFront = front[0]+dir[0];
            int newCFront = back[0]+dir[2];

            int newRBack = front[1] + dir[1];
            int newCBack = back[1] + dir[3];

            if(newCFront >= 0 && newCBack >= 0 && newRBack >= 0 && newRFront >= 0 ){
                if(newCFront < m && newCBack < n && newRBack < m && newRFront < n){
                    ans = Math.min(ans,call(grid,new int[]{newRFront,newCFront},new int []{newRBack,newCBack},visitedFront,visitedBack,horizontal));
                }
            }
        }

        // withRotationMovement


        int k = 0;
        for (int [] arr : newIndicies ) {

            int FRONTR = front[0];
            int FRONTC = front[1];
            int BACKR = back[0];
            int BACKC = back[1];
            if(k<2) {
                FRONTR = arr[0];
                FRONTC = arr[1];
            }else {
                BACKR = arr[0];
                BACKC = arr[1];
            }
            k++;
            for (int[] dir : directions) {

                int newRFront = FRONTR + dir[0];
                int newCFront = FRONTC + dir[2];

                int newRBack = BACKR + dir[1];
                int newCBack = BACKC + dir[3];

                if (newCFront >= 0 && newCBack >= 0 && newRBack >= 0 && newRFront >= 0) {
                    if (newCFront < m && newCBack < n && newRBack < m && newRFront < n) {
                        ans =1 + Math.min(ans, call(grid, new int[]{newRFront, newCFront}, new int[]{newRBack, newCBack}, visitedFront, visitedBack, horizontal));
                    }
                }
            }


        }


        return ans;

    }
//
//    public static int canRotate(int [][] grid, int [] front, int [] back, boolean isHorizontal){
//        // indices for front
//        int i = front[0];
//        int j = front[1];
//
//        // indices for back
//        int i2 = back[0];
//        int j2 = back[1];
//
//        // return 0 if no rotation possible
//        int rotateSpace = 0;
//
//        // for Horizontal
//        if(isHorizontal){
//            int newRFront = i+1;
//            int newRBack = i2+1;
//            if(newRFront >= 0 && newRBack >= 0 && newRBack < grid.length && newRFront < grid.length && grid[newRFront][j]!=1 && grid[newRBack][j2]!=1){
//                rotateSpace += 1;
//            }
//            newRFront = i-1;
//            newRBack = i-1;
//            if(newRFront >= 0 && newRBack >= 0 && newRBack < grid.length && newRFront < grid.length && grid[newRFront][j]!=1 && grid[newRBack][j2]!=1){
//                rotateSpace += 2;
//            }
//
//            // return 1 for up
//            // return 2 for down
//            // return 3 for both
//            return rotateSpace;
//        }
//        else {
//            int newCFront = j+1;
//            int newCBack = j+1;
//            if(newCFront >= 0 && newCBack >= 0 && newCBack < grid.length && newCFront < grid.length && grid[newCFront][j]!=1 && grid[newCBack][j]!=1){
//                rotateSpace -= -1;
//            }
//            newCFront = j-1;
//            newCBack = j2-1;
//            if(newCFront >= 0 && newCBack >= 0 && newCBack < grid[0].length && newCFront < grid[0].length && grid[i][newCFront]!=1 && grid[i2][newCBack]!=1){
//                rotateSpace -= -2;
//            }
//            // rotate -1 for right
//            // rotate -2 for left
//            // return -3 for both
//            return rotateSpace;
//        }
//    }
}
