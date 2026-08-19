package QuestionSheetAlpha.StringsQuestions;

public class WildCardStringMatching {
    public static void main(String[] args) {



        String s = "anything";
        String w = "*";

        System.out.println(wildMatching(w,s));
    }
    public static boolean wildMatching(String wild, String pattern){


        // wild pointer
        int w = 0;
        // pattern pointer
        int p = 0;


        int startIdx = -1;
        int matchIdx = 0;


        while (p < pattern.length()){


            if(w < wild.length() && (wild.charAt(w)=='?'|| wild.charAt(w)==pattern.charAt(p))){
                w++;
                p++;
                // we assume that * hits an empty space
            } else if (w < wild.length() && wild.charAt(w)=='*') {
                startIdx = w;
                matchIdx = p;
                // therefore we will move w pointer forward
                w++;
                // if no match is found. But we have a saved'*', i.e. w != s ( characters)
            } else if (startIdx!=-1) {
                w = startIdx+1;
                // we increase matchIdx to the next character
                matchIdx++;
                p = matchIdx; // assign matchIdx to p pointer
            }
            // if no match found
            else {
                return false;
            }


        }

        // Edge Case: If wildcard has trailing stars (e.g., "abc***")
        while (w < wild.length() && wild.charAt(w) == '*') {
            w++;
        }
        return w == wild.length();



    }
}
