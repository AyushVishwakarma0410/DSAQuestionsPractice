package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class LC841 {



    // self done -> woke at 8 30, spent focus, solved in 29 min

    // can be optimized

    public static void main(String[] args) {


        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(new ArrayList<>());
        rooms.get(0).add(1);
        rooms.get(0).add(3);


        rooms.add(new ArrayList<>());
        rooms.get(1).add(3);
        rooms.get(1).add(0);
        rooms.get(1).add(1);



        rooms.add(new ArrayList<>());
        rooms.get(2).add(2);

        rooms.add(new ArrayList<>());
        rooms.get(3).add(0);

        System.out.println(canVisitAllRooms(rooms));;
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int V = rooms.size();


        // declaration
        ArrayList<Edge>[] graphs = new ArrayList[V];

        // initialization

        for (int i = 0; i< rooms.size();i++){
            graphs[i] = new ArrayList<>();
        }

        // putting values in graph
        for (int i = 0; i < rooms.size(); i++){
            for (int j = 0; j < rooms.get(i).size(); j++) {
                graphs[i].add(new Edge(i,rooms.get(i).get(j),0));
            }
        }
       boolean [] vis =  new boolean[V];
        find(graphs,vis);

        for (boolean b : vis){
            if(!b){
                return false;
            }
        }

        return true;
    }


    public static void find(ArrayList<Edge>[] graph, boolean [] vis){

        Queue<Integer> q = new LinkedList<>();

        vis[0] = true;
        q.add(0);
        while (!q.isEmpty()){

            int curr = q.poll();

            for (int i = 0; i < graph[curr].size();i++){
                Edge e = graph[curr].get(i);

                if(!vis[e.dest]){
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }

        }

    }
}
