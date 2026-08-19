package Graphs;

import java.util.ArrayList;


/// 🧠 Clean Final Statement (Use This)
///
/// “In bipartite checking, color[] acts as both visited tracking and constraint validation. We don’t need parent because revisiting a node is allowed as long as the color constraint is satisfied.”




// 70 % 
public class LC886 {
    public static void main(String[] args) {


        int [][] graph = {{1,2},{1,3},{2,4}};

        System.out.println(possibleBipartition(4,graph));


    }
    public static boolean possibleBipartition(int n, int[][] dislikes) {


        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }



        for (int i = 0; i < dislikes.length;i++){
            graph.get(dislikes[i][0]).add(dislikes[i][1]);

            graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        int [] color = new int[n+1];


        for (int i = 1; i <= n; i++) {


            // 1 = red , 2 = blue
            if(color[i]==0) {
                if (!check(graph, color, i,1)) {
                    return false;
                }
            }
        }




        return true;

    }

    public static boolean check(ArrayList<ArrayList<Integer>> graph, int [] color, int curr,int colorCurr){

        color[curr] = colorCurr;

        for (int neigh : graph.get(curr)){
            if(color[neigh]==0) {
              if (!check(graph, color, neigh, -colorCurr)) {
                    return false;
                }
            }
            else if (color[neigh] == colorCurr) {
                return false;
            }

        }

        return true;

    }
}
