package QuestionSheetAlpha.StringsQuestions;

public class LongestPrefixSuffix {
    public static void main(String[] args) {

        longestPreSuf("aabaaba");

    }

    public static void longestPreSuf(String s){
        int target = s.length()-1;
        int reach = target-1;
        boolean flag = false;
        while (reach >= 0){

            char check = s.charAt(target);
            char ch = s.charAt(reach);

            if(check == ch){
                flag = true;
            }
            else {
                flag = false;
                target = s.length()-1;
                if(s.charAt(target) == s.charAt(reach)){
                    reach++;
                }
            }

            if(flag){
                target--;
            }

            reach--;



        }


        if(flag){
            System.out.println(s.length()-target-1);
        }else{
            System.out.println(0);
        }

    }
}
