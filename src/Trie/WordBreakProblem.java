package Trie;

public class WordBreakProblem {



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


        String [] arr = {"i","like","sam","samsung","mobile","ice"};


        for (int i = 0; i <arr.length; i++) {
            insert(arr[i]);
        }


        String key = "ilikesamsung";

        System.out.println(wordBreak(key));

    }

    public static boolean wordBreak(String key){

        if(key.length()==0) return true;

        // i initialized with 1 not 0 to prevent error in substring method
        for (int i = 1; i <= key.length(); i++) {
               if (search(key.substring(0,i)) && wordBreak( key.substring(i))){//key.substring(i); // no need to put ending idx as it is default
                   return true;
               }
        }
        return false;
    }
}
