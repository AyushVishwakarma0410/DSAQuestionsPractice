package Graphs;

import java.util.*;


// self done 99%
// some edge cases and stuff were missed, overall my idea
// I posted this one on LC

public class LC815 {
    public static void main(String[] args) {


int [][] routes = new int[][] {
                {1, 2, 7, 11, 15},          // Bus 0
                {3, 6, 7, 10, 14},          // Bus 1
                {7, 8, 9, 16},              // Bus 2
                {2, 3, 4, 12},              // Bus 3
                {10, 13, 17, 18},           // Bus 4
                {4, 5, 19, 20},             // Bus 5
                {20, 21, 22, 23},           // Bus 6
                {15, 24, 25, 26},           // Bus 7
                {26, 27, 28, 29},           // Bus 8
                {29, 30, 31, 32},           // Bus 9
                {18, 33, 34, 35},           // Bus 10
                {35, 36, 37, 38},           // Bus 11
                {23, 39, 40, 41},           // Bus 12
                {41, 42, 43, 44}            // Bus 13
        };

        System.out.println(numBusesToDestination(routes,1,44));

    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {


        if (source == target) return 0;

        int moves = 0;
        // stops - buses
        Map<Integer,List> map = new HashMap<>();
        // target buses
        Set<Integer> tarBus = new HashSet<>();

        for (int i = 0; i < routes.length; i++) {


            for (int j = 0; j < routes[i].length; j++) {
                int key = routes[i][j];
                if(!map.containsKey(key)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(key,list);
                }
                else {
                    map.get(key).add(i);

                }
                if(key==target) {
                    tarBus.add(i);
                }

            }
        }


        if (!map.containsKey(source)) return -1;

        // buses
        Queue<Integer> q = new LinkedList<>();
        // buses
        Set<Integer> vis = new HashSet<>();
        // stops
        Set<Integer> visStops = new HashSet<>();

        // buses loaded
        for (int i = 0; i < map.get(source).size(); i++) {
            q.add((Integer) map.get(source).get(i));
            vis.add((Integer)map.get(source).get(i));
        }


        while (!q.isEmpty()){

            int size = q.size();

            moves++;
            for (int i = 0; i < size; i++) {

                // bus
                int curr = q.poll();


                if(tarBus.contains(curr)){
                    return moves;
                }


                // from current bus take routes
                    for (int j = 0; j < routes[curr].length; j++) {
                        if(!visStops.contains(routes[curr][j])){
                            visStops.add(routes[curr][j]);
                            for (Object bus : map.get(routes[curr][j])){
                                if(!vis.contains(bus)) {
                                    q.add((Integer) bus);
                                    vis.add((Integer) bus);
                                }
                            }
                        }

                    }



            }
        }

        return -1;
    }
}
