package Trie;

/*
In the Unique Prefix Problem, the goal is to find the shortest prefix for every word such that no other
 word in the array shares that same prefix. The logic is simple: you traverse the Trie for
 each word and stop as soon as you hit a node where freq == 1. That means this character is
  unique to this specific word's path.
 */


public class PrefixProblemInString {

    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        int freq;

        Node() {
            // Initialize frequency to 0; it will be incremented during insertion
            freq = 0;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            // Increment frequency every time a word passes through this node
            curr.children[idx].freq++;
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static void findPrefix(Node root, String ans) {
        // Base Case: If the current node's frequency is 1, we found the unique prefix
        if (root == null) return;

        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char)(i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"};

        // Build the Trie
        for (String word : arr) {
            insert(word);
        }

        // Start finding unique prefixes from the root
        // We pass an empty string to build the prefix as we go
        findPrefix(root, "");
    }
}