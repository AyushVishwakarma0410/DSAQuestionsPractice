package QuestionSheetAlpha.StringsQuestions;

public class ValidPalindrome {

    public static boolean validPalindrome(String s ){

//        int left = 0;
//        s =  s.replaceAll("[^a-zA-Z0-9]","");
//        int right = s.length()-1;
//        s = s.toLowerCase();
//        while (left <= right){
//            if(s.charAt(left) != s.charAt(right)){
//                return false;
//            }
//            left++;
//            right--;
//        }
//
//        return true;

        int left = 0;
        int right = s.length() - 1;

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

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome(s));
    }
}
