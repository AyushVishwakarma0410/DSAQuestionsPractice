package QuestionSheetAlpha.StringsQuestions;

public class ConsecutiveAlphabetsRemoval {

    public static void removal(String s){

        if(s.length()<=0){
            return;
        }

        char ch  = s.charAt(0);
        StringBuilder answerString = new StringBuilder();
        answerString.append(ch);
        for(int i = 1 ; i < s.length();i++){
            char currCh = s.charAt(i);
            if(ch != currCh){
                answerString.append(currCh);
            }
            ch = currCh;
        }

        System.out.println(answerString);
    }


    public static void main(String[] args) {
        String s = "abcddcba";

        removal(s);

    }


}
