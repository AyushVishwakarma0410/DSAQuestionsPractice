package QuestionSheetAlpha.StringsQuestions;

public class panlindromicSubstrings {



    // brute force
//    public static void allSubstrings(String s){
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//
//                boolean check = checkPalindrome(s,i,j);
//                if(check){
//                    System.out.println(s.substring(i,j+1));
//                }
//            }
//        }
//
//
//    }
//
//    public static boolean checkPalindrome(String s,int start, int end){
//
//
//        int left = start;
//        int right = end;
//
//        while (left < right) {
//            char l = s.charAt(left);
//            char r = s.charAt(right);
//
//            // 1. If Left is not alphanumeric, skip it
//            if (!Character.isLetterOrDigit(l)) {
//                left++;
//            }
//            // 2. If Right is not alphanumeric, skip it
//            else if (!Character.isLetterOrDigit(r)) {
//                right--;
//            }
//            // 3. Both are valid, check equality (case-insensitive)
//            else {
//                if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
//                    return false;
//                }
//                left++;
//                right--;
//            }
//        }
//        return true;
//
//
//    }


    // expand from centre

    public static int expandFromCentre(String s){

        int len1 ;
        int len2 ;

        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {

            totalCount+= check(s,i,i);
            totalCount+= check(s,i,i+1);

        }System.out.println(totalCount);
    return totalCount;
    }

    public static int check(String s, int start, int end){

        int currentCount = 0;
        while (start>=0 && end < s.length() && s.charAt(start) == s.charAt(end) ){
            currentCount++;
            start--;
            end++;
        }
        return currentCount;
    }




    public static void main(String[] args) {


        String s= "aaa";
//        allSubstrings(s);
        expandFromCentre(s);
    }

}
