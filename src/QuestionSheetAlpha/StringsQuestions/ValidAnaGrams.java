package QuestionSheetAlpha.StringsQuestions;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnaGrams {

    public static boolean validAnagrams(String s, String t){



        // METHOD 1
        //
//        if(s.length()!=t.length()){
//            return false;
//        }
//
//        char [] firstString = s.toCharArray();
//        char [] secondString = t.toCharArray();
//        Arrays.sort(firstString);
//        Arrays.sort(secondString);
//
//        for(int i = 0; i < firstString.length;i++){
//            if(firstString[i]!=secondString[i]){
//                return false;
//            }
//        }
//
//        return true;



        // METHOD 2
//        HashMap<Character,Integer> map = new HashMap<>();
//
//        for(int i = 0; i < s.length();i++){
//            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//
//            char c = t.charAt(i);
//
//            if(map.containsKey(c)){
//                map.put(c,map.get(c)-1);
//                if(map.get(c)==0){
//                    map.remove(c);
//                }
//            }else {
//                return false;
//            }
//        }
//
//        if(map.isEmpty()){
//            return true;
//        }else {
//            return false;
//        }



        // METHOD 3

        int [] freqArray = new int[26];

        for(int i = 0; i < freqArray.length; i++){
            char c = s.charAt(i);
            char c2 = t.charAt(i);
            freqArray[c - 'a']++;
            freqArray[c2 - 'a']--;
        }

        for(int val : freqArray){
            if(val!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
            String s = "toy";
            String t = "toy";
        System.out.println(validAnagrams(s,t));;
    }
}
