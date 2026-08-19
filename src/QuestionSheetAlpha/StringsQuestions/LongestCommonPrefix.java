package QuestionSheetAlpha.StringsQuestions;

public class LongestCommonPrefix {
        public static void commonPrefix(String [] s){

            StringBuilder prefix = new StringBuilder(s[0]);
            for(int i = 1; i < s.length;i++){
                for(int j = 0;  j < s[i].length() ; j++){

                    if( j < prefix.length()  &&  prefix.charAt(j) != s[i].charAt(j)) {
                        prefix.delete(j, prefix.length());
                        break;
                    }
                }


            }

            System.out.println(prefix);


        }


    public static void main(String[] args) {

            String [] s = {"a"};
            commonPrefix(s);

    }
}
