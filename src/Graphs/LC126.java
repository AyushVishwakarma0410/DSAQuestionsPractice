package Graphs;

import java.util.*;

public class LC126 {

//
//    // 50 by GPT
//    // 50 by me -> learned storing paths in BFS, also remember storing shortest paths means all the paths will be of same size
//
//    // NVM -> TLE
//
//
////  THIS ONE WILL TEACH MANY NEW THINGS
//
//
//
//    public static void main(String[] args) {
//
//        String beginWord = "hit";
//        String endWord = "cog";
//
//        List<String> wordList = new ArrayList<>();
//
//        wordList.add("hot");
//        wordList.add("dot");
//        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");
//
//        findLadders(beginWord,endWord,wordList);
//
//    }
//
//    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//
//        if(wordList.isEmpty() || beginWord.isEmpty() || endWord.isEmpty()){
//            return new ArrayList<>();
//        }
//
//        List<List<String>> res = new ArrayList<>();
//
//        Queue<List<String >> q = new LinkedList<>();
//
//
//        Set<String> vis = new HashSet<>();
//
//        List<String> start = new ArrayList<>();
//        start.add(beginWord);
//
//        q.add(start);
//
//
//
//        boolean end = false;
//
//        while(!q.isEmpty()){
//
//            int size = q.size();
//
//            Set<String> levelVisited = new HashSet<>();
//            for (int i = 0; i < size; i++) {
//
//                List<String> path = q.poll();
//
//                String last = path.get(path.size()-1);
//
//                if(last.equals(endWord)){
//                    res.add(path);
//                    end = true;
//                    continue;
//                }
//
//
//                int wSize = wordList.size();
//
//
//
//
//                for (int j = 0; j < wSize; j++) {
//
//                    int count = 0;
//
//                    String currentWord = wordList.get(j);
//
//                    for (int k = 0; k < last.length(); k++) {
//                        if(last.charAt(k)!=currentWord.charAt(k)){
//                            count++;
//                        }
//                    }
//
//
//
//                    if(!vis.contains(currentWord) && count==1){
//
//                        levelVisited.add(currentWord);
//                        List<String> newPath = new ArrayList<>(path);
//                        newPath.add(currentWord);
//                        q.add(newPath);
//                    }
//
//
//                }
//
//
//
//            }
//            vis.addAll(levelVisited);
//
//
//            if(end){
//                break;
//            }
//        }
////
////        for (int i = 0; i < res.size(); i++) {
////            System.out.println(res.get(i));
////        }
//
//
//        return res;
//
//    }
//
//
//
//


// must redo
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {



            // resultant list
            List<List<String>> res = new ArrayList<>();


            // In order to check words in O(1) time
            Set<String> dict = new HashSet<>(wordList);

            // if the dictionary does not contain the required word, then return empty list
            if(!dict.contains(endWord)) return res;


            // A map to store parent nodes
            Map<String,List<String>> parents = new HashMap<>();

            // BFS

        // level order
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // visited
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // a endword found variable
        boolean found = false;

        // performing BFS
        while (!queue.isEmpty() && !found){
            int size = queue.size();

            // this set will help us to delay the addition of next nodes to the main visited set
            // suppose I reach to log and dog then both will go to cog, but if log reaches cog first
            // and cog is added to visited, then the path will be blocked for dog.
            Set<String> levelVisited = new HashSet<>();


            for (int i = 0; i < size; i++) {

                // curr
                String word = queue.poll();

                // converting the current word to an array
                char [] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char original = arr[j];

                    for (char c = 'a'; c <= 'z';c++){

                        // switching variables
                        arr[j] = c;

                        // the formed new String
                        String next = new String(arr);

                        // if not present in the wordlist provided
                        if(!dict.contains(next)){
                            continue;
                        }

                        // if not visited in early iteration
                        if(!visited.contains(next)) {

                            // if NOT present in the q for iteration
                            if (!levelVisited.contains(next)) {
                                queue.offer(next);
                                levelVisited.add(next);
                            }


//lambda expression  -->>>>>>>  parents.computeIfAbsent(next,k->new ArrayList<>()).add(word);
                            // if found first time
                            if (!parents.containsKey(next)) {
                                parents.put(next, new ArrayList<>());
                            }
                            // if found 2nd time
                            parents.get(next).add(word);

                            if (next.equals(endWord)) {
                                found = true;
                            }


                        }


                    }
                arr[j] = original;

                }



            }
            visited.addAll(levelVisited);
        }


        // Backtracking
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(endWord, beginWord, parents, path, res);
        }

        return res;
    }

//    cog → [dog, log]
//    dog → [dot]
//    log → [lot]
//    dot → [hot]
//    lot → [hot]
//    hot → [hit]
    public static void backtrack(String word, String beginWord, Map<String, List<String>> parents,
                                 List<String> path,
                                 List<List<String>> result){


        // base condition -- end condition
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        // if no parent exits
        if (!parents.containsKey(word)) return;

        //
        for (String parent : parents.get(word)) {
            path.add(parent);
            backtrack(parent, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }

    }

}
