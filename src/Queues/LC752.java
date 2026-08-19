package Queues;

import java.util.*;

public class LC752 {
    public static void main(String[] args) {

    }


    // BFS shortest path using queues
    public int openLock(String[] deadends, String target) {

        //Deadends
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        //if initial node is blocked return
        if(dead.contains("0000")){
            return -1;
        }

        // BFS queue -> using which we will search all combinations
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        // Visited States(to avoid repetition)
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        // Answer -> number of moves taken
        int steps = 0;

        // BFS
        while (!queue.isEmpty()){
            // expand level
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();


                // if we found the target, return number of moves
                if(current.equals(target)){
                    return steps;
                }

                //skip deadends
                if(dead.contains(current)){
                    continue;
                }

                // Generate all 8 possible rotations

                for (String next : getNextStates(current)){
                    if(!visited.contains(next) && !dead.contains(next)){
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            // next layer of BFS
            steps++;
        }

        // Answer not found or not possible
        return -1;


    }


    // checking
    private List<String> getNextStates(String s){
        List<String>  res = new ArrayList<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char digit = arr[i];

            // rotate forward
            arr[i] = digit=='9'?'0' : (char)(digit+1);
            res.add(new String(arr));

            // rotate backward
            arr[i] = digit == '0' ? '9' : (char)(digit-1);
            res.add(new String(arr));

            // Restore original
            arr[i] = digit;
        }

        return res;
    }
}
