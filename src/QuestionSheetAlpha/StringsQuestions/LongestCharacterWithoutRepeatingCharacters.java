package QuestionSheetAlpha.StringsQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestCharacterWithoutRepeatingCharacters {
    public static void main(String[] args) {

        String s = "pwwkew";

        repeatCharacters(s);

    }
    public static void repeatCharacters(String s){


        // character and its index
        Map<Character,Integer> map = new HashMap<>();


        // pwwekew

        int left = 0;
        int length = 0;

        for (int right = 0; right < s.length();right++) {

            char c = s.charAt(right);

            if(map.containsKey(c)){
                left = Math.max(left,map.get(c)+1);
            }


            map.put(c,right);

            length = Math.max(length, right-left+1);


        }

        System.out.println(length);














        //
//        Set<Character> set = new HashSet<>();
//
//        int size = 0;
//        int max = 0;
//        for(int i = 0; i < s.length();i++){
//
//            if(set.contains(s.charAt(i))){
//                set.remove(set.remove(s.charAt(i)));
//            }
//
//            set.add(s.charAt(i));
//            size = set.size();
//            max = Math.max(max,size);
//        }
//
//        System.out.println(set);
//        System.out.println(size);

    }
}
