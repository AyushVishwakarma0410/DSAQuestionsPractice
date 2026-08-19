package QuestionSheetAlpha.StringsQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

public class SmallestWindowContainingAllCharacters {
    public static void main(String[] args) {

    }

    //
//    // this is the code by gemini but i was 80% close in my logic took an hour thats a fall
    public static String smallestWindow(String s, String p) {
//
//
//        if (s.length() < p.length()) return "";
//
//        // Map to store frequency of characters in p
//        HashMap<Character, Integer> pMap = new HashMap<>();
//        for (char ch : p.toCharArray()) {
//            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
//        }
//
//        // Map to store frequency of characters in current window
//        HashMap<Character, Integer> sMap = new HashMap<>();
//
//        int left = 0, right = 0;
//        int matchCount = 0;
//        int desiredCount = p.length();
//
//        int minLen = Integer.MAX_VALUE;
//        int startIdx = -1;
//
//        while (right < s.length()) {
//            // ACQUIRE phase
//            char charAtRight = s.charAt(right);
//            sMap.put(charAtRight, sMap.getOrDefault(charAtRight, 0) + 1);
//
//            // If the char is needed, and we haven't exceeded its required count
//            if (pMap.containsKey(charAtRight) &&
//                    sMap.get(charAtRight) <= pMap.get(charAtRight)) {
//                matchCount++;
//            }
//
//            // RELEASE phase
//            // When all characters are found, try to shrink the window
//            while (matchCount == desiredCount) {
//                int currentLen = right - left + 1;
//
//                // Update minimum length found so far
//                if (currentLen < minLen) {
//                    minLen = currentLen;
//                    startIdx = left;
//                }
//
//                char charAtLeft = s.charAt(left);
//                // Try to remove the leftmost character
//                if (sMap.get(charAtLeft) == 1) {
//                    sMap.remove(charAtLeft);
//                }
//                else {
//                    sMap.put(charAtLeft, sMap.get(charAtLeft) - 1);
//                }// If removing this char breaks the "match" condition
//                if (pMap.containsKey(charAtLeft) &&
//                        sMap.getOrDefault(charAtLeft, 0) < pMap.get(charAtLeft)) {
//                    matchCount--;
//                }
//
//                left++;
//            }
//            right++;
//        }
//
//        return (startIdx == -1) ? "" : s.substring(startIdx, startIdx + minLen);
//
//


        int left = 0;
        int right = 0;
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();


        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }

        int desiredCount = 0;
        int matchCount = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx=0;


        for (right = 0; right < s.length(); right++) {

            char charAtRight = s.charAt(right);
            sMap.put(charAtRight, sMap.getOrDefault(charAtRight, 0) + 1);

            if (pMap.containsKey(charAtRight) && sMap.get(charAtRight) <= pMap.get(charAtRight)) {
                matchCount++;
            }

            while (desiredCount == matchCount) {


                int currentLength = left - right + 1;
                if (currentLength < minLen) {
                    minLen = currentLength;
                    startIdx = left;
                }

                char charAtleft = s.charAt(left);


                if (sMap.get(charAtleft) == 1) {
                    sMap.remove(charAtleft);
                } else {
                    sMap.put(charAtleft, sMap.get(charAtleft) - 1);
                }


                if (pMap.containsKey(charAtleft) && sMap.getOrDefault(charAtleft, 0) < pMap.get(charAtleft)) {
                    matchCount--;
                }

                left++;
            }
            right++;


        }


        //      QUIET Close
//
//        // for p
//        HashMap<Character, Integer> toGet = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//
//            toGet.put(s.charAt(i), toGet.getOrDefault(s.charAt(i),0)+1);
//
//        }
//
//        // for s and its freq
//        HashMap<Character, Integer> checking = new HashMap<>();
//
//        // sliding window
//        int left = 0;
//        int right = left ;
//
//        int matchCount = 0;
//        int desiredCount = p.length();
//
//        while (right < s.length()){
//
//            if(toGet.containsKey(s.charAt(right))){
//                if(toGet.get(s.charAt(right)) >0){
//                    matchCount++;
//                }
//
//            }
//
//        }
//
//
//

  return s.substring(startIdx,startIdx+minLen);
    }
}