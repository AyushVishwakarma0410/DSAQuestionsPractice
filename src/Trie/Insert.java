package Trie;

public class Insert {

    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;


        // level = for iteration for of String.
        for (int level = 0; level < word.length(); level++) {

            // idx = the index of character.
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }


    public static void main(String[] args) {
//        String [] words = {"the","a","there","their", "any","thee"};
//
//        for (String word : words) {
//            insert(word);
//        }
    }
}
