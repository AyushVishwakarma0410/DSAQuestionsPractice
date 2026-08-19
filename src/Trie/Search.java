package Trie;

public class Search {

    public static void main(String[] args) {
//        String key1 = "thee";
//        String key2 = "thor";
//        String word = "thee";
//
//        insert(word);
//
//
//         boolean ans =  search(word);
//
//        System.out.println(ans);
//
//        System.out.println(search("thor"));
    }


    public static boolean search(String key){

        Node curr = root;

        for (int level = 0; level < key.length();level++){

            int idx = key.charAt(level)-'a';

            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];

        }

        return curr.endOfWord = true;
    }



    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }




}
