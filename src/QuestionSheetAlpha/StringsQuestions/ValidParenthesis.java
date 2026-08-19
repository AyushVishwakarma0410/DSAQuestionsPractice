package QuestionSheetAlpha.StringsQuestions;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean validity(String s){


        Stack<Character> stack  = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch == '(' || ch =='[' || ch == '{' ){
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if(ch==')' && top != '('  || ch == '}' && top !='{' || ch == ']' && top != '['){

                    return false;

                }



            }


        }if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {

        String s = "({([])})";


        System.out.println(validity(s));
    }
}
