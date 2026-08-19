package QuestionSheetAlpha.StringsQuestions;

public class CountPalindromicSubsequences {

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
