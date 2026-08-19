package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class LC752 {
    public static void main(String[] args) {

    }

    public static int openLock(String[] deadends, String target){


        int steps = 0;

        Queue<String> q = new LinkedList<>();

        HashSet<String> vis = new HashSet<>();


        for (String s : deadends){
            vis.add(s);
        }

        if(vis.contains("0000")){
            return -1;
        }

        q.add("0000");
        // BFS
        while (!q.isEmpty()){

            int size = q.size();

            for (int i = 0; i < size; i++) {
                

                String curr = q.poll();

                if(target.equals(curr)){
                    return steps;
                }


//                // if set contains curr that means its a deadend so we are not going to add its neighbours
//                if(vis.contains(curr)){
//                    continue;
//                }


                // Adding neighbours
                for (String next : getNextStates(curr)){
                    if(!vis.contains(next)){
                        q.add(next);
                        vis.add(next);
                    }
                }
            }

            steps++;
        }
        return -1;


    }

    public static List<String> getNextStates(String s){

        // adding all movements
        List<String> res = new ArrayList<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char digit = arr[i];

            // forward
            if(digit=='9'){
                arr[i]='0';
            }else {
                arr[i]= (char)(digit+1);
            }
            res.add(new String(arr));
            if(digit=='0'){
                arr[i]='9';
            }else {
                arr[i] = (char)(digit-1);
            }
            res.add(new String(arr));

            // Restore original
            arr[i] = digit;

        }
        return res;

    }

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////


// optimized bidirectional
/*
public static int openLock(String[] deadends, String target){

    HashSet<String> dead = new HashSet<>();
    for(String d : deadends) dead.add(d);

    if(dead.contains("0000")) return -1;

    HashSet<String> startSet = new HashSet<>();
    HashSet<String> endSet = new HashSet<>();
    HashSet<String> visited = new HashSet<>();

    startSet.add("0000");
    endSet.add(target);

    int steps = 0;

    while(!startSet.isEmpty() && !endSet.isEmpty()){

        // Always expand smaller set (optimization)
        if(startSet.size() > endSet.size()){
            HashSet<String> temp = startSet;
            startSet = endSet;
            endSet = temp;
        }

        HashSet<String> nextLevel = new HashSet<>();

        for(String curr : startSet){

            if(endSet.contains(curr)){
                return steps;
            }

            if(dead.contains(curr)){
                continue;
            }

            visited.add(curr);

            for(String next : getNextStates(curr)){
                if(!visited.contains(next) && !dead.contains(next)){
                    nextLevel.add(next);
                }
            }
        }

        startSet = nextLevel;
        steps++;
    }

    return -1;
}
*/