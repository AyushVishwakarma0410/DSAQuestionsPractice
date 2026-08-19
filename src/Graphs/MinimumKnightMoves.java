package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
    public static void main(String[] args) {



//        👉 Your contribution: ~75–80%
        // well Using hashset wasn't my idea so its fair
        int x = 1;
        int y = 1;

        System.out.println(moves(x,y));
    }


    public static int moves(int x, int y){


        x = Math.abs(x);
        y = Math.abs(y);

        int moves = 0;

        Queue<int []> q = new LinkedList<>();

//        ArrayList<int []> vis = new ArrayList<>(); // TLE

        // Use hashSet instead
        HashSet<String> set = new HashSet<>();
        set.add("0,0");

        q.add(new int[]{0,0});
//        vis.add(new int[]{0,0});

        int [][] directions = {
                {1,2},
                {2,1},
                {-1,-2},
                {-2,-1},
                {1,-2},
                {2,-1},
                {-1,2},
                {-2,1}
        };

        while (!q.isEmpty()){

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int [] curr = q.poll();
                if(curr[0]==x && curr[1]==y){
                    return moves;
                }
                for (int [] dir : directions){

                    int newR = curr[0]+dir[0];
                    int newC = curr[1]+dir[1];

                    String key = newR + ","+ newC;

                    // had normal if else




                    // optimized if-else ( by gpt )-> pruning
                    /*👉 Why this works:

                    After converting (x, y) → positive quadrant
                    You never need to go too far negative
                    Limiting to >= -2 drastically reduces search space*/

                    if(newR >= -2 && newC >= -2 && !set.contains(key)){
                        q.add(new int[]{newR,newC});
                        set.add(key);
                    }


                }

            }

            moves++;
        }


        return moves;
    }
}
