package QuestionSheetAlpha.StringsQuestions;

import java.util.HashMap;

public class LongestPalindromicSubstring {



    // Do not fucking use hashmap for this question, thats useless, read what is needed when, fuck you !!!



    // self implemented brute force
    public static void longestPalindrome(String s){


        int maxLen = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                if (checkPalindrome(s, i, j)){
                    length = j-i+1;
//                    System.out.println(s.substring(i,j+1));
                    maxLen = Math.max(length, maxLen);
                }
            }
        }
        System.out.println(maxLen);


    }


    public static boolean checkPalindrome(String s,int start, int end){


        int left = start;
        int right = end;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            // 1. If Left is not alphanumeric, skip it
            if (!Character.isLetterOrDigit(l)) {
                left++;
            }
            // 2. If Right is not alphanumeric, skip it
            else if (!Character.isLetterOrDigit(r)) {
                right--;
            }
            // 3. Both are valid, check equality (case-insensitive)
            else {
                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;


    }




    // expanding from centre ( gemini)
    public static void expandFromCentre(String s) {

        int start = 0;
        int end = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCentreSearch(s, i, i);
            int len2 = expandFromCentreSearch(s, i, i + 1);
            // len is not a constant length it changes everytime
            len = Math.max(len1, len2);

            if(len > end-start){
                start = i - (len-1)/2 ;
                end = i + len/2;
            }


        }
        System.out.print(s.substring(start,end+1));

    }
    public static int expandFromCentreSearch(String s ,int left, int right){


        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){

            left--;
            right++;

        }

        return (right-1)-(left+1)+1;

    }

    public static void main(String[] args) {


        String s= "racecarplane";

        longestPalindrome(s);
        expandFromCentre(s);
    }
}
