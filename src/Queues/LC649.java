package Queues;

import java.util.*;

public class LC649 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();



        String s = "DDRRR";
        System.out.println(predictPartyVictory(s));
    }

    // 100 % self done
    // TC is O(n2)

//    public static String predictPartyVictory(String senate) {
//        Deque<Character> engaged = new ArrayDeque<>();
//        Stack<Character> stack = new Stack<>();
//        if (senate.isEmpty()) {
//            return new String();
//        }
//
//        // filled with the characters
//        for (char ch : senate.toCharArray()) {
//            engaged.offer(ch);
//        }
//
//        System.out.println("Queue :"+ engaged);
//
//        while (engaged.size() != 1) {
//
//            char ch = engaged.poll();
//
//            if (ch == 'R') {
//                while (engaged.peek() == 'R') {
//                    stack.push(engaged.poll());
//                    if (engaged.isEmpty()) {
//                        return "Radiant";
//                    }
//                }
//                engaged.poll();
//
//            } else {
//                while (!engaged.isEmpty() && engaged.peek() == 'D') {
//                    stack.push(engaged.poll());
//                }
//                if (engaged.isEmpty()) {
//                    return "Dire";
//                }
//                engaged.poll();
//            }
//
//
//            while (!stack.isEmpty()) {
//
//                engaged.addFirst(stack.pop());
//            }
//            engaged.addLast(ch);
//            System.out.println(engaged);
//        }
//
//        return engaged.poll() == 'R' ? "Radiant" : "Dire";
//    }
//


    // optimized

        public static String predictPartyVictory(String s){
            Queue<Integer> rQueue  = new LinkedList<>();
            Queue<Integer> dQueue  = new LinkedList<>();

            int n = s.length();
            int i = 0;

            while (i < n){
                if(s.charAt(i)=='R'){
                    rQueue.add(i);
                }
                else {
                    dQueue.add(i);
                }
                i++;
            }


            while (!rQueue.isEmpty() && !dQueue.isEmpty()){
                int j = rQueue.poll();
                int k = dQueue.poll();
                if(j < k){
                    rQueue.add(j+n);
                }
                else {
                    dQueue.add(k+n);
                }
            }

            return rQueue.isEmpty() ? "Dire":"Radiant";
        }


}
