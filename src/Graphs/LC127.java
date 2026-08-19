package Graphs;

import java.util.*;

public class LC127 {


    // accepted 100% self done TC : n^3

    // can be optimized - very good solution

    // at first blank brain, no idea, suddenly started writing code after writing algo on paper
    // worked
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = new ArrayList<>();

        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
//        wordList.add("cog");
        wordList.add("hog");


        System.out.println(ladderLength(beginWord,endWord,wordList));


    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //edge cases
        if(wordList.isEmpty()){
            return 0;
        }
        if(endWord=="" || beginWord==""){
            return 0;
        }


        // begin word
        char [] beginWordArray = beginWord.toCharArray();

        // end word
        char [] endWordArray = endWord.toCharArray();

        // Answer -> moves
        int moves = 0;

        Set<char []> vis = new HashSet<>();

        Queue<char[]> q = new LinkedList<>();

        q.add(beginWordArray);


        while (!q.isEmpty()) {
            // moves
            moves++;

            int Qsize = q.size();

            for (int k = 0; k < Qsize; k++) {


                int size = wordList.size();
                // level order

                // current word
                char[] curr = q.poll();

                if (Arrays.equals(curr, endWordArray)) {
                    return moves;
                }


                for (int i = 0; i < size; i++) {

                    String tar = wordList.removeFirst();
                    char[] target = tar.toCharArray();



//                    System.out.println(Arrays.toString(target));

                    // if length of word is not same then skip
                    if (curr.length != target.length) {
                        continue;
                    }


                    // count
                    int count = 0;


                    // counting different
                    for (int j = 0; j < curr.length; j++) {
                        if (curr[j] != target[j]) {
                            count++;
                        }
                    }
                    // if the character matching is more than 1, add it to the wordlist
                    if (count > 1) {
                        wordList.add(tar);
                        continue;
                    }
                    // same word
                    else if (count == 0) {
                        continue;
                    }


                    if (!vis.contains(target)) {
                        q.add(target);
                        vis.add(target);
//                        System.out.println(tar);
                    }

                }

            }

            }
        return 0;
    }
}
