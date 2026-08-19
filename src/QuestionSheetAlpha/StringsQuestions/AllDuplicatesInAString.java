package QuestionSheetAlpha.StringsQuestions;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class AllDuplicatesInAString {

    public static void characterCount(String s ){

        int [] arr = new int[26];

        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();


        // stored freq of characters
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }

        // now printing array using order preserving hashmap
        HashMap<Character, Boolean> print = new HashMap<>();

        for(char ch : s.toCharArray()){
            if(!print.containsKey(ch)){
                System.out.println(ch+" "+print.get(ch));
                print.put(ch,true);
            }
        }


        System.out.println(map);
    }

    public static void main(String[] args) {
            characterCount("geeksforgeeks");
    }
}
