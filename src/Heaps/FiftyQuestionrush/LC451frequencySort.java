package Heaps.FiftyQuestionrush;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LC451frequencySort {
    public String frequencySort(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for (Character ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }


        // approach : 1
//        TreeMap<Integer, List<Character>> tm = new TreeMap<>(Collections.reverseOrder());

        PriorityQueue<Integer> q = new PriorityQueue<>();


        // approach : 2
//        Map<Character, Integer> map = new HashMap<>();
//// count freq
//
//        List<Character> list = new ArrayList<>(map.keySet());
//
//        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));


        // approach : 3
        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));



        StringBuilder sb = new StringBuilder();


        while (!pq.isEmpty()) {
            char c = pq.poll();
            int freq = map.get(c);

            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {

    }
}
