package Trie;

import java.util.Arrays;

public class Node {
    Node[] children = new Node[26];
    boolean endOfWord = false;


    Node(){
        Arrays.fill(children, null);
    }

}
