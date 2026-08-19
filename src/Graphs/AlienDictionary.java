package Graphs;
import java.util.*;



// 80 %
// No idea how I did it, but did it 

public class AlienDictionary {
    public static void main(String[] args) {

        String [] words = {"wrt","wrf","er","ett","rftt"};

        System.out.println(Dictionary(words));

    }

    public static List<Character> Dictionary(String [] words){

        Map<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character,List<Character>> map = new HashMap<>();

        map = buildGraph(words, map , inDegree);


        if (map.isEmpty()) {
            return new ArrayList<>(); // invalid dictionary
        }

        System.out.println(map);
        Queue<Character> q = new LinkedList<>();

        for (Character key : inDegree.keySet()){
            int value = inDegree.get(key);
            if(value==0){
                q.add(key);
            }
        }

        List<Character> res = new ArrayList<>();

        while (!q.isEmpty()){
            char key = q.poll();
            res.add(key);

            for (Character ch : map.get(key)){
                inDegree.put(ch,inDegree.get(ch)-1);


                if(inDegree.get(ch)==0){
                    q.add(ch);

                }
            }
        }


        if (res.size() != inDegree.size()) {
            return new ArrayList<>(); // cycle detected
        }
        return res;


    }

    public static HashMap<Character, List<Character>> buildGraph(String[] words, HashMap<Character,
            List<Character>> map, Map<Character,Integer> inDegree){
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length-1;i++){
            String one = words[i];
            String two = words[i+1];
            int u = 0, v =0;
            while (u < one.length() && v < two.length() && one.charAt(u) == two.charAt(v)) {
                u++;
                v++;
            }

            if (u < one.length() && v == two.length()) {
                return new HashMap<>(); // signal invalid
            }
            if (u < one.length() && v < two.length()) {
                char src = one.charAt(u);
                char dest = two.charAt(v);

                if (!map.get(src).contains(dest)) {
                    map.get(src).add(dest);
                    inDegree.put(dest, inDegree.get(dest) + 1);
                }
            }
        }


        return map;
    }
}
